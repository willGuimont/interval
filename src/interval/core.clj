(ns interval.core
  (:require [clojurewerkz.quartzite.jobs :as j]
            [clojurewerkz.quartzite.jobs :refer [defjob]]
            [clojurewerkz.quartzite.schedule.simple :refer [repeat-forever schedule with-interval-in-hours]]
            [clojurewerkz.quartzite.scheduler :as qs]
            [clojurewerkz.quartzite.triggers :as t]
            [interval.exercises :as exe]
            [interval.formatting :as f]
            [interval.priorities :as p]
            [notify-send.core :as n]))

(def exercises (atom (p/update-all exe/exercises p/set-random-priority)))

(defjob SelectExercise
        [ctx]
        (let [exercise (p/select-exercise (deref exercises))
              pretty-string (f/format-exercise exercise)]
          (println pretty-string)
          (n/notify "Hey! Time to exercise!" pretty-string :icon :applications-games))
        (swap! exercises p/update-weights))

(defn -main
  [& m]
  (let [s (-> (qs/initialize) qs/start)
        job (j/build
              (j/of-type SelectExercise)
              (j/with-identity (j/key "jobs.noop.1")))
        trigger (t/build
                  (t/with-identity (t/key "triggers.1"))
                  (t/start-now)
                  (t/with-schedule (schedule
                                     (repeat-forever)
                                     (with-interval-in-hours 1))))]
    (qs/schedule s job trigger)))
