import { useState, useEffect } from "react";

export default function ShopNotes({ selectedShop, onSave }) {
    const [note, setNote] = useState("");

    useEffect(() => {
        if (selectedShop) {
            setNote(selectedShop.notes || "");
        }
    }, [selectedShop]);


    const handleSave = () => {
        if (!selectedShop) return;
        onSave(note);
    };

    return (
        <div style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "flex-start",
            width: "100%"

        }}>
            <h3>Notizen zu: {selectedShop.name}</h3>
            <div style={{ width: "100%" }}>
                <textarea
                    className="form-input2"
                    value={note}
                    onChange={(e) => setNote(e.target.value)}
                />
            </div>
            <button className="form-button" onClick={handleSave}>Speichern</button>
        </div>
    );
}


