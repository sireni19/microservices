package by.prokopovich.ms.weaponmicroservice.repository;

import by.prokopovich.ms.weaponmicroservice.model.Weapon;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface WeaponRepository extends CrudRepository<Weapon,Long> {


    @Transactional
    default void setOwnerToFreeWeapon(String newName) {
        Weapon freeWeapon = findFirstByOwnerIsNull();
        if (freeWeapon != null) {
            freeWeapon.setOwner(newName);
            save(freeWeapon);
        }else {
            throw new EntityNotFoundException("NO FREE WEAPONS");
        }
    }
    Weapon findFirstByOwnerIsNull();
}
