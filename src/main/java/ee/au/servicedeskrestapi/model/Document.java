package ee.au.servicedeskrestapi.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;


@MappedSuperclass
public class Document extends BaseEntity {

	@Column(name = "document_number")
	@NotEmpty
	private String documentNumber;

	@Column(name = "document_date")
	@NotEmpty
	private LocalDate documentDate;

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public @NotEmpty LocalDate getDocumentDate() {
		return this.documentDate;
	}

	public void setDocumentDate(LocalDate localDate) {
		this.documentDate = localDate;
	}

}