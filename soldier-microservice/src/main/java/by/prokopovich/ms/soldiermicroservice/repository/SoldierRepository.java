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
     /**
      * Сохраняет сущность солдата в базе данных.
      *
      * @param entity Сущность солдата для сохранения.
      * @param <S>    Тип сущности солдата.
      * @return Сохраненная сущность солдата.
      */
     @Transactional
     <S extends Soldier> S save(S entity);

     /**
      * Обновляет номер оружия у солдата с заданным идентификатором.
      *
      * @param weaponNumber Новый номер оружия для обновления.
      * @param soldierId    Идентификатор солдата, у которого будет обновлен номер оружия.
      */
     @Transactional
     @Modifying
     @Query(value = "UPDATE Soldier s SET s.weaponNumber = :weaponNumber WHERE s.id = :ownerId")
     void setWeapon(@Param("weaponNumber") String weaponNumber, @Param("ownerId") Long soldierId);
}
