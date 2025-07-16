export default function NpcOptics({ npc, className }) {
    if (!npc) return <p>Optik wird geladen...</p>;

    return (
        <div className={`optics-container ${className || ""}`}>

            <div className="optics-group">
                <p><strong>Kleidungsqualität:</strong> {npc.kleidungsQuali}</p>
                <p><strong>Oberteil:</strong> {npc.jackets}</p>
                <p><strong>Beinkleid:</strong> {npc.trousers}</p>
                <p><strong>Schmuck:</strong> {npc.jewellery}</p>
            </div>

            <div className="optics-group">
                <p><strong>Haarstil:</strong> {npc.hairstyle}</p>
                <p><strong>Haarfarbe:</strong> {npc.haircolor}</p>
                {npc.gender === "Male" && (
                    <p><strong>Bartstil:</strong> {npc.beardstyle}</p>
                )}
            </div>
        </div>
    );
}
