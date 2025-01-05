Zadania

Zadanie 1. Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
def countChars(str: String): Int = /* ... */
która zwróci ile jest różnych znaków użytych w napisie.

Zadanie 2. Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
def swap[A](seq: Seq[A]): Seq[A] = /* ... */
która zamieni kolejnością wartości znajdujących się na parzystych i nieparzystych indeksach.
Przykład:
Dla: seq = Seq(1, 2, 3, 4, 5), Seq(2, 1, 4, 3, 5).

Zadanie 3. Gra MasterMind polega na odgadnięciu w jakich miejscach zostały umieszczone n ukrytych kul, które są oznaczone powtarzającymi się kolorami. Gracz wygrywa, jeżeli w określonej liczbie ruchów odgadnie w jakich miejscach zostały umieszczone kule. W każdej turze gracz wybiera n kul, po czym zostaje mu wyświetlona informacja czy trafił. Każda prawidłowo odgadnięta kula (kula o właściwym kolorze na właściwym miejscu) sygnalizowana jest czarną kropką. Natomiast jeżeli gracz odgadł kolor kuli, ale nie odgadł jej lokalizacji, jest to sygnalizowane białą kropką. Gracz nie wie, które kule są właściwe, które zaś nie.
Korzystając z funkcji kolekcji zdefiniuj funkcję:
def score(code: Seq[Int])(move: Seq[Int]): (Int, Int)
która ocenia ruchy dla gry MasterMind, czyli zwracającą liczbę czarnych i białych kropek.
Przykładowo, dla:
val code = Seq(1, 3, 2, 2, 4, 5)
val move = Seq(2, 1, 2, 4, 7, 2)
Funkcja powinna zwrócić: (1, 3).

Zadanie 4. Korzystając z mechanizmów udostępnianych przez kolekcje oraz fragmentu powieści "Ogniem i mieczem" Henryka Sienkiewicza, skonstruuj "histogram" pokazujący częstotliwość występowanie w tekście poszczególnych liter. Małe i wielkie litery traktuj jako identyczne. Pomiń występujące w tekście znaki interpunkcyjne (kropki, przecinki, myślniki, cudzysłowy itp), a także znaki nie będące literami.
Rozwiązanie przedstaw w postaci funkcji
def histogram(max: Int): String
która przyjmuje argument max oznacza maksymalną szerokość histogramu (jeżeli liter jest więcej histogram nie powinien przekroczyć max).
Przykład:
a:***************************************
ą:**********
b:*****************
c:**************
ć:*******
...
Podpowiedź: mogą się przydać metody standardowe, takie jak Char.isLetter, StringOps.toLowerCase, StringOps.toUpperCase itp.
Plik do zadania: lab05.zip

Zadanie 5. Używając kolekcji i operacji na nich oraz danych z wyników wyborów zawartych w pliku wybory.csv znajdź województwo, w którym różnica procentowa głosów oddanych na Koalicję Obywatelską oraz na PiS była minimalna. Otrzymane wyniki wyświetl na konsoli – zarówno dane województw(a), jak i wartości procentowe. Zauważ, że elementy o wartości "minimalnej/maksymalnej" nie muszą być unikatowe.
Do reprezentowania danych o województwach i gminach użyj zdefiniowanych "klas wzorcowych" (case class) Województwo i Wynik.

Zadanie 6. Napisz program, który, przy pomocy metod oferowanych przez kolekcję, oblicza wyniki zawodów sportowych w konkurencji, w której zawodnicy oceniani są w dwóch kategoriach:

    wdzięk
    spryt

Ocena "cząstkowa" ma postać:
("Imię", "Nazwisko", ocena_wdzięku, ocena_sprytu)
Załóż, że:

    zawodnicy identyfikowani są poprzez imię i nazwisko
    każdy zawodnik może otrzymać dowolną liczbę ocen "cząstkowych"
    ocena_wdzięku oraz ocena_sprytu są dowolnymi liczbami całkowitymi z zakresu od 0 do 20.

Ostateczny wynik zawodnika jest to para liczb typu Double będących średnimi arytmetycznymi ocen cząstkowych w podanych powyżej "kategoriach".
"Ranking" ustala się sumując obie "średnie" noty każdego z zawodników - wyższa suma oznacza lepszy wynik.
Jeśli sumy not dwóch zawodników są identyczne, to wyższe miejsce zajmuje ten, którego (średnia) nota za wdzięk była wyższa. Jeśli również noty za wdzięk są identyczne, to zawodnicy zajmują miejsca ex-aequo.
Załóż, że dane wejściowe programu stanowi lista obiektów reprezentujących oceny "cząstkowe". Program powinien stworzyć uporządkowaną listę obiektów reprezentujących informacje o:

    miejscu zajętym przez zawodnika.
    imieniu i nazwisku zawodnika.
    uzyskanym wyniku.

W przypadku miejsc ex-aequo kolejność na liście wynikowej powinna być zgodna z porządkiem alfabetycznym nazwisk zawodników.
