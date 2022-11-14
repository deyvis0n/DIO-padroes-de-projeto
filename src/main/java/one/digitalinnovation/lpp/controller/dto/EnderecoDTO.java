package one.digitalinnovation.lpp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {
  @NotBlank
  @Max(11)
  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String numero;
  private String localidade;
  @Max(2)
  private String uf;
}
