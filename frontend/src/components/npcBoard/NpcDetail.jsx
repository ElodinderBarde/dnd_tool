export default function NpcDetail({ npc }) {
    if (!npc) return <div>Wähle einen NPC aus</div>;

    return (
        <div>
            <h2>{npc.firstname} {npc.lastname}</h2>

                <p>Geschlecht: {
                        npc.gender === "Male" ? "Männlich" :
                            npc.gender === "Female" ? "Weiblich" :
                                npc.gender === "Other" ? "Unspezifisch" :
                                    "Unbekannt"
                }</p>

            <p>Alter: {npc.age}</p>
            <p>Volk: {npc.race}</p>
            <p>Klasse: {npc.npcClass} / {npc.subclass} {npc.level}</p>
            <p>Hintergrund: {npc.background}</p>




            <h3 id={"npcDetailstitle"}>Persönlichkeit</h3>

            <p>Persönlichkeit:{npc.personality}</p>
            <p>Mag:{npc.likes}</p>
            <p>Abneigungen:{npc.dislikes}</p>
            <p>Ideale: {npc.ideals}</p>

            <p>Gesprächsstil: {npc.talkingStyle}</p>
            <p>Betonung: {npc.betonung}</p>

            <p>Clan: {npc.clan} – {npc.clanPosition}</p>
            <p>{npc.shopRelation}</p>


            <h3 id={"npcDetailstitle"}>Optik</h3>
            <p>Kleidung: {npc.kleidungsQuali}</p>
            <p>Oberteil: {npc.jackets}</p>
            <p>Beinkleid: {npc.trousers}</p>
            <p>Schmuck: {npc.jewellery}</p>

            <p>Haarstil: {npc.hairstyle}</p>
            <p>Haarfarbe: {npc.haircolor}</p>

            {npc.gender === "Male" && (
                <p>Bartstil: {npc.beardstyle}</p>
            )}

            {/* Weitere Details bei Bedarf */}
        </div>
    );
}
