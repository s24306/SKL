Zadania

Zadanie 1. Napisz program, który pobierze od użytkownika liczbę n oraz wyświetli informację, czy każda naturalna liczba parzysta większa od 2 i mniejsza równa od n, czyli czy każda liczba parzysta z przedziału (2, n], jest sumą dwóch liczb pierwszych.
Dodatkowo na ekranie powinny zostać wypisane wszystkie te podziały.
Przykład:
Dla: n = 8
Wyświetlenie może wyglądać w następujący sposób:
2 + 2 = 4
3 + 3 = 6
3 + 5 = 8

Zadanie 2. Zdefiniuj klasę C, która będzie reprezentowała liczby zespolone.

klasa powinna zawierać pola re i im reprezentujące część rzeczywistą i urojoną liczby.
zdefiniuj odpowiednie konstruktory
    konstruktor główny: dzięki któremu, będzie można przypisać wartości części rzeczywistej i urojonej, tworząc obiekt.
    konstruktor pomocniczy: dzięki któremu, będzie można przypisać jedynie wartość części rzeczywistej, tworząc obiekt.
reprezentacja tekstowa obiektów klasy, powinna być bardziej czytelna:
    dla b>0: a + bi
    dla b<0: a – bi
    dla b=0: a
powinna zawierać metody:
    +(that: C): C
    -(that: C): C
    *(that: C): C
które umożliwią wykonanie operacji arytmetycznych na liczbach zespolonych.
podpowiedź:  
![wzoryZespolone1](https://github.com/user-attachments/assets/61bf3d2c-b59f-409d-b649-201fb2e3d100)

Zadanie
powinna zawierać metodę:
    /(that: C): C
która umożliwi wykonanie operacji arytmetycznej na liczbach zespolonych.
jeżeli podany argument będzie powodował dzielenie przez 0, powinien zostać uruchomiony wyjątek IllegalArgumentException. wywołaj metodę i obsłuż odpowiednio wyjątek.
podpowiedź:  
![wzoryZespolone2](https://github.com/user-attachments/assets/f687a823-f078-4f62-8377-2170380578ec)

Zadanie
obiekty klasy, powinny mieć możliwość wykonywania operacji arytmetycznych ze w zwykłymi liczbami rzeczywistymi.
Przykładowo powinny działać operacje:
5.3 + C(2.1, 3.5)
C(2.2, 3.4) * 2.5
obiekty klasy, powinny mieć możliwość wykonywania operatorów logicznych: ==, !=, <, >, <=, >= na liczbach zespolonych.
przyjmij, że operatory są zgodne z odległością od współrzędnej (0, 0) na osi Re, Im.
wykorzystaj cechę Ordered[A], albo metodę equals, tam gdzie to możliwe.
