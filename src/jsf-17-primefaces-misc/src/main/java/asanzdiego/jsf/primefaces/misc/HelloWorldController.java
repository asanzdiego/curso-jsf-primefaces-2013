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
package asanzdiego.jsf.primefaces.misc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@ManagedBean(name = "helloWorld")
@RequestScoped
public class HelloWorldController {

    // properties
    private String name;

    private Date date;

    private String description;

    private String autocomplete;

    private Integer rating;

    private Integer slider;

    /**
     * default empty constructor
     */
    public HelloWorldController() {

    }

    /**
     * Method that is backed to a submit button of a form.
     */
    public String send() {

        // do real logic, return a string which will be used for the navigation
        // system of JSF
        return "page2.xhtml";
    }

    // -------------------getter & setter

    public String getName() {

        return this.name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public Date getDate() {

        return this.date;
    }

    public void setDate(final Date date) {

        this.date = date;
    }

    public String getDescription() {

        return this.description;
    }

    public void setDescription(final String description) {

        this.description = description;
    }

    public String getAutocomplete() {

        return this.autocomplete;
    }

    public void setAutocomplete(final String autocomplete) {

        this.autocomplete = autocomplete;
    }

    public List<String> complete(final String query) {

        final List<String> results = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;
    }

    public Integer getRating() {

        return this.rating;
    }

    public void setRating(final Integer rating) {

        this.rating = rating;
    }

    public Integer getSlider() {

        return this.slider;
    }

    public void setSlider(final Integer slider) {

        this.slider = slider;
    }

}
