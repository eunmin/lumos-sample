(ns user
  (:require [reloaded.repl :refer [go]]
            [environ.core :refer [env]]
            [clojure.tools.logging :as log]
            [ns-tracker.core :as tracker]
            [lumos.util.config :refer [read-config]]
            [lumos-sample.system :refer [new-system]]))

(defn watch []
  (loop [tracker (tracker/ns-tracker ["src" "dev" "prod" "checkouts"])]
    (try
      (doseq [ns-sym (tracker)]
        (log/info "reload" ns-sym)
        (require ns-sym :reload))
      (catch Exception e
        (log/error (.getMessage e))))
    (Thread/sleep 500)
    (recur tracker)))

(defn run-dev []
  (when-let [config (read-config (env :config))]
    (reloaded.repl/set-init! #(new-system config))
    (go)
    (watch)))


