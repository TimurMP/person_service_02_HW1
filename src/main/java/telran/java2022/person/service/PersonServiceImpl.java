package telran.java2022.person.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java2022.person.dao.PersonRepository;
import telran.java2022.person.dto.AddressDto;
import telran.java2022.person.dto.CityPopulationDto;
import telran.java2022.person.dto.PersonDto;
import telran.java2022.person.dto.PersonNotFoundException;
import telran.java2022.person.model.Address;
import telran.java2022.person.model.Person;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
	
	final PersonRepository personRepository;
	final ModelMapper modelMapper;

	@Override
	public Boolean addPerson(PersonDto personDto) {
		personRepository.save(modelMapper.map(personDto, Person.class));
		return true;
	}

	@Override
	public PersonDto findPersonById(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public PersonDto removePerson(Integer id) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
		personRepository.delete(person);
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public PersonDto updatePersonName(Integer id, String name) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
		person.setName(name);
		personRepository.save(person);
		return modelMapper.map(person, PersonDto.class);
	}

	@Override
	public PersonDto updatePersonAddress(Integer id, AddressDto addressDto) {
		Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
		Address address = modelMapper.map(addressDto, Address.class);
		person.setAddress(address);
		personRepository.save(person);
		return modelMapper.map(person, PersonDto.class);

	}

	@Override
	@Transactional
	public Iterable<PersonDto> findPersonsByCity(String city) {
		return personRepository.findByAddress_City(city)
				.map(person -> modelMapper.map(person, PersonDto.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public Iterable<PersonDto> findPersonsByName(String name) {
		return personRepository.findPersonByNameIgnoreCase(name)
				.map(person -> modelMapper.map(person, PersonDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public Iterable<PersonDto> findPersonsBetweenAge(Integer minAge, Integer maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CityPopulationDto> getCitiesPopulation() {
		// TODO Auto-generated method stub
		return null;
	}

}
