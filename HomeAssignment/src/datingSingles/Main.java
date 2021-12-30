package datingSingles;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {

	public static void main(String[] args) {
		try {
			// read the data of people
			File peopleFile = new File("C:\\Users\\barel\\Desktop\\people.txt");
			// create a scanner using file source
			Scanner fileScanner = new Scanner(peopleFile);
			// create a null Person for using after
			Person person = null;
			// create Array for all persons
			ArrayList<Person> allPersons = new ArrayList<Person>();
			
			// while loop for reading all lines
			while(fileScanner.hasNextLine()) {
				// getting the line
				String line = fileScanner.nextLine();
				// separating all attributes by splitting the line string 
				String[] data = line.split(",");
				
				// checking if male or female to create the correct one
				if (data[1].contains("Male"))
					person = new Male(data[0], data[1], Float.parseFloat(data[2]), data[3], data[4], data[5],
							Float.parseFloat(data[6]), data[7], data[8], data[9]);
				else if (data[1].contains("Female"))
					person = new Female(data[0], data[1], Float.parseFloat(data[2]), data[3], data[4], data[5],
							Float.parseFloat(data[6]), data[7], data[8], data[9]);
				
				// adding the person from file to the list
				allPersons.add(person);
			}
			
			// printing
			allPersons.forEach(pers -> {
				System.out.println(pers);
			});
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
