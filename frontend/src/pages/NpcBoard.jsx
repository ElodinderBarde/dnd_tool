import {useEffect, useRef, useState} from 'react';
import Navbar from '../components/navbar';
import NpcDetail from '../components/npcBoard/NpcDetail.jsx';
import NpcFilter from "../components/npcBoard/NpcFilter.jsx";
import NpcList from "../components/npcBoard/NpcList.jsx";
import NpcNotes from "../components/npcBoard/NpcNotes.jsx";
import {GridStack} from "gridstack";
import '../components/npcBoard/npcBoard.css'

export default function NpcBoard() {
  const gridRef = useRef(null);
  const gridInstance = useRef(null);
    const [npcs, setNpcs] = useState([]);
    const [selectedNpc, setSelectedNpc] = useState(null);

    const [filters, setFilters] = useState({});

    const handleFilterChange = (newFilters) => {
        setFilters(newFilters);
        fetchFilteredNpcs(newFilters);

    };




    const fetchFilteredNpcs = async (filterParams) => {
        try {
            const query = new URLSearchParams(filterParams).toString();
            const response = await fetch(`http://localhost:8081/api/npcs/dto/filter?${query}`);
            const data = await response.json();
            setNpcs(data);
        } catch (error) {
            console.error("Fehler beim Laden der NPCs:", error);
        }
    };

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


    useEffect(() => {
        fetchFilteredNpcs({});
    }, []);





  return (
    
    <>
      <div ref={gridRef} className="grid-stack">
    <Navbar />
    <main style={{ padding: '2rem' }}>
      <h2>NPC Page</h2>
   </main>



      <div id="npcDetail" className="grid-stack-item"
           gs-x="9"
           gs-y="6"
           gs-w="3"
           gs-h="6">
        <div className="grid-stack-item-content">
            <NpcDetail npc={selectedNpc} />
        </div>
      </div>


      <div id="npcFilter" className="grid-stack-item"
           gs-x="0"
           gs-y="0"
           gs-w="9"
           gs-h="1">
        <div className="grid-stack-item-content">
            <NpcFilter onFilterChange={handleFilterChange} />
        </div>
      </div>

      <div id="npcList" className="grid-stack-item"
           gs-x="0"
           gs-y="1"
           gs-w="9"
           gs-h="7.5">
        <div className="grid-stack-item-content">
            <NpcList npcs={npcs} onNpcClick={setSelectedNpc} selectedNpc={selectedNpc} onNpcDoubleClick={handleFilterChange} />
        </div>
      </div>
      <div id="npcNotes" className="grid-stack-item"
           gs-x="9"
           gs-y="6"
           gs-w="3"
           gs-h="2.5">
        <div className="grid-stack-item-content">
          <NpcNotes selectedNpc={selectedNpc} />
        </div>
      </div>

</div>
    </>

);
}
    
 

