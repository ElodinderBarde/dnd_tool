import React, { useState } from "react";

export default function PresetModal({ isOpen, title, columns, data, filterKeys, onSelect, onClose }) {
    const [search, setSearch] = useState("");

    if (!isOpen) return null;

    const filteredData = data.filter((row) =>
        filterKeys.some((key) =>
            String(row[key]).toLowerCase().includes(search.toLowerCase())
        )
    );

    return (
        <div className="modal-overlay">
            <div className="modal-box">
                <h2>{title}</h2>

                <input
                    type="text"
                    placeholder="Suche..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    style={{ width: "100%", marginBottom: "1rem" }}
                />

                <table>
                    <thead>
                    <tr>
                        {columns.map((col, idx) => (
                            <th key={idx}>{col}</th>
                        ))}
                    </tr>
                    </thead>
                    <tbody>
                    {filteredData.map((row, rowIndex) => (
                        <tr key={rowIndex} onClick={() => onSelect(row)} style={{ cursor: "pointer" }}>
                            {columns.map((col, colIndex) => (
                                <td key={colIndex}>{row[toCamelCase(col)]}</td>
                            ))}
                        </tr>
                    ))}
                    </tbody>
                </table>

                <button onClick={onClose}>Abbrechen</button>
            </div>
        </div>
    );
}

// optionaler Helfer: "Vorname" → "vorname"
function toCamelCase(text) {
    return text.charAt(0).toLowerCase() + text.slice(1);
}
