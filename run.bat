@echo off
setlocal enabledelayedexpansion

:: Basisverzeichnis automatisch ermitteln (Ordner, in dem diese .bat liegt)
set "BASE_DIR=%~dp0"

:: frontend und backend relativ zum BASE_DIR
set "REACT_DIR=%BASE_DIR%frontend"
set "SPRING_DIR=%BASE_DIR%backend"

:: Start React
echo Starte React-App...
start "React Dev Server" cmd /k "cd /d %REACT_DIR% && npm run dev"

:: Start Spring Boot
echo Starte Spring Boot Anwendung...
start "Spring Boot Server" cmd /k "cd /d %SPRING_DIR% && mvnw spring-boot:run"

echo Beide Anwendungen wurden gestartet.
pause
