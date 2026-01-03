import React from "react";
import "./NpcStats.css";

export default function NpcStats({ npc }) {
    if (!npc) return <p>Statistiken werden geladen...</p>;

    const stats = npc.stats ?? {};

    const getMod = (score) => {
        if (typeof score !== "number") return null;
        const mod = Math.floor((score - 10) / 2);
        return mod >= 0 ? `+${mod}` : `${mod}`;
    };

    const renderCell = (label, value, showMod = true) => {
        const mod = showMod ? getMod(value) : null;

        return (
            <div className="stat-cell">
                <div className="stat-label">{label}</div>
                <div className="stat-value">
                    {typeof value === "number" ? value : "—"}
                    {mod !== null && <span> ({mod})</span>}
                </div>
            </div>
        );
    };

    return (
        <div className="stats-grid">
            {/* Klassenblock rechts */}
            <div className="class-box">
                <div><strong>Klasse:</strong> {npc.npcClass ?? "—"}</div>
                <div><strong>Subklasse:</strong> {npc.subclass ?? "—"}</div>
                <div><strong>Stufe:</strong> {npc.level ?? "0"}</div>
            </div>

            {/* Stats */}
            {renderCell("ATK", stats.strength)}
            {renderCell("CON", stats.constitution)}
            {renderCell("WIS", stats.wisdom)}
            {renderCell("CHA", stats.charisma)}
            {renderCell("INT", stats.intelligence)}
            {renderCell("GES", stats.dexterity)}

            {/* AC ohne Modifier */}
            {renderCell("AC", npc.armor, false)}
        </div>
    );
}
