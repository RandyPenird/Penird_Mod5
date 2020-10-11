package Application;
//this class contains the Recursive and Iterative logic trees to calculate an 'n' number of values
public class Fibonacci 
{
//Recursive method to calculate and 'n' number of values in the Fibonacci Sequence
	public static void fibRecursive(int x, int y, int z, int count, int n)
	{	
		z = x+y;
		count ++;
		if(count < n)
		{
			x = z+y;
			count ++;
		}
		if(count < n)
		{
			y = x+z;
			count++;
		}
		if(count<n)
		{
			fibRecursive(x,y,z,count, n);
		}
		return;
	}
//Iterative method to calculate and 'n' number of values in the Fibonacci Sequence
	public static void fibIterative(int x, int y, int z, int count, int n)
	{	
		do
		{
			z = x+y;
			count ++;
			if(count < n)
			{
			x = z+y;
			count ++;
			}
			if(count < n)
			{
			y = x+z;
			count++;
			}
		}while(count < n);
		return;
	}
}
