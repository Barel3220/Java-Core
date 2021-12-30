package datingSingles;

public class Female extends Person {
	
	// female attribute
	private String hairColor;

	// female constructor calling super -> person
	public Female(String fullName, String gender, float age, String profession,
			String strongQuality, String preferredGender, float preferredMaxAge,
			String preferredProfession, String preferredQuality, String hairColor) {
		super(fullName, gender, age, profession, strongQuality, preferredGender,
				preferredMaxAge, preferredProfession, preferredQuality);
		this.hairColor = hairColor;
	}

	// female toString
	@Override
	public String toString() {
		return "Female [super=" + super.toString() + ", hairColor=" + hairColor + "]";
	}
}
