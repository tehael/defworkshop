(ns defworkshop.state-to-recursion
  (:require [workshoplib.tdd :refer […]]))

;; More often than not, state can be avoided by using recursion. Let's see how it works

(defn reverse-coll
  "Reverse the collection `coll`.

   You can use `loop/recur` construct to loop over the sequence.
   `cons` prepends items to the list, try that out."
  ([coll]
    (loop [c coll acc '()]
      (if (empty? c)
        acc
        (recur (rest c) (cons (first c) acc))))))

(defn recursive-sum
  "We've already implemented sum using reduce, now let's move to implementing it via recursion!"
  [[head & tail]]
  (if (empty? tail)
    (or head 0)
    (+ head (recursive-sum tail))))

(defn recursive-sum-tc
  "with a tail-recursive version of sum, we can avoid stack overflows."
  ([coll]
     (recursive-sum-tc coll 0))
  ([[head & tail] acc]
      (if (nil? head)
        acc
        (recursive-sum-tc tail (+ acc head)))))

(defn max-from-list
  "Get the maximum from list using recursion"
  [[head & tail]]
  (if (empty? tail)
    head
    (if (> head (first tail))
      (max-from-list (cons head (rest tail)))
      (max-from-list tail))))

(defn ^:not-implemented my-reduce
  "generalizing the recursive sum example, write your own implementation of reduce! (for empty coll, just return nil.)"
  ([f [head & tail]]
     (my-reduce f head tail))
  ([f acc-init coll]
    (if (nil? acc-init)
      nil
      )))

(defn max-from-list-tc
  "Get the maximum from list using tail recursion (avoid stack overflow)"
  ([coll]
     (max-from-list-tc coll 0))
  ([[head & tail] max]
    (if (nil? head)
      max
      (if (> head max)
        (max-from-list-tc tail head)
        (max-from-list-tc tail max)))))

(defn loop-recur-sum
  "This implementation is somewhat easier to understand for people coming from imperative style."
  [numbers]
  (loop [nums numbers acc 0]
    (if (empty? nums)
      acc
      (recur (rest nums) (+ (first nums) acc)))))

(defn ^:not-implemented map-from-keys-and-vals
  "Something that we've already implemented previously in terms of `zipmap`, but are going to implement again
   in terms of recursion. Usually you use `loop/recur` construct whenever you have a one or multiple accumulators
   or several collections you iterate over."
  [keys vals]
  (…))

(defn ^:not-implemented parentheses-balanced?
  "Check wether the given string has balanced parantheses or no.

   You can use `cond` statement to avoid deeply nested ints.
   It's a recursive problem, so you'll have to build up stack to solve it.

   `inc` increments a number, `dec` decrements a number."
  ([str] (parentheses-balanced? str 0))
  ([[current & tail] count]
     (…)))
