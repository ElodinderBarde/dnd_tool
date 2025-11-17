import { useEffect, useState } from "react";

export default function ClanMitgliederList({ clan }) {

    const [mitglieder, setMitglieder] = useState([]);

    useEffect(() => {
        if (!clan) return;

        fetch(`/api/npcs/byClan/${clan.id}`)
            .then(res => res.json())
            .then(data => setMitglieder(data));
    }, [clan]);


    return (
        <div
            className="grid-stack-item"
            gs-w="10"
            gs-h="6"
            gs-x="2"
            gs-y="2"
        >
            <div className="grid-stack-item-content mitglieder-container">

                <div className="mitglieder-scrollbox">
                    {mitglieder.length === 0 && (
                        <p style={{ opacity: 0.6 }}>Keine Mitglieder gefunden.</p>
                    )}

                    {mitglieder.map(npc => (
                        <div key={npc.id} className="mitglieder-entry">
                            <span className="mitglieder-name">
                                {npc.firstname} {npc.lastname}
                            </span>
                            <span className="mitglieder-level">Lvl {npc.level}</span>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}
