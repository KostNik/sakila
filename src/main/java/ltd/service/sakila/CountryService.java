package ltd.service.sakila;

import java.util.Date;
import java.util.List;

import ltd.model.sakila.layers.customerDB.Country;

public interface CountryService {

	Country findById(Long id);

	List<Country> findAll();

	Country findByCountryName(String countryName);
	
	List<Country> findByLastUpdateTime(Date lastUpdateTime);

	Country save(Country actor);

	Country delete(Country actor);

	void deleteById(Integer id);

}
