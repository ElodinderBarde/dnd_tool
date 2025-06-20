import { useEffect, useRef, useState } from "react";
import { GridStack } from "gridstack";
import "gridstack/dist/gridstack.min.css";
import "../components/shops/shops.css";

import Navbar from "../components/Navbar";
import ShopFilter from "../components/shops/ShopFilter";
import ShopList from "../components/shops/ShopList";
import ShopCreate from "../components/shops/ShopCreate";
import ShopEmployeeAssign from "../components/shops/ShopEmployeeAssign";

import { getShops } from "../service/shopsAPI";

export default function ShopPage() {
  const gridRef = useRef(null);
  const [shops, setShops] = useState([]);
  const [selectedCity, setSelectedCity] = useState("");
  const [selectedType, setSelectedType] = useState("");

  useEffect(() => {
    const grid = GridStack.init(
      {
        column: 12,
        margin: 5,
        float: false,
        cellHeight: 100,
        staticGrid: true,
        disableResize: true,
        disableDrag: true,
      
      },
      gridRef.current
    );

    getShops()
      .then(setShops)
      .catch((err) => console.error("Fehler beim Laden der Shops:", err));

    return () => grid.destroy(false); // Aufräumen bei Verlassen
  }, []);

  return (
    <>
      <Navbar />
      <div className="grid-stack" ref={gridRef}>
        <ShopFilter
          selectedCity={selectedCity}
          setSelectedCity={setSelectedCity}
          selectedType={selectedType}
          setSelectedType={setSelectedType}
        />

        <ShopList
          shops={shops}
          selectedCity={selectedCity}
          selectedType={selectedType}
        />

        <ShopCreate />

        <ShopEmployeeAssign />
      </div>
    </>
  );
}
