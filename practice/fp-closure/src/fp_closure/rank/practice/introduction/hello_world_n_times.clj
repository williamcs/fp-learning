(ns fp-closure.rank.practice.introduction.hello-world-n-times)

(defn hello_word_n_times
  [n]
  (print (apply str (repeat n "Hello World\n"))))

(defn hello_word_n_times1 [n]
  (if (not= n 0)
    (do
      (println "Hello World")
      (recur (dec n)))))

(def n (Integer/parseInt (read-line)))

(hello_word_n_times n)

(println "------------")

(hello_word_n_times1 n)