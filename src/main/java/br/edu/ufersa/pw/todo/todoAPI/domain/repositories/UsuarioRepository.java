package br.edu.ufersa.pw.todo.todoAPI.domain.repositories;

import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario save(Usuario usuario);

    Usuario findByEmail(String email);
}
