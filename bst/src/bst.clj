(ns bst)

(defn member
  [x tree]
  (loop [a tree]
    (let [y (:data a)
          left (:left a)
          right (:right a)]
      (if (empty? a)
        false
        (cond
          (< x y) (recur left)
          (> x y) (recur right)
          :else true)))))

(comment

  (let [tree {:data 8
              :left {:data 3
                     :left {:data 1}
                     :right {:data 6
                             :left {:data 4}
                             :right {:data 7}}}
              :right {:data 10
                      :right {:data 14
                              :left {:data 13}}}}]
    (member 14 tree)
    )

  )
