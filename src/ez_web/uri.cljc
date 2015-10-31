(ns ez-web.uri
  (:require [clojure.string :as str]))


(defn join-uri
  "Join two or more fragmets of an URI together"
  [& paths]
  (loop [parts []
         [path & paths] paths]
    (if (nil? path)
      (str "/" (str/join "/" (flatten parts)))
      (recur (conj parts (remove str/blank? (str/split path #"/"))) paths))))

(defn uri-last-part
  "Take any uri and only return the last part corresponding to the page"
  [uri]
  (last (remove str/blank? (str/split uri #"/"))))

(defn uri-but-last-part
  "Take any uri and return everything but the last part corresponding to the page"
  [uri]
  (str "/" (str/join "/" (butlast (remove str/blank? (str/split uri #"/"))))))
