package br.edu.ufersa.pw.todo.todoAPI.domain.repositories;

import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Todo;
import br.edu.ufersa.pw.todo.todoAPI.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    public List<Todo> findByUsuario(Usuario usu);
    public Todo save(Todo t);
    @Query(
            value = "select t.id, t.id_usuario, t.item, t.prazo from tb_todos t INNER JOIN tb_usuarios user "
                    + "ON user.id=t.id_usuario and user.email= :email",
            nativeQuery = true)
     List<Todo> findByUsuario(String email);


}
