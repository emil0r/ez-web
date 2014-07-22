(ns ez-web.paginator)


(defmulti paginate
  "Paginate the incoming collection/length"
  (fn [coll? _ _] (sequential? coll?)))
(defmethod paginate true [coll count-per-page page]
  (paginate (count coll) count-per-page page))
(defmethod paginate :default [length count-per-page page]
  (let [pages (+ (int (/ length count-per-page))
                 (if (zero? (mod length count-per-page))
                   0
                   1))
        page (if (and (string? page)
                      (not= page ""))
               (read-string page)
               page)
        page (cond
              (nil? page) 1
              (or (neg? page) (zero? page)) 1
              (> page pages) pages
              :else page)
        next (+ page 1)
        prev (- page 1)]
    (let [prev (if (or (neg? prev) (zero? prev)) nil prev)]
      {:pages pages
       :page page
       :next-seq (range (inc page) (inc pages))
       :prev-seq (reverse (range 1 (if (nil? prev) 1
                                       (inc prev))))
       :next (if (> next pages) nil next)
       :prev prev})))
