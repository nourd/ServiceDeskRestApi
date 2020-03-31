package ee.au.servicedeskrestapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Document extends BaseEntity {

	@Column(name = "document_number")
	//@NotEmpty
	private String documentNumber;

	@Column(name = "document_date")
	//@NotEmpty
	private Date documentDate;

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getDocumentDate() {
		return this.documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

}