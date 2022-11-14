package one.digitalinnovation.lpp.service.impl;

import one.digitalinnovation.lpp.controller.dto.ClienteDTO;
import one.digitalinnovation.lpp.entity.Cliente;
import one.digitalinnovation.lpp.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
  @Override
  public Iterable<Cliente> buscarTodos() {
    return null;
  }

  @Override
  public Cliente buscarPorId(Long id) {
    return null;
  }

  @Override
  public Cliente inserir(ClienteDTO cliente) {
    return null;
  }

  @Override
  public Cliente atualizar(Long id, ClienteDTO cliente) {
    return null;
  }

  @Override
  public void deletar(Long id) {

  }
}
