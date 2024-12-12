package br.edu.ufersa.pw.todo.todoAPI.api.DTO;

import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Todo;

import java.time.LocalDate;


public class TodoDTO {
   long id;
   String item;
   LocalDate prazo;
   Estado estado;
   public TodoDTO(){}
   public TodoDTO(Todo todo){
       setId(todo.getId());
       setEstado(todo.getEstado());
       setPrazo(todo.getPrazo());
       setItem(todo.getItem());
   }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
