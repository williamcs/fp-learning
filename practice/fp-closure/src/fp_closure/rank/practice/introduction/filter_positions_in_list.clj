(ns fp-closure.rank.practice.introduction.filter-positions-in-list)

(defn filter-position-in-list
  "filter positions in a list"
  [lst]
  (map second (partition 2 lst))
  )

(defn filter-positions-in-list1
  "filter positions in a list"
  [lst]
  (take-nth 2 (rest lst))
  )

(defn filter-positions-in-list2
  "filter positions in a list"
  [lst]
  (map (partial nth lst) (filter odd? (range (count lst))))
  )

(println (filter-position-in-list (list 1 2 3 4 5)))

(println (filter-positions-in-list1 (list 1 2 3 4 5)))

(println (filter-positions-in-list2 (list 1 2 3 4 5)))

