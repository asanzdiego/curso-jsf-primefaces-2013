package asanzdiego.jsf.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.apache.commons.lang3.StringUtils;

public class NifValidator implements Validator {

    @Override
    public void validate(final FacesContext context,
            final UIComponent component, final Object value)
            throws ValidatorException {

        // Si el valor es null, lo transformamos en un valor vacio
        String valor = StringUtils.defaultString((String) value);

        // el valor debe tener 9 posiciones,
        // de las cuales las primeras deben ser digitos y la ultima letra
        valor = valor.toUpperCase();
        final Pattern mask = Pattern.compile("[0-9]{8,8}[A-Z]");
        final Matcher matcher = mask.matcher(valor);
        if (!matcher.matches()) {
            throw new ValidatorException(new FacesMessage(
                    component.getClientId()
                            + ": Error de validación: NIF no válido."));
        }

        // Calculamos la letra de control
        final String dni = valor.substring(0, 8);
        final String digitoControl = valor.substring(8, 9);
        final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        final int posicion_modulo = Integer.parseInt(dni) % 23;
        final String digitoControlCalculado = letras.substring(posicion_modulo,
                posicion_modulo + 1);
        if (!digitoControl.equalsIgnoreCase(digitoControlCalculado)) {
            throw new ValidatorException(new FacesMessage(
                    component.getClientId()
                            + ": Error de validación: NIF no válido."));
        }
    }
}
