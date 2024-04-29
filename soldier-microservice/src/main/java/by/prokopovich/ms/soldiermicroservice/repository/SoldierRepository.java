package by.prokopovich.ms.soldiermicroservice.repository;

import by.prokopovich.ms.soldiermicroservice.model.Soldier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SoldierRepository extends CrudRepository<Soldier, Long> {
     @Transactional
     <S extends Soldier> S save(S entity);
}
