import React, { useState, useEffect } from "react";
import axios from "../../service/axios.js"; // Pfad je nach Projektstruktur anpassen

export default function NpcFilter({ onFilterChange }) {
    const [filters, setFilters] = useState({
        search: "",
        race: "",
        npcClass: "",
        subclass: "",
        clan: "",
        clanPosition: "",
        hasPicture: "",
        hasShop: "",
        symbol: "",
        locationId: ""
    });

    const [dropdowns, setDropdowns] = useState({
        races: [],
        classes: [],
        subclasses: [],
        clans: [],
        clanPositions: [],
    });



    const [cities, setCities] = useState([]);

    useEffect(() => {
        const fetchCities = async () => {
            try {
                const res = await axios.get("/api/locations/cities");
                setCities(res.data);
            } catch (error) {
                console.error("Fehler beim Laden der Städte:", error);
            }
        };

        fetchCities();
    }, []);



    useEffect(() => {
        const fetchDropdowns = async () => {
            try {
                const [raceRes, classRes, clanRes, clanPosRes] = await Promise.all([
                    axios.get("/api/npcs/races/names"),
                    axios.get("/api/npcs/classes/names"),
                    axios.get("/api/npcs/clans/names"),
                    axios.get("/api/npcs/clanpositions/names"),
                ]);


                setDropdowns(prev => ({
                    ...prev,
                    races: raceRes.data,
                    classes: classRes.data,
                    clans: clanRes.data,
                    clanPositions: clanPosRes.data,
                    subclasses: []  // Initial leer
                }));
            } catch (error) {
                console.error("Fehler beim Laden der Dropdown-Werte", error);
            }
        };

        fetchDropdowns();
    }, []);

    const handleChange = (event) => {
        const { name, value } = event.target;
        let parsedValue = value;

        // Wandle "__NONE__" in null um
        if (value === "__NONE__") parsedValue = "__NONE__";

        // Boolean-Felder speziell behandeln
        if (name === "hasPicture" || name === "hasShop") {
            if (value === "true") parsedValue = true;
            else if (value === "false") parsedValue = false;
            else parsedValue = "";
        }

        const updatedFilters = { ...filters, [name]: parsedValue };
        setFilters(updatedFilters);
        onFilterChange(updatedFilters);
    };



    useEffect(() => {
        const fetchSubclasses = async () => {
            if (!filters.npcClass) {
                setDropdowns(prev => ({ ...prev, subclasses: [] }));
                return;
            }

            try {
                const res = await axios.get(`/api/npcs/subclasses/names/byClass`, {
                    params: { npcClass: filters.npcClass }
                });
                setDropdowns(prev => ({ ...prev, subclasses: res.data }));
            } catch (error) {
                console.error("Fehler beim Laden der Subklassen:", error);
                setDropdowns(prev => ({ ...prev, subclasses: [] }));
            }
        };

        fetchSubclasses();
    }, [filters.npcClass]);


    return (
        <div style={{ display: "flex", flexWrap: "wrap", gap: "10px" }}>
            <input
                type="text"
                name="search"
                placeholder="Vor- oder Nachname"
                value={filters.search}
                onChange={handleChange}
            />

            <select name="race" value={filters.race} onChange={handleChange}>
                <option value="">Volk wählen</option>
                {dropdowns.races.map((r, idx) => (
                    <option key={idx} value={r}>{r}</option>
                ))}
            </select>

            <select name="npcClass" value={filters.npcClass ?? ""} onChange={handleChange}>
                <option value="">Klasse wählen</option>
                <option value="__NONE__">Keine Klasse</option> {/* bewusst KEIN null */}
                {dropdowns.classes.map((c, idx) => (
                    <option key={idx} value={c}>{c}</option>
                ))}
            </select>


            {filters.npcClass && dropdowns.subclasses.length > 0 && (
                <select name="subclass" value={filters.subclass} onChange={handleChange}>
                    <option value="">Subklasse wählen</option>
                    {dropdowns.subclasses.map((s, idx) => (
                        <option key={idx} value={s}>{s}</option>
                    ))}
                </select>
            )}


            <select name="clan" value={filters.clan} onChange={handleChange}>
                <option value="">Clan wählen</option>
                {dropdowns.clans.map((c, idx) => (
                    <option key={idx} value={c}>{c}</option>
                ))}
            </select>

            {filters.clan && (
                <select name="clanPosition" value={filters.clanPosition} onChange={handleChange}>
                    <option value="">Clan-Position</option>
                    {dropdowns.clanPositions.map((p, idx) => (
                        <option key={idx} value={p}>{p}</option>
                    ))}
                </select>
            )}

            <select name="hasShop" value={filters.hasShop} onChange={handleChange}>
                <option value="">Zugeornet?</option>

                <option value="true">Ja</option>
                <option value="false">Nein</option>
            </select>








            <select name="hasPicture" value={filters.hasPicture} onChange={handleChange}>
                <option value="">Bild?</option>
                <option value="true">Ja</option>
                <option value="false">Nein</option>
            </select>


            <select name="symbol" value={filters.symbol} onChange={handleChange}>
                <option value="">Symbol wählen</option>
                <option value="a">🧭 a</option>
                <option value="b">🛡️ b</option>
                <option value="c">⚔️ c</option>
                <option value="d">📜 d</option>
                <option value="e">🔮 e</option>
                <option value="f">🪓 f</option>
                <option value="g">🏹 g</option>
                <option value="h">👑 h</option>
                <option value="i">📘 i</option>
                <option value="j">🗡️ j</option>


            </select>




            <select name="locationId" value={filters.locationId} onChange={handleChange}>
                <option value="">Alle Städte</option>
                {cities.map((city) => (
                    <option key={city.id} value={city.id}>
                        {city.city_name}
                    </option>
                ))}
            </select>









        </div>
    );
}
