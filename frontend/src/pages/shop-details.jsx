import { useEffect } from 'react';
import Navbar from '../components/Navbar';
import { GridStack } from 'gridstack';
import 'gridstack/dist/gridstack.min.css';

export default function ShopDetails() {
    useEffect(() => {
        const grid = GridStack.init({ column: 8 });

        // Dummy-Daten in Gridstack-Widgets einfügen
        const layout = [
            { content: '🛒 <strong>Shop:</strong> Magierbedarf Aurinor<br/>Ort: Baldurs Tor<br/>Besitzer: Meister Elgor', x: 0, y: 0, w: 1, h: 3 },
           { content: '📦 <strong>Items:</strong><ul><li>Heiltrank</li><li>Zauberstab</li><li>Schriftrolle</li></ul>', x: 1, y: 2, w: 2, h: 2 },
           // { content: '👥 <strong>Gäste:</strong><ul><li>Thorin Eichenschild</li><li>Lady Mirana</li></ul>', x: 2, y: 2, w: 4, h: 3 },
            //{ content: '👷 <strong>Mitarbeitende:</strong><ul><li>Lehrling Tim</li><li>Wächterin Sorcha</li></ul>', x: 0, y: 5, w: 4, h: 2 },
            //{ content: '📈 <strong>Statistiken:</strong><br/>Tägliche Besucher: 17<br/>Meistverkauft: Heiltrank', x: 4, y: 5, w: 4, h: 2 },
            { content: '📝 <strong>Notizen:</strong><br/>Besondere Ereignisse: Lieferung am 1. Monatstag verzögert.', x: 1, y: 2, w: 2, h: 1 },

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

        return () => grid.destroy(false); // Cleanup on unmount
    }, []);

    return (
        <>
            <Navbar />
            <main style={{ padding: '2rem' }}>
                <h2>Shop-Details</h2>
                <div className="grid-stack"></div>
            </main>
        </>
    );
}
