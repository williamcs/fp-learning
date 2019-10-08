(ns fp-closure.rank.practice.introduction.update-list)

(defn update-list
  "update list"
  [lst]
  (map #(Math/abs %) lst)
  )

(println (update-list (list 2, -4, 3, -1, 23, -4, -54)))