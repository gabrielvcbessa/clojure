;; A Half-TruthSolutions
;; Difficulty:	Easy
;; Topics:


;; Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true, but not all of the parameters are true. Otherwise your function should return false.

(fn [& args]
  (and (true? (some true? args)) (true? (some false? args))))
