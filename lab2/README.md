Zadania


Zadanie 1. Zdefiniuj funkcję reverse(str: String): String, która zwróci odwrócony napis pobrany jako argument.
Rozwiąż to zadanie bez korzystania ze zmiennych oraz wykorzystaj rekurencję ogonową.

Zadanie 2. Zdefiniuj funkcję isPrime(n: Int): Boolean która sprawdza, czy argument jest liczba pierwszą. Rozwiąż to zadanie bez korzystania ze zmiennych oraz wykorzystaj rekurencję ogonową.

Zadanie 3. Zdefiniuj funkcję binToDec(bin: Int): Int, która jako argument otrzyma liczbę zapisaną w systemie binarnym i przeliczy ją na system dziesiętny. Rozwiąż to zadanie bez korzystania ze zmiennych oraz wykorzystaj rekurencję ogonową.

Zadanie 4. Zdefiniuj funkcję value(n: Int): Int, która zwróci n-ty wyrażony wzorem:
F(0) = 2
F(1) = 1
F(n) = F(n-1) + F(n-2) dla n > 1
Rozwiąż to zadanie bez korzystania ze zmiennych oraz wykorzystaj rekurencję ogonową.
Pierwsze 10 wyrazów ciągu: 2, 1, 3, 4, 7, 11, 18, 29, 47, 76.

Zadanie 5. Używając rekurencji ogonowej, zdefiniuj funkcję:
def isOrdered(tab: Array[Int], mlr: (Int, Int) => Boolean): Boolean
która sprawdza, czy tablica liczb całkowitych będąca jej argumentem jest uporządkowana zgodnie z porządkiem definiowanym przez funkcję mlr.
Rozwiąż to zadanie bez korzystania ze zmiennych.
Przykład:
Dla: tab = Array(1, 3, 3, 6, 8) i mlr = (_ <= _) funkcja powinna zwrócić true.
Dla: tab = Array(1, 3, 3, 6, 8) i mlr = (_ < _) funkcja powinna zwrócić false.

Zadanie 6. Zdefiniuj funkcję rekurencyjną ogonowo:
def worth(tab1: Array[Int], tab2: Array[Int])(pred: (Int, Int) => Boolean)(op: (Int, Int) => Int): Option[Int]
która zwróci wartość zwracaną przez op, dla pierwszych wartości, które znajdują się na tych samych pozycjach tablic oraz spełniają predykat pred. Jeżeli takie wartości nie istnieją, powinna zostać zwrócona wartość None.
Rozwiąż to zadanie bez korzystania ze zmiennych.
Przykład:
Dla: tab1 = Array(-1, 3, 2, -8, 5) , tab2 = Array(-3, 3, 3, 0, -4, 5) , pred = (_ < _) , op = (_ + _) , funkcja powinna zwrócić Some(5), ponieważ
-1 < -3 // fałsz, pomijamy
3 < 3 // fałsz, pomijamy
2 < 3 // prawda, zwracamy Some(5), ponieważ 2 + 3 = 5
