package _02.domain;

public class Job {
	
	private Integer Id;
	private String type;
	private String company;
	private String location;
	private String position;
	private String description;
	private Integer isPublic;
	
	public Job() { }

	public Job(Integer id, String company, String location) {
		super();
		Id = id;
		this.company = company;
		this.location = location;
	}

	public Integer getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer isPublic() {
		return isPublic;
	}
	public void setPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

}
