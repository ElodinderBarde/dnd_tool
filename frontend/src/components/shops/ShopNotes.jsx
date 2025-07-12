import { useState, useEffect } from "react";

export default function ShopNotes({ selectedShop }) {
    const [note, setNote] = useState("");
    const [, setOriginalNote] = useState("");

    useEffect(() => {
        if (selectedShop) {
            setNote(selectedShop.notes || "");
            setOriginalNote(selectedShop.notes || "");
        }
    }, [selectedShop]);

    const handleSave = async () => {
        if (!selectedShop) return;

        try {
            const response = await fetch(`http://localhost:8081/api/shops/${selectedShop.id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ notes: note }),
            });

            if (!response.ok) {
                throw new Error(`Fehler beim Speichern: ${response.status}`);
            }

            const updated = await response.json();
            setOriginalNote(updated.notes || "");
            alert("Notiz gespeichert!");
        } catch (error) {
            console.error("Fehler beim Speichern der Notiz:", error);
            alert("Fehler beim Speichern.");
        }
    };

    return (
        <div style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "flex-start",
            width: "100%"
        }}>
            <h3>Notizen zu: {selectedShop?.name ?? "Unbekannt"}</h3>
            <div style={{ width: "100%" }}>
                <textarea
                    className="form-input2"
                    value={note}
                    onChange={(e) => setNote(e.target.value)}
                    rows={10}
                    style={{ width: "100%", resize: "vertical" }}
                />
            </div>
            <button className="form-button" onClick={handleSave}>Speichern</button>
        </div>
    );
}
