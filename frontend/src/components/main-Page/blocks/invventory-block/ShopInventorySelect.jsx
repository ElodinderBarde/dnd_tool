import SelectList from "../../elements/SelectList/SelectList.jsx";
import { useShopItems } from "./UseShopItems.js";

export default function ShopInventorySelect({ shopId, onSelectItem }) {
    const { shopItems, loading } = useShopItems(shopId);

    if (!shopId) {
        return <p style={{ padding: "0.5rem", color: "#888" }}>
            Bitte zuerst einen Shop auswählen.
        </p>;
    }

    if (loading) {
        return <p style={{ padding: "0.5rem" }}>Lade Items…</p>;
    }

    const visibleItems = shopItems.filter(
        i => (i.menge ?? i.quantity ?? 0) > 0
    );

    if (visibleItems.length === 0) {
        return <p style={{ padding: "0.5rem", width: "100%" }}>
            Das Geschäft ist zur Zeit ausverkauft.
        </p>;
    }

    return (
        <SelectList

            items={visibleItems}
            onSelect={onSelectItem}
            getId={(i) => i.shopItemId}

            style={{ width: "100%" }}
            getLabel={(i) => (
                <span>
                    {i.item?.name ?? "Unbekannt"}
                    <br />
                    <small>
                        {i.item?.price ?? "?"}g ·
                        {i.item?.seltenheit ?? "-"} ·
                        Menge: {i.menge ?? i.quantity}
                    </small>
                </span>
            )}
        />
    );
}
