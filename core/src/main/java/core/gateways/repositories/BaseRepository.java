package core.gateways.repositories;

import java.util.List;

public interface BaseRepository<T, ID> {

    List<T> findAll();


    List<T> findAllById(Iterable<ID> ids);


    <S extends T> List<S> saveAll(Iterable<S> entities);


    void flush();



    <S extends T> S saveAndFlush(S entity);


    void deleteInBatch(Iterable<T> entities);


    void deleteAllInBatch();


    T getOne(ID id);
}
