(ns fp-closure.rank.practice.introduction.filter-array)

(fn [delim lst] (filter #(< % delim) lst))

(fn [delim lst] (reduce #(if (< %2 delim) (conj %1 %2) %1) [] lst))

(defn filter-array [delim, lst]
  (if (= (count lst) 0)
    []
    (if (< (first lst) delim)
      (concat [(first lst)] (filter-array delim (rest, lst)))
      (recur delim (rest lst))
      )
    ))

(println (filter-array 3 (list 1 2 3 4)))