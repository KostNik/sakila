package ltd.model.sakila.layers.businessDB;

import lombok.extern.slf4j.Slf4j;
import ltd.model.sakila.layers.customerDB.Customer;

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
//@Table(name = "\"payment\"")
@Slf4j
public class Payment {

	private Long     paymentId;
	private Customer customer;
	private Staff    staff;
	private Rental   rental;
	private float    amount;
	private Date     paymentDate;
	private Date     lastUpdate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYMENT_ID")
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	@JoinColumn(name = "STAFF_ID")
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne
	@JoinColumn(name = "RENTAL_ID", nullable = true)
	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	@Column(name = "AMOUNT")
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column(name = "PAYMENT_DATE")
	@Temporal(value = TemporalType.DATE)
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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
		return "Payment [paymentId=" + paymentId + ", customer=" + customer + ", staff=" + staff + ", rental=" + rental
				+ ", amount=" + amount + ", paymentDate=" + paymentDate + ", lastUpdate=" + lastUpdate + "]";
	}

}
