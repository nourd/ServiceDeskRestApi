package ee.au.servicedeskrestapi.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ee.au.servicedeskrestapi.model.Document;

@Entity
@Table(name = "tickets")
public class Ticket extends Document {

	@Column(name = "title")
	//@NotEmpty
    private String title;
/*
	@Column(name = "document_number")
	//@NotEmpty
	private String documentNumber;
*/	
	@Column(name = "problem_description")
	//@NotEmpty
    private String problemDescription;
	
	@Column(name = "email")
	//@NotEmpty
    private String email;

	@Column(name = "status")
	//@NotEmpty
    private String status;

    public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
/*
	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
*/	
	public String getProblemDescription() {
		return this.problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
    
    public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}