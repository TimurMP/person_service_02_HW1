package telran.java2022.person.dao;

import org.springframework.data.repository.CrudRepository;

import telran.java2022.person.model.Person;

import java.util.stream.Stream;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Stream<Person> findByAddress_City(String city);

    Stream<Person> findPersonByNameIgnoreCase(String name);

}
