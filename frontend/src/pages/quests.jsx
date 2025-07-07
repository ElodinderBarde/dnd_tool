// src/pages/SEITENNAME.jsx


import "gridstack/dist/gridstack.min.css";
import {useEffect, useRef} from "react";
import {GridStack} from "gridstack";
import "../components/questboard/QuestBoard.css";

import Navbar from '../components/Navbar';
import QuestFilter from "../components/questboard/QuestFilter.jsx";
import QuestLlist from "../components/questboard/QuestLlist.jsx";
import QuesstCreate from "../components/questboard/QuesstCreate.jsx";


export default function Quests() {
    const gridRef = useRef(null);
    const gridInstance = useRef(null);


    useEffect(() => {
        const grid = GridStack.init({
            column: 12,
            margin: 5,
            cellHeight: 100,
            staticGrid: true,
            disableResize: true,
            disableDrag: true

        }, gridRef.current);

        gridInstance.current = grid;
    },[]);





    return (
        <>
            <Navbar />
            <div className="grid-stack" ref={gridRef}>

                <div className="grid-stack-item" gs-x="3" gs-y="0" gs-w="9" gs-h="1">
                    <div className="grid-stack-item-content">
                        <QuestFilter />
                    </div>
                </div>

                <div className="grid-stack-item" gs-x="3" gs-y="2" gs-w="9" gs-h="5">
                    <div className="grid-stack-item-content">
                        <QuestLlist />
                    </div>
                </div>

                <div className="grid-stack-item" gs-x="0" gs-y="0" gs-w="3" gs-h="6">
                    <div className="grid-stack-item-content">
                        <QuesstCreate />
                    </div>
                </div>

            </div>
        </>
    );
}