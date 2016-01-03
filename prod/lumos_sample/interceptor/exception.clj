(ns lumos-sample.interceptor.exception
  (:require [clojure.tools.logging :as log]
            [io.pedestal.interceptor :refer [interceptor]]
            [ring.util.response :refer [response status]]))

(defn exception-handler []
  (interceptor
    {:error
     (fn [ctx e]
       (log/error e)
       (assoc ctx :resposne (status (response "error") 500)))}))
