const API_BASE_URL = "http://localhost:8081/api/Quest";



export async function getActiveQuests() {
    const res = await fetch(`${API_BASE_URL}/active`);
    if (!res.ok) throw new Error("Failed to load active quests");
    return res.json();
}
