package ee.au.servicedeskrestapi.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;


@MappedSuperclass
public class Document extends BaseEntity {

	@Column(name = "document_number")
	//@NotEmpty
	private String documentNumber;

	//@Column(name = "document_date")
	//@NotEmpty
	//@JsonFormat
    //  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	//private Date documentDate;

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
/*
	public @NotEmpty Date getDocumentDate() {
		return this.documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}
*/
}