package spring.com.token.entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "DocumentUpload")
public class DocumentUploadEntity {

    @Id
    @Field
    private String id;

    @Field
    private String emailId;

    @Field
    private String docType;

    @Field
    private Binary file;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public Binary getFile() {
		return file;
	}

	public void setFile(Binary file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "DocumentUploadEntity [id=" + id + ", emailId=" + emailId + ", docType=" + docType + ", file=" + file
				+ "]";
	}
    
    
}
