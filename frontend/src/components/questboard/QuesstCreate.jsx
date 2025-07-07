export default function QuesstCreate() {
    return (
        <div className="quest-create-container">
            <h3>Neue Quest erstellen:</h3>

            <div className="form-group">
                <label>Questreihe:</label>
                <input type="checkbox" />
            </div>

            <div className="form-group">
                <label>Vorherige Quest:</label>
                <select>
                    <option>Bitte wählen...</option>
                </select>
            </div>

            <div className="form-group">
                <label>Questgruppe:</label>
                <input type="text" />
            </div>

            <div className="form-group">
                <label>Beschreibung:</label>
                <input type="text" />
            </div>

            <div className="form-group">
                <label>Ortschaft:</label>
                <select>
                    <option>Bitte wählen...</option>
                </select>
            </div>

            <div className="form-group">
                <label>Status:</label>
                <select>
                    <option>Bitte wählen...</option>
                </select>
            </div>

            <div className="form-group">
                <label>Belohnung:</label>
                <input type="text" />
            </div>

            <div className="form-group">
                <label>Item:</label>
                <input type="text" />
                <input type="checkbox" />
            </div>

            <div className="form-group">
                <label>Gold:</label>
                <input type="number" />
            </div>

            <div className="form-group npc-function-section">
                <div className="npc-box">
                    <label>Wichtige NPC:</label>
                    <div className="npc-placeholder"></div>
                    <button>+</button>
                </div>
                <div className="function-box">
                    <label>Funktion:</label>
                    <div className="function-placeholder"></div>
                </div>
            </div>

            <div className="form-group">
                <label>Notizen:</label>
                <textarea placeholder="Hier könnten Ihre Questnotes stehen ..." rows="6"></textarea>
            </div>

            <button className="save-button">Speichern</button>
        </div>
    );
}
