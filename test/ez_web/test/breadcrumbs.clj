(ns ez-web.test.breadcrumbs
  (:require [ez-web.breadcrumbs :refer [crumb]]
            [hiccup.core :refer [html]]
            [midje.sweet :refer :all]))


(fact
 "Breadcrumbs string"
 (html (:crumbs (crumb "/path/to/org/ez")))
 => "<ul><li><a href=\"/path\">path</a></li><li class=\"separator\"> &rsaquo; </li><li><a href=\"/path/to\">to</a></li><li class=\"separator\"> &rsaquo; </li><li><a href=\"/path/to/org\">org</a></li><li class=\"separator\"> &rsaquo; </li><li>ez</li></ul>")


(fact
 "Breadcrumbs vectors"
 (html (:crumbs (crumb [["path" "Path"] ["to" "To"] ["org" "Org"] ["ez" "Ez"]])))
 => "<ul><li><a href=\"/path\">Path</a></li><li class=\"separator\"> &rsaquo; </li><li><a href=\"/path/to\">To</a></li><li class=\"separator\"> &rsaquo; </li><li><a href=\"/path/to/org\">Org</a></li><li class=\"separator\"> &rsaquo; </li><li>Ez</li></ul>")
