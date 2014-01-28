public class Trie {
	private Trie[] subTries;

	/**
	 *	Root Constructor
	 */
	public Trie() {
		this.subTries = new Trie[26];
		for(int i = 0; i < this.subTries.length; i++)
			this.subTries[i] = null;
	}


	/**
	 *	Insertion
	 */
	public void insert(String word) {
		this.insert(word, 0);
	}


	private void insert(String word, int index) {
		// Edge Condition
		if(index >= word.length())
			return;

		int subTrieIndex = word.charAt(index) - 'a';
		if(this.subTries[subTrieIndex] == null)
			this.subTries[subTrieIndex] = new Trie();

		this.subTries[subTrieIndex].insert(word, index + 1);
	}


	/**
	 *	Check for Prefix
	 */
	public boolean hasPrefix(String prefix) {
		Trie curr = this;

		int i = 0;
		while(i < prefix.length()) {
			int subTrieIndex = prefix.charAt(i) - 'a';
			curr = curr.subTries[subTrieIndex];
			
			if(curr == null)
				break;
			i++;
		}

		return (i == prefix.length());
	}
}
