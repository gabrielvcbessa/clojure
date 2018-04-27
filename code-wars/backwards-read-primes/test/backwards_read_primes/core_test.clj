(ns backwards-read-primes.core-test
  (:require [clojure.test :refer :all]
            [backwards-read-primes.core :refer :all]))

(deftest prime-test
  (testing "is 3 prime"
    (is (= (prime? 3) true)))

  (testing "is 4 prime"
    (is (= (prime? 4) false)))

  (testing "is 10 prime"
    (is (= (prime? 10) false)))

  (testing "is 13 prime"
    (is (= (prime? 13) true))))

(deftest reverse-test
  (testing "6789 reverse"
    (is (= (reverse-number 6789) 9876)))

  (testing "123 reverse"
    (is (= (reverse-number 123) 321)))

  (testing "7 reverse"
    (is (= (reverse-number 7) 7))))

(deftest a-test1
  (testing "Test 1"
    (def rp [7027, 7043, 7057])
    (is (= (backwards-prime 7000 7100) rp))))

(deftest a-test2
  (testing "Test 2"
    (def rp [13, 17, 31, 37, 71, 73, 79, 97])
    (is (= (backwards-prime 2 100) rp))))

(deftest a-test3
  (testing "Test 2"
    (def rp [9923, 9931, 9941, 9967])
    (is (= (backwards-prime 9900 10000) rp))))
