import { useEffect, useState } from "react";
import { getCities, getShopTypes } from "../../service/shopsAPI";

export default function ShopFilter({ selectedCity, setSelectedCity, selectedType, setSelectedType }) {
  const [cities, setCities] = useState([]);
  const [types, setTypes] = useState([]);

  useEffect(() => {
    getCities().then(setCities).catch(console.error);
    getShopTypes().then(setTypes).catch(console.error);
  }, []);

  return (
    <div className="grid-stack-item" gs-x="1" gs-y="0" gs-w="6" gs-h="1">
      <div className="grid-stack-item-content" style={{ flexDirection: "column", alignItems: "flex-start" }}>
        <label>
          Stadt:
          <select value={selectedCity} onChange={(e) => setSelectedCity(e.target.value)}>
            <option value="">Alle Städte</option>
            {cities.map((city) => (
              <option key={city.id} value={city.id}>
                {city.city_name}
              </option>
            ))}
          </select>
        </label>

        <label style={{ marginTop: "1rem" }}>
          Shoptyp:
          <select value={selectedType} onChange={(e) => setSelectedType(e.target.value)}>
            <option value="">Alle Typen</option>
            {types.map((type) => (
              <option key={type.shop_type_ID} value={type.shop_type_ID}>
                {type.name}
              </option>
            ))}
          </select>
        </label>
      </div>
    </div>
  );
}
