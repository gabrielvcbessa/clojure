;; Prime Sandwich

;; Difficulty:	Medium
;; Topics:	math


;; A balanced prime is a prime number which is also the mean of the primes directly before and after it in the sequence of valid primes. Create a function which takes an integer n, and returns true iff it is a balanced prime.

(fn
  ([n]
  (let [
          divisible? #(zero? (mod %1 %2))
          prime? #(and (> %1 1) (not-any? (partial divisible? %1) (range 2 (inc (Math/sqrt %1)))))
          step-prime (first (drop-while #(not (prime? %)) (take n (iterate dec (- n 1)))))
          balanced-prime? (fn [n] (
                              if (not (and (prime? n) step-prime)) false
                              (->
                                (+ step-prime (first (drop-while #(not (prime? %)) (take n (iterate inc (+ n 1))))))
                                (/ 2)
                                (= n))
                             ))
        ]
   (balanced-prime? n))))
