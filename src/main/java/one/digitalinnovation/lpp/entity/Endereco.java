package one.digitalinnovation.lpp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {
  @Id
  @Length(max = 11)
  private String cep;
  private String logradouro;
  private String complemento;
  private String bairro;
  private String localidade;
  @Length(max = 2)
  private String uf;
}
