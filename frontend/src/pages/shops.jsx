import React, { useEffect } from 'react';
import { GridStack } from 'gridstack';
import 'gridstack/dist/gridstack.min.css';
import Navbar from '../components/Navbar';
import '../components/shops/shops.css';

export default function ShopPage() {
  useEffect(() => {
    const grid = GridStack.init({
      column: 12,
      cellHeight: 80,
      float: true,
      resizable: { handles: 'e, se, s, sw, w' }
    });

    grid.load([
      { x: 1, y: 1, w: 6, h: 2, content: '<div class="grid-content">Stadtwahl</div>' },
      { x: 6, y: 0, w: 6, h: 2, content: '<div class="grid-content">Shops anzeigen</div>' },
      { x: 0, y: 2, w: 6, h: 2, content: '<div class="grid-content">Shop erstellen</div>' },
      { x: 6, y: 2, w: 6, h: 2, content: '<div class="grid-content">Mitarbeitende hinzufügen</div>' },
    ]);
  }, []);

  return (
        <>
    <Navbar />
    <div className="grid-stack"></div>
    </>
  );
}
