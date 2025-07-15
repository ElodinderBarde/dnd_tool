export default function NpcNotes() {
    return (
        <div>
            <div>
                <h3>👤 Mitarbeitende zuweisen</h3>
                <p>(Platzhalter)</p>
                <label>Shop wählen:
                    <select>
                        <option>Shop 1</option>
                        <option>Shop 2</option>
                    </select>
                </label>
                <label>Mitarbeitende:
                    <select multiple>
                        <option>Mitarbeiter A</option>
                        <option>Mitarbeiter B</option>
                    </select>
                </label>
                <button>Zuweisen</button>
            </div>
        </div>
    );
}
