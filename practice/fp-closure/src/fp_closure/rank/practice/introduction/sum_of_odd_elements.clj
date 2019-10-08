(ns fp-closure.rank.practice.introduction.sum-of-odd-elements)

(defn sum-of-odd-elements
  "sum of odd elements"
  [lst]
  (reduce + (filter odd? lst))
  )

(println (sum-of-odd-elements (list 11, 25, 18, -1, 26, -20, -19, 23, -24, -8)))