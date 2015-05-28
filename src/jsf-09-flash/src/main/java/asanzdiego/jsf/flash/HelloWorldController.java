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
package asanzdiego.jsf.flash;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 * A typical simple backing bean, that is backed to
 * <code>helloWorld.xhtml</code>
 */
@ManagedBean(name = "helloWorld")
@RequestScoped
public class HelloWorldController {

    // properties
    private String name;

    /**
     * default empty constructor
     */
    public HelloWorldController() {

    }

    /**
     * Method that is backed to a submit button of a form.
     */
    public String send() {

        final Flash flash = FacesContext.getCurrentInstance()
                .getExternalContext().getFlash();
        flash.put("bean", this);
        return "page2?faces-redirect=true";
    }

    // -------------------getter & setter

    public String getName() {

        return this.name;
    }

    public void setName(final String name) {

        this.name = name;
    }

}
