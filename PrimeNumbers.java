import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbers implements Runnable{
	
	int num;
	
	public PrimeNumbers(int num)
	{
		this.num = num;
	}
	
	
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
	

	@Override
	public void run() {
		
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("Thread " +  Thread.currentThread().getId() + " is running"); 
            printPrimeNumbers(num);
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        }
			
	}
	
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Number to generate prime numbers (it will output less or equal): ");
		
		int numToGenerate = kb.nextInt();
		
		Thread t1 = new Thread(new PrimeNumbers(numToGenerate), "Thread - T1"); 
		t1.start();
	}
}