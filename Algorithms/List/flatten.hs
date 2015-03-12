data Nested a = Elem a | List [Nested a] deriving Show

_flatten :: Nested a -> [a]
_flatten (Elem x) = [x]
_flatten (List x) = foldl (\a b -> a ++ _flatten b) [] x
