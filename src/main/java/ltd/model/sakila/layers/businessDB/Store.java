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
//@Table(name = "\"store\"")
public class Store {

	private Long    storeId;
	private Staff   staff;
	private Address address;
	private Date    lastUpdate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STORE_ID")
	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	@OneToOne
	@JoinColumn(name = "STAFF_ID")
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@OneToOne
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "LAST_UPDATE")
	@Temporal(value = TemporalType.DATE)
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", staff=" + staff + ", address=" + address + ", lastUpdate=" + lastUpdate
				+ "]";
	}

}
