public class Split {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("hello");
		trie.insert("hao");
		trie.insert("how");
		trie.insert("are");
		trie.insert("you");

		split(trie, "hellohowareyouhao");
	}

	public static String[] split(Trie dict, String str) {
		int i = 0;
		while(i < str.length()) {
			String curStr = str.substring(i);
			int wordLen = dict.hasPrefix(curStr);

			System.out.println(curStr.substring(0, wordLen));
			i = i + wordLen;
		}

		return null;
	}
}
