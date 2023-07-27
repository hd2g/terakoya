(ns frontend.components.layout
  (:require [cljss.reagent :refer-macros [defstyled]]
            [frontend.components.menu :refer [menu]]
            [frontend.components.header :refer [header]]
            [frontend.components.title :refer [title]]))

(defstyled screen :div
  {})

(defn sign-out []
  (js/window.alert "ok"))

(defstyled menu-area :div
  {:display "flex"
   :justify-content "center"
   :align-items "end"
   :margin-left "auto"
   :margin-bottom "auto"})

(defn layout
  ([] (layout {} nil))
  ([children] (layout {} children))
  ([props children]
   [screen
    [header
     [:div
      [title
       [:a {:href "/" :style {:text-decoration "none" :color "black"}}
        "Title"]]]
     [menu-area
       [menu
        [{:name "Problems"
          :href "/problems"}
         {:name "Sign Out"
          :on-click #(sign-out)}]]]]
    ;; [header]
    ;; [contents]
    ;; [footer]
    children]))
