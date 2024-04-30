package by.prokopovich.ms.weaponmicroservice.handler;


import by.prokopovich.ms.customlibrary.SoldierEvent;
import by.prokopovich.ms.weaponmicroservice.repository.WeaponRepository;
import by.prokopovich.ms.weaponmicroservice.service.GRPCWeaponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
/**
 * Класс представляет собой Kafka Consumer.
 */
@Component
@KafkaListener(topics = "soldier-weapon-event-topic")
@Slf4j
public class SoldierEventHandler {
    private final WeaponRepository weaponRepository;
    private final GRPCWeaponService grpcWeaponService;

    @Autowired
    public SoldierEventHandler(WeaponRepository weaponRepository, GRPCWeaponService grpcWeaponService) {
        this.weaponRepository = weaponRepository;
        this.grpcWeaponService = grpcWeaponService;
    }
    /**
     * Метод читает сообщения(SoldierEvent) переданные в Kafka Broker Kafka Produer-ом
     * (SoldierServiceImpl в by/prokopovich/ms/soldiermicroservice/service/SoldierServiceImpl.java)
     *
     * @param soldierEvent сериализованное сообщение из Kafka Broker-а.
     */
    @KafkaHandler
    public void handle(SoldierEvent soldierEvent) {
        log.info("RECEIVED SOLDIER EVENT: " + soldierEvent);
        String serialNumber = weaponRepository.setOwnerToFreeWeapon(soldierEvent.getLastName_firstName_patronymic());
        grpcWeaponService.send(Long.parseLong(soldierEvent.getSoldierId()),serialNumber);
    }

}
