(ns lumos-sample.service
  (:require [io.pedestal.http :as http]
            [lumos-sample.routes :refer [routes]]))

(defn create-service [config]
  {:env :prod
   ::http/join? false
   ::http/routes routes
   ::http/resource-path "/public"
   ::http/type :immutant
   ::http/port (:port config)})
