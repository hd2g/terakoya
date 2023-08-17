(ns frontend.components.problem.core
  (:require [cljss.reagent :refer-macros [defstyled]]))

(defstyled problem-area :div
  {})

(defn tags-list [tags]
  [:ul
   (for [tag tags]
     ^{:key tag}
     [:li {"key" tag}
      [:a {:href (str "/problems?tag=" (name tag)) :alt tag}
       tag]])])

(defstyled problem-information-area :div
  {:display "flex"
   :flex-direction "column"})

(defstyled styled-user-informations-area :div
  {})

(defn user-informations-area
  ([] (user-informations-area {} nil))
  ([params-or-children]
   (if (map? params-or-children)
     (user-informations-area params-or-children nil)
     (user-informations-area {} params-or-children)))
  ([{:keys [href]} & children]
   [:div
    [:div {:href href}
     children]]))
  
;; TODO: define styles
(defn problem
  "examples:
  [problem
   :brief \"brief\"
   :description \"description\"
   :href \"#\"
   :tags [:sql]
   :user {:name \"user name\"
          :icon \"#\"}]"
  [{:keys [brief description href tags user]}]
  (let [{:keys [id name icon]} user
        user-page-link (:href user)]
    [problem-area
     [tags-list tags]
     [problem-information-area
      [:a {:alt brief :href href} brief]
      [:div description]]
     [user-informations-area {:href user-informations-area}
      [:a {:href (str "/users/" id)}
       [:div {:style {:display "flex" :flex-direction "row" :align-items "center"}}
        [:img {:src icon}]
        [:p name]]]]]))
