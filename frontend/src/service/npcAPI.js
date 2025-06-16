export async function getNpcs() {
    const response = await fetch('/api/npcs');
    if (!response.ok) {
      throw new Error('Fehler beim Laden der NPCs');
    }
    return await response.json();
  }
  