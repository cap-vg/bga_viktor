# bga_viktor

## fixing stuff

 * loaded into intellij (file -> new -> from existing source)
 * ran format code on EVERYTHING
 * ran ctrl+f to change hardcoded paths from dpiechni
 * tried to run test, failed, somewhere there is another hardcoded path
 * maven -> edit config -> path found
 * path inherited from global settings????
 * disable override
 * fixed? - YES

## tasks

1. [x] Założyć konto na GitHubie za pomocą firmowego maila. Stworzyć lokalne
  repozytorium z bga. Stworzyć nowe prywatne repozytorium na GitHubie (nazwa:
  bga_twojeImię) i spushować swoje lokalne rezpozytorium na GitHuba. Dodać jako
  współpracownika: (obecnie szukamy ludzi do robienia review – informacje uzupełnie
  na grupie na teamsach)

2. [x] Sformatować cały kod za pomocą standardowego formatera Intellij i spushować
  zmiany na główną gałąź na GitHubie. Alternatywnie, formatowanie można wykonać
  przed punktem pierwszym – wtedy będziemy mieli jeden commit mniej.

3. [x] Przejść przez wszystkie warstwy aplikacji wszystkich endpointów i zaznajomić się z
  nieznajomymi rzeczami, które napotkamy.

4.[ ] Przetestować wszystkie endpointy Postmanem. Użyć debuggera podczas ich
  testowania (w razie potrzeby przeczytać krótki tutorial).

5.[ ] Dodać nowy endpoint, który zwróci wszystkie gry przechowywane w bazie danych.
  Wykonać do zadanie na osobnym branchu: `feature/task-5`. Stworzyć pull requesta i
  przypisać go do so swojego opiekuna.
    1. Do mapowania encji na ETO użyć metody `mapList` (nie używać metody map
       w pętli)
    2. Gdy powyższe rozwiązanie już działa, dodać alternatywne w którym użyjemy
       metody map ale bez pętli – należy użyć Stream API z Java 8 (oczywiście
       najlepszym sposobem rozwiązania tego zadania jest użycie metody `mapList` –
       ten podpunkt jest tylko ćwiczeniem, pozwalającym na zapoznanie się ze
       streamami)

6. [ ] Dodać metody `@PATCH` i `@PUT` dla encji gra. Dowiedzieć się, jaka powinna być
  między nimi różnica. Id encji powinno zostać zawarte w URI, a body powinno
  zawierać ETO z nowymi wartościami. Stworzyć nowy customowy ETO tylko z polem
  cost dla metody Patch. Stworzyć nowy customowy mapper dla metody Put (encja ->
  ETO, ETO -> encja) – powinien działać na podobnej zasadzie co BeanUtils (zobaczyć
  jak działa BeanUtils). Nazwa brancha: `feature/task-6_patch_and_put`

7. [ ] Gdy zapisujemy nową grę i nie podamy pola extension, jest ono automatycznie
  ustawiane na false. Dlaczego tak się dzieje? Zmienić logikę aplikacji, aby w takim
  przypadku pole extension było automatycznie ustawiane na true. Upewnić się, że gdy
  przy zapisie ustawimy pole na false, zostanie ono faktycznie zapisane jako false.
  Należy zaproponować 3 różne rozwiązania. Jedno z nich powinno wymagać zmiany
  tylko w jednej linijce kodu. Pozostałe dwa wymagają zmiany typu pola extension. W
  jednym z rozwiązań tym typem powinien być nowo utworzony Enum, który będzie
  wymagał zmiany w API – pole extension w jsonie, który wysyłamy za pomocą
  Postmana nie będzie już wymagało podania true/false tylko naszych wartości z enuma.
  Dokonać odpowiednich zmian w skryptach migracyjnych SQL, które znajdują się w
  pliku `V0002__Create_DB_Table.sql` (aplikacja będzie działała bez dokonania zmian
  w tym pliku, ponieważ korzysta ona z pamięciowej bazy danych, ale mimo to proszę
  wprowadzić zmiany; byłyby one wymagane w przypadku użycia standardowej bazy
  danych). Każde rozwiązanie powinno zostać stworzone na osobnym branchu. Nazwy
  branchy: `feature/task-7_Solution_1`, `feature/task-7_Solution_2`, `feature/task-
  7_Solution_3`

8.[ ] Zadanie 8 składa się z kilku podpunktów:
   1. Zapoznać się/odświeżyć więdzę o SQL (wystarczy SELECT, WHERE, JOIN
      na ten moment)
   2. Zapoznać się z tworzeniem query za pomocą TypedQuery, NamedQuery,
      NativeQuery, Criteria API Query (zacząć od: [https://www.baeldung.com/jpa-queries#:~:text=There%20are%20three%20basic%20types,constructed%20programmatically%20via%20different%20methods](https://www.baeldung.com/jpa-queries#:~:text=There%20are%20three%20basic%20types,constructed%20programmatically%20via%20different%20methods))
   3. Zapoznać się z tworzeniem query w nazwach metod za pomocą Spring Data ([https://docs.spring.io/spring-data/jpa/docs/current/reference/html/](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) - Table 3)
   4. Zapoznać się z tworzeniem query za pomocą querydsl z aliasami
      ([https://www.baeldung.com/intro-to-querydsl](https://www.baeldung.com/intro-to-querydsl) oraz
   [http://querydsl.com/static/querydsl/2.1.0/reference/html/ch03s04.html](http://querydsl.com/static/querydsl/2.1.0/reference/html/ch03s04.html))
   5. Dodać `CustomGameRepository` (interfejs) i jego implementację. Rozszerzyć
      `GameRepository` o `CustomGameRepository`. Implementacje wszystkich query
      z wyjątkiem Spring Data i querydsl należy pisać w `CustomGameRepository`
      (Spring Data i querydsl w GameRepository). Analogicznie postąpić z
      `GamePlayRepository`.
   6. Napisać podane query wykorzystując `TypedQuery`, `NamedQuery` (nad klasą
      encji), `NativeQuery`, `Criteria API Query`, Spring Data w nazwie metody (jeśli
      jest to możliwe) oraz querydsl z aliasami (bez generowania dodatkowych
      klas); każde query powinno być dostępne przez osobny endpoint. Każde z
      niżej podanych query (napisane za pomocą każdej z możliwych metod pisania
      query wymienionych powyżej) powinno znajdować się na osobnym branchu.
      Upewnić się, że wszystkie query na jednym branchu zwracają ten sam rezultat
      (przetestować Postmanem dla różnych danych testowych). Nazwy branchy:
      `feature/task-8_query_i`, `feature/task-8_query_ii`, `feature/task-8_query_iii`, …
      1. Query, które zwróci wszystkie gry o podanej nazwie,
      2. Query, które zwróci wszystkie gry, których koszt mieści w podanym
         zakresie
      3. Query, które zwróci wszystkie rozgrywki rozegrane w takie gry,
         których koszt jest większy lub równy podanemu
      4. Query, które zwróci wszystkie gry, których jakakolwiek rozgrywka
         trwała dłużej niż podany czas.
