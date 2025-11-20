const BASE = "/api/npcs";



export async function getNpcs() {
    const response = await fetch('/api/npcs/dto'); // du nutzt NpcReadDTO
    if (!response.ok) throw new Error('Fehler beim Laden der NPCs');
    return await response.json();
}

export async function getNpcByClan(clanId) {
    const response = await fetch(`${BASE}/byClan/${clanId}`);

    if (!response.ok) throw new Error('Fehler beim Laden der NPCs nach Clan');
    return await response.json();
}


export async function getNpcById(id) {
    const response = await fetch(`${BASE}/${id}`);

    if (!response.ok) throw new Error('Fehler beim Laden des NPCs nach ID');
    return await response.json();
}


export async function updateNpcClan(id, newClan) {
    const response = await fetch(`${BASE}/UpdateClan/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ clan: newClan }),
    });

    if (!response.ok) throw new Error('Fehler beim Aktualisieren des NPC-Clans');
    return await response.json();
}


export async function updateNpcClanPosition(id, newPosition) {
    const response = await fetch(`${BASE}/UpdateClanPosition/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ clanPosition: newPosition }),
    });

    if (!response.ok) throw new Error('Fehler beim Aktualisieren der NPC-Clan-Position');
    return await response.json();
}

