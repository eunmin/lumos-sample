(ns lumos-sample.routes
  (:require [io.pedestal.http.route.definition :refer [defroutes]]
            [io.pedestal.http :refer [html-body]]
            [lumos-sample.handler.home :refer [home-page]]
            [lumos-sample.interceptor.exception :refer [exception-handler]]))

(defroutes routes
  [[["/" ^:interceptors [html-body (exception-handler)]
     {:get home-page}]]])
