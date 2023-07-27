(ns frontend.styles.style
  (:require [cljss.core :refer [inject-global]]))

(inject-global
 {:html {:font-family "Helvetica Neus, sans-serif"}
  :body {:margin 0
         :padding 0
         :height "100vh"
         :width "100%"}})
