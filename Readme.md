# Modul 226b - Random Access Machine
## Beschreibung
Es wurde eine RAM-Machine implementiert, die mit folgenden RAL-Befehlen bedient werden kann:  

| RAL-Befehl   | Beschreibung                                                                           |
|--------------|----------------------------------------------------------------------------------------|
|     ADD X    |     Addiert den   Inhalt des Memorys an Adresse X zum Accumulator.                     |
|     SUB X    |     Subtrahiert   den Inhalt des Memory an Adresse X vom Accumulator.                  |
|     LDA X    |     Ladet den AC mit dem Inhalt vom   Memory an Adresse X.                             |
|     STA X    |     Speichert den   Inhalt vom AC im Memory mit der Adresse X.                         |
|     LDI X    |     Ladet den AC indirekt mit dem   Inhalt vom Memory mit der Adresse X.               |
|     STI X    |     Speichert den   Inhalt vom AC indirekt in den Memory mit der Adresse X.            |
|     JMP X    |     Jumpt zur X markierten Instruktion   im Programm.                                  |
|     JMZ X    |     Jumpt zur mit   X markierten Instruktion im Programm, wenn der AC gleich 0 ist.    |
|     HLT      |     Beendet das Programm.                                                              |  

### Ablauf eines Programms
Der Input wird zuerst auf seine Richtigkeit überprüft durch die Methoden der Klasse Validator. Stimmen diese mit den Vorgaben überein, wird ein Output generiert. Falls nicht, erscheint eine Fehlermeldung.  

## Anleitung
Bitte beachte folgende Anleitung:  
1. Schreibe in das file `memoryfile.txt` deine Memory. Die erste Zeile ist der 0. Index, die zweite Zeile der 1. Index usw. Achte darauf, nur ganze Zahlen zu verwenden.
2. Schreibe in das file `ralfile.txt` deine RAL-Befehlabfolge. Beachte die Formatvorgaben (Siehe Tabelle in der Beschreibung). Auch hier ist das Programm in Zeilen unterteilt. 1. Zeile = erster Befehl, 2. Zeile = zweiter Befehl usw.
3. Starte das Programm.
4. Überprüfe in der angezeigten Liste deine Eingabe und wähle den Startpunkt deines Programms.
5. Klicke auf Start.
6. have fun