package club.qh.web.dto;

public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
    private String company;
    private String blog;
    private String location;
    
    
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvaterUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}	
  
}
