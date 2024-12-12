package br.edu.ufersa.pw.todo.todoAPI.api.controllers;

import br.edu.ufersa.pw.todo.todoAPI.api.DTO.UsuarioCreateDTO;
import br.edu.ufersa.pw.todo.todoAPI.api.DTO.UsuarioDTO;
import br.edu.ufersa.pw.todo.todoAPI.domain.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {
    public final UsuarioService service;

    public UserController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioCreateDTO dto){
        return new ResponseEntity<UsuarioDTO>(service.criar(dto), HttpStatus.OK);
    }

}
