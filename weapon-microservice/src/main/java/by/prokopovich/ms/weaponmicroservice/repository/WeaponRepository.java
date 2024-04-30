package by.prokopovich.ms.weaponmicroservice.repository;

import by.prokopovich.ms.weaponmicroservice.model.Weapon;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface WeaponRepository extends CrudRepository<Weapon,Long> {


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
    @Query(value = "SELECT * FROM weapon WHERE weapon.owner IS NULL LIMIT 1", nativeQuery = true)
    Weapon getWeaponWithNoOwner();
}
