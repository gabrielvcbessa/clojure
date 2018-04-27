(ns rectangle-into-squares.core)

(defn compute-sq
  [lng wdth sqrs]
  (cond
    (= lng wdth) (conj sqrs lng)
    (< lng wdth) (compute-sq lng (- wdth lng) (conj sqrs lng))
    :else (compute-sq (- lng wdth) wdth (conj sqrs wdth)))
  )

(defn sq-in-rect
  [lng wdth]
  (cond
    (= lng wdth) nil
    :else (compute-sq lng wdth []))
  )

