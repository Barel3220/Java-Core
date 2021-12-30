package movies;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner userScanner = new Scanner(System.in);

		while (true) {
			System.out.println("Please enter an imdb_id: ");
			// getting the user next ID
			String imdbID = userScanner.nextLine();

			// checking if the user wants to end the session
			if (imdbID.contains("0"))
				return;
		}
	}
}
