(ns interval.priorities
  (:require [medley.core :as m]))

(defn update-priority [f x] (assoc x :priority (f (:priority x))))

(defn update-priority-exercises [f xs]
  (update-in xs [:exercises] #(map (partial update-priority f) %)))

(defn update-all [xs f]
  (->> xs
       (m/map-vals #(update-priority f %))
       (m/map-vals #(update-priority-exercises f %))))

(defn set-random-priority [_] (rand))

(defn add-random-priority [x] (+ x (rand)))

(defn select-exercise [xs]
  (let [category (key (apply max-key (comp :priority val) xs))
        exe-category ((comp :exercises category) xs)
        exercise (apply max-key :priority exe-category)
        ]
    {:category category
     :exercise exercise}))

(defn update-weights [xs]
  (let [
        selection (select-exercise xs)
        category (:category selection)
        exercise (:exercise selection)
        exercise-id (:name exercise)]
    (-> xs
        (assoc-in [category exercise-id :priority] 0)
        (assoc-in [category :priority] 0)
        (update-all add-random-priority))))
