/**
 *	Non-repeating longest substring
 */

public class NRLS {
	public static void main(String[] args) {
		System.out.println(nrls(args[0]));
	}

	public static int nrls(String str) {
		int[] exist = new int[26];
		for(int i = 0; i < exist.length; i++)
			exist[i] = -1;

		int maxLength = 0;
		int curLength = 0;
		int i = 0;

		while(i < str.length()) {
			if(exist[str.charAt(i) - 'a'] == -1) {
				/* Not exist anywhere in this current substring */
				curLength++;
				maxLength = curLength >= maxLength ? curLength : maxLength;
			} else {
				curLength = i - exist[str.charAt(i) - 'a'];

				for(int j = exist[str.charAt(i) - 'a']; j >= 0; j--)
					exist[str.charAt(j) - 'a'] = -1;
			}

			exist[str.charAt(i) - 'a'] = i;
			i++;
		}

		return maxLength;
	}
}
