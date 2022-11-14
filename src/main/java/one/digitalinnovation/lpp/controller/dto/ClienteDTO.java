package one.digitalinnovation.lpp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
  @Size(min = 3, max = 255)
  private String nome;
  @Valid
  @NotNull
  private EnderecoDTO endereco;
}
