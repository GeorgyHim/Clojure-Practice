(reduce 
	(fn [primes number]
		(if (some zero? (map (partial mod number) primes) )
			primes
			(conj primes number)
		)
	)
	[2]
	(take 1000 (iterate inc 3))
)
; partial - коррирование (портирование) - когда функцию от двух параметров (mod) сводят к функции 
;	от аргумента и параметра 