package in.ashokit.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DETAILS")
public class ContactEntity  {
	@Id
	@Column(name = "CONTACT_ID")
	@SequenceGenerator(name="cid_seq_gen",sequenceName ="CONTACT_ID_SEQ",allocationSize = 1)
	@GeneratedValue(generator="cid_seq_gen" ,strategy=GenerationType.SEQUENCE)
	private Integer contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", updatable = false)
	private Date createdDate;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE",insertable = false)
	private Date updatedDate;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String conctEmail) {
		this.contactEmail = conctEmail;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	}
