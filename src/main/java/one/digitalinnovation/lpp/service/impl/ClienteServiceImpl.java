package one.digitalinnovation.lpp.service.impl;

import one.digitalinnovation.lpp.controller.dto.ClienteDTO;
import one.digitalinnovation.lpp.controller.dto.EnderecoViaCepDTO;
import one.digitalinnovation.lpp.entity.Cliente;
import one.digitalinnovation.lpp.entity.Endereco;
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
  public Cliente inserir(ClienteDTO cliente) {
    String cep = cliente.getEndereco().getCep();

    Endereco enderecoParaSalvar = enderecoRepository.findById(cep).orElseGet(() -> {
      EnderecoViaCepDTO enderecoViaCep = viaCepService.cosultarCep(cep);
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
    Cliente clienteParaSalvar = Cliente.builder()
        .nome(cliente.getNome())
        .endereco(enderecoParaSalvar)
        .build();
    return clienteRepository.save(clienteParaSalvar);
  }

  @Override
  public Cliente atualizar(Long id, ClienteDTO cliente) {
    return null;
  }

  @Override
  public void deletar(Long id) {

  }
}
