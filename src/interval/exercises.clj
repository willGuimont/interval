(ns interval.exercises)

(defrecord Exercise [name rep duration])

(defn make-exercise [name & {:keys [rep duration]}] (->Exercise name rep duration))

(defn map-exercise [xs] {:exercises (map (partial apply make-exercise) xs)})

; TODO tune reps and duration
(def exercises {:arms     (map-exercise [["Push-ups" :rep 15]
                                         ["Curls" :rep 15]
                                         ["Diamond Push-ups" :rep 10]
                                         ["Chest press" :rep 10]
                                         ["Dips" :rep 10]])
                :core     (map-exercise [["Plank" :duration 1]
                                         ["Crunches" :rep 30]
                                         ["Bicycle crunches" :rep 30]
                                         ["Leg lifts" :rep 10]
                                         ["Superman" :duration 0.5]])
                :legs     (map-exercise [["Squats" :rep 20]
                                         ["One-legged squats" :rep 10]
                                         ["Horsestand" :duration 1]
                                         ["Lunges" :rep 20]
                                         ["Calf raises" :rep 30]])
                :mobility (map-exercise [["Stretching" :duration 5]
                                         ["Mountain climbers" :rep 20]
                                         ["Jumping jacks" :rep 50]
                                         ["Leg lifts" :rep 50]
                                         ["Jog in place" :duration 1.5]])})
