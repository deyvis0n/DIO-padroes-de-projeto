package one.digitalinnovation.lpp.service;

import one.digitalinnovation.lpp.entity.Endereco;

public interface ViaCepService {
  Endereco cosultarCep(String cep);
}
