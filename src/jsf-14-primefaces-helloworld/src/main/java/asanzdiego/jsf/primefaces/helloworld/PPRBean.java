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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@ManagedBean(name = "pprBean")
@RequestScoped
public class PPRBean implements Serializable {

    private String city;

    private String suburb;

    private Map<String, String> cities = new HashMap<String, String>();

    private Map<String, Map<String, String>> suburbsData = new HashMap<String, Map<String, String>>();

    private Map<String, String> suburbs = new HashMap<String, String>();

    public PPRBean() {

        System.out.println("constructor");

        this.cities.put("Istanbul", "Istanbul");
        this.cities.put("Ankara", "Ankara");
        this.cities.put("Izmir", "Izmir");

        final Map<String, String> suburbsIstanbul = new HashMap<String, String>();
        suburbsIstanbul.put("Kadikoy", "Kadikoy");
        suburbsIstanbul.put("Levent", "Levent");
        suburbsIstanbul.put("Cengelkoy", "Cengelkoy");

        final Map<String, String> suburbsAnkara = new HashMap<String, String>();
        suburbsAnkara.put("Kecioren", "Kecioren");
        suburbsAnkara.put("Cankaya", "Cankaya");
        suburbsAnkara.put("Yenimahalle", "Yenimahalle");

        final Map<String, String> suburbsIzmir = new HashMap<String, String>();
        suburbsIzmir.put("Cesme", "Cesme");
        suburbsIzmir.put("Gumuldur", "Gumuldur");
        suburbsIzmir.put("Foca", "Foca");

        this.suburbsData.put("Istanbul", suburbsIstanbul);
        this.suburbsData.put("Ankara", suburbsAnkara);
        this.suburbsData.put("Izmir", suburbsIzmir);
    }

    public String getCity() {

        System.out.println("getCity->" + this.city);
        return this.city;
    }

    public void setCity(final String city) {

        this.city = city;
        System.out.println("setCity->" + this.city);
    }

    public String getSuburb() {

        System.out.println("getSuburb->" + this.suburb);
        return this.suburb;
    }

    public void setSuburb(final String suburb) {

        this.suburb = suburb;
        System.out.println("setSuburb->" + this.suburb);
    }

    public Map<String, String> getCities() {

        System.out.println("getCities->" + this.cities);
        return this.cities;
    }

    public void setCities(final Map<String, String> cities) {

        this.cities = cities;
        System.out.println("setCities->" + this.cities);
    }

    public Map<String, Map<String, String>> getSuburbsData() {

        System.out.println("getSuburbsData->" + this.suburbsData);
        return this.suburbsData;
    }

    public void setSuburbsData(
            final Map<String, Map<String, String>> suburbsData) {

        this.suburbsData = suburbsData;
        System.out.println("setSuburbsData->" + this.suburbsData);
    }

    public Map<String, String> getSuburbs() {

        System.out.println("getSuburbs->" + this.suburbs);
        return this.suburbs;
    }

    public void setSuburbs(final Map<String, String> suburbs) {

        this.suburbs = suburbs;
        System.out.println("setSuburbs->" + this.suburbs);
    }

    public void handleCityChange() {

        System.out.println("handleCityChange->city=" + this.city);

        if ((this.city != null) && !this.city.equals("")) {
            this.suburbs = this.suburbsData.get(this.city);
        } else {
            this.suburbs = new HashMap<String, String>();
        }
    }

    public void displayLocation() {

        System.out.println("displayLocation->city=" + this.city + ", Suburb="
                + this.suburb);
        final FacesMessage msg = new FacesMessage("Selected", "City:"
                + this.city + ", Suburb: " + this.suburb);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}