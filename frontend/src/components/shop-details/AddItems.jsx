import React, { useState, useEffect } from "react";
import ResourceFilter from "../items/ResourceFilter.jsx";

export default function AddItems({ onClose, shopId }) {
    const [allItems, setAllItems] = useState([]);
    const [filteredItems, setFilteredItems] = useState([]);
    const [selectedItems, setSelectedItems] = useState({});
    const [expandedIndex, setExpandedIndex] = useState(null);

    useEffect(() => {
        const fetchItems = async () => {
            try {
                const response = await fetch(`http://localhost:8081/api/items`);
                if (!response.ok) throw new Error(`Fehler: ${response.status}`);
                const data = await response.json();
                setAllItems(data);
                setFilteredItems(data);
            } catch (err) {
                console.error("Fehler beim Laden:", err);
            }
        };
        fetchItems();
    }, []);

    const handleFilterChange = ({ buch, typ, sort }) => {
        let filtered = [...allItems];
        if (buch) filtered = filtered.filter(item => item.buch === buch);
        if (typ) filtered = filtered.filter(item => item.typ === typ);

        switch (sort) {
            case 'price-asc': filtered.sort((a, b) => a.price - b.price); break;
            case 'price-desc': filtered.sort((a, b) => b.price - a.price); break;
            case 'alpha-asc': filtered.sort((a, b) => a.name.localeCompare(b.name)); break;
            case 'alpha-desc': filtered.sort((a, b) => b.name.localeCompare(a.name)); break;
        }

        setFilteredItems(filtered);
    };

    const toggleExpand = (index) => {
        setExpandedIndex(expandedIndex === index ? null : index);
    };

    const toggleSelect = (id) => {
        setSelectedItems(prev => {
            const updated = { ...prev };
            if (updated[id]) {
                delete updated[id];
            } else {
                updated[id] = 1;
            }
            return updated;
        });
    };


    const handleQuantityChange = (id, quantity) => {
        setSelectedItems(prev => ({
            ...prev,
            [id]: quantity
        }));
    };

    const handleAddItems = async () => {
        try {
            const itemsToAdd = Object.entries(selectedItems)
                .filter(([, qty]) => qty > 0)
                .map(([itemId, qty]) => ({
                    shopId: shopId,             // richtig benannt
                    itemId: parseInt(itemId),
                    quantity: qty
                }));

            console.log("Sende an Server:", itemsToAdd); // Debug für JSON-Body

            if (itemsToAdd.length === 0) {
                alert("Bitte wähle mindestens ein Item mit Menge aus.");
                return;
            }

            const response = await fetch(`http://localhost:8081/api/shopItems/addItems`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(itemsToAdd)
            });

            if (!response.ok) throw new Error(`Fehler beim Hinzufügen: ${response.status}`);
            //alert("Items erfolgreich hinzugefügt!");

            onClose();
        } catch (err) {
            console.error("Fehler beim Hinzufügen:", err);
            alert("Fehler beim Hinzufügen.");
        }
    };


    return (
        <div style={overlayStyle}>
            <div style={modalStyle}>
                <button onClick={onClose} style={closeButtonStyle}>✖</button>
                <h3>🛒 Items hinzufügen</h3>

                <ResourceFilter onFilterChange={handleFilterChange} />

                <div style={{ maxHeight: "60vh", overflowY: "auto", marginTop: "1rem" }}>
                    <table style={{ width: "100%", borderCollapse: "collapse" }}>
                        <thead>
                        <tr style={{ backgroundColor: "#333", color: "#fff" }}>
                            <th>✔</th>
                            <th>Name</th>
                            <th>Preis</th>
                            <th>Typ</th>
                            <th>Seltenheit</th>
                            <th>Menge</th>
                        </tr>
                        </thead>
                        <tbody>
                        {filteredItems.map((item, index) => (
                            <React.Fragment key={item.ID}>
                                <tr
                                    onClick={() => toggleExpand(index)}
                                    style={{
                                        cursor: "pointer",
                                        backgroundColor: index % 2 === 0 ? "#222" : "#111"
                                    }}
                                >
                                    <td>
                                        <input
                                            type="checkbox"
                                            checked={selectedItems[item.id] != null}
                                            onChange={() => toggleSelect(item.id)}
                                            onClick={e => e.stopPropagation()}
                                        />
                                    </td>
                                    <td>{item.name}</td>
                                    <td>{item.price}g</td>
                                    <td>{item.typ}</td>
                                    <td>{item.seltenheit}</td>
                                    <td>
                                        {selectedItems[item.id] != null ? (
                                            <input
                                                type="number"
                                                min="1"
                                                value={selectedItems[item.id]}
                                                onChange={e => handleQuantityChange(item.id, parseInt(e.target.value))}
                                                onClick={e => e.stopPropagation()}
                                                style={{ width: "50px" }}
                                            />
                                        ) : "-"}
                                    </td>
                                </tr>
                                {expandedIndex === index && (
                                    <tr>
                                        <td colSpan="6" style={{ backgroundColor: "#1a1a1a", padding: "0.5rem" }}>
                                            <strong>Beschreibung:</strong> {item.beschreibung || "Keine Beschreibung vorhanden."}
                                        </td>
                                    </tr>
                                )}
                            </React.Fragment>
                        ))}
                        </tbody>
                    </table>
                </div>

                <button
                    onClick={handleAddItems}
                    style={{
                        marginTop: "1rem",
                        padding: "0.5rem 1rem",
                        backgroundColor: "#333",
                        color: "white",
                        border: "none",
                        cursor: "pointer",
                        width: "100%"
                    }}
                >
                    Ausgewählte Items hinzufügen
                </button>
            </div>
        </div>
    );
}



const overlayStyle = {
    position: "fixed",
    top: 0,
    left: 0,
    width: "100vw",
    height: "100vh",
    backgroundColor: "rgba(0,0,0,0.7)",
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    zIndex: 9999
};

const modalStyle = {
    backgroundColor: "#1e1e1e",
    padding: "2rem",
    borderRadius: "8px",
    width: "90%",
    maxHeight: "90%",
    overflowY: "auto",
    position: "relative"
};

const closeButtonStyle = {
    position: "absolute",
    top: "1rem",
    right: "1rem",
    background: "transparent",
    color: "white",
    border: "none",
    fontSize: "1.5rem",
    cursor: "pointer"
};