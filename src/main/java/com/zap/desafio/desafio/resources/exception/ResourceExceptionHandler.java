package com.zap.desafio.desafio.resources.exception;

import com.zap.desafio.desafio.service.exceptions.ObjetoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontrado.class)
    public ResponseEntity<StandardError> objetoNaoEncontrado(ObjetoNaoEncontrado erro, HttpServletRequest request){
        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), erro.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException e,
                                                                HttpServletRequest request){
        ValidationError se = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação");
        for(FieldError fe : e.getBindingResult().getFieldErrors()){
            se.addErro(fe.getField(), fe.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }
}
