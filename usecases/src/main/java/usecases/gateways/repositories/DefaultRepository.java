package usecases.gateways.repositories;

import core.gateways.repositories.BaseCrudRepository;
import entities.DefaultEntidade;

public interface DefaultRepository extends BaseCrudRepository<DefaultEntidade, Long> {

    Iterable<DefaultEntidade> findAll();
}
