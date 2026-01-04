import { useParams } from "react-router-dom";
import { useState, useEffect, useLayoutEffect, useRef } from "react";
import { GridStack } from "gridstack";
import Navbar from "../components/navbar";

import "gridstack/dist/gridstack.min.css";
import "../components/npc-detail-page/NpcDetailPage.css"
import NpcNotes from "../components/npcBoard/NpcNotes.jsx";
import NpcPicture from "../components/npc-detail-page/npcPicture.jsx";
import NpcStats from "../components/npc-detail-page/npcStats.jsx";
import NpcOptics from "../components/npc-detail-page/npcOptics.jsx";
import NpcPersonality from "../components/npc-detail-page/npcPersonality.jsx";

export default function NpcDetailPage() {
    const { npcId } = useParams();
    const [npc, setNpc] = useState(null);
    const gridRef = useRef(null);

    useLayoutEffect(() => {
        if (!gridRef.current) return;

        const grid = GridStack.init({
            column: 12,
            margin: 5,
            cellHeight: 100,
           staticGrid: true,
            disableResize: true,
            disableDrag: true,
        }, gridRef.current);


        return () => grid.destroy(false);
    }, []);




    useEffect(() => {
        const fetchNpc = async () => {
            try {
                const res = await fetch(`http://localhost:8081/api/npcs/${npcId}`);
                const data = await res.json();
                setNpc(data);
            } catch (err) {
                console.error("Fehler beim Laden des NPCs:", err);
            }
        };

        if (npcId) fetchNpc();  // <== Wird dies wirklich erreicht?
    }, [npcId]);


    return (
        <>
            <Navbar />

            <div ref={gridRef} className="grid-stack" style={{ minHeight: '800px' }}>
                <div
                    className="grid-stack-item"
                    gs-x="0"
                    gs-y="0"
                    gs-w="2"
                    gs-h="2"
                >
                    <div className="grid-stack-item-content" style={{
                        color: 'white',
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center'
                    }}>
                        <div>
                        {npc ? <h3>{npc.firstname} {npc.lastname}</h3> : <p>npc nicht gefunden</p>}
                        {npc ? <p>{npc.gender}</p> : null}
                        {npc ? <p>{npc.race}</p> : null}
                        {npc ? <p>{npc.age} Jahre alt</p> : null}
                        </div>
                    </div>

                </div>


                    <div
                    className="grid-stack-item"
                    gs-x="6"
                    gs-y="6"
                    gs-w="6"
                    gs-h="6"
                >
                    <div className="grid-stack-item-content" style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center'
                    }}>
                        {npc ? <NpcNotes selectedNpc={npc} className="notes-detail"/> : <p>Lade Notizen...</p>}
                    </div>
                </div>


                <div
                    className="grid-stack-item"
                    gs-x="2"
                    gs-y="0"
                    gs-w="8"
                    gs-h="3"
                >
                    <div className="grid-stack-item-content" style={{ display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                        <NpcPersonality npc={npc} />
                    </div>
                </div>

                <div
                    className="grid-stack-item"
                    gs-x="10"
                    gs-y="0"
                    gs-w="2"
                    gs-h="3"
                >
                    <div className="grid-stack-item-content" style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center',

                    }}>
                        <NpcPicture npc={npc}/>
                    </div>
                </div>

                <div
                    className="grid-stack-item"
                    gs-x="2"
                    gs-y="3"
                    gs-w="4"
                    gs-h="6"
                >
                    <div className="grid-stack-item-content" style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center'
                    }}>
                        <NpcStats  npc={npc}/>
                    </div>
                </div>
                <div
                    className="grid-stack-item"
                    gs-x="0"
                    gs-y="2"
                    gs-w="2"
                    gs-h="7"
                >
                    <div className="grid-stack-item-content" style={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center'
                    }}>
                        <NpcOptics npc ={npc} className={"opticsContainer"}/>
                    </div>
                </div>






            </div>
        </>
    );
}
