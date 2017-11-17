package Lab10;/*
 * Code taken from textBook ARCHIVE
*/
import java.io.File;
import java.util.Scanner;

/**
	Chapter 16, Programming Challenge 8
   This program displays the number of swaps made
	by four sorting algorithms on identical numbers.
 I studied with my brother Matt Doubet on QuickSort and SelectionSort.
*/

public class SortBenchMarks
{
    public SortBenchMarks()
    {
    	
    
    
    	String prompt = "\n\n\n\nEnter the letter cooresponding to the file you wish to process: \n"+
        				"   A - manyNumbers_mixed.csv \n"+
        				"   B - manyNumbers_ascending.csv \n"+ 
        				"   C - manyNumbers_descending.csv \n"+
        				"\n  or anything else to quit!\n\n";
        				 
        System.err.print(prompt);
        Scanner keyBoard = new Scanner(System.in);
        String choice_str = keyBoard.next();
        char choice = choice_str.charAt(0);
    	String fileName = "";
        
        if(choice == 'A' || choice == 'a')
        {	fileName = "manyNumbers_mixed.csv";
        }else if(choice == 'B' || choice == 'b')
        {	fileName = "manyNumbers_ascending.csv";
        }else if(choice == 'C' || choice == 'c')
        {	fileName = "manyNumbers_descending.csv";
        }else
        {	System.out.print("no valid choice entered, program terminating!");
        }
         
    
    	// Arrays of numbers to search.
      	int numbers1[] = loadDataFromFile(fileName);

      	int numbers2[] = loadDataFromFile(fileName);
								
      	int numbers3[] = loadDataFromFile(fileName);

      	int numbers4[] = loadDataFromFile(fileName);
		
		// Create our benchmark objects.
		BubbleSortBenchmarker bsort = 
		           new BubbleSortBenchmarker(numbers1);
		SelectionSortBenchmarker ssort = 
		           new SelectionSortBenchmarker(numbers2);
		InsertionSortBenchmarker isort = 
		           new InsertionSortBenchmarker(numbers3);
		QuickSortBenchmarker qsort = 
		           new QuickSortBenchmarker(numbers4);
					  
		// Display first and last numbers in sorted list
		System.err.print("\n Bubble sort: first 5 numbers: "+numbers1[0]+", "+numbers1[1]+", "+numbers1[2]+", "+numbers1[3]+", "+numbers1[4]); 
		System.err.print("\n select sort: first 5 numbers: "+numbers2[0]+", "+numbers2[1]+", "+numbers2[2]+", "+numbers2[3]+", "+numbers2[4]); 
		System.err.print("\n insert sort: first 5 numbers: "+numbers3[0]+", "+numbers3[1]+", "+numbers3[2]+", "+numbers3[3]+", "+numbers3[4]); 
		System.err.print("\n quick  sort: first 5 numbers: "+numbers4[0]+", "+numbers4[1]+", "+numbers4[2]+", "+numbers4[3]+", "+numbers4[4]); 
		
		System.err.print("\n\n Bubble sort: last 5 numbers: "+numbers1[1495]+", "+numbers1[1496]+", "+numbers1[1497]+", "+numbers1[1498]+", "+numbers1[1499]); 
		System.err.print("\n select sort: last 5 numbers: "  +numbers2[1495]+", "+numbers2[1496]+", "+numbers2[1497]+", "+numbers2[1498]+", "+numbers2[1499]); 
		System.err.print("\n insert sort: last 5 numbers: "  +numbers3[1495]+", "+numbers3[1496]+", "+numbers3[1497]+", "+numbers3[1498]+", "+numbers3[1499]); 
		System.err.print("\n quick  sort: last 5 numbers: "  +numbers4[1495]+", "+numbers4[1496]+", "+numbers4[1497]+", "+numbers4[1498]+", "+numbers4[1499]);


		// Display the numbers of bsort swaps made.
		System.out.println("\n\nNumber of swaps made with bubble sort: " +
                bsort.getNumSwaps());

        // Display the numbers of bsort comparisons made.
        System.out.println("\n\nNumber of comparisons made with bubble sort: " +
                bsort.getNumCompare());

        // Display the numbers of bsort assignments made.
        System.out.println("\n\nNumber of Assignments made with bubble sort: " +
                bsort.getNumAssignments());

        // Display the numbers of ssort swaps made.
		System.out.println("Number of swaps made with selection sort: " +
                ssort.getNumSwaps());

        // Display the numbers of ssort comparisons made.
        System.out.println("Number of comparisons made with selection sort: " +
                ssort.getNumCompare());

        // Display the numbers of ssort assignments made.
        System.out.println("Number of Assignments made with selection sort: " +
                ssort.getNumAssignments());

        // Display the numbers of isort swaps made.
		System.out.println("Number of swaps made with insertion sort: " +
                isort.getNumSwaps());

        // Display the numbers of isort comparisons made.
        System.out.println("Number of comparisons made with insertion sort: " +
                isort.getNumCompare());

        // Display the numbers of isort assignments made.
        System.out.println("Number of Assignments made with insertion sort: " +
                isort.getNumAssignments());

        // Display the numbers of qsort swaps made.
		System.out.println("Number of swaps made with Quicksort: " +
                qsort.getNumSwaps());

        // Display the numbers of qsort comparisons made.
        System.out.println("Number of comparisons made with Quicksort: " +
                qsort.getNumCompare());

        // Display the numbers of qsort assignments made.
        System.out.println("Number of Assignments made with Quicksort: " +
                qsort.getNumAssignments());
    }
    
    
    
    private  static int[] loadDataFromFile(String fileName)
    {
        
        File file = new File(fileName);
       //  al ready know that there are 1500 lines in each file
        int[] quickSortNumbers = new int[1500];
        
        try
        {
            Scanner inScan = new Scanner(file);
            int counter = 0;
            while(inScan.hasNext())
            {
                int temp = inScan.nextInt();
                quickSortNumbers[counter] = temp;
                counter++;
            }
        }catch(Exception e)
        {
            System.err.print(e.toString());
        }
        return quickSortNumbers;
    }

    
    
    
    
   public static void main(String [] args)
   {
      	SortBenchMarks sbm = new SortBenchMarks();
   }
}
