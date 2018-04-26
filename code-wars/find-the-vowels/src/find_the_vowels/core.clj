(ns find-the-vowels.core)

(defn vowel?
      [char]
      (contains? #{\a \e \i \o \u \y} char))

(defn append-indices
  [vowel-list char index]
  (cond
    (vowel? char) (conj vowel-list (+ index 1))
    :else vowel-list))

(defn vowel-indices
  [word]
  (let [lower-cased-word (clojure.string/lower-case word)
        chars-vector (map-indexed #(hash-map :index %1 :value %2) (char-array lower-cased-word ))]
    (reduce #(append-indices %1 (:value %2) (:index %2)) [] chars-vector)))
