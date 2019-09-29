
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Sort
{

	public static void main(String[] args)
	{
		//ArrayList<Integer> unsortedList = new ArrayList<Integer>(Arrays.asList(14, 5 ,88, 313, 43, 17, 24, 42));
		ArrayList<Integer> unsortedList = new ArrayList<Integer>();
		
		Scanner scr = new Scanner(System.in);
		
		System.out.println("Size of unsorted ArrayList: ");
		int sizeOfA = scr.nextInt();
		System.out.println("Scope of random numbers: ");
		int scopeOfRnd = scr.nextInt();
		
		Random rnGesus = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < sizeOfA; i++) 
		{
			unsortedList.add(rnGesus.nextInt(scopeOfRnd));
		}
		
		System.out.println(mergeSort(unsortedList));
	}
	
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> a) 
	{
		if(a.size() == 1) 
		{
			return a;
		}
		//System.out.println("Size of A: " + a.size());
		ArrayList<Integer> copy = a;
		ArrayList<Integer> part1 = new ArrayList<Integer>(a.subList(0, (a.size())/2));
		ArrayList<Integer> part2 = new ArrayList<Integer>(copy.subList(((a.size())/2), a.size()));
		
		part1 = mergeSort(part1);
		part2 = mergeSort(part2);
		
		return merge(part1, part2);
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b)
	{
		ArrayList<Integer> c = new ArrayList<Integer>();
		
		while(!(a.isEmpty()) && !(b.isEmpty()))
		{
			if(a.get(0) > b.get(0))
			{
				c.add(c.size(), b.get(0));
				b.remove(0);
			}
			else 
			{
				c.add(c.size(), a.get(0));
				a.remove(0);
			}
		}
		
		while(!(a.isEmpty())) 
		{
			c.add(c.size(), a.get(0));
			a.remove(0);
		}
		
		while(!(b.isEmpty())) 
		{
			c.add(c.size(), b.get(0));
			b.remove(0);
		}
		
		return c;
	}

}
