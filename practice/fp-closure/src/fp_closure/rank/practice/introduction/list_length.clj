(ns fp-closure.rank.practice.introduction.list-length)

(defn list-length
  "list length"
  [lst]
  (.size lst)
  )

(println (list-length (list 2, 5 ,1 ,4, 3, 7, 8, 6, 0, 9)))

(defn list-length1
  "list length"
  [lst]
  (reduce + (map (fn [x] 1) lst))
  )

(println (list-length1 (list 2, 5 ,1 ,4, 3, 7, 8, 6, 0, 9)))

(defn list-length2
  "list length"
  [lst]
  (reduce (fn [x _] (+ x 1)) 0 lst)
  )

(println (list-length2 (list 2, 5 ,1 ,4, 3, 7, 8, 6, 0, 9)))