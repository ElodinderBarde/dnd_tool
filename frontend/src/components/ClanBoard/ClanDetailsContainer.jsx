import "./ClanDetailsContainer.css";

function getLocationName(clan) {
    if (!clan) return "Unbekannt";
    if (clan.cityName) return clan.cityName;
    if (clan.villageName) return clan.villageName;
    return "Unbekannt";
}

function getMitgliederAmount(clan) {
    if (!clan || !clan.mitglieder || clan.mitglieder === 0) return "Unbekannt";
    return clan.mitglieder;
}



function isFamilyClan(clan) {
   if(!clan) return "Unbekannt";
   if(clan.familienclan == "Y") return "Ja";
   if(clan.familienclan == "N") return "Nein";
}


export default function ClanDetailsContainer({ clan }) {
    return (
        <div className="grid-stack-item" gs-w="10" gs-h="2" gs-x="2" gs-y="0">
            <div className="grid-stack-item-content clan-details-container">
                {clan ? (
                    <>
                        <div className="details-grid">
                            <div className="details-left">

                                <div className="row">
                                    <p><strong>Name:</strong> {clan.clan}</p>
                                    <p><strong>Familienclan:</strong> {isFamilyClan(clan)}</p>
                                </div>

                                <div className="row">
                                    <p><strong>Mitglieder:</strong> {getMitgliederAmount(clan)}</p>
                                    <p><strong>Hauptsitz:</strong> {getLocationName(clan)}</p>
                                </div>

                                <div className="button-row">
                                    <button className="details-btn">Mitglieder verwalten</button>
                                    <button className="details-btn">Notizen vergrößern</button>
                                </div>

                            </div>

                            <div className="details-right">

                                <div className="details-notes-box">
                                    {clan.clanNotes || "Hier könnten Ihre Clannotes stehen!"}
                                </div>
                            </div>
                        </div>

                    </>
                ) : (
                    <div className="clan-details-empty">
                        Wähle einen Clan aus der Liste.
                    </div>
                )}
            </div>
        </div>
    );
}
