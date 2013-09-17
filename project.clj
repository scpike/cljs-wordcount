(defproject cljs-wordcount "0.1.0"
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :plugins [[lein-cljsbuild "0.3.2"]]
  :cljsbuild {:builds [{:source-paths ["src/cljs_wordcount"]
                        :compiler {:output-to "js/counter.js"}}]}
  :main cljs-wordcount.core)
