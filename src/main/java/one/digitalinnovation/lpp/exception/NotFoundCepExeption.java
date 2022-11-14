package one.digitalinnovation.lpp.exception;

public class NotFoundCepExeption extends Exception {
  public NotFoundCepExeption(String cep) {
    super("Não foi possivel localizar o cep: " + cep + " verifique se este é um cep valido");
  }
}
