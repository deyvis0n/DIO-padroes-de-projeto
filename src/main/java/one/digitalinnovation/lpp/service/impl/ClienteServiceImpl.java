package one.digitalinnovation.lpp.service.impl;

import one.digitalinnovation.lpp.controller.dto.ClienteDTO;
import one.digitalinnovation.lpp.controller.dto.EnderecoViaCepDTO;
import one.digitalinnovation.lpp.entity.Cliente;
import one.digitalinnovation.lpp.entity.Endereco;
import one.digitalinnovation.lpp.exception.ClienteNotFoundException;
import one.digitalinnovation.lpp.exception.NotFoundCepExeption;
import one.digitalinnovation.lpp.repository.ClienteRepository;
import one.digitalinnovation.lpp.repository.EnderecoRepository;
import one.digitalinnovation.lpp.service.ClienteService;
import one.digitalinnovation.lpp.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
  @Autowired
  private ViaCepService viaCepService;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private EnderecoRepository enderecoRepository;

  @Override
  public Iterable<Cliente> buscarTodos() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente buscarPorId(Long id) throws ClienteNotFoundException {
    return clienteRepository.findById(id).orElseThrow(() -> new ClienteNotFoundException(id));
  }

  @Override
  public Cliente inserir(ClienteDTO cliente) throws NotFoundCepExeption {
    return salvarClienteComCep(cliente, null);
  }

  @Override
  public Cliente atualizar(Long id, ClienteDTO cliente) throws NotFoundCepExeption, ClienteNotFoundException {
    if (!clienteRepository.existsById(id)) throw new ClienteNotFoundException(id);
    return salvarClienteComCep(cliente, id);
  }

  @Override
  public void deletar(Long id) throws ClienteNotFoundException {
    try {
      clienteRepository.deleteById(id);
    } catch (EmptyResultDataAccessException ex) {
      throw new ClienteNotFoundException(id);
    }
  }

  private Cliente salvarClienteComCep(ClienteDTO cliente, Long id) throws NotFoundCepExeption {
    String cep = cliente.getEndereco().getCep();
    Endereco enderecoParaSalvar = enderecoRepository.findById(cep).orElseGet(() -> {
      EnderecoViaCepDTO enderecoViaCep = viaCepService.cosultarCep(cep);
      if (enderecoViaCep.getCep() == null) return null;
      Endereco endereco = Endereco.builder()
              .cep(enderecoViaCep.getCep())
              .logradouro(enderecoViaCep.getLogradouro())
              .complemento(enderecoViaCep.getComplemento())
              .bairro(enderecoViaCep.getBairro())
              .localidade(enderecoViaCep.getLocalidade())
              .uf(enderecoViaCep.getUf())
              .build();
      return enderecoRepository.save(endereco);
    });
    if (enderecoParaSalvar == null) throw new NotFoundCepExeption(cep);
    Cliente clienteParaSalvar = Cliente.builder()
            .id(id)
            .nome(cliente.getNome())
            .endereco(enderecoParaSalvar)
            .build();
    return clienteRepository.save(clienteParaSalvar);
  }
}
