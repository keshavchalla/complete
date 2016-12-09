package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.model.Person;
import hello.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("savePerson/{name}/{age}")
	public ResponseEntity<?> savePerson(@PathVariable("name") String name,@PathVariable("age") int age){
		personService.savePerson(name, age);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping("getAllPersons")                 
	public ResponseEntity<?> getAllPerson(){
		List<Person> personList = personService.getAllPersons();
		return new ResponseEntity<List<Person>>(personList,HttpStatus.OK);
	}
}
