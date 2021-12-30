package datingSingles;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.stream.Collectors;

public class Main {
	// create Array for all persons
	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	private static ArrayList<Matches> mixAndMatchAllPersons = new ArrayList<Matches>();

	public static void main(String[] args) {
		try {
			// read the data of people
			File peopleFile = new File(System.getProperty("user.dir") + "/src/datingSingles/people.txt");
			// create a scanner using file source
			Scanner fileScanner = new Scanner(peopleFile);
			// create a null Person for using after
			Person person = null;

			
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
			
			// calling the method mix&match which calls scoreMatch 
			new Main().MixAndMatch();
			// getting sorted list
			new Main().SortMatches().forEach(sortedMatch -> {
				System.out.println(sortedMatch);
			});
			
			fileScanner.close();
				
			// exception in case file not found
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void MixAndMatch() {
		// creating pairs for all persons
		for (int i = 0; i < allPersons.size(); i++) 
			for (int j = i + 1; j < allPersons.size(); j++)
				if (allPersons.get(i).getPreferredGender().contains(allPersons.get(j).getGender()))
					mixAndMatchAllPersons.add(new Matches(allPersons.get(i), allPersons.get(j)));
		
		// setting scores for each match
		ScoreMatches();
	}
	
	private void ScoreMatches() {
		mixAndMatchAllPersons.forEach(match -> {
			// zeroing counter for scoring
			int counter = 0;
			// checking for each match the preferred points
			if (match.getFirstPerson().getAge() <= match.getSecondPerson().getPreferredMaxAge() &&
					match.getSecondPerson().getAge() <= match.getFirstPerson().getPreferredMaxAge()) 
				match.setScore(++counter);			
			if (match.getFirstPerson().getStrongQuality().contains(match.getSecondPerson().getPreferredQuality()))
				match.setScore(++counter);
			if (match.getFirstPerson().getProfession().contains(match.getSecondPerson().getPreferredProfession()))
				match.setScore(++counter);
		});
	}
	
	private List<Matches> SortMatches() {
		// returning sorted list for matches
		return mixAndMatchAllPersons.stream()
				.sorted(Comparator.comparing(Matches::getScore).reversed())
				.collect(Collectors.toList());
	}
}
