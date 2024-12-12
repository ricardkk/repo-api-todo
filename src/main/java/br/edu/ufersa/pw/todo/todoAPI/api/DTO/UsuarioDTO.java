package br.edu.ufersa.pw.todo.todoAPI.api.DTO;

import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Usuario;

public class UsuarioDTO {
    Long id;
    String email;

    public UsuarioDTO(){}
    public UsuarioDTO(Usuario usu){
        this.id = usu.getId();
        this.email = usu.getEmail();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
