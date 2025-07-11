// src/components/ItemPresets/ItemPresets.js

const presets = {
    taverne: {
        label: "Taverne",
        items: [
            { typ: "Lebensmittel", rarity: null, quantity: 35 },
            { typ: "Lebensmittel", rarity: null, quantity: 10 },
            { typ: "Other", rarity: "common", quantity: 5 },
        ]
    },
    cityshop: {
        label: "Shop Stadt",
        items: [
            { typ: null, rarity: "rare", quantity: 1 },
            { typ: null, rarity: "uncommon", quantity: 3 },
            { typ: null, rarity: "common", quantity: 10 },
            { typ: "Tränke", rarity: null, quantity: 5 },
            {typ: "Edelsteine", rarity: null, quantity: 3 },
        ]
    },
    alchemist: {
        label: "Alchemist",
        items: [
            { typ: "Tränke", rarity: "rare", quantity: 2 },
            { typ: "Tränke", rarity: "uncommon", quantity: 5 },
            { typ: "Tränke", rarity: "common", quantity: 10 },
            { typ: "Zutaten", rarity: null, quantity: 15 },
        ]
    },
    waffenladen: {
        label: "Waffenladen",
        items: [
            { typ: "Weapons", rarity: "rare", quantity: 1 },
            { typ: "Weapons", rarity: "uncommon", quantity: 3 },
            { typ: "Weapons", rarity: "common", quantity: 5 },
            { typ: "Armor", rarity: null, quantity: 5 },
        ]
    },
    schmied: {
        label: "Schmied",
        items: [
            { typ: "Rüstung", rarity: "rare", quantity: 1 },
            { typ: "Rüstung", rarity: "uncommon", quantity: 2 },
            { typ: "Werkzeug", rarity: null, quantity: 5 },
            { typ: "Material", rarity: null, quantity: 10 },
        ]
    },
};

export default presets;
