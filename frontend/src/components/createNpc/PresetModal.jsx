import React, { useState } from "react";

export default function PresetModal({ isOpen, title, columns, data, filterKeys, onSelect, onClose }) {
    const [search, setSearch] = useState("");

    if (!isOpen) return null;

    const filteredData = data.filter((row) =>
        filterKeys.some((key) => {
            let value = row[key];
            if (key === "race" && typeof row.race === "object") value = row.race.racename;
            if (key === "gender" && typeof row.gender === "object") value = row.gender.gendername;
            if (key === "name" && row.firstname) value = row.firstname;
            if(key === "name" && row.lastname) value = row.lastname;
            return String(value).toLowerCase().includes(search.toLowerCase());
        })
    );


    return (
        <div className="modal-overlay">
            <div className="modal-box" style={{ maxHeight: "80vh", overflow: "hidden", display: "flex", flexDirection: "column" }}>
                <h2>{title}</h2>

                <input
                    type="text"
                    placeholder="Suche..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    style={{ width: "100%", marginBottom: "1rem" }}
                />
                <div style={{ overflowY: "auto", border: "1px solid #444" }}>

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
                            {columns.map((col, colIndex) => {
                                const key = toCamelCase(col);
                                let value = row[key];

                                if (key === "race" && row.race?.racename) value = row.race.racename;
                                if (key === "gender" && row.gender?.gendername) value = row.gender.gendername;
                                if (key === "firstname") value = row.firstname;
                                if (key === "lastname") value = row.lastname;

                                return <td key={colIndex}>{value}</td>;
                            })}


                        </tr>
                    ))}
                    </tbody>
                </table>
                </div>
                <button onClick={onClose}>Abbrechen</button>
            </div>
        </div>
    );
}

// optionaler Helfer: "Vorname" → "vorname"
function toCamelCase(text) {
    return text.charAt(0).toLowerCase() + text.slice(1);
}
