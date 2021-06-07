(ns interval.exercises)

(defrecord Exercise [name rep duration])

(defn make-exercise [name & {:keys [rep duration]}] (->Exercise name rep duration))

(defn map-exercise [xs] {:exercises (map (partial apply make-exercise) xs)})

;; TODO: do a new selection of exercises
(def exercises {:arms     (map-exercise [["Push ups" :rep 10]
                                         ["Dips" :rep 5]
                                         ["Arm hold" :duration 1]
                                         ["Decline push-ups" :rep 5]
                                         ["Diamond push-ups" :rep 5]
                                         ["Pull-ups" :rep 10]
                                         ["Body rows" :rep 10]
                                         ["Band pull" :rep 30]])
                :core     (map-exercise [["Plank" :duration 0.5]
                                         ["Crunches" :rep 30]
                                         ["Bicycle crunches" :rep 30]
                                         ["Rollouts" :rep 10]
                                         ["Leg lifts" :rep 10]
                                         ["Superman" :duration 0.5]
                                         ["Good morning" :rep 10]])
                :legs     (map-exercise [["Squats" :rep 20]
                                         ["Lunges" :rep 20]
                                         ["Chair pose" :duration 1]
                                         ["Calf raises" :rep 30]
                                         ["Wall sit" :duration 1]
                                         ["Jumping Squats" :rep 10]
                                         ["Wide squats" :rep 10]
                                         ["Hip raises" :rep 20]])
                :mobility (map-exercise [["Double unders" :rep 10]
                                         ["Jump rope" :duration 1]
                                         ["Stretching" :duration 5]
                                         ["Mountain climbers" :rep 20]
                                         ["Burpees" :rep 10]
                                         ["Jumping jacks" :rep 50]
                                         ["Leg lifts" :rep 50]
                                         ["Jog in place" :duration 1.5]])})
