package datingSingles;

public class Male extends Person {
	
	// male attribute
	private String height;

	// male constructor calling super -> person
	public Male(String fullName, String gender, float age, String profession,
			String strongQuality, String preferredGender, float preferredMaxAge,
			String preferredProfession, String preferredQuality, String height) {
		super(fullName, gender, age, profession, strongQuality, preferredGender,
				preferredMaxAge, preferredProfession, preferredQuality);
		this.height = height;
	}
	
	// male toString
	@Override
	public String toString() {
		return "Male [super=" + super.toString() + ", height=" + height + "]";
	}
}
