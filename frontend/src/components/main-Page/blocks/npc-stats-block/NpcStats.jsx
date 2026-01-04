import  './NpcStats.css';
function abilityModifier(score) {
    if (typeof score !== "number") return null;
    return Math.floor((score - 10) / 2);
}

function StatBox({ label, value }) {
    const mod = abilityModifier(value);

    return (
        <div className="stat-box">
            <div className="stat-label">{label}</div>
            <div className="stat-value">
                {typeof value === "number" ? value : "—"}
            </div>
            <div
                className={
                    "stat-mod " +
                    (mod > 0 ? "mod-pos" : mod < 0 ? "mod-neg" : "mod-zero")
                }
            >
                {mod !== null ? `(${mod >= 0 ? "+" : ""}${mod})` : "—"}
            </div>
        </div>
    );
}

export default function NpcStats({ npc }) {
    if (!npc) return null;

    const stats = npc.stats ?? {};

    return (
        <div className="npc-stats-row">
            <StatBox label="ATK" value={stats.strength} />
            <StatBox label="CHA" value={stats.charisma} />
            <StatBox label="WIS" value={stats.wisdom} />
            <StatBox label="INT" value={stats.intelligence} />
            <StatBox label="KON" value={stats.constitution} />
            <StatBox label="GES" value={stats.dexterity} />

            <div className="stat-box ac">
                <div className="stat-label">AC</div>
                <div className="stat-value">
                    {npc.armor ?? "—"}
                </div>
            </div>



            <div className="class-box">
                <div>Stufe:<strong>{npc.level ?? '-'}</strong></div>
                <div>Klasse: <strong>{npc.npcClass ?? "—"}</strong></div>
                <div>Subklasse: <strong>{npc.subclass ?? "—"}</strong></div>
            </div>



        </div>
    );
}
