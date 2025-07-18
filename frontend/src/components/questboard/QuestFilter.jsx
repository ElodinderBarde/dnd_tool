// QuestFilter.jsx
import { useState } from "react";

export default function QuestFilter({ onFilterChange }) {
    const [filters, setFilters] = useState({
        name: "",
        questreihe: false,
        gruppe: "",
        ort: "",
        status: ""
    });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        const updated = {
            ...filters,
            [name]: type === "checkbox" ? checked : value
        };
        setFilters(updated);
        onFilterChange(updated);
    };

    return (
        <div className="quest-filter-container">
            <h4>🔎 Questfilter</h4>

            <div className="form-group-inline">
                <label>Name:</label>
                <input type="text" name="name" value={filters.name} onChange={handleChange} />
            </div>

            <div className="form-group-inline">
                <label>Reihe:</label>
                <input type="checkbox" name="questreihe" checked={filters.questreihe} onChange={handleChange} />
            </div>

            <div className="form-group-inline">
                <label>Gruppe:</label>
                <input type="text" name="gruppe" value={filters.gruppe} onChange={handleChange} />
            </div>

            <div className="form-group-inline">
                <label>Ort:</label>
                <input type="text" name="ort" value={filters.ort} onChange={handleChange} />
            </div>

            <div className="form-group-inline">
                <label>Status:</label>
                <select name="status" value={filters.status} onChange={handleChange}>
                    <option value="">Alle</option>
                    <option value="offen">Offen</option>
                    <option value="abgeschlossen">Abgeschlossen</option>
                </select>
            </div>
        </div>
    );
}
