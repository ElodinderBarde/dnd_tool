import "./SelectList.css";

export default function SelectList({
                                       items,
                                       activeId,
                                       onSelect,
                                       getLabel,
                                       getId,
                                   }) {
    return (
        <ul className="select-list">
            {items.map((item) => {
                const id = getId(item);
                const isActive = id === activeId;

                return (
                    <li
                        key={id}
                        className={`select-list-item ${isActive ? "active" : ""}`}
                        onClick={() => onSelect(item)}
                    >
                        <span className="bullet" />
                        <span className="label">{getLabel(item)}</span>
                    </li>
                );
            })}
        </ul>
    );
}
