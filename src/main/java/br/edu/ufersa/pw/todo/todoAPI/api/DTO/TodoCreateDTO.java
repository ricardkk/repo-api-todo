package br.edu.ufersa.pw.todo.todoAPI.api.DTO;

import java.time.LocalDate;

public class TodoCreateDTO {
    long idUsu;
    String item;
    LocalDate prazo;
    Estado estado;

    public long getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(long usu) {
        this.idUsu = usu;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
