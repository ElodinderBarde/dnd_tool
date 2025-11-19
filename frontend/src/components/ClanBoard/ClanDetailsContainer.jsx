import "./ClanDetailsContainer.css";
import ClanNotesModal from "./ClanNotesModal.jsx";
import { saveClanNotes } from "../../service/clanAPI.js";
import { useState } from "react";

export default function ClanDetailsContainer({ clan, refreshClan }) {

    const [showModal, setShowModal] = useState(false);

    async function handleSave(newText) {

        // 1. ID-Schutz
        if (!clan?.id) {
            console.error("Clan hat keine gültige ID");
            return;
        }

        // 2. Änderungen speichern
        await saveClanNotes(clan.id, newText);

        // 3. Nur diesen Clan neu laden
        await refreshClan(clan.id);

        // 4. Modal schließen
        setShowModal(false);
    }

    function isFamilyClan(clan) {
        if (!clan) return "Unbekannt";
        if (clan.familienclan === "Y") return "Ja";
        if (clan.familienclan === "N") return "Nein";
        return "Unbekannt";
    }

    return (
        <div className="grid-stack-item" gs-w="10" gs-h="2" gs-x="2" gs-y="0">
            <div className="grid-stack-item-content clan-details-container">

                {showModal && (
                    <ClanNotesModal
                        clanId={clan.id}
                        initialText={clan.clanNotes}
                        onClose={() => setShowModal(false)}
                        onSave={handleSave}
                    />
                )}

                {clan ? (
                    <div className="details-grid">

                        <div className="details-left">
                            <div className="row">
                                <p><strong>Name:</strong> {clan.clan}</p>
                                <p><strong>Familienclan:</strong> {isFamilyClan(clan)}</p>
                            </div>

                            <div className="row">
                                <p><strong>Mitglieder:</strong> {clan.mitglieder}</p>
                                <p><strong>Hauptsitz:</strong> {clan.cityName || clan.villageName || "Unbekannt"}</p>
                            </div>

                            <div className="button-row">
                                <button className="details-btn">Mitglieder verwalten</button>

                                <button className="details-btn" onClick={() => setShowModal(true)}>
                                    Notizen vergrößern
                                </button>
                            </div>
                        </div>

                        <div className="details-right">
                            <div className="details-notes-box">
                                {clan.clanNotes || "Hier könnten Ihre Clannotes stehen!"}
                            </div>
                        </div>

                    </div>
                ) : (
                    <div className="clan-details-empty">Wähle einen Clan aus der Liste.</div>
                )}

            </div>
        </div>
    );
}
