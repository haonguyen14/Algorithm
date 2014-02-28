import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;


/**
 *	DisjointSet implementation using hash table data structure
 *	Lazy union
 *
 */

public class DisjointSet<T> implements IDisjointSet<T> {
	private HashMap<T, T> table;


	public DisjointSet() {
		table = new HashMap<T, T>();
	}


	public void insert(T item) {
		if(!table.containsKey(item))
			table.put(item, item);
	}


	public T find(T item) {
		T prevKey = table.containsKey(item) ? table.get(item) : null;
		if(prevKey == null)	
			return null;

		T nextKey = table.get(prevKey);
		while(prevKey != nextKey) {	
			/* Move Up */
			prevKey = nextKey;
			nextKey = table.get(nextKey);
		}

		table.put(item, prevKey);
		return prevKey;
	}


	public boolean union(T set1, T set2) {
		T key1 = find(set1);
		T key2 = find(set2);


		if(key1 == null || key2 == null)
			return false;

		table.put(key2, key1);
		return true;
	}


	public String toString() {
		Set<T> keys = table.keySet();

		String ret = "";
		Iterator<T> iter = keys.iterator();
		while(iter.hasNext()) {
			T item = iter.next();
			ret += item + " : " + table.get(item) + "\n";
		}

		return ret;
	}
}
