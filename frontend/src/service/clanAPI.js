const API_URL = 'http://localhost:8081/api/clan';

export async function getClans() {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error('Fehler beim Laden der Clans');
  return await response.json();
}

export async function createClan(clan) {
  const response = await fetch(API_URL +"/createClan", {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(clan),
  });

  if (!response.ok) throw new Error('Fehler beim Erstellen des Clans');
  return await response.json();



}