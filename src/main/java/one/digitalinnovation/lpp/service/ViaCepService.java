package one.digitalinnovation.lpp.service;

import one.digitalinnovation.lpp.controller.dto.EnderecoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
  @GetMapping("/{cep}/json/")
  EnderecoDTO cosultarCep(String cep);
}
