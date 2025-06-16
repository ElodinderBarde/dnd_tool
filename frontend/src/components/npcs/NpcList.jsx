export default function NpcList({ npcs, onSelect }) {
    return (
      <ul>
        {npcs.map(npc => (
          <li key={npc.npc_ID} onClick={() => onSelect(npc)}>
            {npc.firstname?.name} {npc.lastname?.name}
          </li>
        ))}
      </ul>
    );
  }
  