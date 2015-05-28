package asanzdiego.jsf.integration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asanzdiego.jsf.integration.dao.PersonDAO;
import asanzdiego.jsf.integration.model.Person;
import asanzdiego.jsf.integration.service.PersonService;


@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(final PersonDAO personDAO) {

        this.personDAO = personDAO;
    }

    public List<Person> list() {

        return this.personDAO.list();
    }

    public void add(final Person person) {

        this.personDAO.add(person);
    }

    public void delete(final Person personToDelete) {

        this.personDAO.delete(personToDelete);
    }

}
