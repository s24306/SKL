Zadania

Zadanie 1. Zdefiniuj klasę
class Player extends Actor { ... }
tak, aby po utworzeniu:

    dwóch aktorów typu Player mogli oni grać w "ping-ponga" (w nieskończoność wysyłali do siebie komunikat).
    trzech aktorów typu Player mogli oni grać w "ping-ponga" w trójkącie.
    listy, zawierającą dowolną liczbę aktorów typu Player, mogli oni grać w "ping-ponga" po okręgu.


Zadanie 2. Używając aktorów zaimplementuj "rozproszony licznik słów". Powinien on składać się z aktora głównego, typu:
class Nadzorca extends Actor { ... }
oraz dynamicznie określanej (w momencie inicjowania działania nadzorcy) liczby aktorów "roboczych", typu:
class Pracownik extends Actor { ... }
Po uruchomieniu, Nadzorca powinien być w stanie przyjąć jedynie komunikat inicjalizacyjny postaci
case class Init(liczbaPracownikow: Int)
w którego efekcie powinien utworzyć zadaną liczbę aktorów typu Pracownik i przejść do stanu, w którym jest w stanie przyjmować "zlecenia" nadsyłane za pomocą komunikatów
case class Zlecenie(tekst: List[String])
Po otrzymaniu komunikatu Zlecenie nadzorca powinien zmienić swój stan oraz przekazywać poszczególne napisy z listy tekst do "obróbki" pracownikom. Służyć do tego powinny komunikaty
case class Wykonaj( /* argumenty */ )
Pracownicy zwracają informację do nadzorcy odnośnie liczby znalezionych różnych słów w wersie (np. "Ulica" i "ulica" to identyczne słowa).
case class Wynik( /* argumenty */ )
Nadzorca sumuje/agreguje napływające wyniki oraz wysyła kolejny napis (jeżeli jeszcze jakiś istnieje) z listy tekst, pracownikowi od którego otrzymał wynik. Po otrzymaniu wszystkich odpowiedzi od pracowników i wyliczeniu wszystkich słów z listy, nadzorca wypisuje na konsoli wynik i wraca do stanu oczekiwania na kolejne zlecenie.
