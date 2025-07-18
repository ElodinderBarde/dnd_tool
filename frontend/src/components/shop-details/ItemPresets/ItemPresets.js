// src/components/ItemPresets/ItemPresets.js

const presets = {
    taverne: {
        label: "Taverne",
        items: [
            { typ: "Lebensmittel", rarity: null, quantity: 35 },
            { typ: "Lebensmittel", rarity: null, quantity: 10 },
            { typ: "Other", rarity: "common", quantity: 5 },
            { typ: "Wundersamer Gegenstand", rarity: null, quantity: 2},
        ]
    },
    cityshopbig: {
        label: "Shop Stadt gross",
        items: [
            { typ: "Wundersamer Gegenstand", rarity: "null", quantity: 5 },
            { typ: "Wundersamer Gegenstand", rarity: "null", quantity: 3 },
            { typ: "Wundersamer Gegenstand", rarity: "common", quantity: 10 },
            { typ: "Tränke", rarity: null, quantity: 5 },
            {typ: "Edelsteine", rarity: null, quantity: 3 },
            {typ: "Gift", rarity: null, quantity: 2 },
            { typ: "Ring", rarity: null, quantity: 2 },
        ]
    },


    cityshopsmall: {
        label: "Shop Stadt klein",
        items: [
            { typ: "Wundersamer Gegenstand", rarity: "rare", quantity: 1 },
            { typ: "Wundersamer Gegenstand", rarity: "uncommon", quantity: 3 },
            { typ: "Wundersamer Gegenstand", rarity: "common", quantity: 10 },
            { typ: "Tränke", rarity: null, quantity: 5 },
            {typ: "Edelsteine", rarity: null, quantity: 1 },
        ]
    },

    alchemist: {
        label: "Alchemist",
        items: [
            { typ: "Trank", rarity: "rare", quantity: 2 },
            { typ: "Trank", rarity: "uncommon", quantity: 5 },
            { typ: "Trank", rarity: "common", quantity: 10 },
            { typ: "Zutaten", rarity: null, quantity: 15 },
        ]
    },
    waffenladen: {
        label: "Waffenladen",
        items: [
            { typ: "Waffe", rarity: null, quantity: 1 },
            { typ: "Waffe", rarity: null, quantity: 3 },
            { typ: "Waffe", rarity: null , quantity: 5 },
            { typ: "Rüstung", rarity: null, quantity: 5 },
        ]
    },
    schmied: {
        label: "Schmied",
        items: [
            { typ: "Rüstung", rarity: "rare", quantity: 1 },
            { typ: "Rüstung", rarity: "uncommon", quantity: 2 },
            { typ: "Werkzeug", rarity: null, quantity: 5 },
            { typ: "Rohstoff", rarity: null, quantity: 10 },
            { typ: "Waffe", rarity: null, quantity: 8 },
        ]
    },

    circus: {
        label: "Zirkus",
        items: [
            { typ: "Tiere ", rarity: "common", quantity: 10 },
            { typ: "Sattelzeug", rarity: null, quantity: 5 },
            {typ: "Transportmittel", rarity: null, quantity: 5 },
        ]
    },


};





export default presets;
