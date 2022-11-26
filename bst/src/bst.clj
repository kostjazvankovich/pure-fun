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

(defn insert
  [x tree]
  (let [y (:data tree)
        left (:left tree)
        right (:right tree)]
    (if (empty? tree)
      {:data x}
      (cond
        (< x y) {:data y :left (insert x left) :right right }
        (> x y) {:data y :left left :right (insert x right)}
        :else tree))))

(comment

  (let [tree {:data 8
              :left {:data 3
                     :left {:data 1}
                     :right {:data 6
                             :left {:data 4}
                             :right {:data 7}}}
              :right {:data 10
                      :right {:data 14
                              :left {:data 13}}}}
        x 2]
    (member x (insert x tree))
    )
  )
