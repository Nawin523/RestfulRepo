package com.rngs.restful.resource.service;

import java.util.ArrayList;
import java.util.List;

import com.rngs.restful.resource.model.Person;

public class PersonService {
	List<Person> list = new ArrayList<Person>();
 	
	public List<Person> getAllPeresons(){
	Person preson1 = new Person("Naveen",29,1);
	Person preson2 = new Person("VAsudha",24,2);
	list.add(preson1);
	list.add(preson2);
	return list;
	}
	
	public String addPerson(Person p) {
		list.add(p);
		return "Success";
	}

}
