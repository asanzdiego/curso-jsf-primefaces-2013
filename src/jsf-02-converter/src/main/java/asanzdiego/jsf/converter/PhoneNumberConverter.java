package asanzdiego.jsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

@FacesConverter(forClass = PhoneNumber.class)
public class PhoneNumberConverter implements Converter {

    @Override
    public Object getAsObject(final FacesContext context,
            final UIComponent component, final String value)
            throws ConverterException {

        PhoneNumber phoneNumber = null;
        if (!StringUtils.isEmpty(value)) {
            phoneNumber = new PhoneNumber();

            final String errorMessage = component.getClientId()
                    + ": formato incorrecto. Ejemplo 'pp-nnnnnnn'";
            final String[] values = StringUtils.split(value, "-");
            if (values.length != 2) {
                throw new ConverterException(new FacesMessage(errorMessage));
            }
            if (values[0].length() != 2) {
                throw new ConverterException(new FacesMessage(errorMessage));
            }
            if (values[1].length() != 7) {
                throw new ConverterException(new FacesMessage(errorMessage));
            }

            phoneNumber.setPrefix(values[0]);
            phoneNumber.setNumber(values[1]);
        }
        return phoneNumber;
    }

    @Override
    public String getAsString(final FacesContext context,
            final UIComponent component, final Object value)
            throws ConverterException {

        return value == null ? null : value.toString();
    }
}
