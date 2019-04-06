package ltd.model.sakila.layers.businessDB;

import ltd.model.sakila.layers.customerDB.Customer;
import ltd.model.sakila.layers.movieDB.Inventory;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "\"rental\"")
public class Rental {

	private Long      rentalId;
	private Date      rentalDate;
	private Inventory inventory;
	private Customer  customer;
	private Date      returnDate;
	private Staff     staff;
	private Date      lastUpdate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RENTAL_ID")
	public Long getRentalId() {
		return rentalId;
	}

	public void setRentalId(Long rentalId) {
		this.rentalId = rentalId;
	}

	@Column(name = "RENTAL_DATE")
	@Temporal(value = TemporalType.DATE)
	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	@ManyToOne
	@JoinColumn(name = "INVENTORY_ID")
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "RETURN_DATE")
	@Temporal(value = TemporalType.DATE)
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@ManyToOne
	@JoinColumn(name = "STAFF_ID")
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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
		return "Rental [rentalId=" + rentalId + ", rentalDate=" + rentalDate + ", inventory=" + inventory
				+ ", customer=" + customer + ", returnDate=" + returnDate + ", staff=" + staff + ", lastUpdate="
				+ lastUpdate + "]";
	}

}
