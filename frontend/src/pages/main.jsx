import {useEffect, useState, useRef} from 'react';
import './CSS/main.css';

import { GridStack } from 'gridstack';
import Navbar from '../components/navbar';
import CityNameSelector from "../components/main-Page/blocks/city-name-block/CityNameSelector.jsx";
import {CommandMenu01} from "../components/main-Page/blocks/city-name-block/modal/locationSelectorModal.jsx";
import SelectList from "../components/main-Page/elements/SelectList/SelectList.jsx";
import {getShops} from "../service/shopsAPI.js";
import {getEmployees, getCustomers} from "../service/ShopCustomerEmployeeAPI.js";
import { useNavigate } from "react-router-dom";

function loadFromStorage(key) {
    const raw = localStorage.getItem(key);
    if (!raw) return null;
    try {
        return JSON.parse(raw);
    } catch (err) {
        console.warn(`Failed to parse localStorage key ${key}:`, raw);
        try { localStorage.removeItem(key); } catch (e) {}
        return null;
    }
}

function saveToStorage(key, value) {
    try {
        if (value === null || typeof value === 'undefined') {
            localStorage.removeItem(key);
        } else {
            localStorage.setItem(key, JSON.stringify(value));
        }
    } catch (err) {
        console.warn(`Failed to write localStorage key ${key}:`, err);
    }
}

export default function Main() {
    const navigate = useNavigate();
    // UI
    const [isCityModalOpen, setCityModalOpen] = useState(false);
    const [viewMode, setViewMode] = useState("EMPLOYEE");

    // Persistenter State
    const [selectedLocation, setSelectedLocation] = useState(() =>
        loadFromStorage("selectedLocation")
    );
    const [shopType, setShopType] = useState(() =>
        loadFromStorage("selectedShopType")
    );
    const [selectedShop, setSelectedShop] = useState(() =>
        loadFromStorage("selectedShop")
    );
    const [selectedNpc, setSelectedNpc] = useState(() =>
        loadFromStorage("selectedNpc")
    );

    // Refs to hold latest values for synchronous save on unload
    const selectedLocationRef = useRef(selectedLocation);
    const shopTypeRef = useRef(shopType);
    const selectedShopRef = useRef(selectedShop);
    const selectedNpcRef = useRef(selectedNpc);

    // keep refs up to date
    useEffect(() => { selectedLocationRef.current = selectedLocation; }, [selectedLocation]);
    useEffect(() => { shopTypeRef.current = shopType; }, [shopType]);
    useEffect(() => { selectedShopRef.current = selectedShop; }, [selectedShop]);
    useEffect(() => { selectedNpcRef.current = selectedNpc; }, [selectedNpc]);

    // Persist on unload / when document hidden
    useEffect(() => {
        const handleSave = () => {
            try {
                saveToStorage("selectedLocation", selectedLocationRef.current);
                saveToStorage("selectedShopType", shopTypeRef.current);
                saveToStorage("selectedShop", selectedShopRef.current);
                saveToStorage("selectedNpc", selectedNpcRef.current);
            } catch (err) {
                console.error('Error saving state on unload', err);
            }
        };

        const onBeforeUnload = () => { handleSave(); };
        const onVisibilityChange = () => {
            if (document.visibilityState === 'hidden') handleSave();
        };

        window.addEventListener('beforeunload', onBeforeUnload);
        document.addEventListener('visibilitychange', onVisibilityChange);

        return () => {
            window.removeEventListener('beforeunload', onBeforeUnload);
            document.removeEventListener('visibilitychange', onVisibilityChange);
            handleSave(); // final save on unmount
        };
    }, []);

    // Daten
    const [shops, setShops] = useState([]);
    const [availableShopTypes, setAvailableShopTypes] = useState([]);
    const [filteredShops, setFilteredShops] = useState([]);
    const [employees, setEmployees] = useState([]);
    const [customers, setCustomers] = useState([]);

    // 1. Reset-Kaskaden
    const [hydrated, setHydrated] = useState(false);

    useEffect(() => {
        setHydrated(true);
    }, []);

    useEffect(() => {
        if (!hydrated) return;
        if (!selectedLocation) return;
        if (!shopType) return;
        if (shops.length === 0) return;

        const stillValid = shops.some(
            s =>
                s.locationId === selectedLocation.locationId &&
                s.shopTypeId === shopType.id
        );

        if (!stillValid) {
            setShopType(null);
            setSelectedShop(null);
            setSelectedNpc(null);
        }
    }, [selectedLocation, shopType, hydrated, shops]);

    useEffect(() => {
        if (!shopType || !selectedShop) return;

        const stillValid = selectedShop.shopTypeId === shopType.id;

        if (!stillValid) {
            setSelectedShop(null);
            setSelectedNpc(null);
        }
    }, [shopType, selectedShop]);

    useEffect(() => {
        if (!selectedShop) return;
        setSelectedNpc(null);
    }, [selectedShop]);

    // 2. Daten laden
    useEffect(() => {
        async function loadShops() {
            const data = await getShops();
            setShops(data);
        }
        loadShops();
    }, []);

    useEffect(() => {
        if (!selectedLocation || shops.length === 0) {
            setAvailableShopTypes([]);
            return;
        }
        setAvailableShopTypes(
            deriveShopTypesForLocation(shops, selectedLocation.locationId)
        );
    }, [selectedLocation, shops]);

    useEffect(() => {
        if (!selectedLocation || !shopType) {
            setFilteredShops([]);
            return;
        }
        setFilteredShops(
            shops.filter(
                s =>
                    s.locationId === selectedLocation.locationId &&
                    s.shopTypeId === shopType.id
            )
        );
    }, [shops, selectedLocation, shopType]);

    useEffect(() => {
        if (!selectedShop) {
            setEmployees([]);
            setCustomers([]);
            return;
        }

        Promise.all([
            getEmployees(selectedShop.id),
            getCustomers(selectedShop.id),
        ]).then(([emp, cust]) => {
            setEmployees(emp);
            setCustomers(cust);
        });
    }, [selectedShop]);

    // 3. Persistence (bei normalen state-Änderungen)
    useEffect(() => {
        saveToStorage("selectedLocation", selectedLocation);
        saveToStorage("selectedShopType", shopType);
        saveToStorage("selectedShop", selectedShop);
        saveToStorage("selectedNpc", selectedNpc);
    }, [selectedLocation, shopType, selectedShop, selectedNpc]);

    // Hilfsfunktionen
    function sortByNameAsc(a, b) {
        return a.name.localeCompare(b.name, 'de', { sensitivity: 'base' });
    }

    function deriveShopTypesForLocation(shops, locationId) {
        const map = new Map();
        shops
            .filter(shop => shop.locationId === locationId)
            .forEach(shop => {
                if (!map.has(shop.shopTypeId)) {
                    map.set(shop.shopTypeId, {
                        id: shop.shopTypeId,
                        name: shop.shopTypeName,
                    });
                }
            });
        return Array.from(map.values());
    }

    function handleNpcDoubleClick(npc) {
        console.log("DoubleClick NPC:", npc);
        navigate(`/npc/${npc.npcId}`);
    }
    function handleShopDoubleClick(shop) {
        setSelectedShop(shop);
        navigate(`/shops/${shop.id}`);
    }

    function toggleViewMode() {
        setViewMode((prev) => prev === "EMPLOYEE" ? "CUSTOMER" : "EMPLOYEE");
    }

    useEffect(() => {
        GridStack.init({
            column: 100,
            cellHeight: 100,
            margin: 4,
            disableResize: true,
            disableDrag: true,
        });
    }, []);

    return (
        <>
            <Navbar />
            <main style={{ padding: '1rem' }}>
                <div className="grid-stack">
                    <CommandMenu01
                        open={isCityModalOpen}
                        setOpen={setCityModalOpen}
                        onSelectLocation={setSelectedLocation}
                    />
                    <div className="grid-stack-item" gs-x="80" gs-y="10" gs-w="20" gs-h="4">
                        <div className="grid-stack-item-content">NPC Pic</div>
                    </div>
                    <div className="grid-stack-item" gs-x="60" gs-y="10" gs-w="20" gs-h="7">
                        <div className="grid-stack-item-content">NPC Detail</div>
                    </div>
                    <div className="grid-stack-item" gs-x="80" gs-y="0" gs-w="40" gs-h="1">
                        <div className="grid-stack-item-content">NPC Stats</div>
                    </div>
                    <div className="grid-stack-item" gs-x="80" gs-y="50" gs-w="20" gs-h="3">
                        <div className="grid-stack-item-content">Party</div>
                    </div>
                    <div className="grid-stack-item" gs-x="35" gs-y="40" gs-w="25" gs-h="2">
                        <div className="grid-stack-item-content">

                            <button
                                type="button"
                                onClick={toggleViewMode}
                            >
                                {viewMode === "EMPLOYEE" ? "Mitarbeiter" : "Kunden"}
                            </button>
<br/>
                            <div className="flex-1 overflow-y-auto">

                            <SelectList
                                items={viewMode === "EMPLOYEE" ? employees : customers}
                                activeId={selectedNpc ? selectedNpc.npcId : null}
                                onSelect={setSelectedNpc}
                                onDoubleClick={handleNpcDoubleClick}
                                getId={(p) => p.npcId}
                                getLabel={(p) => (
                               <span>
                               {p.firstname} {p.lastname}
                                   <br/>
                                <small>{p.shopRelation}</small>
                                 </span>
                                )}
                            />
                            </div>

                        </div>
                    </div>

                    <div className="grid-stack-item" gs-x="35" gs-y="42" gs-w="25" gs-h="2">
                        <div className="grid-stack-item-content">Inventory</div>
                    </div>
                    <div className="grid-stack-item" gs-x="25" gs-y="40" gs-w="10" gs-h="4">
                        <div className="grid-stack-item-content">
                            <SelectList
                                items={filteredShops.sort(sortByNameAsc)}
                                activeId={selectedShop ? selectedShop.id : null}
                                onSelect={setSelectedShop}
                                onDoubleClick={handleShopDoubleClick}
                                getId={(s) => s.id}
                                getLabel={(s) => s.name}
                            />
                        </div>
                    </div>

                    <div className="grid-stack-item" gs-x="15" gs-y="40" gs-w="10" gs-h="4">
                        <div className="grid-stack-item-content">
                            <SelectList
                                items={availableShopTypes.sort(sortByNameAsc)}
                                activeId={shopType ? shopType.id : null}
                                onSelect={setShopType}
                                getId={(t) => t.id}
                                getLabel={(t) => t.name}
                            />
                        </div>
                    </div>
                    <div className="grid-stack-item" gs-x="35" gs-y="70" gs-w="25" gs-h="2">
                        <div className="grid-stack-item-content">Item Details</div>
                    </div>
                    <div className="grid-stack-item" gs-x="35" gs-y="80" gs-w="25" gs-h="2">
                        <div className="grid-stack-item-content">Karte</div>
                    </div>
                    <div className="grid-stack-item" gs-x="15" gs-y="80" gs-w="20" gs-h="4">
                        <div className="grid-stack-item-content">QuestNotes</div>
                    </div>
                    <div className="grid-stack-item" gs-x="0" gs-y="100" gs-w="15" gs-h="4">
                        <div className="grid-stack-item-content">QuestNotes</div>
                    </div>
                    <div className="grid-stack-item" gs-x="0" gs-y="0" gs-w="15" gs-h="1">
                        <div className="grid-stack-item-content">

                            <CityNameSelector selectedLocation={selectedLocation} onOpen={() => setCityModalOpen(true)} />
                        </div>
                    </div>
                    <div className="grid-stack-item" gs-x="0" gs-y="1" gs-w="15" gs-h="3">
                        <div className="grid-stack-item-content">Ruf</div>
                    </div>
                </div>
            </main>
        </>
    );
}
