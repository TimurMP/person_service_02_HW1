package telran.java2022.person.dao;

import org.springframework.data.repository.CrudRepository;
import telran.java2022.person.model.Person;

import java.time.LocalDate;
import java.util.stream.Stream;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Stream<Person> findByAddress_City(String city);

    Stream<Person> findPersonByNameIgnoreCase(String name);

//    @Query(value = "from Person  where Person.birthDate BETWEEN :startDate AND :endDate")
//    Stream<Person> findPersonByBirthDate_YearIsBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    Stream<Person> findAllByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    Stream<Person> getAllBy();
    Long countByAddress_City(String city);





}
