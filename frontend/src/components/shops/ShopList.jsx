import {useNavigate} from "react-router-dom";


export default function ShopList({ shops, selectedCity, selectedType, onShopClick }) {
  const navigate = useNavigate();
  const filteredShops = shops.filter((shop) => {


    const matchesCity = !selectedCity || shop.locationId == selectedCity;
    const matchesType =
        selectedType === null || Number(shop.shopTypeId) === Number(selectedType);




    //console.log("selectedType (typeof):", selectedType, typeof selectedType);
    //console.log("shop.shopTypeId (typeof):", shop.shopTypeId, typeof shop.shopTypeId);

    return matchesCity && matchesType;
  })
  const handleDoubleClick = (shopId) => {
    navigate(`/shops/${shopId}`);
  };

  return (
    <div className="grid-stack-item" gs-x="6" gs-y="0" gs-w="6" gs-h="8">
      <div className="grid-stack-item-content" style={{ flexDirection: "column", alignItems: "flex-start", overflowY: "auto" }}>
        <ul style={{ paddingLeft: "1rem" }}>
          {filteredShops.map((shop) => (
              <li key={shop.id}
                  onClick={() => onShopClick(shop)}
                  onDoubleClick={() => handleDoubleClick(shop.id)}>
              <strong>{shop.name}</strong>
                {shop.shopTypeName && ` (${shop.shopTypeName})`}
                {shop.cityName && ` – ${shop.cityName}`}

              </li>
          ))}
        </ul>
      </div>
    </div>
  );
}
