(defproject lumos-sample "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.stuartsierra/component "0.3.1"]
                 [environ "1.0.1"]
                 [io.pedestal/pedestal.service "0.4.1"]
                 [io.pedestal/pedestal.immutant "0.4.1"]
                 [org.clojure/tools.logging "0.3.1"]
                 [lumos "0.1.0-SNAPSHOT"]
                 [ch.qos.logback/logback-classic "1.1.2" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.7"]
                 [org.slf4j/jcl-over-slf4j "1.7.7"]
                 [org.slf4j/log4j-over-slf4j "1.7.7"]]
  :profiles {:uberjar
             {:aot :all
              :source-paths ["prod"]}
             :dev
             {:dependencies [[ns-tracker "0.3.0"]
                             [reloaded.repl "0.2.1"]]
              :aliases {"run-dev" ["trampoline" "run" "-m" "user/run-dev"]}
              :source-paths ["dev"]
              :repl-options {:init-ns user}
              :env {:config "config-dev.edn"}}})
