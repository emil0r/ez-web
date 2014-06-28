(defproject ez-web "0.2.0"
  :description "Batteries for the web"
  :url "https://github.com/emil0r/ez-web"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :profiles {:dev {:plugins [[lein-midje "3.1.1"]]
                   :dependencies [[midje "1.6.3"]
                                  [hiccup "1.0.5"]]}})
