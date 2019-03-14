import java.util.Arrays;
import java.util.Scanner;

public class StatisticalValues {
	
	private static class Average implements Runnable 
	{ 		
		int[] nums;
		
		public Average(int[] nums)
		{
			this.nums = nums;
		}
		
		public void printAverage(int[] nums)
		{
			double sum = 0;
			double average;
			
			for(int i = 0; i < nums.length; i++)
			{
				sum += nums[i];
			}
			
			average = sum / nums.length;
			
			System.out.println("The average is " + average);
		}
		
		public void run()
		{ 
			System.out.println(Thread.currentThread().getName() + " is executing this code");		
			printAverage(nums);
		} 
	}
	
	private static class Max implements Runnable
	{
		int[] nums;
		
		public Max(int[] nums)
		{
			this.nums = nums;
		}
		
		public void printMax(int[] nums)
		{
			int max = Arrays.stream(nums).max().getAsInt();
			
			System.out.println("The max value of the array is "+ max);
		}

		@Override
		public void run() {
			
			System.out.println(Thread.currentThread().getName() + " is executing this code");		
			printMax(nums);
			
		}
	}
	
	private static class Min implements Runnable
	{
		int[] nums;
		
		public Min(int[] nums)
		{
			this.nums = nums;
		}
		
		public void printMin(int[] nums)
		{
			int min = Arrays.stream(nums).min().getAsInt();
			
			System.out.println("The min value of the array is "+ min);
		}

		@Override
		public void run() {
			
			System.out.println(Thread.currentThread().getName() + " is executing this code");		
			printMin(nums);
			
		}
	}

	public static void main(String[] args) {
		
		int[] nums = new int[5];
		
		Scanner kb = new Scanner(System.in);// User input

		System.out.println("Enter 5 values to calculate the Average, Max and Min :");


		for (int i=0;i<5;i++) // used for loop for user input

		{

		nums[i] = kb.nextInt(); // Assigned users value to array

		}
		
		kb.close();

				
		// created three threads, none will start until we call start() method
		
		Thread t1 = new Thread(new Average(nums), "Thread - T1"); 
		Thread t2 = new Thread(new Max(nums), "Thread - T2"); 
		Thread t3 = new Thread(new Min(nums), "Thread - T3"); 
		
		// Start all three threads
		
		t1.start();
		t2.start(); 
		t3.start();

	}

}