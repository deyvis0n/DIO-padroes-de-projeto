package one.digitalinnovation.lpp.service;

import one.digitalinnovation.lpp.controller.dto.ClienteDTO;
import one.digitalinnovation.lpp.entity.Cliente;

public interface ClienteService {
  Iterable<Cliente> buscarTodos();

  Cliente buscarPorId(Long id);

  Cliente inserir(ClienteDTO cliente);

  Cliente atualizar(Long id, ClienteDTO cliente);

  void deletar(Long id);
}
