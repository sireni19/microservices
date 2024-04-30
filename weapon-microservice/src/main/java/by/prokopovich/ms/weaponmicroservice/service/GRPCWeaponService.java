package by.prokopovich.ms.weaponmicroservice.service;

import by.prokopovich.ms.weaponmicroservice.model.Weapon;

public interface GRPCWeaponService {

    Long send(Long soldierId,String serialNumber);

}
