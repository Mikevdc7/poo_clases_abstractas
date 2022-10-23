package org.mvallesg.pooclasesabstractas.form.validador;

import java.util.regex.Matcher;

public class EmailValidador extends Validador{

    protected String mensaje = "El campo %s tiene un formato de correo inválido";
    private final static String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return this.mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(EMAIL_REGEX);
    }
}