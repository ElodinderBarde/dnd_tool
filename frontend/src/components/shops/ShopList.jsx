export default function ShopList({ shops, selectedCity, selectedType }) {
  const filteredShops = shops.filter((shop) => {
    const matchesCity = !selectedCity || shop.location?.cityID?.id == selectedCity;
    const matchesType = !selectedType || shop.shop_type?.shop_type_ID == selectedType;
    return matchesCity && matchesType;
  });

  return (
    <div className="grid-stack-item" gs-x="6" gs-y="0" gs-w="6" gs-h="8">
      <div className="grid-stack-item-content" style={{ flexDirection: "column", alignItems: "flex-start", overflowY: "auto" }}>
        
        <ul style={{ paddingLeft: "1rem" }}>
          {filteredShops.map((shop) => (
            <li key={shop.shop_ID}>
              <strong>{shop.name}</strong>
              {shop.shop_type?.name && ` (${shop.shop_type.name})`}
              {shop.location?.cityID?.city_name && ` – ${shop.location.cityID.city_name}`}
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}
