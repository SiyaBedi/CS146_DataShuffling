package cs146F19.Bedi.project1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class DataTest {

	@Test
	public void test() throws IOException{
		
		BufferedReader in = new BufferedReader(new FileReader("Target2.txt"));
		BufferedReader out = new BufferedReader(new FileReader("BediSiyaShuffled.txt")); 
		String expectedLine = "";
		while((expectedLine = in.readLine()) != null) {
			String actualLine = out.readLine();
			assertEquals(expectedLine, actualLine);
			
		}
		in.close();
		out.close();
	}

}
