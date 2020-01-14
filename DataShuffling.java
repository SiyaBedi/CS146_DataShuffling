package cs146F19.Bedi.project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class DataShuffling {

	public static void main(String[] args) {

		//new arraylist to store all the lines of the file
		ArrayList<String> arr = new ArrayList<>(); 

		//start counting time for reading the file
		long start = System.currentTimeMillis();

		//read the file
		try {
			FileReader fr = new FileReader("ErdosCA.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String str = br.readLine(); 
			str = br.readLine(); //skip the first line
			
			//add all lines to arraylist until there is nothing to read in file
			while(str != null) {
				arr.add(str);
				str = br.readLine();
			}
			
			//close file
			br.close();
			fr.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		//end counting time to read the file and calculate total time
		long end = System.currentTimeMillis(); 
		long totalTime = end - start; 
		System.out.println("The total time to read the file is " + totalTime + " milliseconds.");

		//start counting time to shuffle the elements
		start = System.currentTimeMillis();
		
		
		int n = arr.size();
		Random rand = new Random();
		rand.setSeed(20);
		String key;

		//shuffle elements starting from the end of the file
		for(int i = n - 1; i > 0; i--) {
			int j = rand.nextInt(i);
			key = arr.get(i);
			arr.set(i, arr.get(j));
			arr.set(j, key);

		}
		
		//end counting time and calculate total time taken for shuffling elements
		end = System.currentTimeMillis();
		totalTime = end - start;
		System.out.println("The total time to shuffle the elements in the file is " + totalTime + " milliseconds.");

		//start counting time taken to create output file
		start = System.currentTimeMillis();
		
		//produce output file
		try {
			//create new file
			BufferedWriter out = null;
			out = new BufferedWriter(new FileWriter("BediSiyaShuffled.txt"));
			
			//print all lines into the new created file
			for(int i = 0; i < n; i++) {
				out.write(arr.get(i));
				out.newLine();
			} 
			
			//close new file
			out.close();

		}
		catch (Exception e) {
			System.out.println(e.getMessage());


		}
		
		//end counting time and calculate total time take for producing the new file
		end = System.currentTimeMillis();
		totalTime = end - start;
		System.out.println("The total time to create an output file is " + totalTime + " milliseconds.");


	}
}
