package one.digitalinnovation.lpp.controller;

import one.digitalinnovation.lpp.controller.dto.ClienteDTO;
import one.digitalinnovation.lpp.entity.Cliente;
import one.digitalinnovation.lpp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
  public Cliente buscarPorId(@PathVariable Long id) {
    return clienteService.buscarPorId(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente inserir(@RequestBody ClienteDTO cliente) {
    return clienteService.inserir(cliente);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Cliente atualiza(@PathVariable Long id, @RequestBody ClienteDTO cliente) {
    return clienteService.atualizar(id, cliente);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void deletar(@PathVariable Long id) {
    clienteService.deletar(id);
  }
}
