package datingSingles;

public class Person {
	// person attributes
	private String fullName;
	private String gender;
	private float age;
	private String profession;
	private String strongQuality;
	private String preferredGender;
	private float preferredMaxAge;
	private String preferredProfession;
	private String preferredQuality;
	
	
	// person constructor
	public Person(String fullName, String gender, float age, String profession, String strongQuality,
			String preferredGender, float preferredMaxAge, String preferredProfession, String preferredQuality) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
		this.profession = profession;
		this.strongQuality = strongQuality;
		this.preferredGender = preferredGender;
		this.preferredMaxAge = preferredMaxAge;
		this.preferredProfession = preferredProfession;
		this.preferredQuality = preferredQuality;
	}

	
	// person toString
	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", gender=" + gender + ", age=" + age + ", profession=" + profession
				+ ", strongQuality=" + strongQuality + ", preferredGender=" + preferredGender + ", preferredMaxAge="
				+ preferredMaxAge + ", preferredProfession=" + preferredProfession + ", preferredQuality="
				+ preferredQuality + "]";
	}
}
