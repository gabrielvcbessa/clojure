(ns buying-a-car.core-test
  (:require [clojure.test :refer :all]
            [buying-a-car.core :refer :all]))

(deftest depreciation-by-month-test
  (testing "monthly depreciation in 2 months"
    (is (= (calculate-depreciation-by-month 1.5 2) [0.015 0.02]))))

(deftest depreciation-test
  (testing "1 month depreciation"
    (is (= (float (calculate-depreciation 1.5 1)) (float 0.015))))

  (testing "2 month depreciation"
    (is (= (float (calculate-depreciation 1.5 2)) (float 0.0347)))))

(deftest car-price-test
  (testing "car price after 1 month"
    (is (= (calculate-new-car-price 1 1.5 1) (/ 98.5 100))))

  (testing "car price after 2 month"
    (is (= (calculate-new-car-price 1 1.5 2) (/ 96.53 100)))))

(deftest can-buy-test
  (testing "can buy what he couldn't")
    (is (= (can-buy 1000 2100 1000 1.5 1) false))

  (testing "can buy what he could")
   (is (= (can-buy 1000 2000 1000 1.5 1) true)))

(deftest a-test1
  (testing "Test 1"
    (is (= (nb-months 2000 8000 1000 1.5) [6, 766]))))

(deftest a-test2
  (testing "Test 2"
    (is (= (nb-months 12000 8000 1000 1.5) [0, 4000]))))

