package ltd.service.sakila;

import java.util.List;

import ltd.model.sakila.layers.customerDB.Address;

public interface AddressService {

	Address findById(Integer id);

	List<Address> findAll();

	Address save(Address adress);

	Address delete(Address adress);

	void deleteById(Integer id);

}
