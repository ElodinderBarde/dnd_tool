@echo off
setlocal enabledelayedexpansion

REM === Abhängigkeitsprüfung ===

REM Java
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [FEHLT] Java nicht gefunden! Bitte Java JDK 21 installieren: https://adoptium.net/de/temurin/releases/?version=21
    pause
    exit /b 1
)
echo [OK] Java gefunden.

REM Node.js
node -v >nul 2>&1
if %errorlevel% neq 0 (
    echo [FEHLT] Node.js nicht gefunden! Bitte Node.js installieren: https://nodejs.org/en/download/
    pause
    exit /b 1
)
echo [OK] Node.js gefunden.

REM npm
npm -v >nul 2>&1
if %errorlevel% neq 0 (
    echo [FEHLT] npm nicht gefunden! Problem mit Node.js Installation.
    pause
    exit /b 1
)
echo [OK] npm gefunden.

REM Maven Wrapper oder Maven prüfen
if exist "%~dp0backend\mvnw.cmd" (
    echo [OK] Maven Wrapper gefunden.
) else (
    mvn -v >nul 2>&1
    if %errorlevel% neq 0 (
        echo [FEHLT] Maven nicht gefunden! Entweder mvnw.cmd einfügen oder Maven installieren: https://maven.apache.org/download.cgi
        pause
        exit /b 1
    ) else (
        echo [OK] Maven gefunden.
    )
)

REM ===============================
REM    Installation für DnD Tool
REM ===============================

REM --- Basisverzeichnis bestimmen ---
set "BASE_DIR=%~dp0"

REM --- MySQL Konfiguration ---
echo Bitte gib den MySQL-Root-Benutzernamen ein:
set /p MYSQL_ROOT_USER=Benutzername:

echo Bitte gib das MySQL-Root-Passwort ein:
set /p MYSQL_ROOT_PW=Passwort:

REM --- App-DB-Konstanten ---
set "APP_USER=DnD_Tool"
set "APP_PW=123456"
set "DB_NAME=dnd1"

REM --- SQL-Pfad ---
set "SQL_PATH=%BASE_DIR%backend\database\dnd1.sql"

REM --- ZIP-Kontrolle (nur Hinweis) ---
if not exist "%BASE_DIR%backend" (
    echo Bitte die ZIP-Datei entpacken, bevor du dieses Script ausführst.
    pause
    exit /b 1
)

REM --- MySQL: User + DB anlegen ---
echo Erstelle Datenbank und User...
echo CREATE DATABASE IF NOT EXISTS %DB_NAME%; > "%TEMP%\dnd1.sql"
echo CREATE USER IF NOT EXISTS '%APP_USER%'@'localhost' IDENTIFIED BY '%APP_PW%'; >> "%TEMP%\dnd1.sql"
echo GRANT ALL PRIVILEGES ON %DB_NAME%.* TO '%APP_USER%'@'localhost'; >> "%TEMP%\dnd1.sql"
echo FLUSH PRIVILEGES; >> "%TEMP%\dnd1.sql"

mysql -u%MYSQL_ROOT_USER% -p%MYSQL_ROOT_PW% < "%TEMP%\dnd1.sql"
if %errorlevel% neq 0 (
    echo [FEHLER] MySQL DB/User konnte nicht erstellt werden! Prüfe Zugangsdaten.
    pause
    exit /b 1
)

REM --- SQL Datei einspielen ---
mysql -u%APP_USER% -p%APP_PW% %DB_NAME% < "%SQL_PATH%"
if %errorlevel% neq 0 (
    echo [FEHLER] Konnte SQL-Daten nicht importieren.
    pause
    exit /b 1
)

REM --- npm install Frontend ---
cd /d "%BASE_DIR%frontend"
npm install
if %errorlevel% neq 0 (
    echo [FEHLER] npm install (Frontend) fehlgeschlagen!
    pause
    exit /b 1
)

REM --- npm install Backend (optional) ---
cd /d "%BASE_DIR%backend"
if exist package.json npm install

REM --- Start React ---
start "React Dev Server" cmd /k "cd /d %BASE_DIR%frontend && npm run dev"

REM --- Start Spring Boot ---
if exist "%BASE_DIR%backend\mvnw.cmd" (
    start "Spring Boot Server" cmd /k "cd /d %BASE_DIR%backend && mvnw spring-boot:run"
) else (
    start "Spring Boot Server" cmd /k "cd /d %BASE_DIR%backend && mvn spring-boot:run"
)

echo Beide Anwendungen wurden gestartet.
start "" "http://localhost:5173/"
pause
