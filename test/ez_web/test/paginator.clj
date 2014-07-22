(ns ez-web.test.paginator
  (:require [ez-web.paginator :refer [paginate]]
            [midje.sweet :refer :all]))


(fact
 "Num pages"
 [(:pages (paginate (range 15) 1 1))
  (:pages (paginate (range 15) 2 1))
  (:pages (paginate (range 15) 3 1))
  (:pages (paginate (range 15) 4 1))]
 => [15 8 5 4])


(fact
 "Prev sequence"
 (let [p1 (paginate (range 15) 1 7)
       p2 (paginate (range 15) 2 4)
       p3 (paginate (range 15) 3 3)
       p4 (paginate (range 15) 4 2)
       p5 (paginate (range 15) 1 1)]
   [(:prev-seq p1)
    (:prev-seq p2)
    (:prev-seq p3)
    (:prev-seq p4)
    (:prev-seq p5)])
 => [[6 5 4 3 2 1] [3 2 1] [2 1] [1] []])

(fact
 "Next sequence"
 (let [p1 (paginate (range 15) 1 7)
       p2 (paginate (range 15) 1 15)]
   [(:next-seq p1)
    (:next-seq p2)])
 => [[8 9 10 11 12 13 14 15] []])

(fact
 "prev/next"
 (let [p1 (paginate (range 15) 1 7)]
   [(:next p1) (:prev p1)]
   => [8 6]))
