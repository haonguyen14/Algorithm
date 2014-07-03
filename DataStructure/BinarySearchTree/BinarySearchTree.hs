data BinarySearchTree a = Empty | Node a (BinarySearchTree a) (BinarySearchTree a) deriving Show


insert :: (Ord a) => BinarySearchTree a -> a -> BinarySearchTree a
insert Empty x = Node x Empty Empty
insert (Node v left right) x
	| v > x = Node v (insert left x) right
	| v < x = Node v left (insert right x)
	| otherwise = Node v left right


contains :: (Ord a) => BinarySearchTree a -> a -> Bool
contains Empty _ = False
contains (Node n l r) x
	| x == n = True
	| x > n = contains r x
	| otherwise = contains l x


getMin :: (Ord a) => BinarySearchTree a -> a
getMin (Node n Empty _) = n
getMin (Node _ l _) = getMin l 


delete :: (Ord a) => BinarySearchTree a -> a -> BinarySearchTree a
delete Empty _ = Empty
delete (Node n l r) x
	| x < n = Node n (delete l x) r
	| x > n = Node n l (delete r x)
	| otherwise = remove (Node n l r)


remove :: (Ord a) => BinarySearchTree a -> BinarySearchTree a
remove Empty = Empty
remove (Node _ Empty Empty) = Empty
remove (Node _ l Empty) = l
remove (Node _ Empty r) = r
remove (Node n l r) = Node min l (delete r min)
	where min = getMin r
