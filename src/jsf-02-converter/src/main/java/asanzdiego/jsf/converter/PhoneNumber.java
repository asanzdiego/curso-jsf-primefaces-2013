package asanzdiego.jsf.converter;

public class PhoneNumber {

    private String prefix;

    private String number;

    public PhoneNumber() {

    }

    public String getPrefix() {

        return this.prefix;
    }

    public void setPrefix(final String prefix) {

        this.prefix = prefix;
    }

    public String getNumber() {

        return this.number;
    }

    public void setNumber(final String number) {

        this.number = number;
    }

    @Override
    public String toString() {

        final StringBuffer text = new StringBuffer();
        text.append(this.prefix);
        text.append("-");
        text.append(this.number);
        return text.toString();
    }
}
