import './CreateNpc.css';
import React, {useState, useEffect} from "react";
import PresetModal from "./PresetModal";
import axios from "axios";



    export default function CreateOptions() {
        const [modalOpen, setModalOpen] = useState(false);
        const [modalField, setModalField] = useState(null);

        // Dropdown-Daten
        const [races, setRaces] = useState([]);
        const [genders, setGenders] = useState([]);
        const [classes, setClasses] = useState([]);
        const [subclass, setSubclass] = useState([]);
        const [locations, setLocations] = useState([]);
        const [shopTypes, setShopTypes] = useState([]);
        const [shops, setShops] = useState([]);
        const [employeeRoles, setEmployeeRoles] = useState([]);
        const [customerRoles, setCustomerRoles] = useState([]);
        const [firstname, setFirstname] = useState([]);
        const [lastname, setLastname] = useState([]);
        const [personality, setPersonality] = useState([]);
        const [otherDescription, setOtherDescription] = useState([]);
        const [likes, setLikes] = useState([]);
        const [ dislikes, setDislikes] = useState([]);
        const [ideals, setIdeals] = useState([]);
        const [kleidungsQuali, setKleidungsQuali] = useState([]);
        const [hairColor, setHairColor] = useState([]);
        const [jackets, setJackets] = useState([]);
        const [trousers, setTrousers] = useState([]);
        const [hairstyle, setHairstyle] = useState([]);
        const [beardstyle, setBeardstyle] = useState([]);





        const initialForm = {
            vorname: "", vornameId: null,
            nachname: "",nachnameId: null,
            age: "",
            race: "",
            genderId: "",
            classId: "",
            subclass: "", subclassID: null,
            npc_lvl: "",
            personality: "", personalityId: null,
            otherDescription: "", otherDescriptionId: null,
            likes: "", likesId: null,
            dislikes: "", dislikesId: null,
            ideals: "", idealsId: null,
            notes: "",
            kleidungsQuali: "", kleidungQualiId: null,
            jackets: "", jacketsId: null,
            trousers: "", trousersId: null,
            hairstyle: "", hairstyleId: null,
            hairColor: "", haircolorId: null,
            beardstyle: "", beardstyleId: null,

            location: "", locationId: null,
            shopType: "", shopTypeId: null,
            shop: "", shopId: null,
            customerOrEmployee: "", customerOrEmployeeId: null,
            employeePosition: "",
            customerRole: ""
        };


        const [form, setForm] = useState(initialForm);


        const [stats, setStats] = useState({
            ATK: 10, CON: 10, WIS: 10, CHA: 10, INT: 10, AC: 10,
        });



        const resolveOrCreateId = async ({ apiName, value, formKey, idKey, matchField }) => {
            if (!value) return null;

            try {
                // 1. Abruf aller existierenden Einträge aus API
                const { data } = await axios.get(`/api/${apiName}`);
                const existing = data.find(e => e[matchField].toLowerCase() === value.toLowerCase());

                if (existing) {
                    return existing[idKey];
                } else {
                    // 2. Falls nicht gefunden, erstelle neuen Eintrag
                    const postData = { [matchField]: value };
                    const { data: created } = await axios.post(`/api/${apiName}`, postData);
                    return created[idKey];
                }
            } catch (err) {
                console.error(`Fehler bei ${formKey}`, err);
                return null;
            }
        };


        useEffect(() => {
            if (form.classId) {
                axios.get(`/api/npcs/Subclasses/byClass/${form.classId}`)
                    .then(res => {
                        console.log("Subklassen geladen:", res.data);
                        setSubclass(res.data);
                    });
            } else {
                console.log("Keine Klasse gewählt, Subklassen geleert");
                setSubclass([]);
            }
        }, [form.classId]);




        useEffect(() => {
            axios.get("/api/Race").then(res => setRaces(res.data));
            axios.get("/api/Gender").then(res => setGenders(res.data));
            axios.get("/api/NpcClass").then(res => setClasses(res.data));
            axios.get("/api/locations").then(res => setLocations(res.data));
            axios.get("/api/ShopType").then(res => setShopTypes(res.data));
            axios.get("/api/shops").then(res => setShops(res.data));
            axios.get("/api/ShopEmployee").then(res => setEmployeeRoles(res.data));
            axios.get("/api/ShopCustomer").then(res => setCustomerRoles(res.data));
            axios.get("/api/Firstname").then(res => setFirstname(res.data));
            axios.get("/api/Lastname").then(res => setLastname(res.data));
            axios.get("/api/Personality").then(res => setPersonality(res.data));
            axios.get("/api/OtherDescription").then(res => setOtherDescription(res.data));
            axios.get("/api/Likes").then(res => setLikes(res.data));
            axios.get("/api/Dislikes").then(res => setDislikes(res.data));
            axios.get("/api/Ideals").then(res => setIdeals(res.data));
            axios.get("/api/KleidungQuali").then(res => setKleidungsQuali(res.data));
            axios.get("/api/Jackets").then(res => setJackets(res.data));
            axios.get("/api/Trousers").then(res => setTrousers(res.data));
            axios.get("/api/Hairstyle").then(res => setHairstyle(res.data));
            axios.get("/api/Haircolor").then(res => setHairColor(res.data));
            axios.get("/api/Beardstyle").then(res => setBeardstyle(res.data));


        }, []);









        const handleChange = (e) => {
            const { name, value } = e.target;
            setForm(prev => ({ ...prev, [name]: value }));

 if (name === "race") {
                setForm(prev => ({
                    ...prev,
                    race: value,
                    raceId: parseInt(value) || null
                }));

                }else if (name === "genderId") {
     console.log("genderId selected:", typeof value, value);
     setForm(prev => ({
         ...prev,
         genderId: parseInt(value) || null
     }));






        } else if (name === "classId") {
                setForm(prev => ({
                    ...prev,
                    classId: parseInt(value) || null
                }));

            } else if (name === "subclass") {
                setForm(prev => ({
                    ...prev,
                    subclass: value,
                    subclassId: parseInt(value) || null
                }));
                }else {
                setForm(prev => ({ ...prev, [name]: value }));
            }
        };

        const renderCell = (label, value, onChange) => (
            <div className="stat-cell">
                <label>{label}</label>
                <input
                    type="number"
                    value={value}
                    onChange={(e) => onChange(label, e.target.value)}
                    style={{ width: "60px", marginLeft: "5px" }}
                />
            </div>
        );

        const handleStatChange = (key, val) => {
            setStats(prev => ({ ...prev, [key]: parseInt(val) || 0 }));
        };


        //TODO: NPC speicherlogik anpassen / überarbeiten.
        // Shop dropdownlogik überarbeiten: Sortieren
        // customer und mitarbeitere dropdown ausblenden

        // frontend darstellung von Informationen funktioniert

        const createNpc = async () => {
            try {
                const firstnameId = await resolveOrCreateId({
                    apiName: "Firstname",
                    value: form.vorname,
                    formKey: "vorname",
                    idKey: "firstname_ID",
                    matchField: "firstname"
                });

                const lastnameId = await resolveOrCreateId({
                    apiName: "Lastname",
                    value: form.nachname,
                    formKey: "nachname",
                    idKey: "lastname_ID",
                    matchField: "lastname"
                });

                const personalityId = await resolveOrCreateId({
                    apiName: "Personality",
                    value: form.personality,
                    formKey: "personality",
                    idKey: "personality_ID",
                    matchField: "description"
                });

                const otherDescriptionId = await resolveOrCreateId({
                    apiName: "OtherDescription",
                    value: form.otherDescription,
                    formKey: "otherDescription",
                    idKey: "otherDescription_ID",
                    matchField: "description"
                });

                const likesId = await resolveOrCreateId({
                    apiName: "Likes",
                    value: form.likes,
                    formKey: "likes",
                    idKey: "likes_ID",
                    matchField: "description"
                });

                const dislikesId = await resolveOrCreateId({
                    apiName: "Dislikes",
                    value: form.dislikes,
                    formKey: "dislikes",
                    idKey: "dislikes_ID",
                    matchField: "description"
                });

                const idealsId = await resolveOrCreateId({
                    apiName: "Ideals",
                    value: form.ideals,
                    formKey: "ideals",
                    idKey: "ideals",
                    matchField: "description"
                });

                const kleidungQualiId = await resolveOrCreateId({
                    apiName: "KleidungQuali",
                    value: form.kleidungsQuali,
                    formKey: "kleidungsQuali",
                    idKey: "kleidungsQuali",
                    matchField: "description"
                });

                const jacketsId = await resolveOrCreateId({
                    apiName: "Jackets",
                    value: form.jackets,
                    formKey: "jackets",
                    idKey: "jackets_ID",
                    matchField: "name"
                });

                const trousersId = await resolveOrCreateId({
                    apiName: "Trousers",
                    value: form.trousers,
                    formKey: "trousers",
                    idKey: "trousers_ID",
                    matchField: "name"
                });

                const hairstyleId = await resolveOrCreateId({
                    apiName: "Hairstyle",
                    value: form.hairstyle,
                    formKey: "hairstyle",
                    idKey: "hairstyle_ID",
                    matchField: "name"
                });

                const haircolorId = await resolveOrCreateId({
                    apiName: "Haircolor",
                    value: form.hairColor,
                    formKey: "hairColor",
                    idKey: "haircolor_ID",
                    matchField: "name"
                });

                const beardstyleId = await resolveOrCreateId({
                    apiName: "Beardstyle",
                    value: form.beardstyle,
                    formKey: "beardstyle",
                    idKey: "beardstyle_ID",
                    matchField: "name"
                });



                const payload = {
                    firstnameId,
                    lastnameId,
                    genderId: form.genderId === "" ? null : parseInt(form.genderId),
                    age: form.age, //
                    raceId: parseInt(form.race) || null,
                    levelId: parseInt(form.npc_lvl) || 1,
                    classId: parseInt(form.classId)||null, //
                    subclassID: parseInt(form.subclass), //
                    personalityId,
                    otherDescriptionId,
                    likesId,
                    dislikesId,
                    idealsId,
                    kleidungQualiId,
                    jacketsId,
                    trousersId,
                    hairstyleId,
                    haircolorId,
                    beardstyleId,
                    notes: form.notes
                };


                console.log("NPC Payload:", payload);
                console.log("classId:", payload.classId);
                console.log("genderId:", payload.genderId);
                console.log("Genders:", genders);



                console.log("Finaler Payload:", payload);
                await axios.post("/api/npcs", payload);
                alert("NPC erfolgreich erstellt!");
                setForm(initialForm);
                setStats({ ATK: 10, CON: 10, WIS: 10, CHA: 10, INT: 10, AC: 10 });
            } catch (err) {
                console.error(err);
                alert("Fehler beim Erstellen des NPCs.");
            }
        };

        const openPreset = (field) => {
            setModalField(field);
            setModalOpen(true);
        };

        const getColumnsForField = (field) => {
            switch (field) {
                case "vorname": return ["firstname", "race", "gender"];
                case "nachname": return ["lastname", "race"];

                case "personality": return ["personality"];
                case "otherDescription": return ["otherDescription"];
                case "likes": return ["likes"];
                case "dislikes": return ["dislikes"];
                case "ideals": return ["ideals"];


                case "kleidungsQuali": return ["kleidungsQuali"];
                case "jackets": return ["jackets", "gender"];
                case "trousers": return ["trousers", "gender"];
                case "hairstyle": return ["hairstyle" , "gender"];
                case "hairColor": return ["hairColor"];
                case "bartstyle": return ["bartstyle"];
                default: return ["Name"];
            }
        };

        const getFilterKeysForField = (field) => {
            switch (field) {
                case "vorname": return ["firstname", "race", "gender"];
                case "nachname": return ["lastname", "race"];

                case "personality": return ["personality"];
                case "otherDescription": return ["otherDescription"];
                case "likes": return ["likes"];
                case "dislikes": return ["dislikes"];
                case "ideals": return ["ideals"];


                case "kleidungsQuali": return ["kleidungsQuali"];
                case "jackets": return ["jackets", "gender"];
                case "trousers": return ["trousers", "gender"];
                case "hairstyle": return ["hairstyle", "gender"];
                case "hairColor": return ["hairColor"];
                case "bartstyle": return ["bartstyle"];
                default: return ["Name"];
            }
        };
        const selectedRaceId = form.race?.raceId;
        const selectedGenderId = form.gender?.genderId;



        return (
            <div className="npc-options-grid">
                {/* LINKE SPALTE: Details */}
                <div className="left-column">

                    <div className="field-row">
                        <label>Volk:</label>
                        <select name="race" value={form.race} onChange={handleChange}>
                            <option value="">Wähle Volk</option>
                            {races.map(r => (
                                <option key={r.id} value={r.id}>{r.racename}</option>
                            ))}
                        </select>
                    </div>



                    <div className="field-row">
                        <label>Geschlecht</label>
                        <select name="genderId" value={form.genderId ?? ""} onChange={handleChange}>
                            <option value="">Wähle ein Geschlecht</option>
                            {genders.map((g) => (
                                <option key={g.gender_ID} value={g.gender_ID}>
                                    {g.gendername}
                                </option>
                            ))}
                        </select>



                    </div>



                    <div className="field-row">
                        <label>Vorname:</label>
                        <input name="vorname" value={form.vorname} onChange={handleChange}
                               disabled={!form.raceId || !form.genderId}
                        />
                        <button onClick={() => openPreset("vorname") } disabled={!form.raceId}>Preset</button>
                    </div>

                    <div className="field-row">
                        <label>Nachname:</label>
                        <input name="nachname" value={form.nachname} onChange={handleChange}disabled={!form.raceId}/>
                        <button onClick={() => openPreset("nachname")} disabled={!form.raceId}>Preset</button>
                    </div>



                    <div className="field-row">
                        <label>Alter:</label>
                        <input name="age" value={form.age} onChange={handleChange}/>
                    </div>




                    <div>
                        <div className="stats-grid">
                            <div className="field-row">
                                <label>Klasse:</label>
                                <select name="classId" value={form.classId || ""} onChange={handleChange}>
                                    <option value="">Wähle eine Klasse</option>
                                    {classes.map(c => (
                                        <option key={c.class_ID} value={c.class_ID}>
                                            {c.classname}
                                        </option>

                                    ))}



                                </select>

                            </div>

                            <div className="field-row">
                                <label>Subklasse:</label>
                                <select
                                    name="subclass"
                                    value={form.subclass}
                                    onChange={handleChange}
                                    disabled={!form.classId}
                                >
                                    <option value="">Wähle eine Subklasse</option>
                                    {subclass.map(sc => (
                                        <option key={sc.subclass_ID} value={sc.subclass_ID}>
                                            {sc.subclassname}
                                        </option>
                                    ))}
                                </select>

                            </div>
                            <div className="field-row">
                                <label>Stufe:</label>
                                <input name="npc_lvl" id={"npc_lvl"} value={form.npc_lvl} onChange={handleChange}/>

                            </div>
                            <br/>
                            <br/>
                            {renderCell("ATK", stats.ATK, handleStatChange)}
                            {renderCell("CON", stats.CON, handleStatChange)}
                            {renderCell("WIS", stats.WIS, handleStatChange)}
                            {renderCell("CHA", stats.CHA, handleStatChange)}
                            {renderCell("INT", stats.INT, handleStatChange)}
                            {renderCell("AC", stats.AC, handleStatChange)}

                        </div>
                        <button onClick={() => {
                            const roll = () => Math.floor(Math.random() * 18) + 3;
                            setStats({ ATK: roll(), CON: roll(), WIS: roll(), CHA: roll(), INT: roll(), AC: roll() });
                        }}>
                            Randomize
                        </button>
                    </div>






                </div>

                <div className="middle-column">
                    <div>
                        <div className="field-row">
                            <label>Persönlichkeit:</label>
                            <input name="personality" value={form.personality} onChange={handleChange}/>
                            <button onClick={() => openPreset("personality")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Weitere Information:</label>
                            <input name="otherDescription" value={form.otherDescription} onChange={handleChange}/>
                            <button onClick={() => openPreset("otherDescription")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Gefällt:</label>
                            <input name="likes" value={form.likes} onChange={handleChange} />
                            <button onClick={() => openPreset("likes")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Gefällt nicht:</label>
                            <input name="dislikes" value={form.dislikes} onChange={handleChange}/>
                            <button onClick={() => openPreset("dislikes")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Ideale:</label>
                            <input name="ideals" value={form.ideals} onChange={handleChange} />
                            <button onClick={() => openPreset("ideals")} >Preset</button>
                        </div>
                        <br/>

                        <label>Notizen:</label>
                        <textarea name="notes" className="notizfeld" value={form.notes} onChange={handleChange} />


                    </div>
                </div>

                <div className="right-column">
                    <div>
                        <div className="field-row">
                            <label>Kleidungsqualität:</label>
                            <input name="kleidungsQuali" value={form.kleidungsQuali} onChange={handleChange} />
                            <button onClick={() => openPreset("kleidungsQuali")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Oberteil:</label>
                            <input name="jackets" value={form.jackets} onChange={handleChange}/>
                            <button onClick={() => openPreset("jackets")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Beinkleid:</label>
                            <input name="trousers" value={form.trousers} onChange={handleChange} />
                            <button onClick={() => openPreset("trousers")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Haarstil:</label>
                            <input name="hairstyle" value={form.hairstyle} onChange={handleChange}/>
                            <button onClick={() => openPreset("hairstyle")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Haarfarbe:</label>
                            <input name="hairColor" value={form.hairColor} onChange={handleChange} />
                            <button onClick={() => openPreset("hairColor")} >Preset</button>
                        </div>
                        <div className="field-row">
                            <label>Bartstil:</label>
                            <input name="beardstyle" value={form.beardstyle} onChange={handleChange}/>
                            <button onClick={() => openPreset("beardstyle")} >Preset</button>
                        </div>

                        <br/>
                        <br/>

                        <div className="field-row">
                            <label>Aufenthaltsort:</label>
                            <select name="location" value={form.location} onChange={handleChange}>
                                <option value="">Wähle eine Ortschaft</option>
                                {locations.map(l => (
                                    <option key={l.id} value={l.id}>{l.cityName || l.villageName}</option>

                            ))}


                            </select>
                        </div>
                        <div className="field-row">
                            <label>Gebäudetyp:</label>
                            <select name="shopType" value={form.shopType} onChange={handleChange}>
                                <option value="">Wähle einen Shoptyp</option>
                                {shopTypes.map(st => (
                                    <option key={st.id} value={st.id}>{st.name}</option>
                                ))}
                            </select>
                        </div>
                        <div className="field-row">
                            <label>Gebäude:</label>
                            <select name="shop" value={form.shops} onChange={handleChange}>
                                <option value="">Wähle ein Gebäude</option>
                                {shops.map(s => (
                                    <option key={s.id} value={s.id}>{s.name}</option>
                                ))}
                            </select>
                        </div>

                        <p>
                        <div className="field-row">
                            <label>
                                Mitarbeiter
                                <input
                                    type="radio"
                                    name="customerOrEmployee"
                                    value="Employee"
                                    checked={form.customerOrEmployee === "Employee"}
                                    onChange={handleChange}
                                />
                            </label>
                            <label>

                                Kunde
                                <input
                                    type="radio"
                                    name="customerOrEmployee"
                                    value="Customer"
                                    checked={form.customerOrEmployee === "Customer"}
                                    onChange={handleChange}
                                />
                            </label>


                        </div>
                        </p>



                        <div className="field-row">
                            <label>Position:</label>
                            <select name="employeePosition" value={form.employeePosition} onChange={handleChange}>
                                <option value="">Wähle den Beruf</option>
                                {employeeRoles.map(er => (
                                    <option key={er.id} value={er.id}>{er.position}</option>
                                ))}
                            </select>
                        </div>
                        <div className="field-row">
                            <label>Kundentyp:</label>
                            <select name="customerRole" value={form.customerRole} onChange={handleChange}>
                                <option value="">Wähle den Kundentyp</option>
                                {customerRoles.map(cr => (
                                    <option key={cr.id} value={cr.id}>{cr.position}</option>
                                ))}
                            </select>
                        </div>


                    </div>
                    <PresetModal
                        isOpen={modalOpen}
                        title={`${modalField} auswählen`}
                        data={
                            modalField === "vorname" ? firstname :
                            modalField === "jackets" ? jackets :
                            modalField === "nachname" ? lastname:
                            modalField ==="personality" ? personality:
                            modalField === "otherDescription" ? otherDescription:
                            modalField === "likes" ? likes:
                            modalField === "dislikes" ? dislikes:
                            modalField === "ideals" ? ideals:
                            modalField === "kleidungsQuali" ? kleidungsQuali:
                            modalField === "trousers" ? trousers:
                            modalField === "hairstyle" ? hairstyle:
                            modalField === "hairColor" ? hairColor:
                            modalField === "beardstyle" ? beardstyle:

                                []
                        }
                        columns={getColumnsForField(modalField)}
                        filterKeys={getFilterKeysForField(modalField)}
                        selectedRaceId={form.raceId}
                        selectedGenderId={form.genderId}
                        currentValue={form[modalField]}
                        onSelect={(entry) => {
                            const entryValueMap = {
                                vorname: "firstname",
                                nachname: "lastname",
                                personality: "description",
                                otherDescription: "description",
                                likes: "description",
                                dislikes: "description",
                                ideals: "description",
                                jackets: "name",
                                trousers: "name",
                                hairstyle: "name",
                                hairColor: "name",
                                beardstyle: "name",
                                kleidungsQuali: "description",
                            };

                            const IdFieldMap = {
                                vorname: "firstname_ID",
                                nachname: "lastname_ID",
                                gender: "gender_ID",
                                personality: "personality_ID",
                                otherDescription: "otherDescription_ID",
                                likes: "likes_ID",
                                dislikes: "dislikes_ID",
                                ideals: "ideals",
                                jackets: "jackets_ID",
                                trousers: "trousers_ID",
                                hairstyle: "hairstyle_ID",
                                hairColor: "haircolor_ID",
                                beardstyle: "beardstyle_ID",
                                kleidungsQuali: "kleidungsQuali",
                            };

                            const resolvedKey = entryValueMap[modalField];
                            const value = typeof entry === "string"
                                ? entry
                                : resolvedKey && entry[resolvedKey] !== undefined
                                    ? entry[resolvedKey]
                                    : entry.name || "";

                            const idValue = entry?.[IdFieldMap[modalField]] ?? null;

                            setForm(prev => ({
                                ...prev,
                                [modalField]: value,
                                [`${modalField}Id`]: idValue
                            }));



                            console.log("==> modalField:", modalField);
                            console.log("==> expected id key:", IdFieldMap[modalField]);
                            console.log("==> raw entry:", entry);
                            console.log("==> extracted id value:", entry?.[IdFieldMap[modalField]]);
                            console.log("Filter active: race =", selectedRaceId, ", gender =", selectedGenderId);



                            setModalOpen(false);
                        }}


                        onRemove={() => {
                            setForm(prev => ({ ...prev, [modalField]: "" , [`${modalField}Id`]: null }));
                            setModalOpen(false);
                        }}
                        onClose={() => setModalOpen(false)}
                    />


                                </div>
                <button onClick={() => createNpc()}>
                    Npc Erstellen
                </button>


            </div>
        );
    }
