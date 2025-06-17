import React, { useEffect, useRef } from 'react';
import { GridStack } from 'gridstack';
import 'gridstack/dist/gridstack.min.css';

export default function DashboardGrid() {
  const gridRef = useRef();

  useEffect(() => {
    const grid = GridStack.init({ /* Optionen */ }, gridRef.current);
    grid.addWidget('<div class="grid-stack-item" gs-w="4" gs-h="2"><div class="grid-stack-item-content">NPC-Stat</div></div>');
    return () => grid.destroy();
  }, []);

  return <div className="grid-stack" ref={gridRef} />;
}
