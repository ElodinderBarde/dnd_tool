import {useEffect, useState} from 'react';
import './CSS/main.css';

import { GridStack } from 'gridstack';
import Navbar from '../components/navbar';
import CityNameSelector from "../components/main-Page/blocks/city-name-block/CityNameSelector.jsx";
import {CommandMenu01} from "../components/main-Page/blocks/city-name-block/modal/locationSelectorModal.jsx";
import SelectList from "../components/main-Page/elements/SelectList/SelectList.jsx";
import {getShops} from "../service/shopsAPI.js";

export function sortByNameAsc(a, b) {
    return a.name.localeCompare(b.name, 'de', { sensitivity: 'base' });
}

export default function Main() {
    const [isCityModalOpen, setCityModalOpen] = useState(false);
    const [shops, setShops] = useState([]);
    const [availableShopTypes, setAvailableShopTypes] = useState([]);
    const [filteredShops, setFilteredShops] = useState([]);
    const [selectedShop, setSelectedShop] = useState(null);


    const [selectedLocation, setSelectedLocation] = useState(() => {
        const stored = localStorage.getItem("selectedLocation");
        return stored ? JSON.parse(stored) : null;
    });
    useEffect(() => {
        if (selectedLocation) {
            localStorage.setItem(
                "selectedLocation",
                JSON.stringify(selectedLocation)
            );
        }
    }, [selectedLocation]);

    useEffect(() => {
        async function loadShops() {
            try {
                const data = await getShops();
                setShops(data);
            } catch (err) {
                console.error("Fehler beim Laden der Shops:", err);
            }
        }

        loadShops();
    }, []);


    useEffect(() => {
        if (!selectedLocation || shops.length === 0) {
            setAvailableShopTypes([]);
            setShopType(null);
            return;
        }

        const types = deriveShopTypesForLocation(
            shops,
            selectedLocation.locationId
        );

        setAvailableShopTypes(types);
    }, [selectedLocation, shops]);

    useEffect(() => {
        setShopType(null);
        localStorage.removeItem("shopType");
    }, [selectedLocation]);


    const [shopType, setShopType] = useState(() => {
        const stored = localStorage.getItem("shopType");
        return stored ? JSON.parse(stored) : null;
    });
    useEffect(() => {
        if (shopType) {
            localStorage.setItem("shopType", JSON.stringify(shopType));
        }
    }, [shopType]);

    useEffect(() => {
        if (!selectedLocation || !shopType || shops.length === 0) {
            setFilteredShops([]);
            setSelectedShop(null);
            return;
        }

        const result = shops.filter(
            shop =>
                shop.locationId === selectedLocation.locationId &&
                shop.shopTypeId === shopType.id
        );

        setFilteredShops(result);
    }, [shops, selectedLocation, shopType]);













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
                        <div className="grid-stack-item-content">Employees</div>
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
