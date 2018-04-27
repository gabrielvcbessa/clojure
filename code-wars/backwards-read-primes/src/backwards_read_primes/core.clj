(ns backwards-read-primes.core)

(defn prime?
  [number]
  (not-any? #(= 0 (mod number %)) (range 2 (+ 1 (Math/sqrt number)))))

(defn reverse-number
  [number]
  (Integer/parseInt (clojure.string/reverse (str number))))

(defn backwards-prime?
  [number]
  (let [reversed (reverse-number number)]
    (and (prime? number) (not= number reversed) (prime? reversed))))

(defn backwards-prime
  [start stop]
  (keep #(when (backwards-prime? %) %) (range start (+ stop 1))))
