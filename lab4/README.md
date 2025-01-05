Zadania

Zadanie 1. Korzystając z metod drop i take, zdefiniuj funkcję:
def subSeq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = /* ... */
która zwraca podciąg ciągów sekwencji seq z przedziału od indeksu begIdx do endIdx.

Zadanie 2. Korzystając z metod filter, map i zipWithIndex, zdefiniuj funkcję:
def remElems[A](seq: Seq[A], k: Int): Seq[A] = /* ... */
która usunie k-ty element sekwencji seq.

Zadanie 3. Korzystając z metody zip i innych metod, zdefiniuj funkcję:
def diff[A](seq1: Seq[A], seq2: Seq[A]): Seq[A] = /* ... */
która zwróci wszystkie elementy z seq1, które nie pasują wg "indeksów" z seq2.
Przykład:
Dla: seq1 = Seq(1, 2, 3), seq2 = Seq(2, 2, 1, 3), funkcja powinna zwrócić: Seq(1, 3), ponieważ
seq1(0) != seq2(0) // zostawiamy
seq1(1) == seq2(1) // usuwamy
seq1(2) != seq2(2) // zostawiamy

Zadanie 4. Korzystając z metody foldLeft/foldRight, zdefiniuj funkcję:
def sumOption(seq: Seq[Option[Double]]): Double = /* ... */
która zwróci sumę elementów sekwencji seq. Wszystkie elementy None powinny zostać pominięte.
Przykład:
Dla: seq = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6)), funkcja powinna zwrócić: 7.0.

Zadanie 5. Korzystając z metody foldLeft/foldRight, zdefiniuj generyczną funkcję:
def deStutter[A](seq: Seq[A]): Seq[A] = /* ... */
która usunie z sekwencji seq wszystkie powtarzające się ciągi.
Przykład:
Dla: seq = Seq(1, 1, 2, 4, 4, 4, 1, 3), funkcja powinna zwrócić: Seq(1, 2, 4, 1, 3).

Zadanie 6. Korzystając z metody sliding i innych metod, zdefiniuj funkcję:
def isOrdered[A](seq: Seq[A])(leq:(A, A) => Boolean): Boolean = /* ... */
która zwróci informację czy wszystkie sąsiednie elementy w seq, są zgodne z predykatem leq.
Przykłady:
Dla: seq = Seq(1, 2, 2, 4) i leq = (_ < _) funkcja powinna zwrócić false.
Dla: seq = Seq(1, 2, 2, 4) i leq = (_ <= _) funkcja powinna zwrócić true.

Zadanie 7. Korzystając z metody groupBy i innych metod, zdefiniuj funkcję:
def freq[A](seq: Seq[A]): Set[(A, Int)] = /* ... */
która zwróci częstość wystąpienia poszczególnych elementów w ciągu seq.
Przykład:
Dla: seq = Seq('a','b','a','c','c','a') funkcja powinna zwrócić Set(('a', 3),('b', 1),('c', 2)).

Zadanie 8. Korzystając z metod sortBy, apply, zdefiniuj funkcję:
def median(seq: Seq[(String, Double)]): Double = /* ... */
która zwróci medianę wyników znajdujących się w seq, który zawiera nazwy użytkownika i liczby punktów.

Zadanie 9. Korzystając z metod minBy, maxBy, zdefiniuj funkcję:
def minMax(seq: Seq[(String, Double)]): Option[(String, String)] = /* ... */
która zwróci nazwę użytkownika w seq, który zdobył najwięcej i najmniej punktów.

Zadanie 10. Korzystając z "wyliczenia" for/yield, zdefiniuj funkcję:
def threeNumbers(n: Int): Set[(Int, Int, Int)] = /* ... */
która zwróci sekwencję zawierającą wszystkie kombinacje trzech liczb: (a, b, c), liczby a, b, c, są liczbami z przedziału [1, n], które są zgodne ze wzorem:
a2 + b2 = c2, gdzie a < b.
Podpowiedź: Sposób wygenerowania ciągu liczb od z przedziału [a, b]: (a to b).toList.
