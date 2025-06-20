// src/api/shopApi.js

const API_URL = 'http://localhost:8081/api/Shop';

//  Alle Shops laden
export async function getShops() {
  const response = await fetch(API_URL);
  if (!response.ok) throw new Error('Fehler beim Laden der Shops');
  return await response.json();
}

// Neuen Shop erstellen
export async function createShop(shop) {
  const response = await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(shop),
  });

  if (!response.ok) throw new Error('Fehler beim Erstellen des Geschäfts');
  return await response.json();
}

// Shop-Beschreibung laden (falls du das brauchst)
export async function getShopDescription() {
  const res = await fetch(`${API_URL}/description`);
  if (!res.ok) throw new Error('Fehler beim Laden der Beschreibung');
  return await res.json();
}

//filter nach Stadt
export async function getCities() {
    const res = await fetch("http://localhost:8081/api/City");
    if (!res.ok) throw new Error("Fehler beim Laden der Städte");
    return await res.json();
  }
  //Filter nach ShopTyp
  export async function getShopTypes() {
    const res = await fetch("http://localhost:8081/api/ShopType");
    if (!res.ok) throw new Error("Fehler beim Laden der Shoptypen");
    return await res.json();
  }