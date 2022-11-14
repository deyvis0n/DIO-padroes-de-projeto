package one.digitalinnovation.lpp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

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
