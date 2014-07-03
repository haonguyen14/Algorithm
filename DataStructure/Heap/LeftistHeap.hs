data LeftistHeap a = Empty | Node Int a (LeftistHeap a) (LeftistHeap a)
	deriving Show



rank :: (Ord a) => LeftistHeap a -> Int
rank Empty = 0
rank (Node rk _ _ _) = rk


getMin :: (Ord a) => LeftistHeap a -> a
getMin (Node _ n _ _) = n


removeMin :: (Ord a) => LeftistHeap a -> LeftistHeap a
removeMin (Node _ _ l r) = merge l r


leftist :: (Ord a) => a -> LeftistHeap a -> LeftistHeap a -> LeftistHeap a
leftist n t1 t2
	| rk1 >= rk2 = Node (rk2 + 1) n t1 t2
	| otherwise = Node (rk1 + 1) n t2 t1
	where rk1 = rank t1
	      rk2 = rank t2


merge :: (Ord a) => LeftistHeap a -> LeftistHeap a -> LeftistHeap a
merge Empty t = t
merge t Empty = t
merge t1@(Node _ n1 l1 r1) t2@(Node _ n2 l2 r2)
	| n1 < n2 = leftist n1 l1 (merge t2 r1)
	| otherwise = leftist n2 l2 (merge t1 r2)



insert :: (Ord a) => LeftistHeap a -> a -> LeftistHeap a
insert Empty x = Node 1 x Empty Empty
insert t x = merge t (insert Empty x)
