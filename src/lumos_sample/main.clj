(ns lumos-sample.main
  (:gen-class)
  (:require [com.stuartsierra.component :as component]
            [environ.core :refer [env]]
            [lumos.util.config :refer [read-config]]
            [lumos-sample.system :refer [new-system]]))

(defn -main [& args]
  (when-let [config (read-config (env :config))]
    (component/start (new-system config))))
