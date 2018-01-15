;; Symmetric DifferenceSolutions
;; Difficulty:	Easy
;; Topics:	set-theory


;; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.

(fn diff [set1, set2]
  (clojure.set/union (clojure.set/difference set1 set2) (clojure.set/difference set2 set1)))
