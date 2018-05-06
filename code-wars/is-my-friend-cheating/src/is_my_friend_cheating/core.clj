(ns is-my-friend-cheating.core)

(defn complement?
  [n complement sum]
  (let [total (- sum (+ n complement))
        prod (* n complement)]
    (cond (= total prod) true
          :else false)))

(defn find-complements
  [n ceil sum]
  (keep #(when (complement? n % sum) [n %]) (range n (+ ceil 1))))

(defn remove-nb
  [ceil]
  (let [seq (range 1 (+ ceil 1))
        sum (reduce + seq)
        complements (reduce #(concat %1 (find-complements %2 ceil sum)) [] seq)]
    (concat complements (reverse (map reverse complements)))))
