(ns fp-closure.rank.practice.introduction.array-of-n-elements)

;(defn array-of-n-elements
;  "array of n elements"
;  [num]
;  (range num)
;  )
;
;(def n (read-line))
;
;(println (array-of-n-elements (Integer/parseInt n)))

(
  let [lines (line-seq (java.io.BufferedReader. *in*))] (
                                                          println (
                                                                   (fn [n] (range n))
                                                                   (Integer. (first lines))
                                                                   )
                                                                  )
                                                        )