WebTech Project

# WebTechProjectSafety
M1: Thema überlegt, Paar gefunden, GitHub Repo erstellt, „Hello World“ Spring Boot Thymeleaf App gepusht
Deadline: Woche 24.10.22
Finale Deadline: 08.01.23

Angaben zum Projekt:

Teilnehmeranzahl: 1 Person
Name: Liliane Jörger
MatrikelNr.: S0583302
Projektname: Safety
Repro Backend: https://github.com/JoergerLiliane/WebTechProjectSafety.git
Repro Frontend: https://github.com/JoergerLiliane/FrontendRepo/tree/main/src/views

Projekt:

Abkürzungen:
VP = Vertrauensperson / definiert im Projekt als "Guardian"
Nutzer = definiert im Projekt als "User"

Beschreibung: 

Eine Safety Webapp, ursprünglich gedacht als Sicherheitsapp für Individuen. 
Der/die Nutzer/in kann Notfallnummern seiner VP(auch mehrere) einspeichern.
Diese Webapp dient zum einpflegen der Daten (Bearbeiten, Speichern und Löschen der eigenen Daten + das Einfügen/Löschen/Bearbeiten
von Daten der VP(en).)


Programmiert aus Sicht des Nutzers/User
Nutzung/Funktionen/REST Schnittstellen

User/Nutzer/in
  registrieren, um die App nutzen zu können: -> POST Request: ein Profil erstellen + Anzeigefunktionen (Form/Button)
  einloggen, um auf sein Profil zu kommen:   -> GET Request: erneute Abfrage, der hinterlegten Daten + Anzeigefunktionen (Profilbild+Form+Button)
-> Darstellung:Array von Users
  persönliche Daten ändern:                 -> PUT Request: hinterlegte Daten ändern + Anzeigefunktionen (Settings+Button)
  Profil löschen:                            -> DELETE Request: hinterlegte Daten löschen + Anzeigefunktionen (Buttons)
  Kann eine/mehrere VP(en) hinzufügen:       -> POST Request:Guardian(s) Profil(e) mit bestimmten Daten erstellt + Anzeigefunktionen (Profilbild+Settings+Buttons)
-> Darstellung:Array von Guardians                                          
                                             -> GET Request: erneute Abfrage, der bei der hinterlegten Daten + Anzeigefunktionen (Profilbild+Form+Button)
  Kann Daten der VP(en) ändern:              -> PUT Request: hinterlegte Daten ändern + Anzeigefunktionen (Settings+Buttons)
  Kann Daten der VP(en) ändern:              -> DELETE Request: hinterlegte Daten löschen + Anzeigefunktionen (Buttons)
  Kann seine Live location sehen:            -> Öffentliche API, nur halb optimal: sollte nur auf der eigenen Webseite zu sehen sein (Nur zur Demonstration)

