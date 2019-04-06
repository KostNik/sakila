package ltd.service.sakila;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ltd.model.sakila.layers.customerDB.Address;

//@Repository
//@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Address findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findAll() {
		return entityManager.createNamedQuery("Address.findAllByPage", Address.class).getResultList();
	}

	@Override
	public Address save(Address adress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address delete(Address adress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
