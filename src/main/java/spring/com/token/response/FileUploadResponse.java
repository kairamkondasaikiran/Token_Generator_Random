package spring.com.token.response;


public class FileUploadResponse {

	private String fileName;
	private Long size;
	private String downloadUri;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getDownloadUri() {
		return downloadUri;
	}
	public void setDownloadUri(String downloadUri) {
		this.downloadUri = downloadUri;
	}
	@Override
	public String toString() {
		return "FileUploadResponse [fileName=" + fileName + ", size=" + size + ", downloadUri=" + downloadUri + "]";
	}
	
	
}
