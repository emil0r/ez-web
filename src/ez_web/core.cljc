(ns ez-web.core
  (:require [ez-web.breadcrumbs :as breadcrumbs]
            [ez-web.paginator :as paginator]
            [ez-web.sidemenu :as sidemenu]
            [ez-web.uri :as uri]))


(def paginate paginator/paginate)
(def crumb breadcrumbs/crumb)
(def join-uri uri/join-uri)
(def uri-last-part uri/uri-last-part)
(def uri-but-last-part uri/uri-but-last-part)
(def sidemenu sidemenu/sidemenu)
