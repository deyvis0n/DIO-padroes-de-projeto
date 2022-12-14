package one.digitalinnovation.lpp.controller;

import one.digitalinnovation.lpp.controller.dto.ClienteDTO;
import one.digitalinnovation.lpp.entity.Cliente;
import one.digitalinnovation.lpp.exception.ClienteNotFoundException;
import one.digitalinnovation.lpp.exception.NotFoundCepExeption;
import one.digitalinnovation.lpp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {
  @Autowired
  private ClienteService clienteService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Cliente> buscarTodos() {
    return clienteService.buscarTodos();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Cliente buscarPorId(@PathVariable Long id) throws ClienteNotFoundException {
    return clienteService.buscarPorId(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente inserir(@Valid @RequestBody ClienteDTO cliente) throws NotFoundCepExeption {
    return clienteService.inserir(cliente);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Cliente atualiza(@PathVariable Long id, @Valid @RequestBody ClienteDTO cliente) throws NotFoundCepExeption, ClienteNotFoundException {
    return clienteService.atualizar(id, cliente);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void deletar(@PathVariable Long id) throws ClienteNotFoundException {
    clienteService.deletar(id);
  }
}
