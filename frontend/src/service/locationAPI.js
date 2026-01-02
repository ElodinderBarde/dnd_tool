const API_URL = 'http://localhost:8081/api/locations';

export async function getLocation() {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error('Fehler beim Laden der Location');
  return await response.json();
}

export async function createLocation(location) {
  const response = await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(location),
  });

  if (!response.ok) throw new Error('Fehler beim Erstellen der Ortschaft');
  return await response.json();
}


export async function createLocationNote(locationNote) {
    const response = await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(locationNote),
    });
  
    if (!response.ok) throw new Error('Fehler beim Erstellen der Ortschaftsnotiz');
    return await response.json();
  }
  