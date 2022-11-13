(ns suffixes)

(defn suffixes
  [xs]
  (loop [res []
         x xs]
    (if (empty? x)
      (conj res x)
      (recur
       (into res [x])
       (subvec x 1)))))

(comment
  ; [1 2 3 4] -> [[1 2 3 4] [2 3 4] [3 4] [4] []]
  (suffixes [1 2 3 4 ])
  )
