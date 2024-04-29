package by.prokopovich.ms.weaponmicroservice.handler;


import by.prokopovich.ms.customlibrary.SoldierEvent;
import by.prokopovich.ms.weaponmicroservice.repository.WeaponRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "soldier-weapon-event-topic")
@Slf4j
public class SoldierEventHandler {
    private final WeaponRepository weaponRepository;

    @Autowired
    public SoldierEventHandler(WeaponRepository weaponRepository) {
        this.weaponRepository = weaponRepository;
    }

    @KafkaHandler
    public void handle(SoldierEvent soldierEvent) {
        log.info("RECEIVED SOLDIER EVENT: " + soldierEvent);
        weaponRepository.setOwnerToFreeWeapon(soldierEvent.getLastName_firstName_patronymic());
    }

}
