# Projekt webAndMobileApp
## Opis 
Projekt składa się z dwóch głównych komponentów: aplikacji webowej i mobilnej. Aplikacja webowa została zbudowana przy użyciu frameworka Spring i komunikuje się z bazą danych MariaDB. Aplikacja mobilna, stworzona na platformie Android, umożliwia logowanie i interakcję z systemem.

### Aplikacja Webowa
#### Technologie:
- Spring Framework
- MariaDB
- REST API
#### Funkcjonalności:
1) Logowanie Użytkowników: Umożliwia użytkownikom logowanie do systemu z wykorzystaniem nazwy użytkownika i hasła.
2) CRUD dla zgłoszeń: Użytkownicy mogą tworzyć, czytać, aktualizować i usuwać zgłoszenia.
    Każde zgłoszenie zawiera:
    - Id zgłoszenia
    - Data zgłoszenia
    - Osoba zgłaszająca
    - Osoba przypisana (konto użytkownika w systemie)
    - Treść Zgłoszenia
    - Adres Zgłoszenia
3) API REST-owe: Aplikacja webowa wystawia REST API do pobierania zgłoszeń, co umożliwia integrację z aplikacją mobilną.
4) Możliwość rejestracji nowych użytkowników.


### Aplikacja Mobilna
#### Technologie:
  - Android SDK
#### Funkcjonalności:
Logowanie do Systemu: Aplikacja mobilna umożliwia logowanie do systemu z wykorzystaniem danych uwierzytelniających z aplikacji webowej.
