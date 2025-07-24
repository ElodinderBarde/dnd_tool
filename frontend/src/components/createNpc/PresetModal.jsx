import React, { useMemo, useState } from "react";

export default function PresetModal({
                                        isOpen,
                                        title,
                                        columns,
                                        data,
                                        filterKeys,
                                        onSelect,
                                        onClose,
                                        selectedGenderId,
                                        selectedRaceId
                                    }) {
    const [search, setSearch] = useState("");


    const filteredData = useMemo(() => {
        if (!isOpen) return [];

        const requiresRaceFilter = filterKeys.includes("race");
        const requiresGenderFilter = filterKeys.includes("gender");

        // Mapping: ID (number) → Name (string)
        const genderMap = {
            1: "Male",
            2: "Female",
            3: "Unisex"
        };

        // Vor dem Filter initialisieren!
        const normalizedSelectedGender = requiresGenderFilter && selectedGenderId !== undefined
            ? genderMap[selectedGenderId]
            : undefined;

        function normalizeGenderString(gender) {
            if (typeof gender !== "string") return gender;
            const lower = gender.toLowerCase();
            if (lower === "other") return "Unisex";
            if (lower === "male") return "Male";
            if (lower === "female") return "Female";
            return gender;
        }

        return data.filter((row) => {
            const raceId =
                row.race?.id ??
                row.race?.race_ID ??
                row.race?.raceId ??
                row.raceId ??
                row.race_id;

            const genderId = normalizeGenderString(
                row.gender?.gendername ??
                row.gender ??
                row.gender?.gender_ID ??
                row.genderId ??
                row.gender_id
            );

            const matchesRace =
                !requiresRaceFilter || selectedRaceId === undefined || raceId === selectedRaceId;

            const matchesGender =
                !requiresGenderFilter || normalizedSelectedGender === undefined || genderId === normalizedSelectedGender;

            const matchesSearch = filterKeys.some((key) => {
                let value = row[key];
                if (key === "race" && typeof row.race === "object") value = row.race.racename;
                if (key === "gender" && typeof row.gender === "object") value = row.gender.gendername;
                if (key === "name" && row.firstname) value = row.firstname;
                if (key === "name" && row.lastname) value = row.lastname;
                return String(value).toLowerCase().includes(search.toLowerCase());
            });

            return matchesRace && matchesGender && matchesSearch;
        });
    }, [isOpen, data, search, filterKeys, selectedRaceId, selectedGenderId]);

    if (!isOpen) return null;


    return (

        <div className="modal-overlay">
            <div className="modal-box" style={{ maxHeight: "80vh", overflow: "hidden", display: "flex", flexDirection: "column" }}>
                <h2>{title}</h2>

                <input
                    type="text"
                    placeholder="Suche..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    style={{ width: "100%", marginBottom: "1rem" }}
                />
                <div style={{ overflowY: "auto", border: "1px solid #444" }}>

                <table>
                    <thead>
                    <tr>
                        {columns.map((col, idx) => (
                            <th key={idx}>{col}</th>
                        ))}
                    </tr>
                    </thead>
                    <tbody>
                    {filteredData.map((row, rowIndex) => (
                        <tr key={rowIndex} onClick={() => onSelect(row)} style={{ cursor: "pointer" }}>
                            {columns.map((col, colIndex) => {
                                const key = toCamelCase(col);
                                let value = row[key];

                                if (key === "race" && row.race?.racename) value = row.race.racename;
                                if (key === "gender" && row.gender?.gendername) value = row.gender.gendername;
                                if (key === "firstname") value = row.firstname;
                                if (key === "lastname") value = row.lastname;

                                if (key === "personality") value = row.description;
                                if (key === "otherDescription") value = row.description;
                                if (key === "likes") value = row.description;
                                if (key === "dislikes") value = row.description;
                                if (key === "ideals") value = row.description;

                                if (key === "kleidungsQuali") value = row.description;
                                if (key === "jackets") value = row.name;
                                if (key === "trousers") value = row.name;
                                if (key === "hairstyle") value = row.name;
                                if (key === "hairColor") value = row.name;
                                if (key === "bearstyle") value = row.name;

                                return <td key={colIndex}>{value}</td>;
                            })}


                        </tr>
                    ))}
                    </tbody>
                </table>
                </div>
                <button onClick={onClose}>Abbrechen</button>
            </div>
        </div>
    );
}

// optionaler Helfer: "Vorname" → "vorname"
function toCamelCase(text) {
    return text.charAt(0).toLowerCase() + text.slice(1);
}
