(ns fp-closure.rank.practice.introduction.evaluating-e-power-x)

(defn facts
  "factorial"
  [number]
  (loop [cumulative 1 num number]
    (if (zero? num)
      cumulative
      (recur (* cumulative num) (dec num)))))

(defn expo
  "expo"
  [principle, exponent]
  (loop [cumulative 1 expat exponent]
    (if (zero? expat)
      cumulative
      (recur (* cumulative principle) (dec expat)))))

(defn expansion
  "expansion"
  [val]
  (loop [total val index 2]
    (if (= index 10)
      total
      (recur (+ total (/ (expo val index) (facts index))) (inc index)))))

(defn e-x
  "e power x"
  [val]
  (+ 1 (expansion val)))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [n-itr (range n)]
  (def x (Double/parseDouble (clojure.string/trim (read-line))))
  (println (e-x x))
  )

;(def n (Integer/parseInt (clojure.string/trim (read-line))))
;
;(doseq [n-itr (range n)]
;  (def x (Double/parseDouble (clojure.string/trim (read-line))))
;  (println (+ 1
;              (loop [total x index 2]
;                (if (= index 10)
;                  total
;                  (recur (+ total (/
;                                    (loop [cumulative 1 expat index]
;                                      (if (zero? expat)
;                                        cumulative
;                                        (recur (* cumulative x) (dec expat))))
;                                    (loop [cumulative 1 num index]
;                                      (if (zero? num)
;                                        cumulative
;                                        (recur (* cumulative num) (dec num)))))) (inc index)))))))


;
;(def n (Integer/parseInt (clojure.string/trim (read-line))))
;
;(doseq [n-itr (range n)]
;  (def x (Double/parseDouble (clojure.string/trim (read-line))))
;  (println
;    ((fn [x] (reduce + (reduce #(conj %1
;                                      (/ (Math/pow x %2)
;                                         (reduce * (range 1 (inc %2))))) [1] (range 1 10)))) x)))