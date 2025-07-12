import { useEffect, useState } from "react";
import { getCities, getShopTypes } from "../../service/shopsAPI";

export default function ShopFilter({ selectedCity, setSelectedCity, selectedType, setSelectedType }) {
  const [cities, setCities] = useState([]);
  const [types, setTypes] = useState([]);

  useEffect(() => {
    getCities().then(setCities).catch(console.error);

    getShopTypes()
        .then((data) => {
          console.log("ShopTypes geladen:", data);
          setTypes(data);
        })
        .catch(console.error);
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
          <select
              value={typeof selectedType === "number" ? selectedType.toString() : ""}
              onChange={(e) => {
                const value = e.target.value;
                const parsed = parseInt(value, 10);
                setSelectedType(isNaN(parsed) ? null : parsed);
              }}
          >
            <option value="">Alle Typen</option>
            {Array.isArray(types) && types
                .filter((type) => type && typeof type.id === "number" && typeof type.name === "string")
                .map((type) => (
                    <option key={type.id} value={type.id.toString()}>
                      {type.name}
                    </option>
                ))}
          </select>
        </label>

      </div>
    </div>
  );
}
