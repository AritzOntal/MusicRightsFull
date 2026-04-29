package com.svalero.music.rights.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WorkNotFoundException.class)
    public ResponseEntity<ErrorResponse> WorkHandleException(WorkNotFoundException cnfe) {
        return notFound("La obra no existe");
    }

    @ExceptionHandler(MusicianNotFoundException.class)
    public ResponseEntity<ErrorResponse> MusicianHandleException(MusicianNotFoundException cnfe) {
        return notFound("El músico no existe");
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<ErrorResponse> DocumentHandleException(DocumentNotFoundException cnfe) {
        return notFound("El documento no existe");
    }

    @ExceptionHandler(ClaimNotFoundException.class)
    public ResponseEntity<ErrorResponse> ClaimHandleException(ClaimNotFoundException cnfe) {
        return notFound("La reclamación no existe");
    }

    @ExceptionHandler(ConcertNotFoundException.class)
    public ResponseEntity<ErrorResponse> ConcertHandleException(ConcertNotFoundException cnfe) {
        return notFound("El concierto no existe");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException manve) {
        return badRequest("Error de validación");
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleMethodMessageNotValid(MethodArgumentTypeMismatchException hmnre) {
        return badRequest("Error en los parametros de la llamada");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMethodMessageNotValid(HttpMessageNotReadableException hmnre) {
        return badRequest("Error en los campos");
    }

    //HELPERS
    private ResponseEntity<ErrorResponse> notFound(String message) {
        ErrorResponse body = new ErrorResponse(404, "Not-found", message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    private ResponseEntity<ErrorResponse> badRequest(String message) {
        ErrorResponse body = new ErrorResponse(400, "bad-request", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    //TODO SACAR MESSAGES DE LAS VALIDACIONES PARA MOSTRARLOS EN LOS 400 (BAD REQUEST)

}
