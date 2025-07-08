import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

export default function ShopItems() {
    const { shopId } = useParams();
    const [shopItems, setShopItems] = useState([]);
    const [expandedIndex, setExpandedIndex] = useState(null);
    const [selectedItemIndex, setSelectedItemIndex] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchShopItems = async () => {
            try {
                const response = await fetch(`http://localhost:8081/api/shopItems/shop/${shopId}`);
                if (!response.ok) {
                    throw new Error(`Fehler beim Laden: ${response.status}`);
                }
                const data = await response.json();
                setShopItems(data);
            } catch (error) {
                console.error("Fehler beim Laden der ShopItems:", error);
            } finally {
                setLoading(false);
            }
        };

        fetchShopItems();
    }, [shopId]);

    const toggleExpand = (index) => {
        setExpandedIndex(index === expandedIndex ? null : index);
        setSelectedItemIndex(index === selectedItemIndex ? null : index);
    };

    const updateQuantityInDatabase = async (shopItemId, newQuantity) => {
        try {
            const response = await fetch(`http://localhost:8081/api/shopItems/${shopItemId}/quantity`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(newQuantity)
            });

            if (!response.ok) {
                throw new Error(`Fehler beim Speichern: ${response.status}`);
            }
            console.log(`Menge für Item ${shopItemId} erfolgreich auf ${newQuantity} gesetzt.`);
        } catch (error) {
            console.error("Fehler beim Speichern der Menge:", error);
        }
    };



    const increaseQuantity = () => {
        if (selectedItemIndex !== null) {
            const updatedItems = [...shopItems];
            const item = updatedItems[selectedItemIndex];
            const currentQuantity = item.menge ?? item.quantity ?? 0;
            const newQuantity = currentQuantity + 1;

            item.menge = newQuantity;
            setShopItems(updatedItems);

            // in DB speichern
            updateQuantityInDatabase(item.shopItemId, newQuantity);
        }
    };


    const decreaseQuantity = () => {
        if (selectedItemIndex !== null) {
            const updatedItems = [...shopItems];
            const item = updatedItems[selectedItemIndex];
            const currentQuantity = item.menge ?? item.quantity ?? 0;
            const newQuantity = currentQuantity > 0 ? currentQuantity - 1 : 0;

            item.menge = newQuantity;
            setShopItems(updatedItems);

            // in DB speichern
            updateQuantityInDatabase(item.shopItemId, newQuantity);
        }
    };


    if (loading) {
        return <p>Lade Items...</p>;
    }

    if (!shopItems || shopItems.length === 0) {
        return <p>Das Geschäft ist zur Zeit ausverkauft.</p>;
    }



    return (
        <div style={{
            display: "flex",
            flexDirection: "column",
            height: "100%",
            width: "100%",
            justifyContent: "space-between"
        }}>
            <div style={{ overflowY: "auto", flexGrow: 1 }}>
                <table style={{ width: "100%", borderCollapse: "collapse" }}>
                    <thead>
                    <tr style={{ backgroundColor: "#333", color: "#fff" }}>
                        <th style={thStyle}>Name</th>
                        <th style={thStyle}>Preis</th>
                        <th style={thStyle}>Typ</th>
                        <th style={thStyle}>Seltenheit</th>
                        <th style={thStyle}>Menge</th>
                    </tr>
                    </thead>
                    <tbody>
                    {shopItems.map((item, index) => (
                        <React.Fragment key={item.shopItemId}>
                            <tr
                                onClick={() => toggleExpand(index)}
                                style={{
                                    cursor: "pointer",
                                    backgroundColor: index % 2 === 0 ? "#222" : "#111",
                                    outline: selectedItemIndex === index ? "2px solid #888" : "none"
                                }}
                            >
                                <td style={tdStyle}>{item.item?.itemName || "Unbekannt"}</td>
                                <td style={tdStyle}>{item.item?.price ?? "?"}g</td>
                                <td style={tdStyle}>{item.item?.typ || "-"}</td>
                                <td style={tdStyle}>{item.item?.seltenheit || "-"}</td>
                                <td style={tdStyle}>{item.menge ?? item.quantity ?? "-"}</td>
                            </tr>
                            {expandedIndex === index && (
                                <tr>
                                    <td colSpan="5" style={{ ...tdStyle, backgroundColor: "#1a1a1a" }}>
                                        <strong>Beschreibung:</strong> {item.item?.beschreibung || "Keine Beschreibung vorhanden."}
                                    </td>
                                </tr>
                            )}
                        </React.Fragment>
                    ))}
                    </tbody>
                </table>
            </div>

            <div style={{ display: "flex", justifyContent: "flex-end", gap: "0.5rem", marginTop: "0.5rem" }}>
                <button
                    className="form-button"
                    onClick={increaseQuantity}
                    disabled={selectedItemIndex === null}
                >
                    + Element
                </button>
                <button
                    className="form-button"
                    onClick={decreaseQuantity}
                    disabled={selectedItemIndex === null}
                >
                    - Element
                </button>
                <button
                    className="form-button"
                    disabled
                >
                    Hinzufügen Element
                </button>
            </div>
        </div>
    );
}

const thStyle = {
    padding: "0.5rem",
    textAlign: "left",
    borderBottom: "1px solid #555",
};

const tdStyle = {
    padding: "0.5rem",
    borderBottom: "1px solid #333",
};
