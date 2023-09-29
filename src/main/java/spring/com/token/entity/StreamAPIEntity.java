package spring.com.token.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StreamAPI")
public class StreamAPIEntity {

	@Id
	private Integer userid;
	private String user;
	private List<UserFiles> userFile;
	private List<Address> userAddress;
	private int fileCount;
	private Long salary;
	private String comments;
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<UserFiles> getUserFile() {
		return userFile;
	}
	public void setUserFile(List<UserFiles> userFile) {
		this.userFile = userFile;
	}
	public List<Address> getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(List<Address> userAddress) {
		this.userAddress = userAddress;
	}
	public int getFileCount() {
		return fileCount;
	}
	public void setFileCount(int fileCount) {
		this.fileCount = fileCount;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "StreamAPIEntity [userid=" + userid + ", user=" + user + ", userFile=" + userFile + ", userAddress="
				+ userAddress + ", fileCount=" + fileCount + ", salary=" + salary + ", comments=" + comments + "]";
	}
	
	
}
