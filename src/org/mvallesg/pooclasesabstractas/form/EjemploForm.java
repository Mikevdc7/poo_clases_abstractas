package org.mvallesg.pooclasesabstractas.form;

import org.mvallesg.pooclasesabstractas.form.elementos.*;
import org.mvallesg.pooclasesabstractas.form.elementos.select.Opcion;
import org.mvallesg.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("password", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador((new LargoValidador(6, 12)));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "Javascript"))
                .addOpcion(new Opcion("4", "Typescript"))
                .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("saludo"){
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre + "' value='" + this.valor + "'>";
            }
        };

        saludar.setValor("Hola que tal, este campo está deshabilitado");
        username.setValor("Mike.Valles");
        password.setValor("a1B234");
        email.setValor("email@correo.com");
        edad.setValor("26");
        experiencia.setValor("... más de 10 años de experiencia ...");
        java.setSelected(true);

        List<ElementoForm> elementos = new ArrayList<>();
        elementos.add(username);
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);
        elementos.add(saludar);

        /*
        for(ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }*/

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e ->{
           if(!e.esValido()){
               e.getErrores().forEach(System.out::println);
           }
        });
    }
}
