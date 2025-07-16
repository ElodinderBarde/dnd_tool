export default function NpcPersonality({ npc }) {
    if (!npc) return null;

    return (
        <div className="personality-container">

            <div className="personality-group">
                <p><strong>Clan:</strong> {npc.clan}  <br/> <strong> Position:</strong> {npc.clanPosition ?? 'ohne'}</p>
                <p><strong>Aufenthaltsort::</strong> {npc.shopRelation}</p>
            </div>

            <div className="personality-group">
                <p><strong>Persönlichkeit:</strong> {npc.personality}</p>
                <p><strong>Mag:</strong> {npc.likes}</p>
                <p><strong>Abneigungen:</strong> {npc.dislikes}</p>
                <p><strong>Ideale:</strong> {npc.ideals}</p>
                <p><strong>Gesprächsstil:</strong> {npc.talkingStyle}</p>
                <p><strong>Betonung:</strong> {npc.betonung}</p>
                <p><strong>Schwächen:</strong> {npc.flaw}</p>
            </div>
        </div>
    );
}
