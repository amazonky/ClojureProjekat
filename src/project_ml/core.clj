(ns project-ml.core
  (:gen-class))
(defn get-random-number [min-value max-value]
  (+ (rand-int (- max-value min-value 1)) min-value))
(defn -main [& args]
  (println "Welcome to Guess the Number!")
  (let [min-value 1
        max-value 100
        target (get-random-number min-value max-value)]
    (loop [attempts 0]
      (if (= attempts 10)
        (do
          (println "You've run out of attempts! The number was" target)
          (println "Game Over!"))
        (let [guess (read-line)]
          (if (Integer/parseInt guess)
            (let [guess (Integer/parseInt guess)]
              (cond
                (< guess target) (do
                                   (println "Too low!")
                                   (recur (inc attempts)))
                (> guess target) (do
                                   (println "Too high!")
                                   (recur (inc attempts)))
                :else (do
                        (println "Congratulations! You guessed the number in" (inc attempts) "attempts!")
                        (println "Game Over!"))))
            (do
              (println "Please enter a valid number!")
              (recur attempts)))))))
  )
