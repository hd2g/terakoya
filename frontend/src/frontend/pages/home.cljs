(ns frontend.pages.home
  (:require [frontend.components.layout :refer [layout]]
            [frontend.components.problem.core :refer [problem]]))

(def problems (atom []))

(reset! problems
        [{:brief "ここに問題の概要が入る"
          :description "ここに説明文が入る"
          :href "#"
          :tags [:sql]
          :user {:name "user name"
                 :icon "#"}}
         {:brief "ここに問題の概要が入る"
          :description "ここに説明文が入る"
          :href "#"
          :tags [:sql]
          :user {:name "user name"
                 :icon "#"}}
         {:brief "ここに問題の概要が入る"
          :description "ここに説明文が入る"
          :href "#"
          :tags [:sql]
          :user {:name "user name"
                 :icon "#"}}
         {:brief "ここに問題の概要が入る"
          :description "ここに説明文が入る"
          :href "#"
          :tags [:sql]
          :user {:name "user name"
                 :icon "#"}}
         {:brief "ここに問題の概要が入る"
          :description "ここに説明文が入る"
          :href "#"
          :tags [:sql]
          :user {:name "user name"
                 :icon "#"}}
         {:brief "ここに問題の概要が入る"
          :description "ここに説明文が入る"
          :href "#"
          :tags [:sql]
          :user {:name "user name"
                 :icon "#"}}])

;; TODO: home page is dashboard, problems page is /problems route
;; TODO: define routing for reitit 
(defn home []
  [layout
   [:div
    (for [dat @problems]
      [problem
       dat])]])
