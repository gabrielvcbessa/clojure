(ns rectangle-into-squares.core-test
  (:require [clojure.test :refer :all]
            [rectangle-into-squares.core :refer :all]))

(deftest a-test1
  (testing "Test 1"
    (is (= (sq-in-rect 5 3) [3 2 1 1]))))

(deftest a-test2
  (testing "Test 2"
    (is (= (sq-in-rect 3 5) [3 2 1 1]))))

(deftest a-test3
  (testing "Test 3"
    (is (= (sq-in-rect 5 5) nil))))

(deftest a-test4
  (testing "Test 4"
    (is (= (sq-in-rect 1 5) [1 1 1 1 1]))))
