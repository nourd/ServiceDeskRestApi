package ee.au.servicedeskrestapi.dao;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import ee.au.servicedeskrestapi.model.BaseEntity;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

	@Column(name = "title")
	private String title;
		
	@Column(name = "problem_description")	
    private String problemDescription;
	
	@Column(name = "email")	
    private String email;

	@Column(name = "status")	
	private String status;
	
	@Column(name = "priority")	
	private String priority;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "doc_number")
	private Long documentNumber;

	@Column(name = "document_date")
	private Date documentDate;

	public Long getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(Long documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getDocumentDate() {
		return this.documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

    public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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
	
	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
    public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}