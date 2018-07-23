package com.uppi.poc;
import java.util.List;

import org.springframework.data.repository.*;

public interface PersonRepository extends CrudRepository<Person, String>{
	List<Person> findByName(String lastname);
	List<Person> findByStatus(String status);
	
}
