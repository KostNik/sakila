package ltd.model.sakila.layers.customerDB;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "\"address\"")
@NamedQueries({ @NamedQuery(name = "Address.findAllByPage", query = "select a FROM Address a") })
public class Address {

	private Long addressId;
	private String adress;
	private City city;
	private String adress2;
	private String district;
	private Integer postalCode;
	private String phone;
	private byte[] location;
	private Date lastUpdate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDRESS_ID")
	public Long getAdressId() {
		return addressId;
	}

	public void setAdressId(Long adressId) {
		this.addressId = adressId;
	}

	@Column(name = "ADDRESS")
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@JoinColumn(name = "CITY_ID")
	@ManyToOne(fetch = FetchType.EAGER)
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "ADDRESS2")
	public String getAdress2() {
		return adress2;
	}

	public void setAdress2(String adress2) {
		this.adress2 = adress2;
	}

	@Column(name = "DISTRICT")
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "POSTAL_CODE")
	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "LOCATION")
//	@Basic(fetch = FetchType.LAZY)
	@Lob
	public byte[] getLocation() {
		return location;
	}

	public void setLocation(byte[] location) {
		this.location = location;
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
		return "Adress [adressId=" + addressId + ", adress=" + adress + ", city=" + city + ", adress2=" + adress2
				+ ", district=" + district + ", postalCode=" + postalCode + ", phone=" + phone + ", location="
				+ Arrays.toString(location) + ", lastUpdate=" + lastUpdate + "]";
	}

}
