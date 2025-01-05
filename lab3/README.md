Zadania

Zadanie 1. Napisz generyczną funkcję
def divide[A](list: List[A]): (List[A], List[A]) = /* ... */
która podzieli listę list na dwie części. W pierwszej będą się znajdywać elementy na parzystych indeksach w drugiej elementy na nieparzystych.
Przykład:
divide(List(1, 3, 5, 6, 7)) == (List(1, 5, 7), List(3, 6))
W rozwiązaniu skorzystaj z rekurencji ogonowej i dopasowania wzorca (nie używaj metod head i tail).

Zadanie 2. Zdefiniuj generyczną funkcję
def merge[A](a: List[A], b: List[A])(leq: (A, A) => Boolean): List[A]
która połączy ze sobą dowolne dwa ciągi elementów typu A, zgodnie z porządkiem zadanym przez funkcję leq (załóżmy, że ciągi są posortowane).
W rozwiązaniu skorzystaj z rekurencji ogonowej i dopasowania wzorca (nie używaj metod head i tail).
Przykład:
Dla: a = List(1 ,3, 5, 8), b = List(2, 4, 6, 8, 10, 12) i leq = (m, n) => m < n, funkcja powinna zwrócić List(1, 2, 3, 4, 5, 6, 8, 8, 10, 12).

Zadanie 3. Napisz generyczną funkcję
def compress[A](list: List[A]): List[(A, Int)]
która w liście list zastępuje każdy podciąg powtarzających się elementów a...a parą (a, długość podciągu).
W rozwiązaniu skorzystaj z rekurencji ogonowej i dopasowania wzorca (nie używaj metod head i tail).
Przykład:
compress(List('a','a','b','c','c','c','d','d','c')) == List( ('a',2), ('b',1), ('c',3), ('d',2), ('c',1) )

Zadanie 4. Zdefiniuj generyczną funkcję
def isSub[A](l: List[A], lSub: List[A]): Boolean = /* ... */
która zwróci informację czy wszystkie elementy w lSub znajdują się w l. Możesz założyć, że elementy w lSub są unikatowe.
W rozwiązaniu skorzystaj z rekurencji ogonowej i dopasowania wzorca (nie używaj metod head i tail).
Przykład:
Dla lSub = List('a', 'b', 'c') i l = List('b', 'o', 'c', 'i', 'a', 'n'), powinna zostać zwrócona true.

Zadanie 5. Zdefiniuj generyczną funkcję
def compute[A, B](l: List[Option[A]])(op1: A => B)(op2: (A, B) => B): Option[B] = /* ... */
która korzystając z wartości początkowej oraz funkcji op1 (dla pierwszego elementu listy) i op2, obliczy "wartość" ciągu l. Zdefiniuj funkcję z użyciem rekurencji ogonowej.
Funkcja powinna zwrócić wartość None, wtedy i tylko wtedy, gdy wszystkie elementy listy l, będą miały wartość None.
W rozwiązaniu skorzystaj z rekurencji ogonowej i dopasowania wzorca (nie używaj metod head i tail).
Przykład:
Dla: l = List(Some(1), None, Some(2), None, Some(3), Some(4)), op1 = (_ + 0), op2 = (_ + _), funkcja powinna zwrócić: Some(10).

Zadanie 6. Zapoznaj się z możliwością zwracania funkcji, przez funkcję.

    Zdefiniuj następujące generyczne operujące na funkcjach:
        składanie funkcji:
        def compose[A, B, C](f: A => B)(g: B => C): A => C = /* ... */
        iloczyn funkcji:
        def prod[A, B, C, D](f: A => C, g: B => D): (A, B) => (C, D) = /* ... */
        podniesienie operatora op: (T, T) => T
        def lift[A, B, T](op: (T,T) => T)(f: A => T, g: B => T): (A,B) => T = /* ... */
    Niech MSet[A] oznacza multi-zbiór (zbiór w którym elementy mogą się powtarzać) typu A.
    type MSet[A] = A => Int
    Czyli jest to funkcja zwracająca liczbę wystąpienia elementu typu A w danym multizbiorze. np.
    val s: MSet[Int] = (n: Int) => n match {
     case 1 => 2
     case 3 => 1
     case _ => 0
    }.
    Korzystając z funkcji w podpunkcie a zdefiniuj funkcję wykonujące operację: sumy, różnicy oraz części wspólnej dla wielozbiorów:
    def sum[A](s1: MSet[A], s2: MSet[A]): MSet[A] = /* ... */
    def diff[A](s1: MSet[A], s2: MSet[A]): MSet[A] = /* ... */
    def mult[A](s1: MSet[A], s2: MSet[A]): MSet[A] = /* ... */
