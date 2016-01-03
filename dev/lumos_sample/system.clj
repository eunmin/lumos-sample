(ns lumos-sample.system
  (:require [com.stuartsierra.component :as component]
            [lumos-sample.service :refer [create-service]]
            [lumos.component
             [database :refer [new-database]]
             [server :refer [new-server]]]))

(defn new-system [config]
  (component/system-using
    (component/system-map
      :db (new-database (:db config))
      :server (new-server (create-service (:server config))))
    {:server [:db]}))
