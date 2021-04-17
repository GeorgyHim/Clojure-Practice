(= {:a 1 :b 2} (hash-map :a 1 :b 2))

(= {:a 1} (hash-map :a 1))

(= 2 (count {:a 1 :b 2}))

" Получение значения по ключу, 3 способа"
(= 2 (get {:a 1 :b 2} :b))
(= 1 ({:a 1 :b 2} :a))
(= 1 (:a {:a 1 :b 2}))

(= "Sochi" ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))

(= nil (get {:a 1 :b 2} :c))

(= :key-not-found (get {:a 1 :b 2} :c :key-not-found))

(= true (contains? {:a nil :b nil} :b))

(= false (contains? {:a nil :b nil} :c))

"Maps are immutable, but you can create a new and improved version"
(= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February"))

"You can also create a new version with an entry removed"
(= {1 "January"} (dissoc {1 "January" 2 "February"} 2))

(= {:a 1 :b 2 :c 3} (merge {:a 1 :b 2} {:c 3}))

"Specify how to handle entries with same keys when merging"
(= {:a 1 :b 2 :c 3} (merge-with + {:a 1 :b 1} {:b 1 :c 3}))

(= (list 2010 2014 2018)
   (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))

(= (list "PyeongChang" "Sochi" "Vancouver")
   (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"})))

"You can even iterate over the map entries as a seq"
(= {:a 2 :b 3}
   (into {}
         (map
          (fn [[k v]] [k (inc v)])
          {:a 1 :b 2})))

" Это работает так: функция map сжимает в мап на основе безымянной функции указанный словарь."
" Функция принимает на вход список из двух аргументов и возвращает список из первого аргумента и второго+1"
" Когда подаем на вход этой функции словарь, она принимает каждую пару ключ-значение как список из двух элементов"