(defn is-even? [n]
  (if (= n 0)
    true
    (not (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n n acc true]
    (if (= n 0)
      acc
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  (if (= (count coll) 0)
  		()
  		(concat [(last coll)] (recursive-reverse (butlast coll)))))

(defn factorial [n]
  (if (= n 1)
  				1
  				(* n (factorial (dec n)))))

-------------------------------------------------------------

  (= true (is-even? 0))

  (= false (is-even? 1))

  (= false (is-even-bigint? 100003N))

  (= '(1) (recursive-reverse [1]))

  (= '(6 5 4 3 2) (recursive-reverse [2 3 4 5 6]))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (< 1000000000000000000000000N (factorial 1000N))

  "But what happens when the machine limits you?"
  (< 1000000000000000000000000N (factorial 100003N))