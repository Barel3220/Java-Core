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

	
	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public float getAge() {
		return age;
	}


	public void setAge(float age) {
		this.age = age;
	}


	public String getProfession() {
		return profession;
	}


	public void setProfession(String profession) {
		this.profession = profession;
	}


	public String getStrongQuality() {
		return strongQuality;
	}


	public void setStrongQuality(String strongQuality) {
		this.strongQuality = strongQuality;
	}


	public String getPreferredGender() {
		return preferredGender;
	}


	public void setPreferredGender(String preferredGender) {
		this.preferredGender = preferredGender;
	}


	public float getPreferredMaxAge() {
		return preferredMaxAge;
	}


	public void setPreferredMaxAge(float preferredMaxAge) {
		this.preferredMaxAge = preferredMaxAge;
	}


	public String getPreferredProfession() {
		return preferredProfession;
	}


	public void setPreferredProfession(String preferredProfession) {
		this.preferredProfession = preferredProfession;
	}


	public String getPreferredQuality() {
		return preferredQuality;
	}


	public void setPreferredQuality(String preferredQuality) {
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
