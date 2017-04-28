package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Person;

@Service
public class PersonService {

	List<Person> persons=new ArrayList<>();
	public PersonService() {
		Person person=new Person();
		person.setId(15);
		person.setName("person1");
		persons.add(person);
		
		Person person2=new Person();
		person2.setId(20);
		person2.setName("person2");
		persons.add(person2);
	}
	
	public List<Person> getAll(){
		return persons;
	}
	
	public Person getById(Integer id){
		if(persons.get(id)!=null){
			return persons.get(id);
		}
		return null;
	}

	public void putFromJson(Person person) {
		persons.add(person);
	}
	
/*	public static void main(String Arg[]){
		System.out.println(new PersonService().getById(0).getName());
		
	}*/
}
