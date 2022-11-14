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
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
  @Autowired
  ViaCepService viaCepService;

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  EnderecoRepository enderecoRepository;

  @Override
  public Iterable<Cliente> buscarTodos() {
    return null;
  }

  @Override
  public Cliente buscarPorId(Long id) {
    return null;
  }

  @Override
  public Cliente inserir(ClienteDTO cliente) throws NotFoundCepExeption {
    Cliente clienteParaSalvar = verificarCEPeRetornarCliente(cliente);
    return clienteRepository.save(clienteParaSalvar);
  }

  @Override
  public Cliente atualizar(Long id, ClienteDTO cliente) throws NotFoundCepExeption, ClienteNotFoundException {
    if (!clienteRepository.existsById(id)) throw new ClienteNotFoundException(id);
    Cliente clienteParaAtualizar = verificarCEPeRetornarCliente(cliente);
    clienteParaAtualizar.setId(id);
    return clienteRepository.save(clienteParaAtualizar);
  }

  @Override
  public void deletar(Long id) {

  }

  private Cliente verificarCEPeRetornarCliente(ClienteDTO cliente) throws NotFoundCepExeption {
    String cep = cliente.getEndereco().getCep();
    Endereco enderecoParaSalvar = enderecoRepository.findById(cep).orElseGet(() -> {
      EnderecoViaCepDTO enderecoViaCep = viaCepService.cosultarCep(cep);
      if (enderecoViaCep.getCep() == null) return null;
      Endereco endereco = Endereco.builder()
          .cep(enderecoViaCep.getCep())
          .logradouro(enderecoViaCep.getLogradouro())
          .complemento(enderecoViaCep.getComplemento())
          .bairro(enderecoViaCep.getBairro())
          .numero(cliente.getEndereco().getNumero())
          .localidade(enderecoViaCep.getLocalidade())
          .uf(enderecoViaCep.getUf())
          .build();
      return enderecoRepository.save(endereco);
    });
    if (enderecoParaSalvar == null) throw new NotFoundCepExeption(cep);
    return Cliente.builder()
        .nome(cliente.getNome())
        .endereco(enderecoParaSalvar)
        .build();
  }
}
