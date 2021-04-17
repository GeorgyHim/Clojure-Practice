"A clojure.string is nothing more than text surrounded by double quotes"
(= "hello" "hello")

"But double quotes are just magic on top of something deeper"
(= "world" (str 'world))

"You can do more than create clojure.strings, you can put them together"
(= "Cool right?" (str 'Cool " right?"))

"You can even get certain characters"
(= \C (get "Characters" 0))

"Or even count the characters"
(= 11 (count "Hello World"))

"But clojure.strings and characters are not the same"
(= false (= \c "c"))

"What if you only wanted to get part of a clojure.string?"
(= "World" (subs "Hello World" 6 11))

"How about joining together elements in a list?"
(= "123" (clojure.string/join '(1 2 3)))

"What if you wanted to separate them out?"
(= "1, 2, 3" (clojure.string/join ", " '(1 2 3)))

"Maybe you want to separate out all your lines"
(= ["1" "2" "3"] (clojure.string/split-lines "1\n2\n3"))

"You may want to make sure your words are backwards"
(= "olleh" (clojure.string/reverse "hello"))

"Maybe you want to find the index of the first occurrence of a subclojure.string"
(= 0 (clojure.string/index-of "hello world" "h"))

"Or maybe the last index of the same"
(= 13 (clojure.string/last-index-of "hello world, hello" "hello"))

"But when something doesn't exist, nothing is found"
(= nil (clojure.string/index-of "hello world" "bob"))

"Sometimes you don't want whitespace cluttering the front and back"
(= "hello world" (clojure.string/trim "  \nhello world \t \n"))

"You can check if something is a char"
(= true (char? \c))

"But it may not be"
(= false (char? "a"))

"But chars aren't clojure.strings"
(= false (string? \b))

"clojure.strings are clojure.strings"
(= true (string? "some"))

"Some clojure.strings may be blank"
(= true (string/blank? ""))

"Even if at first glance they aren't"
(= true (string/blank? " \n \t  "))

"However, most strings aren't blank"
(= false (string/blank? "hello?\nare you out there?"))