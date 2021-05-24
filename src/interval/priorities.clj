(ns interval.priorities
  (:require [interval.exercises :as exe]
            [medley.core :as m]))

(defn set-priority [f x] (assoc x :priority (f (:priority x))))

(defn set-priority-exercises [f x]
  (update-in x [:exercises] #(map (partial set-priority f) %)))

(defn set-zero [_] 0)

(def initial-exercises (->> exe/exercises
                    (m/map-vals (partial set-priority set-zero))
                    (m/map-vals (partial set-priority-exercises set-zero))))

(println initial-exercises)
