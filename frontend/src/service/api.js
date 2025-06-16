const BASE_URL = 'http://localhost:8081/api';

export async function fetchNpcs() {
  const response = await fetch(`${BASE_URL}/npcs`);
  return response.json();
}
