package ee.au.servicedeskrestapi.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import ee.au.servicedeskrestapi.model.*;


@Entity
@Table(name = "tickets")
public class Ticket extends Document {

	@Column(name = "title")
	@NotEmpty
    private String title;

	@Column(name = "document_number")
	@NotEmpty
	private String documentNumber;
	
	@Column(name = "problem_description")
	@NotEmpty
    private String problemDescription;
	
	@Column(name = "email")
	@NotEmpty
    private String email;

    @Column(name = "status_id")
	//@NotEmpty
    private Integer statusId;

    public String getTitle() {
		return this.title;
	}

	public String getDocumentNumber() {
		return this.documentNumber;
	}

	public String getProblemDescription() {
		return this.problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
    public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ticket_priorities", joinColumns = @JoinColumn(name = "ticket_id"),
			inverseJoinColumns = @JoinColumn(name = "priority_id"))
	private Set<Priority> priorities;

	protected Set<Priority> getPrioritiesInternal() {
		if (this.priorities == null) {
			this.priorities = new HashSet<>();
		}
		return this.priorities;
	}

	protected void setPrioritiesInternal(Set<Priority> priorities) {
		this.priorities = priorities;
	}

	@XmlElement
	public List<Priority> getPriorities() {
		List<Priority> sortedPriorities = new ArrayList<>(getPrioritiesInternal());
		PropertyComparator.sort(sortedPriorities, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedPriorities);
	}

	public int getNrOfPriorities() {
		return getPrioritiesInternal().size();
	}

	public void addPriority(Priority priority) {
		getPrioritiesInternal().add(priority);
	}

}