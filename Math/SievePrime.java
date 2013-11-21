import java.util.ArrayList;

class SievePrime {
	public static void main(String[] args) {
		ArrayList<Integer> primes = primes(Integer.parseInt(args[0]));
		for(int i = 0; i < primes.size(); i++)
			System.out.print(primes.get(i) + "  ");

		System.out.println();
	}


	/* Regular */
	public static ArrayList<Integer> primes(int to) {
		int total = to;
		ArrayList<Integer> ret = new ArrayList<Integer>();

		boolean[] marker = new boolean[to];
		for(int i = 0; i < total; i++)
			marker[i] = true;		/* all are prime */
		

		/* Processing */
		int prime = 2;
		while (prime < total) {
			if (!marker[prime]) {
				prime++;
				continue;
			}

			/* Elimination */
			ret.add(prime);

			for(int i = prime; i < total; i += prime)
				marker[i] = false;

			prime++;
		}

		return ret;
	}
}
