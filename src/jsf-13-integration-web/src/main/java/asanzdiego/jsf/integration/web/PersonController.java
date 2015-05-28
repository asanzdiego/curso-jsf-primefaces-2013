/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package asanzdiego.jsf.integration.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asanzdiego.jsf.integration.model.Person;
import asanzdiego.jsf.integration.service.PersonService;


@ManagedBean(name = "personController")
@RequestScoped
@Component
public class PersonController {

    private PersonService personService;

    private final Person person = new Person();

    @Autowired
    public void setPersonService(final PersonService personService) {

        this.personService = personService;
    }

    public Person getPerson() {

        return this.person;
    }

    public List<Person> getPersons() {

        return this.personService.list();
    }

    public String addPerson() {

        this.personService.add(this.person);
        return null;
    }

    public String deletePerson(final Person personToDelete) {

        this.personService.delete(personToDelete);
        return null;
    }

}
