package asanzdiego.jsf.integration.dao;

import java.util.List;

import asanzdiego.jsf.integration.model.Person;


public interface PersonDAO {

    public abstract List<Person> list();

    public abstract void add(Person person);

    public abstract void delete(Person personToDelete);

}