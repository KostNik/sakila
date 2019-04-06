package ltd.service.sakila;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ltd.model.sakila.layers.customerDB.Country;

//@Service("countryService")
//@Repository
public class CountryServiceImpl implements CountryService {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CountryRepository countryRepository;

	@Transactional(readOnly = true)
	@Override
	public Country findById(Long id) {
		return countryRepository.findByCountryId(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Country> findAll() {
//		return Lists.newArrayList(countryRepository.findAllByPage());
		return null;
	}

	@Transactional(readOnly = true)
	@Override
	public Country findByCountryName(String countryName) {
		return entityManager.createNamedQuery("Country.findByCountryName", Country.class).getSingleResult();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Country> findByLastUpdateTime(Date lastUpdateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country delete(Country actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
