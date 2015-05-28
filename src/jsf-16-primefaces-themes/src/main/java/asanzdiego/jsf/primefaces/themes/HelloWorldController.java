/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package asanzdiego.jsf.primefaces.themes;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@ManagedBean(name = "helloWorld")
@ViewScoped
public class HelloWorldController {

    private static final List<Person> persons = new ArrayList<Person>();

    static {

        HelloWorldController.persons.add(new Person("Isabel", 34));
        HelloWorldController.persons.add(new Person("Alba", 4));
        HelloWorldController.persons.add(new Person("Laura", 1));
    }

    private Person person = new Person();

    /**
     * default empty constructor
     */
    public HelloWorldController() {

    }

    public String addAction() {

        HelloWorldController.persons.add(this.person);
        return null;
    }

    public String deleteAction(final Person personToDelete) {

        HelloWorldController.persons.remove(personToDelete);
        return null;
    }

    public String editAction(final Person personToEdit) {

        personToEdit.setEditable(true);
        return null;
    }

    public String saveAction() {

        for (final Person personSaved : HelloWorldController.persons) {
            personSaved.setEditable(false);
        }
        return null;
    }

    public List<Person> getPersons() {

        return HelloWorldController.persons;
    }

    public Person getPerson() {

        return this.person;
    }

    public void onRowSelect(final SelectEvent event) {

        this.person = (Person) event.getObject();
    }
}
