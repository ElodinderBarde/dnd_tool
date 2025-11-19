import { useEffect, useState } from "react";
import "./ClanNotesModal.css";
import { getClanNotes } from "../../service/clanAPI.js";

export default function ClanNotesModal({ clanId, initialText, onClose, onSave }) {

    const [text, setText] = useState(initialText || "");
    const [originalText, setOriginalText] = useState(initialText || "");

    // Beim Öffnen neu von Backend laden
    useEffect(() => {
        if (clanId) {
            getClanNotes(clanId).then((fetched) => {
                setText(fetched || "");
                setOriginalText(fetched || "");
            });
        }
    }, [clanId]);

    function handleCancel() {
        if (text !== originalText) {
            const confirmExit = window.confirm("Änderungen verwerfen?\nDiese können nicht rückgängig gemacht werden!");
            if (!confirmExit) return;
        }
        onClose();
    }

    function handleSave() {
        if (text !== originalText) {
            const confirmExit = window.confirm("Änderungen Speichern?\nDiese können nicht rückgängig gemacht werden!");
            if (!confirmExit) return;
        }

        onSave(text);
    }

    return (
        <div className="modal-overlay">
            <div className="modal-container">

                <textarea
                    className="modal-textarea"
                    value={text}
                    onChange={(e) => setText(e.target.value)}
                />

                <div className="modal-buttons">
                    <button className="modal-btn cancel" onClick={handleCancel}>Abbrechen</button>
                    <button className="modal-btn save" onClick={handleSave}>Speichern</button>
                </div>
            </div>
        </div>
    );
}
