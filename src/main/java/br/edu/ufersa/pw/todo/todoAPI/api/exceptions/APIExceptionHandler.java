package br.edu.ufersa.pw.todo.todoAPI.api.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        // Constrói a mensagem de erro
        StringBuilder mensagem = new StringBuilder("Erro(s) de validação: ");
        ex.getBindingResult().getAllErrors().forEach(error -> {
            mensagem.append(error.getDefaultMessage()).append("; ");
        });
        // Estrutura a resposta
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Problema nos parâmetros enviados!");
        body.put("message", mensagem.toString().trim());
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityException(DataIntegrityViolationException ex) {
        // Constrói a mensagem de erro
        StringBuilder mensagem = new StringBuilder("Erro de violação de integridade.");
        mensagem.append(ex.getMessage());
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Problema nos parâmetros enviados!");
        body.put("message", mensagem.toString().trim());
        body.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}