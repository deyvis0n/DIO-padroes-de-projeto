package one.digitalinnovation.lpp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
  @NotNull
  @Pattern(regexp = "^\\d{8}$", message = "formato de CEP invalido")
  private String cep;
  @Size(max = 255)
  private String logradouro;
  @Size(max = 255)
  private String complemento;
  @Size(max = 255)
  private String bairro;
  @Size(max = 255)
  private String localidade;
  @Size(max = 2)
  private String uf;
}
