; comment 
(comment ...)	- Многострочный коммент
(def a [1 2 3])		-	Присваивание
 "text" - строка
 (get "string" N) - Возвращает N-ый символ строки "string"
 (str "s1" "s2") - конкатенация				в перечислении пробел заменяет ","
 (subs "Hello World" 0 5) - Возвращает Hello
 (clojure.string/join '(1 2 3)) - соединяет в строку эл-ты списка
 (clojure.string/join ", " '(1 2 3)) - применяет первый аргумент после каждого эл-та из второго
 (clojure.string/split-lines "1\n2\n3") - превращает большую строку в массив маленьких => ["1" "2" "3"]
 (clojure.string/reverse "hello") - реверсирует строку
 (clojure.string/index-of "hello world" "h") - ищет первое вхождение второй подстроки в первую строку; если такого нет то возвращает Nil
 (clojure.string/last-index-of "hello world, hello" "hello") - ищет последнее вхождение в строку
 (char? \c) - проверка на чаровость => 0/1; строку из 1 символа нельзя так проверить
 (string? "bob") - проверка объекта на стринговость 
 (clojure.string/blank? "") - проверка строки на пустоту
 (char arg) перевод чего то в строку
 (char \unicode) перевод чего то в строку \tab \space

/с  - Создание символа

:keyword - ключи в clojure 
; Это может использоваться для создания объектов:
(def human {:name "Гоша", :age 23})
(human :name)			;	Получение значения поля
 (keyword :arg)			-				Создает ключ. связывает то что вместо keyword и какое то численное значение которое генерируется автоматически

'(a b c) - составление однонаправленного списка 
	list (a b c)	- составление списка
 (doc [obj]) - выводит документацию о объекте
 (source arg) - выдает исходный код			(source +)
 (count '(dracula dooku chocula)) - возвращает кол-во эл-тов списка
 (cons :a '(:b :c :d :e)) - возвращает новую последовательность где а - первый элемент - construction
	(conj '(:a :b :c :d) :e) - возвращает новую последовательность где e - первый элемент - conjoining, 
 в документации написано что добавление может случиться  в любое место в зависимости от типа 
 (peek '(:a :b :c :d :e)) - возвращает первый ЭЛЕМЕНТ списка
 (pop '(:a :b :c :d :e)) - возвращает СПИСОК с элементами кроме первого. если попнуть пустой список то будет ошибка
 [a  b  c] массив
 (vector a b c) массив можно обратиться по индексу
 #{a b c}			Задание множества
 (hash-set a b c) сохраняет элементы, можно хранить разные элементы по типу
 (sorted-set a b c) сохраняет порядок

 {key1 value1, key2 value2, ...} 		хэш-мап
 (hash-map ...) хранит содержимое - дерево
 (sorted-map ...) хранит соддержимое с порядком

	эти 4 структуры данных - коллекции
 навигация в структурах 
 (first [1 2 3])	-	Первый элемент
 (last a)								-	Последний элемент
 (rest [collection])	-	Все кроме первого элемента коллекции
(nth [:peanut :butter :and :jelly] 3)

 если коллекция сконструирована то она не будет изменена - иммутабельность
 (conj ...) - соединение списков 
 (disj [set] [set key]) - Создание новой коллекции - копии указанной, но без указанного эл-та
 
 можно создать пространство имен
 (ns [name]) если есть уже созданное пр-во он использует, если нет то создает 
 
 (let [a 2, b 3] соединение какого то значения и переменной типа локальной переменной для потока
	(+ a b)) 
 = 5
 
 (binding [a 2, b 3]) - перекрывает значение глобальной переменной для потока. забиндить можно на значение но на выражение
 с какой то версии кложа перекрываемые переменные надо объявлять динамической (def ^:dynamic a [1 2 3])
 
 (apply функция коллекция) (apply + [1 2 3])=(+ [1 2 3])
 
; как задать функцию
 (defn f [ p1 v1, p2 v2]								анонимная функция + связывание с переменной чтоб меньше скобок
 .
 .
 .
 )
 
 #(func %1 %2) анонимная функция с именованными параметрами

 (map #(+ %1 1) '(1 2 3)) - берет функцию у которой один аргумент применяет +1 к каждому элементу коллекции и возвращает в ноую коллекцию 
 = 2 3 4 

 (if (condition) ans1 ans2) 	-  если условие возвращает ans1, иначе ans2

 (map #((if %1>2 0 %1) '(1 2 3))
 
; функция фильтр пробегает по коллекцию и берет элементы которые удовлетворяют условию
 (filter #(> %1 0) '(-1 0 1)) = 1
 
; логические функции обозначают (ф-я? арг) => 0/1
 (odd? arg) - нечетные 
 (even? arg) - четные
; 
; Логические выражения
 (and arg1 arg2 ... argN)
 (or arg1 arg2 ... argN)
;
 (reduce * [1 2 3]) = 1*2*3 сжимает список в одно число с указанной операцией (функцией)

 ; тут кажется лажа
 (reduce #((if (= %2 "a") %1 (str %1 %2)) '("a" "b" "c")) - сложить четные эл-ты последовательности

 'symbol = (symbol "symbol") это создание символа. Символ это имя - терма языка
 сивол и ключ это не одно и то же

 исключения записываются в виде:
 (try
    (pop '())																										то что делаем
    (catch IllegalStateException e    	непонятная штука, если заменить е то ничего не меняется
      "No dice!"))																					то что вылазит в случе ошибки