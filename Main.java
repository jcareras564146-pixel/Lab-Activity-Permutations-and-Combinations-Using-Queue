package pack;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {

	 static Scanner input = new Scanner(System.in);

	    // Queue implementation
	    static Queue<String> queue = new LinkedList<>();

	    public static void main(String[] args) {

	        int choice;

	        do {
	            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
	            System.out.println("[1] Add Elements to Queue");
	            System.out.println("[2] Display Queue");
	            System.out.println("[3] Generate Permutations");
	            System.out.println("[4] Generate Combinations");
	            System.out.println("[5] Exit");
	            System.out.print("Enter choice: ");
	            
	            choice = input.nextInt();

	            switch (choice) {

	                case 1:
	                    addElements();
	                    break;

	                case 2:
	                    displayQueue();
	                    break;

	                case 3:
	                    generatePermutations();
	                    break;

	                case 4:
	                    generateCombinations();
	                    break;

	                case 5:
	                    System.out.println("Program terminated.");
	                    break;

	                default:
	                    System.out.println("Invalid choice!");
	            }

	        } while (choice != 5);
	    }

	    // TODO 1: Accept elements and add them to the Queue
	    static void addElements() {
	    	Scanner scanner = new Scanner(System.in);
	    	
	    	System.out.print("Enter number of elements to select: ");
	    	int count = scanner.nextInt();
	    	scanner.nextLine();
	    	
	    	System.out.println("Enter " + count + " elements");
	    	for(int i = 0; i < count; i++) {
	    		System.out.print("Element " + (i + 1) + ": ");
	    		String element = scanner.nextLine();
	    		
	    		queue.add(element);
	    		
	    	}
	    	System.out.println();
	    	System.out.println("Elements successfully added to the queue");
	    }
	    
	    	

	    // TODO 2: Display all elements in the Queue
        // Display the contents of the Queue

	    static void displayQueue() {
	    	
	    	if (queue.isEmpty()) {
	    		System.out.println("The queue is empty");
	    		return;
	    	}
	    	
	    	System.out.println("\n Current Queue elements First in, First Out");
	    	for(String elements : queue) {
	    		System.out.println("- " + elements);
	    	}


	    }

	 // TODO 3: Generate all possible permutations
	    static void generatePermutations() {
	        List<String> elements = new ArrayList<>(queue);
	        int n = elements.size();

	        System.out.println(); 

	        int[] totalCount = {0}; 
	        boolean[] used = new boolean[n];
	        
	        backtrackPermutations(elements, n, "", used, totalCount);

	        System.out.println("\nTotal Permutations: " + totalCount[0]);
	    }

	    private static void backtrackPermutations(List<String> elements, int totalSize, String current, boolean[] used, int[] totalCount) {
	        if (current.length() == totalSize) {
	            System.out.println(current);
	            totalCount[0]++;
	            return;
	        }

	        for (int i = 0; i < elements.size(); i++) {
	            if (used[i]) continue;

	            used[i] = true;
	            backtrackPermutations(elements, totalSize, current + elements.get(i), used, totalCount);
	            used[i] = false; 
	        }
	    }
	    // TODO 4: Generate all possible combinations
	    static void generateCombinations() {
	    	
	    	Scanner scanner = new Scanner(System.in);
	    	List<String> elements = new ArrayList<>(queue);
	    	
	    	System.out.print("Enter number of elements to combine");
	    	int r = scanner.nextInt();
	    	System.out.println();
	    	
	    	int [] totalCount = {0};
	    	
	    	backtrackCombinations(elements, r, 0, "", totalCount);
	    	
	    	System.out.println("\nTotal Combinations: " + totalCount);
	    	

	        // Ask how many elements should be selected (r)
	        // Generate all possible selections
	        // Avoid duplicate combinations
	        // Display the total number of combinations
	    }
	    
	    private static void backtrackCombinations(List<String> elements, int r, int startIndex, String current, int[] totalCount) {
	    	if (current.length() == r) {
	    		System.out.println(current);
	    		totalCount[0]++;
	    		return;
	    	}
	    	
	    	for(int i = startIndex; i < elements.size(); i++) {
	    		backtrackCombinations(elements, r, i + 1, current + elements.get(i), totalCount);
	    	}
	    }
}
