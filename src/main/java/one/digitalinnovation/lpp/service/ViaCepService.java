package one.digitalinnovation.lpp.service;

import one.digitalinnovation.lpp.controller.dto.EnderecoDTO;

public interface ViaCepService {
  EnderecoDTO cosultarCep(String cep);
}
