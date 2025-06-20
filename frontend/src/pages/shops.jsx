import React, { useEffect, useRef } from 'react';
import { GridStack } from 'gridstack';
import 'gridstack/dist/gridstack.min.css';
import Navbar from '../components/Navbar';
import '../components/shops/shops.css';

export default function ShopPage() {
  const gridRef = useRef(null);



  useEffect(() => {
    const grid = GridStack.init(
      {
        column: 12,
        float: true,
        cellHeight: 100,
      },
      gridRef.current
    );
  }, []);

  return (
        <>
    <Navbar />
   <div className="grid-stack" ref={gridRef}>
  <div className="grid-stack-item" gs-x="0" gs-y="0" gs-w="6" gs-h="2">
    <div className="grid-stack-item-content">🏙️ Stadtwahl</div>
  </div>
  <div className="grid-stack-item" gs-x="6" gs-y="0" gs-w="6" gs-h="2">
    <div className="grid-stack-item-content">🛒 Vorhandene Shops</div>
  </div>
  <div className="grid-stack-item" gs-x="0" gs-y="2" gs-w="6" gs-h="2">
    <div className="grid-stack-item-content">➕ Shop erstellen</div>
  </div>
  <div className="grid-stack-item" gs-x="6" gs-y="2" gs-w="6" gs-h="2">
    <div className="grid-stack-item-content">👤 Mitarbeitende zuweisen</div>
  </div>
</div>

    </>
  );
}