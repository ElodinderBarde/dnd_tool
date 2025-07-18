import { useEffect, useState } from 'react';
import { getItemResources } from '../../service/itemAPI';

export default function ResourceFilter({ onFilterChange }) {
  const [resources, setResources] = useState([]);
  const [typFilter, setTypFilter] = useState('');
  const [buchFilter, setBuchFilter] = useState('');
  const [sortOption, setSortOption] = useState('');

  useEffect(() => {
    getItemResources()
      .then(setResources)
      .catch((err) => console.error("Fehler beim Laden der Ressourcen:", err));
  }, []);

  useEffect(() => {
    onFilterChange({ buch: buchFilter, typ: typFilter, sort: sortOption });
  }, [buchFilter, typFilter, sortOption]);

  return (
    <div className="resource-filter">
      <h4>Filter</h4>

      <label>Buch:</label>
      <select value={buchFilter} onChange={(e) => setBuchFilter(e.target.value)}>
        <option value="">Alle</option>
        {resources.map((r, i) => (
          <option key={i} value={r}>{r}</option>
        ))}
      </select>
      <br />
      <label>Typ:</label>
      <select value={typFilter} onChange={(e) => setTypFilter(e.target.value)}>
        <option value="">Alle</option>
        <option value="Lebensmittel">Lebensmittel</option>
        <option value="Transportmittel">Transportmittel</option>
        <option value="Waffe">Waffen</option>
        <option value="Kunstgegenstände">Kunstgegenstände</option>
        <option value="Zutaten">Zutaten</option>
        <option value="Trank">Tränke</option>
        <option value="Other">Andere</option>
        <option value="Edelsteine">Edelsteine</option>
        <option value="Buch">Buch</option>
          <option value="Dienstleistung">Dienstleistung</option>
          <option value="Gift">Gift</option>
          <option value="Handelsgüter">Handelsgüter</option>
          <option value="Instrument">Instrument</option>
          <option value="Ring">Ring</option>
          <option value="Rohstoff">Rohstoff</option>
          <option value="Sattelzeug">Sattelzeug</option>
          <option value="Schriftrolle">Schriftrolle</option>
          <option value="Tiere">Tiere</option>
          <option value="Rüstung">Rüstung</option>
          <option value="Werkzeug">Werkzeug</option>
          <option value="Wundersamer Gegenstand">Wundersamer Gegenstand</option>
          <option value="Zauberstab">Zauberstab</option>
          <option value="Zauberstecken">Zauberstecken</option>
          <option value="Zepter">Zepter</option>
          <option value="Zutaten">Zutaten</option>
          <option value="Other">Anderes</option>
          <option value="Werkzeug">Werkzeug</option>
          <option value="Werkzeug">Werkzeug</option>






      </select>
      <br />
      <label>Sortierung:</label>
      <select value={sortOption} onChange={(e) => setSortOption(e.target.value)}>
        <option value="">Keine</option>
        <option value="price-asc">Preis aufsteigend</option>
        <option value="price-desc">Preis absteigend</option>
        <option value="alpha-asc">A–Z</option>
        <option value="alpha-desc">Z–A</option>
      </select>
    </div>
  );
}
