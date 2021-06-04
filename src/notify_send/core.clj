(ns notify-send.core
  (:require [clojure.java.shell :refer [sh]]
            [notify-send.icons :refer [icons]]))

(defn notify [title message & {:keys [icon] :or {icon :dialog-information}}]
  (sh "notify-send" title message (format "--icon=%s" (get icons icon))))
