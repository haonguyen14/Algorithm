/* Malcolm Ross 1/14
 *
 * Here's my indexedBST for the SOS lab 4.
 *
 * It is based on an implementation I of a standard BST I found online at
 * cprograming.com (as of 1/14/14 it is lesson 18) with a few modifications
 * based on my personal taste and what the assignment called for:
 *
 * I added the indexValue to the node struct and gave each node a pointer to 
 * its parent. That way, as nodes are inserted, the index of the parent node
 * is adjusted along the way upon insertion. Duplicates are not inserted. 
 *
 */

class indexedBST
{

	public:
		indexedBST( ) { root = NULL }
		~indexedBST( ) { emptyTree( root ) }

		int insert( int val )
		{
			if( root != NULL )
				insert( val, root );
			else
			{
				root = new node( val );
				root->indexValue = 0;
			}
			return val;	
		}

		node* search( int val )
		{
			if( root != NULL )
				search( val, root );
			else
				return NULL;
		}

		void emptyTree( *node n ) 
		{
			while( n )
			{ 
				emptyTree( n->left );
				emptyTree( n->right );
				delete n;
			}
		}
		struct node
		{
			private:
				int value;
				struct node* left;
				struct node* right;
				int indexValue;
				int node* parent;
			
			public:
				node( int val )
				{
					value = val;
					left = NULL;
					right = NULL;
					indexValue = -1;
				}
		}

	private:
		node* root;

		int insert( int val, node* n1 )
		{
			if( val == n1->value )
				return val;
			else if( val < n1->value )
			{
				if( n1->left != NULL )
				{
					insert( val, n1->left );
				}
				else
				{
					node n2 = new node( val );
					n2->parent = n1->left;
					increaseParentIndex( n2 );
					n2->indexValue = n1->indexValue - 1;
				}
			}
			else
			{
				if( n1->right != NULL )
				{
					insert( val, n1->right );
				}
				else
				{
					increaseParentIndex( n1 );
					node n2 = new node( val );
					n2->indexValue = n1->indexValue + 1;
					n1->right = n2;
				}
			}

			return val;
		}

		node* search( int val, node* n )
		{
			if( n == NULL )
				return NULL;
			else if( val == n->value )
				return n;
			else if( val < n->value )
				search( val, n->left );
			else
				searh( val, n->right );
		}
		
		void increaseParentIndex( node* n )
		{
			if( n->parent != NULL )
			{
				if( n == (n->parent)->left )
				{
					((n->parent)->indexValue)++;
					increaseParentIndex( n->parent );
				}
				else
					increaseParentIndex( n->parent );
			}
		}
};
