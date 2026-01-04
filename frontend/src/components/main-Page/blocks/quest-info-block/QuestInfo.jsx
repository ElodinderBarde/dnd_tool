import { useEffect, useState } from "react";
import { getActiveQuests } from "@/service/questApi";
import "./QuestInfo.css";
export default function ActiveQuestPanel() {
    const [quests, setQuests] = useState([]);
    const [activeIndex, setActiveIndex] = useState(0);

    useEffect(() => {
        getActiveQuests().then(setQuests);
    }, []);

    if (quests.length === 0) {
        return <div>Keine aktiven Quests</div>;
    }

    const quest = quests[activeIndex];

    return (
        <div className="quest-panel">
            {/* Umschalter */}
            <div className="quest-switch">
                {quests.map((q, idx) => (
                    <button
                        key={q.questID}
                        className={idx === activeIndex ? "active" : ""}
                        onClick={() => setActiveIndex(idx)}
                    >
                        Quest {String.fromCharCode(65 + idx)}
                    </button>
                ))}
            </div>

            {/* Inhalt */}
            <div className="quest-content">
                <p className="quest-title">{quest.questName}</p>

                <h3>Beschreibung:</h3>
                <p>{quest.description}</p>

                <div className="quest-meta">
                    <div>Ort: {quest.locationName ?? "–"}</div>
                    <div>Gruppe: {quest.group ?? "–"}</div>
                    <div>Gegenstände: {quest.price_item ?? "–"}</div>
                </div>
            </div>
        </div>
    );
}
