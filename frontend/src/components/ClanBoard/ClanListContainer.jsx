export default function ClanListContainer({ clans, onSelectClan }) {
    return (
        <div className="grid-stack-item" gs-w="4" gs-h="8" gs-x="0" gs-y="0">
            <div className="grid-stack-item-content" style={{ padding: "1rem" }}>
                <h3>Clans</h3>
                <ul style={{ listStyle: "disc", paddingLeft: "1.5rem" }}>
                    {clans.map((c) => (
                        <li
                            key={c.id}
                            style={{ cursor: "pointer" }}
                            onClick={() => onSelectClan(c)}
                        >
                            {c.clan}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
}
