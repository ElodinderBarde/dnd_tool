const API_URL = "http://localhost:8081/api/shops";


export async function getShopCustomers(shopId) {
    const response = await fetch(`${API_URL}/${shopId}/customers`);
    if (!response.ok) throw new Error("Fehler beim Laden der Kunden");
    return await response.json();
}

export async function getShopEmployees(shopId) {
    const response = await fetch(`${API_URL}/${shopId}/employees`);
    if (!response.ok) throw new Error("Fehler beim Laden der Mitarbeitenden");
    return await response.json();
}
export async function getEmployees(shopId) {
    if (!shopId) throw new Error("shopId fehlt");

    const res = await fetch(
        `${API_URL}/${shopId}/employees`    );
    if (!res.ok) throw new Error("Fehler beim Laden der Mitarbeitenden");
    return res.json();
}
export async function getCustomers(shopId) {
    if (!shopId) throw new Error("shopId fehlt");

    const res = await fetch(
        `${API_URL}/${shopId}/customers`    );
    if (!res.ok) throw new Error("Fehler beim Laden der Kunden");
    return res.json();
}