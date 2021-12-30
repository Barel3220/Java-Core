package movies;

public class Movie {
	private String title;
	private String posterPath;
	private float rating;
	
	public Movie(String title, String posterPath, float rating) {
		super();
		this.title = title;
		this.posterPath = posterPath;
		this.rating = rating;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPosterPath() {
		return posterPath;
	}
	
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", posterPath=" + posterPath + ", rating=" + rating + "]";
	}
}
