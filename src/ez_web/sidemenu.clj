(ns ez-web.sidemenu
  (:require [ez-web.uri :refer [join-uri]]))

(defn sidemenu
  ([uri children] (sidemenu uri children {}))
  ([uri children {:keys [holder holder-attrib elem elem-attrib href-attrib
                         base]
                  :or {holder :ul holder-attrib {:class "sidemenu"}
                       elem :li elem-attrib {} href-attrib {}
                       base "/"}
                  :as opts}]
     (let [base (if (and (not= base "/") (.endsWith base "/"))
                  (apply str (butlast base))
                  base)]
      [holder holder-attrib
       (map (fn [[path name & sub-children]]
              (let [path (if base (join-uri base path) path)]
                [elem (merge elem-attrib
                             (cond
                              ;; page == page you're currently on
                              (= path base uri) {:class "active"}
                              ;; ;; page starts with the uri being sent in
                              (and (not (= path base))
                                   (.startsWith uri path)) {:class "active"}
                                   ;; not on the path
                              :else nil))
                 [:a (merge {:href path} href-attrib) name]
                 (when sub-children
                   (sidemenu uri sub-children (assoc opts :holder-attrib {:class "sub"})))
                 ])) children)])))
