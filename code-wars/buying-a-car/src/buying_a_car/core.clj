(ns buying-a-car.core)

(defn calculate-depreciation-by-month
  [percent-loss-per-month month]
  (map #(/ (+ percent-loss-per-month (* 0.5 (quot % 2))) 100) (range 1 (+ month 1))))

(defn calculate-depreciation
  [percent-loss-per-month month]
  (let [depreciation-by-month (calculate-depreciation-by-month percent-loss-per-month month)
        final-percentage (reduce #(* %1 (- 1 %2)) 1 depreciation-by-month)]
    (- 1 final-percentage))
)

(defn calculate-new-car-price
  [start-car-price percent-loss-per-month month]
  (let [depreciation (calculate-depreciation percent-loss-per-month month)
        price-percentage (- 1 depreciation)]
    (* price-percentage start-car-price))
)

(defn can-buy
  [start-price-old
   start-price-new
   saving-per-month
   percent-loss-per-month
   month]
  (let [total-earns (* month saving-per-month)
        old-car-price (calculate-new-car-price start-price-old percent-loss-per-month month)
        new-car-price (calculate-new-car-price start-price-new percent-loss-per-month month)]
    (> (+ total-earns old-car-price) new-car-price))
)

(defn nearest-integer
  [number]
  (let [floor (Math/floor number)
        ceil (Math/ceil number)]
    (cond
      (< (- number floor) (- ceil number)) floor
      :else ceil)))

(defn calculate-left-over
  [start-price-old
   start-price-new
   saving-per-month
   percent-loss-per-month
   month]
  (let [total-earns (* month saving-per-month)
        old-car-price (calculate-new-car-price start-price-old percent-loss-per-month month)
        new-car-price (calculate-new-car-price start-price-new percent-loss-per-month month)
        left-over (- (+ total-earns old-car-price) new-car-price)]
    (nearest-integer left-over))
)

(defn valid-months
  "Valid months are considered months that the new car could be bought"
  [start-price-old
   start-price-new
   saving-per-month
   percent-loss-per-month]
  (filter #(can-buy start-price-old start-price-new saving-per-month percent-loss-per-month %) (range)))

(defn nb-months
  [start-price-old
   start-price-new
   saving-per-month
   percent-loss-per-month]
  (let [valid-months (valid-months start-price-old start-price-new saving-per-month percent-loss-per-month)
        months-counter (first valid-months)
        left-over (calculate-left-over
                    start-price-old start-price-new saving-per-month percent-loss-per-month months-counter)]
    [ months-counter (int left-over)])
)
