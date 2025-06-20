export default function ShopEmployeeAssign() {
    return (
      <div className="grid-stack-item" gs-x="0" gs-y="5" gs-w="6" gs-h="4">
        <div className="grid-stack-item-content" style={{ flexDirection: "column", alignItems: "flex-start" }}>
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
  