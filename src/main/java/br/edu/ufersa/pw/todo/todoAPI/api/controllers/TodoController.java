package br.edu.ufersa.pw.todo.todoAPI.api.controllers;

import br.edu.ufersa.pw.todo.todoAPI.api.DTO.TodoCreateDTO;
import br.edu.ufersa.pw.todo.todoAPI.api.DTO.TodoDTO;
import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Todo;
import br.edu.ufersa.pw.todo.todoAPI.domain.repositories.TodoRepository;
import br.edu.ufersa.pw.todo.todoAPI.domain.services.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    @Autowired
    private ModelMapper mapper;
    private final TodoService service;
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listar(){
       ResponseEntity<List<TodoDTO>> response = new
               ResponseEntity<List<TodoDTO>>(service.buscarTodos(), HttpStatus.OK);
        return response;
    }
   /* public ResponseEntity<?> listar(){
        List<Todo> l = repository.findAll();
        List<TodoDTO> lreturn = l.stream().map(todo-> new TodoDTO(todo))
                                .collect(Collectors.toList());
        ResponseEntity<List<TodoDTO>> response = new
                ResponseEntity<List<TodoDTO>>(lreturn, HttpStatus.OK);
        return response;
    }*/
    @GetMapping("/{userId}")
    public ResponseEntity<?> listarPorUsuario(@PathVariable long userId){
        ResponseEntity<List<TodoDTO>> response =
                new ResponseEntity<List<TodoDTO>>(service.buscarPorUsuario(userId),
                        HttpStatus.OK);
        return response;
    }

    @PostMapping
    public ResponseEntity<TodoDTO> criar(@RequestBody TodoCreateDTO todo){
        System.out.println("Chegou aqui : " + todo.getIdUsu());
        ResponseEntity<TodoDTO> response = new ResponseEntity<TodoDTO>(
                service.criar(todo), HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<TodoDTO> RemoverUsuario(@PathVariable Long todoId){return null;}

    @PutMapping("/todos")
    public ResponseEntity<TodoCreateDTO> alterar (@RequestBody TodoCreateDTO todo){return null;}

    @PatchMapping("/todos")
    public ResponseEntity<TodoCreateDTO> concluir (){return null;}
}
