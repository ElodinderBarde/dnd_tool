import {useEffect, useRef,} from 'react';
import Navbar from '../components/navbar';

import {GridStack} from "gridstack";
import '../components/npcBoard/npcBoard.css'
import CreateOptions from "../components/createNpc/CreateOptions.jsx";
import NpcNotesPreview from "../components/createNpc/NpcNotesPreview.jsx";





export default function NpcCreate() {
    const gridRef = useRef(null);
    const gridInstance = useRef(null);






    useEffect(() => {
        const grid = GridStack.init({
            column: 12,
            margin: 5,
            cellHeight: 100,
            staticGrid: true,
            disableResize: true,
            disableDrag:true
        }, gridRef.current);

        gridInstance.current = grid;


    }, []);





    return (

        <>
            <div ref={gridRef} className="grid-stack">
                <Navbar />
                <main style={{ padding: '2rem' }}>
                    <h2>NPC Create</h2>
                </main>




                <div id="createOption" className="grid-stack-item"
                     gs-x="0"
                     gs-y="0"
                     gs-w="9"
                     gs-h="8">
                    <div className="grid-stack-item-content">
                        <CreateOptions />
                    </div>
                </div>
                <div id="npcNotes" className="grid-stack-item"
                     gs-x="9"
                     gs-y="6"
                     gs-w="3"
                     gs-h="8">

                    <div className="grid-stack-item-content">
                        <NpcNotesPreview />
                    </div>
                </div>

            </div>
        </>

    );
}



