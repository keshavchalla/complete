package hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import hello.model.Person;

@Service
public class PersonService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void savePerson(String name,int age){
		System.out.println("Inside Persion Service");
		Person p = new Person(name,age);
		mongoTemplate.save(p);
		System.out.println("Saved person Successfully");
	}
	
	public List<Person> getAllPersons(){
		List<Person> personList = mongoTemplate.findAll(Person.class);
		return personList;
	}
}
