package ltd.model.sakila.layers.businessDB;

import ltd.model.sakila.layers.customerDB.Address;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "\"staff\"")
public class Staff {

	private Long    staffId;
	private String  firstName;
	private String  lastName;
	private Address address;
	private byte[]  picture;
	private String  email;
	private Store   store;
	private int     active;
	private String  username;
	private String  password;
	private Date    lastUpdate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAFF_ID")
	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToOne
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "PICTURE")
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(targetEntity = Store.class, mappedBy = "staff")
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Column(name = "ACTIVE")
	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "LAST_UPDATE")
	@Temporal(value = TemporalType.DATE)
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
