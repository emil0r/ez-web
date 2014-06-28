(ns ez-web.test.sidemenu
  (:require [ez-web.sidemenu :refer [sidemenu]]
            [hiccup.core :refer [html]]
            [midje.sweet :refer :all]))



(fact
 "Get a sidemenu"
 (html (sidemenu "/foo/bar"
                 [["/" "Home"]
                  ["/foo" "Foo" ["/foo/bar" "Bar"]]
                  ["/baz" "Baz"]]))
 => "<ul class=\"sidemenu\"><li><a href=\"/\">Home</a></li><li class=\"active\"><a href=\"/foo\">Foo</a><ul class=\"sub\"><li class=\"active\"><a href=\"/foo/bar\">Bar</a></li></ul></li><li><a href=\"/baz\">Baz</a></li></ul>")
