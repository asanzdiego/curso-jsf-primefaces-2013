package asanzdiego.jsf.integration.dao.impl2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import asanzdiego.jsf.integration.dao.PersonDAO;
import asanzdiego.jsf.integration.model.Person;


@Repository
public class PersonDAOImpl implements PersonDAO {

    private static final List<Person> persons = new ArrayList<Person>();
    static {
        PersonDAOImpl.persons.add(new Person("Jesus", 4));
        PersonDAOImpl.persons.add(new Person("Juan Pedro", 2));
        PersonDAOImpl.persons.add(new Person("Andriy", 34));
    }

    public List<Person> list() {

        return PersonDAOImpl.persons;
    }

    public void add(final Person person) {

        PersonDAOImpl.persons.add(person);
    }

    public void delete(final Person personToDelete) {

        PersonDAOImpl.persons.remove(personToDelete);
    }

}
