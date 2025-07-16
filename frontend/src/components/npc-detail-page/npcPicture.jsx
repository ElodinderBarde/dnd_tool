import { useState } from "react";
import "./NpcPicture.css"; // eigenen Stil auslagern

export default function NpcPicture({ npc }) {
    const [showModal, setShowModal] = useState(false);

    const handleDoubleClick = () => {
        setShowModal(true);
    };

    const handleClose = () => {
        setShowModal(false);
    };

    const imagePath = npc?.pictureUrl ? `/npc-images/${npc.pictureUrl}` : "/npc-images/placeholder.png";

    return (
        <div style={{ textAlign: "center" }}>
            <img
                src={imagePath}
                alt={`Bild von ${npc?.firstname ?? "NPC"}`}
                onDoubleClick={handleDoubleClick}
                style={{
                    maxWidth: "100%",
                    maxHeight: "300px",
                    objectFit: "cover",
                    borderRadius: "8px",
                    cursor: "zoom-in"
                }}
            />

            {showModal && (
                <div className="modal-overlay" onClick={handleClose}>
                    <img
                        className="modal-image"
                        src={imagePath}
                        alt={`Bild von ${npc?.firstname ?? "NPC"}`}
                    />
                </div>
            )}
        </div>
    );
}
