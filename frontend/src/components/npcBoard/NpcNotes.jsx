import { useState, useEffect } from "react";

export default function NpcNotes({ selectedNpc, className }) {
    const [note, setNote] = useState("");
    const [originalNote, setOriginalNote] = useState("");

    function getNpcDisplayName(npc) {
        if (!npc) return "Unbekannt";



        const fname = npc.firstname?.trim();
        const lname = npc.lastname?.trim();

        if (!fname && !lname) return "Unbekannt";
        return `${fname ?? ""} ${lname ?? ""}`.trim();


    }



    useEffect(() => {

        if (selectedNpc) {
            const noteValue = selectedNpc.notes ?? ""; // null wird zu ""
            setNote(noteValue);
            setOriginalNote(noteValue);


        } else {
            setNote("");
            setOriginalNote("");
        }
    }, [selectedNpc]);




    const handleSave = async () => {
        if (!selectedNpc) return;

        try {
            const response = await fetch(`http://localhost:8081/api/npcs/${selectedNpc.npcId}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ notes: note }),
            });

            if (!response.ok) {
                throw new Error(`Fehler beim Speichern: ${response.status}`);
            }

            alert("Notiz gespeichert!");
        } catch (error) {
            console.error("Fehler beim Speichern der Notiz:", error);
            alert("Fehler beim Speichern.");
        }
    };

    return (
        <div className={`notes-container ${className || ""}`}>

            <textarea
                className="notes-textarea"
                value={note}
                onChange={(e) => setNote(e.target.value)}
                rows={10}
            />

            <button className="form-button" onClick={handleSave}>Speichern</button>
        </div>

    );
}
