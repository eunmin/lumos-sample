(ns lumos-sample.interceptor.exception
  (:require [lumos.interceptor.prone-pedestal :refer [exceptions]]))

(defn exception-handler []
  (exceptions))
