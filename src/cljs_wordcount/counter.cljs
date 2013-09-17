(ns cljs-wordcount.counter
  (:use [clojure.string :only (split blank?)])
  (:require [clojure.browser.dom :as dom]
            [clojure.browser.event :as event]))

(defn count-words [text] (count (remove blank? (split text #"\s+"))))
(defn count-lines [text] (count (remove blank? (split text #"\n+"))))

(defn count-text [t]
  (set! (.-innerHTML (dom/get-element "chars")) (count t))
  (set! (.-innerHTML (dom/get-element "words")) (count-words t))
  (set! (.-innerHTML (dom/get-element "lines")) (count-lines t)))

(def input (dom/get-element "input"))
(defn input-text [] (.-value input))

(event/listen input :keyup (fn [e] (count-text (input-text))))
(count-text (input-text))
