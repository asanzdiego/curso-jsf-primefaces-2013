package asanzdiego.jsf.integration.service;

import java.util.List;

import asanzdiego.jsf.integration.model.Person;


public interface PersonService {

    public abstract List<Person> list();

    public abstract void add(Person person);

    public abstract void delete(Person personToDelete);

}