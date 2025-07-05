import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Navbar from '../components/Navbar';
import { GridStack } from 'gridstack';
import 'gridstack/dist/gridstack.min.css';

export default function ShopDetails() {
    const { shopId } = useParams(); // ← Hier wird die ID geholt

    useEffect(() => {
        const grid = GridStack.init({ column: 8 });

        // Dummy-Daten kannst du später durch einen Fetch nach shopId ersetzen
        const layout = [
            { content: `🛒 <strong>Shop ID:</strong> ${shopId}<br/>Ort: Baldurs Tor<br/>Besitzer: Meister Elgor`, x: 0, y: 0, w: 1, h: 3 },
            { content: '📦 <strong>Items:</strong><ul><li>Heiltrank</li><li>Zauberstab</li><li>Schriftrolle</li></ul>', x: 1, y: 2, w: 2, h: 2 },
            { content: '📝 <strong>Notizen:</strong><br/>Lieferung am 1. Monatstag verzögert.', x: 1, y: 2, w: 2, h: 1 },
        ];

        layout.forEach(item => {
            const node = document.createElement('div');
            node.classList.add('grid-stack-item');
            node.setAttribute('gs-x', item.x);
            node.setAttribute('gs-y', item.y);
            node.setAttribute('gs-w', item.w);
            node.setAttribute('gs-h', item.h);

            node.innerHTML = `
                <div class="grid-stack-item-content">
                    ${item.content}
                </div>
            `;
            grid.el.appendChild(node);
        });

        return () => grid.destroy(false);
    }, [shopId]); // ← Abhängigkeit hinzugefügt

    return (
        <>
            <Navbar />
            <main style={{ padding: '2rem' }}>
                <h2>Shop-Details für Shop ID {shopId}</h2>
                <div className="grid-stack"></div>
            </main>
        </>
    );
}
