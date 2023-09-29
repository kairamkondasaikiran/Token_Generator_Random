package spring.com.token.request;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadRequest {

	private String fileName;
	private String fileId;
	private MultipartFile file;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "FileUploadRequest [fileName=" + fileName + ", fileId=" + fileId + ", file=" + file + "]";
	}
	
	
}
