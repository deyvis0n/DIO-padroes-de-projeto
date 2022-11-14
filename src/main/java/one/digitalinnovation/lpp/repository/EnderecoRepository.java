package one.digitalinnovation.lpp.repository;

import one.digitalinnovation.lpp.entity.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
