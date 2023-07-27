(ns frontend.components.header
  (:require [cljss.reagent :refer-macros [defstyled]]))

(defstyled styled-header :header
  {:display "flex"
   :flex-direction "row"
   :justify-content "center"
   :margin "1rem"})

(defn header [& children]
  [styled-header
   children])
