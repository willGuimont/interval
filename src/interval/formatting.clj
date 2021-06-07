(ns interval.formatting
  (:require [clojure.string :as str]))

(defn format-exercise [exe]
  (let [exercise (:exercise exe)
        category (:category exe)]
    (str (str/capitalize (name category))
         (format ": %s for " (:name exercise))
         (if-let [rep (:rep exercise)]
           (format "%d repetitions " rep) "")
         (if-let [duration (:duration exercise)]
           (format "%d minutes " duration)))))