(ns defworkshop.working-with-maps
  (:require [workshoplib.tdd :refer […]]))

;;
;; Maps
;;

(defn get-name-or-empty
  "Write a function that would retrieve a :name from map or return `:empty` token otherwise"
  [m]
  (def name (get m :name))
  (if name
    name
    :empty))

(defn retrieve-city
  "Given hash with following structure:

      {:name \"Alex\"
       :address { :city \"Munich\" :street \"Saulingstr\" }}

   Retrieve :city from the hash"
  [m]
  (get (get m :address) :city))

(defn get-by-path
  "Given a map of {:person {:name {:first-name \"Alex\" }}} return the `:first-name` key value.

   You can use `get-in` for that"
  [m]
  (get-in m [:person :name :first-name]))

(defn add-name
  "Write a function that adds :name to the map by using `assoc`"
  [m name]
  (assoc m :name name))

(defn add-age
  "Write a function that adds :age to the map by using `assoc`"
  [m age]
  (assoc m :age age))

(defn add-name-and-age
  "Use threading `->`, `add-name` and `add-age` functions to compose a new record that has both :name and :age"
  [m name age]
  (assoc (assoc m :age age) :name name))

(defn remove-name
  "Remove :name key from map by using `dissoc`"
  [m]
  (dissoc m :name))

(defn remove-age
  "Remove :age key from map by using `dissoc`"
  [m]
  (dissoc m :age))

(defn remove-name-and-age
  "Use threading `->`, `remove-name` and `remove-age` functions to compose a new record without :name and :age"
  [m]
  (dissoc (dissoc m :age) :name))

(defn map-keys
  "Given a map, return only it's keys. You can use `keys` function for that."
  [m]
  (keys m))

(defn map-values
  "Given a map, return only it's values. You can use `vals` function for that."
  [m]
  (vals m))

(defn map-select
  "Given a map `m` and a vector of keys `ks`, return a map that only contains entries keyed by `ks`. hint: you can use `select-keys`."
  [m ks]
  (select-keys m ks))

(defn ^:not-implemented map-from-keys-and-vals
  "Construct a new map from keys and values. Hint: take a look at `zipmap`."
  [keys vals]
  (…))

(defn ^:not-implemented kv-for-key
  "given a map `m` and a key `k`, return the key-value pair in `m` for `k`. return nil if the `k` isn't present in `m`. Hint: take a look at `find`."
  [m k]
  (…))

(defn map-merge
  "given two maps `m1` and `m2`, merge them such that when there's identical keys in both maps, the value in `m1` will prevail in the merged map."
  [m1 m2]
  (merge m2 m1))

(defn merge-max
  "given two maps `m1` and `m2` (values are all numbers), merge them such that for identical keys, the larger value prevails. try to leverage `merge-with` in order to achieve this."
  [m1 m2]
  (merge-with 
    (fn [a b] (max a b))
    m1 m2))

(defn contains-key
  "Check wether the given map `m` contains given key `key`.

   You can use `contains` for that."
  [m key]
  (m contains? key))

(defn ^:not-implemented invert-map
  "given a map, invert the mapping, ie {:a :b, :c :d} should become {:d :c, :b :a}. if the value set contains duplicates, choose any mapping."
  [m]
  (…))
