const API_URL = 'http://localhost:8081/api/clan';

export async function getClans() {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error('Fehler beim Laden der Clans');
  return await response.json();
}

export async function createClan(clan) {
  const response = await fetch(API_URL + "/createClan", {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(clan),
  });

  if (!response.ok) throw new Error('Fehler beim Erstellen des Clans');
  return await response.json();
}



export async function saveClanNotes(id, notes) {
  const response = await fetch(`http://localhost:8081/api/clan/updateNotes/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ clanNotes: notes })
  });

  if (!response.ok) {
    throw new Error("Fehler beim Speichern der Notizen");
  }

  return await response.json();
}

export async function getClanNotes(id) {
  const response = await fetch(`http://localhost:8081/api/clan/GetClanNotes/${id}`);

  if (!response.ok) {
    throw new Error("Fehler beim Laden der Clannotizen");
  }

  return await response.text();   // <- wichtig, NICHT .json()
}


export async function getClanById(id) {
  const response = await fetch(`http://localhost:8081/api/clan/${id}`);

  if (!response.ok) {
    throw new Error("Clan konnte nicht geladen werden");
  }

  return await response.json();
}


