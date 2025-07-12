import { useEffect, useState } from "react";
import { createShop, getCities, getShopTypes } from "../../service/shopsAPI";
import "./shops.css";

export default function ShopCreate() {
  const [name, setName] = useState("");
  const [cityID, setCityID] = useState("");
  const [shopTypeID, setShopTypeID] = useState("");
  const [cities, setCities] = useState([]);
  const [types, setTypes] = useState([]);
  const [notes, setNotes] = useState("");

  useEffect(() => {
    getCities().then(setCities);
    getShopTypes().then(setTypes);
  }, []);

  const handleCreate = async () => {
    // Validierung
    if (!name || !cityID || !shopTypeID) {
      alert("Bitte Name, Stadt und Typ auswählen!");
      return;
    }

    const shop = {
      name,
      notes,
      shopTypeId: parseInt(shopTypeID, 10),
      locationId: parseInt(cityID, 10),
    };

    console.log("Shop-Daten zum Senden:", shop); // <-- Debug!

    try {
      await createShop(shop);
      alert("Shop erstellt!");
      setName("");
      setCityID("");
      setShopTypeID("");
      setNotes("");
    } catch (e) {
      alert("Fehler beim Erstellen");
      console.error(e);
    }
  };


  return (
      <div className="grid-stack-item" gs-x="0" gs-y="2" gs-w="6" gs-h="3">
        <div className="grid-stack-item-content">
          <h3>Shop erstellen</h3>

          <div className="form-row">
            <div className="form-group">
              <label>Shopname:</label>
              <input className="form-input" type="text" value={name} onChange={(e) => setName(e.target.value)} />
            </div>

            <div className="form-group">
              <label>Stadt:</label>
              <select className="form-select" value={cityID} onChange={(e) => setCityID(e.target.value)}>
                <option value="">Stadt wählen</option>
                {cities.map((c) => <option key={c.id} value={c.id}>{c.city_name}</option>)}
              </select>
            </div>

            <div className="form-group">
              <label>Typ:</label>
              <select className="form-select" value={shopTypeID} onChange={(e) => {
                const value = parseInt(e.target.value, 10);
                setShopTypeID(isNaN(value) ? "" : value);
              }}>
                <option value="">Typ wählen</option>
                {types.map((t) => (
                    <option key={t.id} value={t.id}>
                      {t.name}
                    </option>
                ))}
              </select>
            </div>
          </div>

          <div className="form-row">
            <div className="form-group flex-grow">
              <label>Notizen:</label>
              <textarea
                  className="form-input2"
                  value={notes}
                  onChange={(e) => setNotes(e.target.value)}
              />
            </div>
            <div className="form-group bottom-align">
              <button className="form-button" onClick={handleCreate}>Erstellen</button>
            </div>
          </div>
        </div>
      </div>

  );

}
