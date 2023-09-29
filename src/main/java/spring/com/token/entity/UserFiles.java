package spring.com.token.entity;

public class UserFiles {

	private Integer fileId;
	private String fileName;
	private String fileDate;
	private String fileComments;
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public String getFileComments() {
		return fileComments;
	}
	public void setFileComments(String fileComments) {
		this.fileComments = fileComments;
	}
	@Override
	public String toString() {
		return "UserFiles [fileId=" + fileId + ", fileName=" + fileName + ", fileDate=" + fileDate + ", fileComments="
				+ fileComments + "]";
	}
	
	
}
