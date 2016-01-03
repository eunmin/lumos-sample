(ns lumos-sample.handler.home
  (:require [ring.util.response :refer [response]]))

(defn home-page [request]
  (let [a 1]
    (response "Hello 땡큐")))
