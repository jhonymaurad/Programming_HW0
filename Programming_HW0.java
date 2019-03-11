
public class Programming_HW0 {
	
	public static boolean isPrime(int num) 
	{ 
		if (num <= 1)  return false;

		for (int i = 2; i < num; i++)
		{
			if (num % i == 0) return false;
		}	
		return true;
	} 
	  
	// Function to print primes 
	public static void printPrimeNumbers(int num) 
	{ 
	for (int i = 2; i <= num; i++)  
	{ 
	    if (isPrime(i)) 
	        System.out.println(i); 
	} 
	} 
	public static void main(String[] args) {


		int n = 20; 
	    printPrimeNumbers(n);

	}

}