package asanzdiego.jsf.primefaces.themes;

public class Person {

    private String name;

    private Integer age;

    private boolean editable;

    public Person() {

        super();
        // TODO Auto-generated constructor stub
    }

    public Person(final String name, final Integer age) {

        super();
        this.name = name;
        this.age = age;
        this.editable = false;
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

    public boolean isEditable() {

        return this.editable;
    }

    public void setEditable(final boolean editable) {

        this.editable = editable;
    }

    @Override
    public String toString() {

        return "Person [name=" + this.name + ", age=" + this.age + "]";
    }

}
