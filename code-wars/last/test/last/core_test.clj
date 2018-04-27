(ns last.core-test
  (:require [clojure.test :refer :all]
            [last.core :refer :all]))

(deftest a-test
  (testing "testing last"
    (is (= (last [1, 2, 3, 4]) 4))))

(deftest b-test
  (testing "testing last"
    (is (= (last "xyz") \z))))
