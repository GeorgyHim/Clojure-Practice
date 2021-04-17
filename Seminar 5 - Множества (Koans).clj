"You can create a set by converting another collection"
  (= #{3} (set '(3)))

  (= 3 (count #{1 2 3}))

  (= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5)))

  (= #{1 2 3 4 5} (clojure.set/union #{1 2 3 4} #{2 3 5}))

  (= #{2 3} (clojure.set/intersection #{1 2 3 4} #{2 3 5}))

  (= #{1 4} (clojure.set/difference #{1 2 3 4 5} #{2 3 5}))