package br.edu.ufersa.pw.todo.todoAPI.domain.services;

import br.edu.ufersa.pw.todo.todoAPI.api.DTO.UsuarioCreateDTO;
import br.edu.ufersa.pw.todo.todoAPI.api.DTO.UsuarioDTO;
import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Usuario;
import br.edu.ufersa.pw.todo.todoAPI.domain.repositories.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo){
        this.repo = repo;
    }
    public UsuarioDTO criar (UsuarioCreateDTO dto)
            throws DataIntegrityViolationException{
        Usuario usu = repo.findByEmail(dto.getEmail());
        if (usu != null) throw new DataIntegrityViolationException(
                "Já existe usuário cadastrado com este email!");
        return new UsuarioDTO(repo.save(new Usuario(dto)));
    }

}
