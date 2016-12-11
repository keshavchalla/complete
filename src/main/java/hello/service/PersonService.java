package hello.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import hello.model.Person;

@Service
public class PersonService {
	private final Logger logger = LoggerFactory.getLogger(PersonService.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void savePerson(String name,int age){
		logger.info("Inside save person services with name :"+ name +" age :"+age);
		System.out.println("Inside Persion Service");
		Person p = new Person(name,age);
		mongoTemplate.save(p);
		System.out.println("Saved person Successfully");
	}
	
	public List<Person> getAllPersons(){
		logger.info("Retriveing all persons in mongo db");
		List<Person> personList = mongoTemplate.findAll(Person.class);
		return personList;
	}
}
