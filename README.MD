#  DnD Tool – Webbasiertes Spielleiter-Tool

Dies ist die frühe Ausarbeitung eines webbasierten Spielleiter-Tools zur Verwaltung und Erschaffung einer lebendigen DnD-Spielwelt.  
Der Prototyp dieses Werkes ward ursprünglich unter [DnD-WebUI](https://github.com/ElodinderBarde/DnD-WebUI) geboren und wird nun als **eigenständige Spring Boot Applikation** weitergeführt, um sich von XAMPP zu lösen und ein modular aufgebautes Backend zu etablieren.

---

##  Projektübersicht

Dieses Tool richtet sich an Spielleiter, die ihre Welt digital führen und mit umfassenden Verwaltungsfunktionen versehen möchten.  
In dieser **Early Stage** liegt der Fokus auf der Backend-Architektur (Spring Boot + REST API) sowie einem Frontend auf Basis von **React + Vite**.

---

##  Features (Geplant / In Umsetzung)

- **NPC-Verwaltung**: Erstellen, Generieren, Bearbeiten, Notizen speichern
- **Shops**: Verwaltung von Händlern & Sortiment
- **Items**: Erstellen und Ressourcen zuweisen
- **Ortschaften**: Anlegen und verwalten
- **Monster**: Bestien erzeugen und verwalten
- **Clans**: Soziale Strukturen mit Rufsystem
- **Spieler**: Erfassen & verwalten
- **Quests**: Anlegen, Zuordnen und Verfolgen
- **Rufsystem**: Beziehungen zwischen Spielern, Clans und NPCs

---

##  Tech Stack

| Ebene      | Technologie                  |
|------------|------------------------------|
| **Backend** | Java 21, Spring Boot 3.x, Maven |
| **Datenbank** | MySQL (via JDBC, später evtl. JPA) |
| **Frontend** | React, Vite, Tailwind CSS (optional) |
| **API**     | RESTful, JSON |

---

## Projektstruktur

```plaintext
dnd_tool/
├── backend/       # Spring Boot REST-API
├── frontend/      # Vite + React Benutzeroberfläche
└── README.md

```

Lokale Einrichtung (Entwicklung)
Voraussetzungen
Java 21 (Temurin empfohlen)

Node.js (v18+)

MySQL-Datenbank

Maven



Installation
```
Prüfen ob Java 21 Installiert ist
Prüfen ob Node.js Installiert ist
Prüfen ob Maven installiert ist
Prüfen ob MySql Server installiert ist


install.bat ausführen

root Benutzername eintragen
root Passwort eintragen

nun wird die benötigte db erstellt und User angelegt

bei erfolgreichem Import wird run.bat ausgeführt

Wenn Spring Boot Server erfolgreich geestartet wurde:
öffne einen beliebigen Browser und besuche die Adresse : localhost:5173


```


Backend starten

run.bat ausführen oder 


```bash

cd backend
./mvnw spring-boot:run
# Läuft auf: http://localhost:8081

```


Frontend starten
```bash
cd frontend
npm install
npm run dev
# Läuft auf: http://localhost:5173
``` 


API Proxy (in vite.config.js)
```js
server: {
  proxy: {
    '/api': {
      target: 'http://localhost:8081',
      changeOrigin: true,
      rewrite: path => path.replace(/^\/api/, '')
    }
  }
}
```


🚧 Entwicklungsstand
⚠️ Dieses Projekt befindet sich in einem frühen Stadium.
Die Architektur wird fortlaufend modularisiert, das Datenmodell verfeinert und eine vollständige API aufgebaut.

👤 Autor
Elodin, Webzauberer & Spielleiter aus der Schweiz
GitHub: ElodinderBarde

🧾 Lizenz
Lizenzierung folgt im weiteren Verlauf der Entwicklung.
Aktuell private Nutzung. Kein öffentlicher Rollout vorgesehen.


## 📚 Rechtlicher Hinweis

Dieses Tool verwendet Teile der **Dungeons & Dragons 5e System Reference Document (SRD 5.1)**, veröffentlicht von **Wizards of the Coast** unter der **Creative Commons Attribution 4.0 International License (CC-BY-4.0)**.

[Link zur SRD 5.1](https://dnd.wizards.com/resources/systems-reference-document)

Alle Rechte an Dungeons & Dragons, den zugehörigen Namen, Marken, Welten und Charakteren verbleiben bei Wizards of the Coast.  
Dieses Projekt ist ein **inoffizielles Fanprojekt** und steht in **keiner offiziellen Verbindung** zu Wizards of the Coast.


🌱 Zukunftsideen (Vision)
Nutzerverwaltung & Sessions

Export/Import von Welten & NPCs

Admin-Dashboard für Live-Spielleitung

Mobile-optimierte Companion-Ansicht für Spieler

