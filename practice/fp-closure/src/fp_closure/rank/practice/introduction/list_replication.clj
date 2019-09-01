(ns fp-closure.rank.practice.introduction.list-replication)

(defn replicate-list
  "replicate list with n times"
  [num lst]
  (flatten (map #(replicate num %) lst)))

(fn[num lst]
  (map #(dotimes [_ num] (println %)) lst))


(fn [num lst]
  (flatten
    (map (fn [n] (vec (repeat num n))) lst)
    )
  )

(println (replicate-list 3 (list 1, 2, 3)))

