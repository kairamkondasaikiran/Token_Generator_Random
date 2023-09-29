package spring.com.token.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FileData")
public class FileData {

	@Id
	private String id;
	private ArrayList<String> fileData;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<String> getFileData() {
		return fileData;
	}
	public void setFileData(ArrayList<String> fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "FileData [id=" + id + ", fileData=" + fileData + "]";
	}
	
	
}
