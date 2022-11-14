package one.digitalinnovation.lpp.advice;

import one.digitalinnovation.lpp.exception.ClienteNotFoundException;
import one.digitalinnovation.lpp.exception.NotFoundCepExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({
      NotFoundCepExeption.class,
      ClienteNotFoundException.class
  })
  public Map<String, String> handleCustomExeption(Exception ex) {
    Map<String, String> erroMap = new HashMap<>();
    erroMap.put("errorMessage", ex.getMessage());
    return erroMap;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleUnexpectedTypeException(MethodArgumentNotValidException ex) {
    Map<String, String> erroMap = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      erroMap.put(error.getField(), error.getDefaultMessage());
    });
    return erroMap;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    Map<String, String> erroMap = new HashMap<>();
    erroMap.put("errorMessage", "Verifique a formatação do Body da requesição");
    return erroMap;
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public Map<String, String> handleException(Exception ex) {
    // Aqui pode ser salvo um log no banco de dados no lugar do printStackTrace()
    ex.printStackTrace();
    Map<String, String> erroMap = new HashMap<>();
    erroMap.put("errorMessage", "Internal Server Error");
    return erroMap;
  }
}
