# ez-web

Batteries for the web

## paginate
```clojure
(require '[ez-web.paginator :refer [paginate]])
(def paginate-this (range 101))
(let [{:keys [prev-seq next-seq pages page next prev] (paginate paginate-this 10 5)]
   {pages 11 ;; num pages
    page 5 ;; current page
    next 6 ;; one up from page
    prev 4 ;; one down from page
    next-seq [7 8 9 10 11] ;; lazy sequence starting after next
    prev-seq [3 2 1] ;; lazy sequence starting from before prev
    })
```

## breadcrumbs
```clojure
(require '[ez-web.breadcrumbs :refer [crumb]])
(crumb "/path/in/your/website" opts?)
(crumb [["path" "The path"] ["in" "Within"] ["your" "Thy Royal Highness'"] ["website" "Kingdom"]])

;; will give back a map with the keys
;; :crumb-data - the raw data
;; :last - the last bit
;; :crumbs - a vector representation of the breadcrumbs

;; crumb will also take an additional map of options
;; no documentation right now apart from the source code
```

## License

Copyright © 2014 Emil Bengtsson

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
