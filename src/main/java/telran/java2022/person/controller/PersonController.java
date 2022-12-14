package telran.java2022.person.controller;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import telran.java2022.person.dto.AddressDto;
import telran.java2022.person.dto.CityPopulationDto;
import telran.java2022.person.dto.PersonDto;
import telran.java2022.person.service.PersonService;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
	
	final PersonService personService;
	
	@PostMapping
	public Boolean addPerson(@RequestBody PersonDto personDto) {
		return personService.addPerson(personDto);
	}
	
	@GetMapping("/{id}")
	public PersonDto findPerson(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}


	@DeleteMapping("/{id}")
	public PersonDto removePerson(@PathVariable Integer id){
		return personService.removePerson(id);
	}

	@PutMapping("/{id}/name/{name}")
	public PersonDto UpdatePersonName(@PathVariable Integer id, @PathVariable String name){
		return personService.updatePersonName(id, name);
	}

	@PutMapping("/{id}/address")
	public PersonDto UpdatePersonAddress(@PathVariable Integer id, @RequestBody AddressDto address){
		return personService.updatePersonAddress(id, address);
	}

	@GetMapping("/city/{city}")
	public Iterable <PersonDto> findPersonByCity(@PathVariable String city){
		return personService.findPersonsByCity(city);
	}

	@GetMapping("/name/{name}")
	public Iterable <PersonDto> findPersonByName(@PathVariable String name){
		return personService.findPersonsByName(name);
	}

	@GetMapping("/ages/{minAge}/{maxAge}")
	public Iterable<PersonDto> findPersonsBetweenAge(@PathVariable Integer minAge,@PathVariable Integer maxAge) {
		return personService.findPersonsBetweenAge(minAge, maxAge);
	}

	@GetMapping("/population/city")
	public Iterable<CityPopulationDto> getCitiesPopulation() {
		return personService.getCitiesPopulation();
	}



}
