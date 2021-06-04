(ns interval.core
  (:require [interval.priorities]
            [notify-send.core :as n]))

(defn -main
  "I don't do a whole lot."
  [& args]
  (println "Hello, World!")
  (n/notify "a" "d" :icon :mail-send))
