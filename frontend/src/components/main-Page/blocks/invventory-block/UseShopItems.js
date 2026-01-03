import { useEffect, useState } from "react";

export function useShopItems(shopId) {
    const [shopItems, setShopItems] = useState([]);
    const [loading, setLoading] = useState(false);

    const fetchShopItems = async () => {
        if (!shopId) return;

        try {
            setLoading(true);
            const res = await fetch(
                `http://localhost:8081/api/shopItems/shop/${shopId}`
            );

            if (!res.ok) {
                if (res.status === 204) {
                    setShopItems([]);
                    return;
                }
                throw new Error(res.status);
            }

            const text = await res.text();
            setShopItems(text ? JSON.parse(text) : []);
        } catch (e) {
            console.error("Fehler beim Laden der ShopItems", e);
            setShopItems([]);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchShopItems();
    }, [shopId]);

    return {
        shopItems,
        loading,
        refresh: fetchShopItems,
    };
}
