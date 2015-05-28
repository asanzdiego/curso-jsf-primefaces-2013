package asanzdiego.jsf.integration.model;

public class Person {

    private String name;

    private Integer age;

    public Person() {

        super();
        // TODO Auto-generated constructor stub
    }

    public Person(final String name, final Integer age) {

        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {

        return this.name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public Integer getAge() {

        return this.age;
    }

    public void setAge(final Integer age) {

        this.age = age;
    }

    @Override
    public String toString() {

        return "Person [name=" + this.name + ", age=" + this.age + "]";
    }

}
