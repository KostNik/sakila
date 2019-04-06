package ltd.service.sakila;

import ltd.model.sakila.layers.customerDB.Country;

public interface CountryRepository /*extends CrudRepository<Country, Integer>*/ {


	@SuppressWarnings("unchecked")
	Country save(Country actor);

	Country findByCountryId(Long id);

}
