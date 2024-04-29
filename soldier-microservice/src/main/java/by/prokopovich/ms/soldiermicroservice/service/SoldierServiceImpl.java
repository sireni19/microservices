package by.prokopovich.ms.soldiermicroservice.service;

import by.prokopovich.ms.customlibrary.SoldierEvent;
import by.prokopovich.ms.soldiermicroservice.dto.SoldierDto;

import by.prokopovich.ms.soldiermicroservice.model.Soldier;
import by.prokopovich.ms.soldiermicroservice.repository.SoldierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class SoldierServiceImpl implements SoldierService {

    private SoldierRepository soldierRepository;
    private KafkaTemplate<String, SoldierEvent> kafkaTemplate;//aka KafkaProducer
    @Autowired
    public SoldierServiceImpl(SoldierRepository soldierRepository, KafkaTemplate<String, SoldierEvent> kafkaTemplate) {
        this.soldierRepository = soldierRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String addSoldier(SoldierDto dto) throws ExecutionException, InterruptedException {
        Soldier soldier = new Soldier(dto.getFirstName(),dto.getLastName(),dto.getPatronymic());
        Optional<Soldier> optionalSoldier = Optional.ofNullable(soldierRepository.save(soldier));
        if (optionalSoldier.isPresent()) {
            Soldier savedSoldier = optionalSoldier.get();
            SoldierEvent event = new SoldierEvent();
            String key = savedSoldier.getId().toString();
            event.setSoldierId(key);
            event.setLastName_firstName_patronymic(savedSoldier.getLastName() + " " + savedSoldier.getFirstName() + " " + savedSoldier.getPatronymic());
            SendResult<String, SoldierEvent> result = kafkaTemplate.send("soldier-weapon-event-topic", key, event).get();
            log.info("MESSAGE SENT SUCCESSFULLY: {}", result.getRecordMetadata());
            return key;
        } else {
            log.error("SAVING FAILED");
            throw new RuntimeException("SAVING IN DATABASE WAS FAILED");
        }
    }
}
