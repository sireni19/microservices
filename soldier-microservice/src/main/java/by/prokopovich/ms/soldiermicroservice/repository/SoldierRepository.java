package by.prokopovich.ms.soldiermicroservice.repository;

import by.prokopovich.ms.soldiermicroservice.model.Soldier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SoldierRepository extends CrudRepository<Soldier, Long> {
     @Transactional
     <S extends Soldier> S save(S entity);

     @Transactional
     @Modifying
     @Query(value = "UPDATE Soldier s SET s.weaponNumber = :weaponNumber WHERE s.id = :ownerId")
     void setWeapon(@Param("weaponNumber") String weaponNumber, @Param("ownerId") Long soldierId);
}
