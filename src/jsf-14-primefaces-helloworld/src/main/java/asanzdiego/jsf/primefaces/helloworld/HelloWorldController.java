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
package asanzdiego.jsf.primefaces.helloworld;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@ManagedBean
@ViewScoped
public class HelloWorldController {

    private boolean rendered = false;

    private String continent;

    private String country;

    private Map<String, String> continents = new HashMap<String, String>();

    private Map<String, Map<String, String>> countryData = new HashMap<String, Map<String, String>>();

    private Map<String, String> countries = new HashMap<String, String>();

    public HelloWorldController() {

        this.continents.put("America", "America");
        this.continents.put("Europe", "Europe");
        this.continents.put("Asia", "Asia");

        final Map<String, String> americasCountries = new HashMap<String, String>();
        americasCountries.put("EEUU", "EEUU");
        americasCountries.put("Mexico", "Mexico");
        americasCountries.put("Canada", "Canada");

        final Map<String, String> europesCountries = new HashMap<String, String>();
        europesCountries.put("Spain", "Spain");
        europesCountries.put("France", "France");
        europesCountries.put("Italy", "Italy");

        final Map<String, String> asiasCountries = new HashMap<String, String>();
        asiasCountries.put("India", "India");
        asiasCountries.put("Japan", "Japan");
        asiasCountries.put("China", "China");

        this.countryData.put("America", americasCountries);
        this.countryData.put("Europe", europesCountries);
        this.countryData.put("Asia", asiasCountries);
    }

    public String getContinent() {

        return this.continent;
    }

    public void setContinent(final String newContinent) {

        this.continent = newContinent;
    }

    public String getCountry() {

        return this.country;
    }

    public void setCountry(final String newCountry) {

        this.country = newCountry;
    }

    public Map<String, String> getContinents() {

        return this.continents;
    }

    public void setContinents(final Map<String, String> newContinents) {

        this.continents = newContinents;
    }

    public Map<String, Map<String, String>> getCountryData() {

        return this.countryData;
    }

    public void setCountryData(
            final Map<String, Map<String, String>> newCountryData) {

        this.countryData = newCountryData;
    }

    public Map<String, String> getCountries() {

        return this.countries;
    }

    public void setCountries(final Map<String, String> newCountries) {

        this.countries = newCountries;
    }

    public void handleContinentChange() {

        if ((this.continent != null) && !this.continent.equals("")) {
            this.countries = this.countryData.get(this.continent);
            this.rendered = true;
        } else {
            this.countries = new HashMap<String, String>();
            this.rendered = false;
        }
    }

    public void displayLocation() {

        final FacesMessage msg = new FacesMessage("Selected", "Continent:"
                + this.continent + ", Country: " + this.country);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isRendered() {

        return this.rendered;
    }

}
