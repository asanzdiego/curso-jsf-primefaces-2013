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
package asanzdiego.jsf.eventhadler;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@ManagedBean(name = "helloWorld")
@RequestScoped
public class HelloWorldController {

    private static final long serialVersionUID = 1L;

    private static Map<String, String> countries;

    private String localeCode = "en"; // default value

    static {
        HelloWorldController.countries = new LinkedHashMap<String, String>();
        HelloWorldController.countries.put("United Kingdom", "en");
        HelloWorldController.countries.put("French", "fr");
        HelloWorldController.countries.put("German", "de");
        HelloWorldController.countries.put("Spain", "es");
    }

    public void countryLocaleCodeChanged(final ValueChangeEvent e) {

        // assign new value to localeCode
        this.localeCode = e.getNewValue().toString();

    }

    public Map<String, String> getCountryInMap() {

        return HelloWorldController.countries;
    }

    public String getLocaleCode() {

        return this.localeCode;
    }

    public void setLocaleCode(final String localeCode) {

        this.localeCode = localeCode;
    }

}
