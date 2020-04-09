package gateways.repository.jpa;

import entities.DefaultEntidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefaultRepository extends CrudRepository<DefaultEntidade, Long>, usecases.gateways.repositories.DefaultRepository {

    Iterable<DefaultEntidade> findAll(Long processoId);
}

