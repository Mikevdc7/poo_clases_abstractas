package org.mvallesg.pooclasesabstractas.form.validador;

import org.mvallesg.pooclasesabstractas.form.validador.mensaje.MensajeFormateable;

public class LargoValidador extends Validador implements MensajeFormateable {

    protected String mensaje = "El campo %s debe tener mínimo %d caracteres y máximo %d caracteres";
    private int min;
    private int max=Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

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
        if (valor == null){
            return true;
        }
        return (valor.length()>=min && valor.length()<=max);
    }

    @Override
    public String getMensajeFormateado(String campo){
        return String.format(this.mensaje, campo, min, max);
    }
}
