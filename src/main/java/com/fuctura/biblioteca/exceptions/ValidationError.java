package com.fuctura.biblioteca.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    //foi instanciado a lista no prorpio atributo pois é uma indicação que a lista está vazia. Caso nao for instaciado, quer dizer que a lista inicial está nula.
    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {

    }

    public ValidationError(LocalDateTime timeStemp, Integer status, String message, String path) {
        super(timeStemp, status, message, path);

    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErros(String fieldName, String message) {
        this.erros.add(new FieldMessage(fieldName, message));
    }
}
