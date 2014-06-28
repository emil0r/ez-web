# ez-web

Batteries for the web

## Dependancy
```clojure
[ez-web "0.1.1"]
```


## paginate
```clojure
(require '[ez-web.paginator :refer [paginate]])
;; if a collection is sent it a count of the collection will be used as length
;; otherwise send in a length, number of pages you want and a position
(= (paginate (range 101) 10 5)
   {:prev-seq (3 2 1), :next-seq (7 8 9 10 11), :pages 11, :page 5, :next 6, :prev 4}
```

## breadcrumbs
```clojure
(require '[ez-web.breadcrumbs :refer [crumb]])
;; send in a string with an opts? map
(crumb "/path/in/your/website" opts?)
;; send in a vector of vectors with [[URI part 1, name of URI 1], [URI part 2, name of URI 2]]
(crumb [["path" "The path"] ["in" "Within"] ["your" "Thy Royal Highness'"] ["website" "Kingdom"]])

;; will give back a map with the keys
;; :crumb-data - the raw data
;; :last - the last bit that is not linked (since you're already on that URL)
;; :crumbs - a vector representation of the breadcrumbs. 
;;           works both with hiccup and enlive/html hiccup 
;;           style function

;; opts?
;; :last? [true] - true/false to have the last bit show up in the crumbs or not
;; :separator [" &rsaquo; "] - what to put in the separators between the uris
;; :separator-attrib [{:class "separator"}] - attrib map for the separator element
;; :holder [:ul] - element to hold the breadcrumbs in
;; :elem [:li] - element to hold each individual breadcrumb/separator in
;; :href-attrib - send in a map to add extra elements. will always have a calculated :href key
;; :base-uri - attach a base uri to the beginning of every breadcrumb
```

## sidmenu
```clojure
(require '[ez-web.sidemenu :refer [sidemenu]])
(sidemenu "/foo/bar"
          [["/" "Home"]
           ["/foo" "Foo" 
             ["/foo/bar" "Bar"]]
           ["/baz" "Baz"]])
           
           =>
           
           <ul class="sidemenu">
             <li>
               <a href="/">Home</a>
             </li>
             <li class="active">
               <a href="/foo">Foo</a>
               <ul class="sub">
                  <li class="active">
                     <a href="/foo/bar">Bar</a>
                  </li>
               </ul>
             </li>
             <li>
               <a href="/baz">Baz</a>
             </li>
           </ul>
```

## URI
```clojure
(require '[ez-web.uri :refer [join-uri uri-last-part uri-but-last-part])

(= (join-uri "path" "to" "your" "website")
   "/path/to/your/website")

(= (uri-last-part "/path/to/your/website")
   "website")
   
(= (uri-but-last-part "/path/to/your/website")
   "/path/to/your")
```

## License

Copyright © 2014 Emil Bengtsson

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
