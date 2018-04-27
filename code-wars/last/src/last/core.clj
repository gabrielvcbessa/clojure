(ns last.core)

(defn last
  "Returns the last element of an ISeq"
  [lst]
  (peek (into [] lst))
  )
