package one.digitalinnovation.lpp.exception;

public class ClienteNotFoundException extends Exception {
  public ClienteNotFoundException(Long id) {
    super("Não foi possivel localizar o cliente de id " + id);
  }
}
