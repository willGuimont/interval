(defproject interval "0.1.0-SNAPSHOT"
  :description "interval work"
  :url "https://github.com/willGuimont/interval"
  :license {:name "MIT"
            :url  "https://choosealicense.com/licenses/mit/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [medley "1.3.0"]
                 [desktop-alert "0.5.2"]
                 [clojurewerkz/quartzite "2.1.0"]]
  :repl-options {:init-ns interval.core}
  :main interval.core)
