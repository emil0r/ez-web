(ns ez-web.sidemenu)

(defn sidemenu
  ([uri children] (sidemenu uri children {}))
  ([uri children {:keys [holder holder-attrib elem elem-attrib href-attrib
                         base]
                  :or {holder :ul holder-attrib {:class "sidemenu"}
                       elem :li elem-attrib {} href-attrib {}
                       base "/"}
                  :as opts}]
     [holder holder-attrib
      (map (fn [[path name sub-children]]
             [elem (merge elem-attrib
                          (cond
                           ;; page == page you're currently on
                           (= path base uri) {:class "active"}
                           ;; page starts with the uri being sent in
                           (and (not (= path base))
                                (.startsWith uri path)) {:class "active"}
                           ;; not on the path
                           :else nil))
              [:a (merge {:href path} href-attrib) name]
              (when sub-children
                (sidemenu uri [sub-children] (assoc opts :holder-attrib {:class "sub"})))
              ]) children)]))
