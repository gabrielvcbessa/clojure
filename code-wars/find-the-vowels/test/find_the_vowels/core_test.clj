(ns find-the-vowels.core-test
  (:require [clojure.test :refer :all]
            [find-the-vowels.core :refer :all]))

(defn test-assert [act exp]
  (is (= act exp)))

(deftest test-vowel
  (testing "is-vowel"
    (test-assert (vowel? "a"), false)
    )

  (testing "isn't-vowel"
    (test-assert (vowel? "b"), false)
    ))

(deftest test-generate-indices
  (testing "generate index"
    (test-assert (append-indices [] \a 0), [1]))

  (testing "ignore index"
    (test-assert (append-indices [] \b 0), [])
    ))

(deftest test-vowel-indices
  (testing "vowel-indices with super"
    (test-assert (vowel-indices "super"), [2, 4]))

  (testing "vowel-indices with Mmmm"
    (test-assert (vowel-indices "Mmmm"), []))

  (testing "vowel-indices with Super"
    (test-assert (vowel-indices "Super"), [2,4]))

  (testing "vowel-indices with Apple"
    (test-assert (vowel-indices "Apple"), [1,5]))

  (testing "vowel-indices with YoMama"
    (test-assert (vowel-indices "YoMama"), [1,2,4,6]))

  (testing "vowel-indices with repetition"
    (test-assert (vowel-indices "aaa"), [1, 2, 3]))
  )
