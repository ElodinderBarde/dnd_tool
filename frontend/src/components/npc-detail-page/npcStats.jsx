import React from "react";
import "./NpcStats.css";

export default function NpcStats({ npc }) {
    if (!npc) return <p>Statistiken werden geladen...</p>;

    const getMod = (score) => {
        if (score == null) return "";
        const mod = Math.floor((score - 10) / 2);
        return mod >= 0 ? `+${mod}` : `${mod}`;
    };

    const renderCell = (label, value) => (
        <div className="stat-cell">
            <div className="stat-label">{label}</div>
            <div className="stat-value">
                {value ?? "-"} {value != null && `(${getMod(value)})`}
            </div>
        </div>
    );

    return (
        <div className="stats-grid">
            <p>{npc.npcClass || "Keine Klasse"}</p>
            <p>{npc.subclass || "& Subklasse"}</p>
            <p>Stufe: {npc.level || "0"}</p>
            {renderCell("ATK", npc.strength)}
            {renderCell("CON", npc.constitution)}
            {renderCell("WIS", npc.wisdom)}
            {renderCell("CHA", npc.charisma)}
            {renderCell("INT", npc.intelligence)}
            {renderCell("AC", npc.armor)}
        </div>
    );
}
