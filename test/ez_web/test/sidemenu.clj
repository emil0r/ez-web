(ns ez-web.test.sidemenu
  (:require [ez-web.sidemenu :refer [sidemenu]]
            [hiccup.core :refer [html]]
            [midje.sweet :refer :all]))



(fact
 "Get a sidemenu"
 (html (sidemenu "/foo/bar"
                 [["/" "Home"]
                  ["/foo" "Foo"
                   ["/foo/bar" "Bar"]
                   ["/foo/baz" "Baz"]]
                  ["/baz" "Baz2"]]))
 => "<ul class=\"sidemenu\"><li><a href=\"/\">Home</a></li><li class=\"active\"><a href=\"/foo\">Foo</a><ul class=\"sub\"><li class=\"active\"><a href=\"/foo/bar\">Bar</a></li><li><a href=\"/foo/baz\">Baz</a></li></ul></li><li><a href=\"/baz\">Baz2</a></li></ul>")


(fact
 "Get a sidemenu"
 (html (sidemenu "/admin/foo/bar"
                 [["/" "Home"]
                  ["/foo" "Foo" ["/foo/bar" "Bar"]]
                  ["/baz" "Baz"]]
                 {:base "/admin"}))
 => "<ul class=\"sidemenu\"><li><a href=\"/admin\">Home</a></li><li class=\"active\"><a href=\"/admin/foo\">Foo</a><ul class=\"sub\"><li class=\"active\"><a href=\"/admin/foo/bar\">Bar</a></li></ul></li><li><a href=\"/admin/baz\">Baz</a></li></ul>")
