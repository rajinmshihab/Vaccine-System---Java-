//Class of people
public class People {

	//Concepts of encapsulation has been used here
	private String firstname;
	private String lastname;
	private String DOB;
	private String CNIC;
	private String city;
	private String age;
	private String gender;
	private String key;
	private String type;
	
	
	
	// Getters and setters
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	private boolean appointmentSet;
	private boolean vaccinated;
	
	public boolean isAppointmentSet() {
		return appointmentSet;
	}

	public void setAppointmentSet(boolean appointmentSet) {
		this.appointmentSet = appointmentSet;
	}

	public boolean isVaccinated() {
		return vaccinated;
	}

	public void setVaccinated(boolean vaccinated) {
		this.vaccinated = vaccinated;
	}

	// Constructor

	public People(String firstname, String lastname, String dOB, String cNIC, String city, String age, String gender, boolean appointmentSet, boolean vaccinated, String key, String type) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.DOB = dOB;
		this.CNIC = cNIC;
		this.city = city;
		this.age = age;
		this.gender = gender;
		this.appointmentSet= appointmentSet;
		this.vaccinated = vaccinated;
		this.key = key;
		this.type = type;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getCNIC() {
		return CNIC;
	}

	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	//To-string representation and Override methods
	
	@Override
	public String toString() {
		return "People [firstname=" + firstname + ", lastname=" + lastname + ", DOB=" + DOB + ", CNIC=" + CNIC
				+ ", city=" + city + ", age=" + age + ", gender=" + gender + ", key=" + key + ", appointmentSet="
				+ appointmentSet + ", vaccinated=" + vaccinated + "]";
	}
	
	
	
	
}
