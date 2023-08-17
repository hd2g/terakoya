(ns frontend.components.menu
  (:require
   [reagent.core :as r]
   [react :as react]
   [cljss.core :as css :refer-macros [defstyles]]
   [cljss.reagent :refer-macros [defstyled]]))

(defstyled styled-menu :ul
  {})

(defstyles pointerd []
  {:cursor "pointer"})

(defn menu-icon [{:keys [on-click]}]
  [:div {:on-click on-click :class (pointerd)}
   [:img {:src "https://icongr.am/entypo/menu.svg"
          :alt "menu"}]])

(defn close-button-icon [props]
  [:div (assoc props :class (pointerd))
   [:img {:src "https://icongr.am/material/close.svg"
          :alt "close"}]])

(defstyled styled-item :li
  {:display "flex"
   :justify-content "end"
   :align-items "center"
   :margin-left "auto"
   :list-style "none"
   :padding "0.6rem 2.4rem"
   ;; :background-color "red"
   "&:hover" {:border-bottom "1px solid gray"}})

(defstyled menu-item-link :a
  {:text-decoration "none"
   :color "black"})

(defstyled menu-item-action :div
  {"&:hover" {:cursor "pointer"}})

(defstyled menu-area :div
  {;; :background-color "red"
   :position "absolute"
   :right 0}
  ;; {:display "flex"
  ;;  :height "100vh"
  ;;  :width "24%"
  ;;  :background-color "red"
  ;;  ::css/media {[:only :screen :and [:max-width "320px"]]
  ;;               {:width "32%"}}}
  )

(defstyled close-button-area :div
  {:position "relative"
   :display "flex"
   :justify-content "end"
   :align-items "center"
   :margin-top "auto"
   })

(defn menu [props]
  (let [opened? (r/atom false)
        button-area-ref (atom nil)
        out-of-close-button-area-handler
        (fn [e]
          (when (and @button-area-ref
                     (not (and (.-contains @button-area-ref)
                               (.contains @button-area-ref (.-target e)))))
            (reset! opened? false)))
        out-of-close-button-area-event
        (.addEventListener js/document "click" out-of-close-button-area-handler)]
    (fn []
      [:div {:style {:margin-right 0}}
       [close-button-area {:ref (fn [e] (when e (reset! button-area-ref e)))}
        (if @opened?
          [close-button-icon {:on-click #(reset! opened? false)}]
          [menu-icon {:on-click #(reset! opened? true)}])]
       (when @opened?
         [menu-area
          [styled-menu
           (for [{:keys [name href on-click]} props]
             [styled-item {:key name}
              (if on-click
                [menu-item-action {:on-click on-click} name]
                [menu-item-link {:href href :alt name} name])])]])])))
