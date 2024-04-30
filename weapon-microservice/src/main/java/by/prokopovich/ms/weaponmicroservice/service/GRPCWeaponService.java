package by.prokopovich.ms.weaponmicroservice.service;


public interface GRPCWeaponService {

    void send(Long soldierId,String serialNumber);

}
