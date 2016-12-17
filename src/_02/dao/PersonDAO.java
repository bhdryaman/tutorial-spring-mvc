package _02.dao;

import java.util.List;

import _02.domain.Person;

public interface PersonDAO {

	public void insertPerson(Person person);
	public Person getPersonById(int id);
	public List<Person> getAllPersons();
	public void updatePerson(Person person);
	public void deletePerson(int id);

}
