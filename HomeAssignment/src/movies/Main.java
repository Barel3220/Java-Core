package movies;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	// creating connection instance
	private static HttpURLConnection connection;
	// creating array list for comparing rating at the end
	private static ArrayList<Movie> allMovies = new ArrayList<Movie>();

	public static void main(String[] args) {
		// creating a scanner for user input
		Scanner userScanner = new Scanner(System.in);
		// creating a reader for the connection answer
		BufferedReader reader;
		// for each line in reader
		String line;
		// full string which contains the results
		StringBuffer responseContent = new StringBuffer();
		// creating a null Movie entity
		Movie tempMovie = null;

		while (true) {
			System.out.println("Please enter an imdb_id: ");
			// getting the user next ID
			String imdbID = userScanner.nextLine();

			// checking if the user wants to end the session
			if (imdbID.startsWith("0")) {
				// using new Main().<methodName> because there is no reason to make it static
				Movie temp = new Main().getMostRatedMovie();
				System.out.println(
						"Most Rated Movie is: " + temp.getTitle() + "\nWith the rating of: " + temp.getRating());
				return;
			}

			try {
				// creating a new URL, exception in case of illegal URL
				URL url = new URL(
						"https://api.themoviedb.org/3/movie/" + imdbID + "?api_key=1cbc42575b2509ab308f247ff6d10958");

				// open connection
				connection = (HttpURLConnection) url.openConnection();

				// setting the connection properties
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);

				// response status code
				int status = connection.getResponseCode();

				if (status > 299) {
					reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
					// in case of bad status, print error and retry
					System.out.println("The resource you requested could not be found.");
				} else {
					reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					// collecting the answer and closing the reader at the end
					while ((line = reader.readLine()) != null)
						responseContent.append(line);
					reader.close();

					// extracting the entities for each movie
					// using new Main().<methodName> because there is no reason to make it static
					String posterPath = new Main().getStringFromJsonString(responseContent.toString(),
							"poster_path\":\"");
					String title = new Main().getStringFromJsonString(responseContent.toString(), "title\":\"");
					float rating = Float.parseFloat(
							new Main().getStringFromJsonString(responseContent.toString(), "vote_average\":"));

					// printing the title of the movie as requested
					System.out.println(title);
					// creating a movie entity and adding it to a list
					tempMovie = new Movie(title, posterPath, rating);
					allMovies.add(tempMovie);

					// create temp folder if not exists
					new File("C:/temp").mkdirs();
					// try to save the poster at C:/temp
					try (InputStream in = new URL("https://image.tmdb.org/t/p/w500" + posterPath).openStream()) {
						Files.copy(in, Paths.get("C:/temp/"
								+ title.replaceAll("[^a-zA-Z0-9]", " ").trim().replaceAll(" +", " ") + ".jpg"));
					}
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid URL, please try again");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				userScanner.close();
				e.printStackTrace();
			} finally {
				// at the end close the connection
				connection.disconnect();
			}
		}
	}

	private Movie getMostRatedMovie() {
		// returning the max rating from all searched movies
		return allMovies.stream().max(Comparator.comparing(Movie::getRating)).get();
	}

	// extracting the relevant data from the response
	private String getStringFromJsonString(String fullString, String stringToSearch) {
		int beginIndexOfPoster = fullString.toString().lastIndexOf(stringToSearch) + stringToSearch.length();
		String partialString = fullString.toString().substring(beginIndexOfPoster);
		int endIndexOfPoster = 0;
		// in case we're looking for the ratings, we need to search text without " at
		// the end
		if (Character.isDigit(partialString.charAt(0)))
			endIndexOfPoster = beginIndexOfPoster + partialString.indexOf(",");
		else
			endIndexOfPoster = beginIndexOfPoster + partialString.indexOf("\",");

		return fullString.toString().substring(beginIndexOfPoster, endIndexOfPoster);
	}

}
