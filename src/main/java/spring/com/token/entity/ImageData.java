package spring.com.token.entity;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "ImageData")
public class ImageData {

	@Id
	private Long id;
	private String name;
	private String fileType;
	private Byte[] imageData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public Byte[] getImageData() {
		return imageData;
	}
	public void setImageData(Byte[] imageData) {
		this.imageData = imageData;
	}
	@Override
	public String toString() {
		return "ImageData [id=" + id + ", name=" + name + ", fileType=" + fileType + ", imageData="
				+ Arrays.toString(imageData) + "]";
	}
	
	
}
