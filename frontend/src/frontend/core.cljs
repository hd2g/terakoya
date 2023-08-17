(ns ^:figwheel-hooks frontend.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [cljss.core :as css]
   [frontend.pages.home :refer [home]]
   [cljss.core :refer [inject-global]]))

(defn eval-global-css []
  (inject-global
   {:html {:font-family "Helvetica Neus, sans-serif"
           :height "100vh"
           :width "100%"
           :margin 0
           :padding 0}
    :body {:padding-left "1rem"
           :padding-right "1rem"}}))

(println "This text is printed from src/frontend/core.cljs. Go ahead and edit it and see reloading in action.")

(defn multiply [a b] (* a b))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (rdom/render [home] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

(defn reset-styles! []
  (css/remove-styles!)
  (mount-app-element)
  (eval-global-css))

;; specify reload hook with ^:after-load metadata
(defn ^:after-load on-reload []
  (reset-styles!)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
