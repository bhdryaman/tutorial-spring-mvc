package _02.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Job {
	
	@Min(10)
	@Max(1000)
	private Integer id;

	private String type;
	private String company;
	private String location;
	private String position;

	@NotBlank
	private String description;
	private Boolean isPublic;
	
	public Job() { }

	public Job(Integer id, String company, String location) {
		super();
		this.id = id;
		this.company = company;
		this.location = location;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	public String toString() {
		return "Job [Id=" + id + ", type=" + type + ", company=" + company + ", location=" + location + ", position="
				+ position + ", description=" + description + ", isPublic=" + isPublic + "]";
	}

}
