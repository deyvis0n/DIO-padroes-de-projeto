package one.digitalinnovation.lpp.service;

import one.digitalinnovation.lpp.controller.dto.EnderecoViaCepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
  @GetMapping("/{cep}/json/")
  EnderecoViaCepDTO cosultarCep(@PathVariable String cep);
}
