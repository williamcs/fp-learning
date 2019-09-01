(ns fp-closure.rank.practice.introduction.reverse-list)

(defn reverse-list
  "reverse list"
  [lst]
  (reduce conj `() lst))

(println (reverse-list (list 1 2 3 4 5)))

(defn reverse-list1
  "reverse list"
  [lst]
  (rseq (vec lst))
  )

(println (reverse-list1 (list 1 2 3 4 5)))