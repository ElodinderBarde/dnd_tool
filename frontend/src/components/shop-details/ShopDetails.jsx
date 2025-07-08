import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

export default function ShopDetail() {
    const { shopId } = useParams(); // Holt die ID aus der URL
    const [shop, setShop] = useState(null);

    useEffect(() => {
        const fetchShop = async () => {
            try {
                const response = await fetch(`http://localhost:8081/api/Shop/${shopId}`);
                const data = await response.json();
                setShop(data);
            } catch (error) {
                console.error('Fehler beim Laden des Shops:', error);
                console.log("Lade Shop mit ID:", shopId);

            }
        };

        void fetchShop();
    }, [shopId]);

    if (!shop) {
        return <p>Bitte versuche es nochmals...</p>;
    }

    return (

        <div>
            <div>
                <h2>{shop.name}</h2>
                <h3>{shop.location?.cityID?.city_name ?? "Ort unbekannt"}</h3>

            </div>
        </div>
    );
}
