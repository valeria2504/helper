# Helper
Dies ist mein erstes Programm, in dem ich versucht habe, all mein Wissen zu vereinen. Beim Öffnen des Programms können Sie sich auf der linken Seite mit allen Funktionen kennen lernen.

### Chat GPT
Chat GPT ist derzeit noch nicht aktiv, da OpenAI die Möglichkeit, über die API auf Chat GPT zuzugreifen, noch nicht hinzugefügt hat.

### Weather
In Weather können Sie die Wetterdaten für jede Stadt abrufen (sofern sie von OpenWeather gefunden wird). Hier habe ich eine REST-API verwendet, um eine Wetteranfrage für eine Stadt zu senden und die Daten zurückzuerhalten. Dem Benutzer werden Informationen wie Temperatur (umgerechnet in Grad Celsius), Bewölkung, Niederschlag und Windgeschwindigkeit angezeigt.

### Tic Tac Toe
Hier gibt es die Möglichkeit, ein Spiel "Kreuz und Kreis" zu spielen. Es sind drei mögliche Szenarien beschrieben: Gewinn des Kreises, Gewinn des Kreuzes und ein Unentschieden. Oben links wird der Punktestand angezeigt. Der Knopf unten ermöglicht es, das Spiel mit einem sauberen Punktestand neu zu starten.

### Calculator
Dies ist ein Taschenrechner mit all seinen Standardfunktionen. Die "Delete"-Taste löscht das letzte Zeichen, die "New"-Taste löscht die gesamte Eingabezeile.

### Notes
"Notes" ist ein unfertiges Projekt. Die Notizen werden es ermöglichen, sich in sein Konto einzuloggen, die benötigten Informationen zu notieren, zu speichern und beim nächsten Mal zu öffnen. In der aktuellen Entwicklungsphase ist nur die Erstellung eines neuen Benutzers möglich, dessen Daten werden in einer PostgreSQL-Datenbank gespeichert.

## Requirements
- Windows OS
- Installed [git](https://github.com/git-for-windows/git/releases/download/v2.47.1.windows.2/Git-2.47.1.2-64-bit.exe)
- Installed [java jdk 23](https://download.oracle.com/java/23/latest/jdk-23_windows-x64_bin.exe)


## Usage manual
- Copy source code to your PC `git clone https://github.com/valeria2504/helper.git`
- Open `helper\demo` directory
- Open **run.bat** file (or alternative open CMD, `cd helper\demo` and run `java --module-path "\lib" --add-modules javafx.controls,javafx.fxml -jar sample.jar
`)

