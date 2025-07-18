import './CreateNpc.css';
import React, {useState, useEffect} from "react";
import PresetModal from "./PresetModal";
import { presetOptions } from "./presetData";
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
        const [kleidungsQuali, setKleidungsQuali] = useState(null);
        const [jackets, setJackets] = useState([]);
        const [trousers, setTrousers] = useState([]);
        const [hairstyle, setHairstyle] = useState([]);
        const [hairColor, setHairColor] = useState(null);
        const [beardstyle, setBeardstyle] = useState([]);




        const initialForm = {
            vorname: "", nachname: "", age: "", race: "", gender: "", class: "", subclass: "", npc_lvl: "",
            personality: "", otherDescription: "", likes: "", dislikes: "", ideals: "", notes: "",
            kleidungsQuali: "", jackets: "", trousers: "", hairstyle: "", hairColor: "", beardstyle: "",
            location: "", shopType: "", shop: "", customerOrEmployee: "", employeePosition: "", customerRole: ""
        };


        const [form, setForm] = useState(initialForm);


        const [stats, setStats] = useState({
            ATK: 10, CON: 10, WIS: 10, CHA: 10, INT: 10, AC: 10,
        });







        useEffect(() => {
            if (form.class) {
                axios.get(`/api/Subclass/names/byClass`, {
                    params: { npcClass: form.class }
                }).then(res => setSubclass(res.data));
            } else {
                setSubclass([]);
            }
        }, [form.class]);






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
            axios.get("/api/Personality").then(res => presetOptions.personality = res.data);
            axios.get("/api/OtherDescription").then(res => presetOptions.otherDescription = res.data);
            axios.get("/api/Likes").then(res => presetOptions.likes = res.data);
            axios.get("/api/Dislikes").then(res => presetOptions.dislikes = res.data);
            axios.get("/api/Ideals").then(res => presetOptions.ideals = res.data);
            axios.get("/api/KleidungsQuali").then(res => presetOptions.kleidungsQuali = res.data);
            axios.get("/api/Jackets").then(res => presetOptions.jackets = res.data);
            axios.get("/api/Trousers").then(res => presetOptions.trousers = res.data);
            axios.get("/api/Hairstyles").then(res => presetOptions.hairstyle = res.data);
            axios.get("/api/HairColors").then(res => presetOptions.hairColor = res.data);
            axios.get("/api/Beardstyles").then(res => presetOptions.beardstyle = res.data);

        }, []);









        const handleChange = (e) => {
            const { name, value } = e.target;
            setForm(prev => ({ ...prev, [name]: value }));
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

        const createNpc = async () => {
            try {
                const payload = {
                    ...form,
                    stats,
                    role: form.customerOrEmployee,
                };

                const response = await axios.post("/api/npcs", payload);
                alert("NPC erfolgreich erstellt!");
                setForm({}); // optional: reset logic hier erweitern
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
                case "hairstyle": return ["hairstyle"];
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



        return (
            <div className="npc-options-grid">
                {/* LINKE SPALTE: Details */}
                <div className="left-column">
                    <div className="field-row">
                        <label>Vorname:</label>
                        <input name="vorname" value={form.vorname} onChange={handleChange} />
                        <button onClick={() => openPreset("vorname")} >Preset</button>
                    </div>

                    <div className="field-row">
                        <label>Nachname:</label>
                        <input name="nachname" value={form.nachname} onChange={handleChange}/>
                        <button onClick={() => openPreset("nachname")} >Preset</button>
                    </div>



                    <div className="field-row">
                        <label>Alter:</label>
                        <input name="age" value={form.age} onChange={handleChange}/>
                    </div>


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
                    <select name="gender" value={form.gender} onChange={handleChange}>
                        <option value="">Wähle Geschlecht</option>
                        {genders.map(g => (
                            <option key={g.id} value={g.id}>{g.gendername}</option>
                        ))}
                    </select>

                    </div>

                    <div>
                        <div className="stats-grid">
                            <div className="field-row">
                                <label>Klasse:</label>
                                <select name="class" value={form.class} onChange={handleChange}>
                                    <option value="">Wähle eine Klasse</option>
                                    {classes.map(c => (
                                        <option key={c.id} value={c.id}>{c.classname}</option>
                                    ))}
                                </select>

                            </div>

                            <div className="field-row">
                                <label>Subklasse:</label>
                                <select
                                    name="subclass"
                                    value={form.subclass}
                                    onChange={handleChange}
                                    disabled={!form.class} // <--- HIER wird es deaktiviert
                                >
                                    <option value="">Wähle eine Subklasse</option>
                                    {subclass.map(sc => (
                                        <option key={sc.id} value={sc.id}>{sc.name}</option>
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
                                    presetOptions[modalField] || []
                        }
                        columns={getColumnsForField(modalField)}
                        filterKeys={getFilterKeysForField(modalField)}
                        currentValue={form[modalField]}
                        onSelect={(entry) => {
                            const entryValueMap = {
                                vorname: "firstname",
                                nachname: "lastname",
                                personality: "personality",
                                otherDescription: "otherDescription",
                                likes: "likes",
                                dislikes: "dislikes",
                                ideals: "ideals",
                                jackets: "jackets",
                                trousers: "trousers",
                                hairstyle: "hairstyle",
                                hairColor: "hairColor",
                                beardstyle: "beardstyle",
                            };

                            const resolvedKey = entryValueMap[modalField];
                            const value = typeof entry === "string"
                                ? entry
                                : resolvedKey && entry[resolvedKey] !== undefined
                                    ? entry[resolvedKey]
                                    : entry.name || "";

                            setForm(prev => ({ ...prev, [modalField]: value }));
                            setModalOpen(false);

                        }}


                        onRemove={() => {
                            setForm(prev => ({ ...prev, [modalField]: "" }));
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
