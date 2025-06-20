const API_URL = 'http://localhost:8081/api/city';

export async function getCity() {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error('Fehler beim Laden der Items');
  return await response.json();
}

export async function createCity(city) {
  const response = await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(city),
  });

  if (!response.ok) throw new Error('Fehler beim Erstellen der Stadt');
  return await response.json();
}


