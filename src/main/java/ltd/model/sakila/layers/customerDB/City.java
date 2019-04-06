package ltd.model.sakila.layers.customerDB;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "\"city\"", schema = "sakila")
public class City {

	private Long cityId;
	private String city;
	private Country country;
	private Date lastUpdate;

	private Set<Address> adresses;

	public City() {
		setAddresses(new HashSet<>());
	}

	@Id
	@Column(name = "CITY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Temporal(value = TemporalType.DATE)
	@Column(name = "LAST_UPDATE")
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(targetEntity = Address.class, mappedBy = "city", fetch = FetchType.EAGER)
	// @JoinTable(name = "address", joinColumns = @JoinColumn(name = "CITY_ID"),
	// inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID"))
	public Set<Address> getAddresses() {
		return adresses;
	}

	public void setAddresses(Set<Address> adresses) {
		this.adresses = adresses;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", city=" + city + ", country=" + country + ", lastUpdate=" + lastUpdate
				+ "]";
	}

}
