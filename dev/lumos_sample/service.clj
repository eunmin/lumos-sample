(ns lumos-sample.service
  (:require [io.pedestal.http :as http]
            [lumos-sample.routes :refer [routes]]))

(defn create-service [config]
  {:env :dev
   ::http/join? false
   ::http/routes #(deref #'routes)
   ::http/resource-path "/public"
   ::http/type :immutant
   ::http/port (:port config)})
