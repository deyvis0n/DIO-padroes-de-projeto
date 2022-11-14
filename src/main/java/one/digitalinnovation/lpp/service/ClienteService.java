package one.digitalinnovation.lpp.service;

import one.digitalinnovation.lpp.controller.dto.ClienteDTO;
import one.digitalinnovation.lpp.entity.Cliente;
import one.digitalinnovation.lpp.exception.ClienteNotFoundException;
import one.digitalinnovation.lpp.exception.NotFoundCepExeption;

public interface ClienteService {
  Iterable<Cliente> buscarTodos();

  Cliente buscarPorId(Long id) throws ClienteNotFoundException;

  Cliente inserir(ClienteDTO cliente) throws NotFoundCepExeption;

  Cliente atualizar(Long id, ClienteDTO cliente) throws NotFoundCepExeption, ClienteNotFoundException;

  void deletar(Long id);
}
