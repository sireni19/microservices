package by.prokopovich.ms.weaponmicroservice.repository;

import by.prokopovich.ms.weaponmicroservice.model.Weapon;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface WeaponRepository extends CrudRepository<Weapon,Long> {

    /**
     * Метод назначает незанятому оружию нового владельца
     * @param newName ФИО нового владельца
     * @return Серийный номер оружия, которому только что назначили владельца
     */
    @Transactional
    default String setOwnerToFreeWeapon(String newName) {
        Weapon freeWeapon = getWeaponWithNoOwner();
        if (freeWeapon != null) {
            freeWeapon.setOwner(newName);
            save(freeWeapon);
            return freeWeapon.getSerialNumber();
        }else {
            throw new EntityNotFoundException("NO FREE WEAPONS");
        }
    }

    /**
     * Метод ищет в базе данных запись с оружием, у которого нет владельца
     * @return Объект Weapon, представляющий оружие без владельца.
     */
    @Query(value = "SELECT * FROM weapon WHERE weapon.owner IS NULL LIMIT 1", nativeQuery = true)
    Weapon getWeaponWithNoOwner();
}
