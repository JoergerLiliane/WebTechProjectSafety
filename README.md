WebTech Project

# WebTechProjectSafety
M1: Thema überlegt, Paar gefunden, GitHub Repo erstellt, „Hello World“ Spring Boot Thymeleaf App gepusht
Deadline: Woche 24. Oktober

Angaben zum Projekt:

Teilnehmeranzahl: 1 Person
Projektname: Safety
Repro: https://github.com/JoergerLiliane/WebTechProjectSafety.git

Projektidee:
Eine Safety Webapp, ursprünglich gedacht als Sicherheitsapp für Frauen. Kann jetzt jedoch von jedem Gender genutzt werden.
Der/die Nutzer/in kann Notfallnummern einspeichern, wie z.B. die Daten einer/mehrerer Vertrauenspersonen (VP).
Nutzer/in kann die Daten der Polizei, Notruf, Krankenhaus etc. einspeichern.

Nutzer/in kann über Google Search die Polizeistation suchen, die am nächsten gelegen ist, einspeichern oder verständigen.
Bei einem Vorfall oder sollte sich der/die Nutzer/in einer bestimmten Situation  unwohl fühlen, kann er/sie durch die App sofort eine ALARM-SMS an die VP bzw. Polizei senden oder sofort ein Anruf/SOS Button tätigen.
Diese Funktion kann genauso genutzt werden für den Fall, wenn eine andere Person in Lebensgefahr schwebt oder ernsthaft Hilfe benötigt.
Diese Webapp ist im Weiteren auch als Mobile App enthalten und die Webapp dient zum einpflegen der Daten + der Erhalt einer Übersicht der Daten bzw.
zur Einsicht darüber, wie oft Vorfälle aufgetreten sind oder wie oft und in welchen Fällen ein Alarm ausgelöst wurde.


Nutzungsmöglichkeiten aus verschiedenen Sichten
(Programmiert aus Sicht des Nutzers)

User/Nutzer/in
  kann sich registrieren (optional)
  Einloggen über die App (optional)
  Kann eine/mehrere VP hinzufügen, löschen, nach Reihenfolge sortieren (Name + Handynummer)
  Kann die Daten des VPs auch nach Reihenfolge sortieren, falls einer der VPs nicht sofort erreichbare ist, dann wird
der nächste angerufen etc.
  Kann Updates über Google Search/Geo Location erhalten über Polizeistation, Krankenhäuser in der Nähe,
kann diese auch einspeichern und nach Favoriten einsortieren
  Alarm/SMS senden/Anruf/SOS Button an die VP oder Polizei (Falls Vertrauensperson als erstes benachrichtigt wird,
dann muss nicht zwingend die Polizei benachrichtigt werden. Sollte der/die Nutzer/in zuerst die Polizei/Krankenhaus
benachrichtigt, dann wird automatisch auch die VP verständigt (Diese Einstellung kann Nutzer/in jeder Zeit ändern )
  Kann eine Beschwerde direkt über ein Formular einsenden an die dafür zuständigen Hilfsstellen, falls der Vorfall
nicht ordnungsgemäß von der Polizei/Krankenhaus durchgeführt wurde
  Kann den Status/Anzahl seiner Vorfälle einsehen und seiner/ihrer Beschwerden/kann einsehen welche VP/Hilfsstellen benachrichtigen wurden

Admin/Vertrauensperson
  kann sich registrieren (optional)
  Einloggen über die App (Optonial)
  Bei einem Notfall + Primäre Benachrichtigung an Polizei oder Krankenhaut, erhält die VP Location der Station, in dem sich die betroffene Person befindet (Sollte das die Person so eingestellt haben)
  Kann Updates über Google Search/Geo Location erhalten über Polizeistation, Krankenhaus in der Nähe der betroffenen Person (Freigabe dafür muss auch über die betroffenen Person erfolgen), kann diese Hilfsstellen auch einspeichern und nach Favoriten einsortieren
  Kann im Fall eines Notfalls + als Primär benachrichtigte Person, eine automatische Benachrichtigung an die notwendigen Hilfsstellen (Polizei etc.) senden + die Kontaktdaten der betroffenen Person (Freigabe dafür muss auch über die betroffenen Person erfolgen)
  Kann Benachrichtigungen von der betroffenen Person erhalten
  Kann eine Beschwerde direkt über ein Formular einsenden an die dafür zuständigen Stellen, falls der Vorfall
nicht ordnungsgemäß von der Polizei/Krankenhaus durchgeführt wurde
  Kann den Status/Anzahl der Vorfälle der betroffenen Person, welche in Verbindung mit den eigenen darauffolgenden Hilfsaktionen stehen, einsehen (Weitere Vorfälle, die nicht mit dem VP in Verbindung stehen, erfordert Freigabe des Nutzers)/kann die eigenen eingeleiteten Beschwerden einsehen/kann einsehen, welche Personen/Hilfsstellen benachrichtigt wurden

Polizei
  kann sich registrieren (optional)
  Einloggen über die App (Optional)
 Kann von der betroffenen Person benachrichtigt werden und  kann den Standort der betroffenen Person erhalten
  Hat Einsicht auf schon bestehenden Daten/Akten (sollte der Nutzer eingewilligt haben)/der vergangenen Vorfälle der betroffene Personen bearbeiten, speichern, löschen (Ermöglicht bessere Einschätzung der Sachlage oder hilft bei der Entscheidung, welche Schritte als nächstes eingeleitet werden müssen)
  Kann den Status/Anzahl der eingetroffenen Beschwerden einsehen und darauf Stellungnehmen

