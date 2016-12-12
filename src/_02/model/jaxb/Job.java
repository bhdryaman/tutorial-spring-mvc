package _02.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "job")
public class Job {
	
	private Integer id;
	private String type;
	private String company;
	private String location;
	private String position;
	private String description;
	private Boolean isPublic;
	
	// com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationsException
	public Job() { }

	public Job(Integer id, String company, String location) {
		super();
		this.id = id;
		this.company = company;
		this.location = location;
	}

	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@XmlElement
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
