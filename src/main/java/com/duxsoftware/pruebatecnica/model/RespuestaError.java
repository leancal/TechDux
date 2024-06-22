package com.duxsoftware.pruebatecnica.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RespuestaError {
    private String mensaje;
    private int codigo;

    @JsonCreator
    public RespuestaError(@JsonProperty("mensaje") String mensaje, @JsonProperty("codigo") int codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }
    public String getMensaje() {
        return mensaje;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}