(ns frontend.components.title
  (:require [cljss.reagent :refer-macros [defstyled]]))

(defstyled styled-title :h1
  {:display "flex"
   :justify-content "center"
   :align-items "center"
   :margin 0
   :padding 0})

(defn title
  ([] (title {} nil))
  ([children] (title {} children))
  ([props children]
   (styled-title props children)))
