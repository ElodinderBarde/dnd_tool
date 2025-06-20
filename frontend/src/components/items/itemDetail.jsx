export default function ItemDetail({ item }) {
    if (!item) return null;
  
    return (
      <div className="item-detail">
        <h2>{item.name}</h2>
        <p><strong>Typ:</strong> {item.typ}</p>
        <p><strong>Preis:</strong> {item.price}g</p>
        <p><strong>Seltenheit:</strong> {item.seltenheit ? item.seltenheit : <em>Unbekannt</em>}</p>
        <p>{item.beschreibung ? item.beschreibung : <em>Keine Beschreibung vorhanden. </em>}</p>

        <p className="platzhalter">testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest</p>
      </div>
    );
  }
  