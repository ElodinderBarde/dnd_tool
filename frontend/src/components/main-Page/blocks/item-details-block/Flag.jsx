import { SYMBOL_ICON } from "./Symbols.jsx";
import "./npc-details.css"
import frame from "./media/grapesframe.svg";
import background from "./media/shadow with glow.svg";
export default function Flag({ symbol, size = 200 }) {
    if (!symbol) return null;

    const Icon = SYMBOL_ICON[symbol];
    if (!Icon) return null;

    return (
        <div
            className="flag-container"
            style={{ width: size, height: size * 1.6 }}
        >

            {/* Background */}
            <img src={background} className="flag-background" />


            {/* Frame */}
            <img src={frame} className="flag-frame" />

            {/* Symbol */}
            <img src={Icon} className="flag-symbol" />
        </div>
    );
}
