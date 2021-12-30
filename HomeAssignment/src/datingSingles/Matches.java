package datingSingles;

public class Matches {
	
	// Matched attributes
	// keeping the full person for easier scoring
	private Person firstPerson;
	private Person secondPerson;
	private int score;
	
	public Matches(Person firstPerson, Person secondPerson) {
		super();
		this.firstPerson = firstPerson;
		this.secondPerson = secondPerson;
	}

	public Person getFirstPerson() {
		return firstPerson;
	}

	public void setFirstPerson(Person firstPerson) {
		this.firstPerson = firstPerson;
	}

	public Person getSecondPerson() {
		return secondPerson;
	}

	public void setSecondPerson(Person secondPerson) {
		this.secondPerson = secondPerson;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Matches [firstPerson=" + firstPerson.getFullName() + ", secondPerson=" + secondPerson.getFullName() + ", score=" + score + "]";
	}	
}
