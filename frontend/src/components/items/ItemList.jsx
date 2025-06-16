export default function ItemList({ items, onSelect }) {
  return (
    <ul>
      {items.map((item, i) => (
        <li key={i} onClick={() => onSelect(item)}>
          <strong>{item.name}</strong> –  {item.price}g
        </li>
      ))}
    </ul>
  );
}
