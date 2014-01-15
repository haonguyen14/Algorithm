//Malcolm Ross - 1/14/14
//
//This simple class allows for the creation of a Sieve of Eratosthenes
//which constructs a boolean array that stores if a particular value 
//(or value + an offset if a range of values is given) is composite.
//
//The user can then ask if a particular value within the range is prime
//or for all the primes in sieve as well as the number of primes in the 
//sieve. 

public class SoE
{
	
	private int min; int max; 
	private boolean composits[];
	public int numPrimes;

	public SoE()
	{
		min = 0; max = 0; numPrimes = 0;
		composits = new boolean[1];
		composits[0] = true;
	}	
	public SoE( int size )
	{
		min = 0; max = size;
		composits = new boolean[ max + 1];
		composits[0] = true; composits[1] = true;

		for( int i = 2; i < Math.sqrt( max ) + 1; i++ )
		{
			for( int j = 2; j < max; j++ )
			{ 
				if( j % i == 0 ) 
				{ 
					composits[ j ] = true;
					numPrimes++;
				}
			}
		}
		numPrimes = size - numPrimes;		
	}
	public SoE( int min, int max )
	{
		min = min; max = max; numPrimes = 0;
		composits = new boolean[ max - min + 1];

		for( int i = 2; i < Math.sqrt( max ) + 1; i++ )
		{
			for( int j = min; j < max; j++ )
			{ 
				if( j % i == 0 ) 
				{
					composits[ j - min ] = true; 
					numPrimes++;
				}
			}
		}
		numPrimes = (max - min) - numPrimes;		
	}
	
	public boolean isPrime( int val )
	{
		if( val > max || val < min )
		{
			System.out.println( "Value out of range!\n" );
			return false;
		}
		else
			return !( composits[ val + min ] );
	}
	public int[] getPrimes()
	{
		int primes[] = new int[ numPrimes ];
		int p = 0;

		for( int i = 0; i < max; i++ )
		{
			if( composits[ i + min ] == false )
			{
				primes[ p ] = i + min;
				p++;
			}
		}
		
		return primes;
	}
	public int numPrimes()
	{
		return numPrimes;
	}
}
