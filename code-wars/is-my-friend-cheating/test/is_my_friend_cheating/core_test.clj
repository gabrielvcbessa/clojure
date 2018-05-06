(ns is-my-friend-cheating.core-test
  (:require [clojure.test :refer :all]
            [is-my-friend-cheating.core :refer :all]))

(deftest complement-test
  (testing "Test complement"
    (is (= (complement? 15 21 (reduce + (range 1 27))) true)))

  (testing "Test complement"
    (is (= (complement? 21 15 (reduce + (range 1 27))) true)))

  (testing "Test complement"
    (is (= (complement? 15 21 (reduce + (range 1 100))) false))))

(deftest find-complements-test
  (testing "Test find complements"
    (is (= (find-complements 15 26 (reduce + (range 1 27))) '([15 21])))))

(deftest a-test1
  (testing "Test 1"
    (is (= (remove-nb 26) [[15 21] [21 15]]))))

(deftest a-test2
  (testing "Test 2"
    (is (= (remove-nb 1000) []))))
