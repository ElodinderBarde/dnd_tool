import { useState, useEffect, useRef } from "react";
import { GridStack } from "gridstack";
import { getClans } from "../service/clanAPI";
import ClanListContainer from "../components/ClanBoard/ClanListContainer";
import ClanDetailsContainer from "../components/ClanBoard/ClanDetailsContainer.jsx";
import ClanMitgliederList from "../components/ClanBoard/clanMitgliederList.jsx";
import Navbar from "../components/navbar.jsx";

export default function Clan() {
  const gridRef = useRef(null);

  const [clans, setClans] = useState([]);
  const [selectedClan, setSelectedClan] = useState(null);

  useEffect(() => {
    GridStack.init(
        {
          column: 12,
          margin: 5,
          cellHeight: 90,
          staticGrid: true,
          disableResize: true,
          disableDrag: true
        },
        gridRef.current
    );
  }, []);

  useEffect(() => {
    getClans().then(setClans).catch(console.error);
  }, []);

  return (
      <>
          <Navbar />

          <div className="grid-stack" ref={gridRef}>
          <ClanListContainer
              clans={clans}
              onSelectClan={setSelectedClan}
          />

          <ClanDetailsContainer clan={selectedClan} />

         <ClanMitgliederList clans={clans} onSelectClan={setSelectedClan} />
          </div>
      </>
  );
}
