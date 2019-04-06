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
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name = "\"country\"", schema = "sakila")
@NamedQueries({ @NamedQuery(name = "Country.findAllByPage", query = "select c FROM Country c"),
		@NamedQuery(name = "Country.findByCountryName", query = "select a FROM Country a WHERE a.country = :country") })
public class Country {

	private Long countryId;
	private String country;
	private Date lastUpdate;
	private Set<City> cities;

	public Country() {
		cities = new HashSet<>();
	}

	@Id
	@Column(name = "COUNTRY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
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

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "city", joinColumns = @JoinColumn(name = "COUNTRY_ID"), inverseJoinColumns = @JoinColumn(name = "CITY_ID"))
	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", country=" + country + ", lastUpdate=" + lastUpdate + "]";
	}

}
