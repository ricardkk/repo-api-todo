package br.edu.ufersa.pw.todo.todoAPI.domain.services;

import br.edu.ufersa.pw.todo.todoAPI.api.DTO.TodoCreateDTO;
import br.edu.ufersa.pw.todo.todoAPI.api.DTO.TodoDTO;
import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Todo;
import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Usuario;
import br.edu.ufersa.pw.todo.todoAPI.domain.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository repository;
    public TodoService(final TodoRepository repository){
        this.repository = repository;
    }
    public List<TodoDTO> buscarTodos(){
        List<TodoDTO> result = repository.findAll()
                .stream().map(todo -> new TodoDTO(todo))
                .collect(Collectors.toList());
        return result;
    }
    public List<TodoDTO> buscarPorUsuario(long id){
        List<TodoDTO> result = repository.findByUsuario(new Usuario(id))
                .stream()
                .map(todo -> new TodoDTO(todo))
                .collect(Collectors.toList());
        return result;
    }
    public TodoDTO criar (TodoCreateDTO todo){
        return new TodoDTO(repository.save(new Todo(todo)));
    }
}
