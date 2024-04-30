package by.prokopovich.ms.soldiermicroservice.controller;

import by.prokopovich.ms.soldiermicroservice.dto.SoldierDto;
import by.prokopovich.ms.soldiermicroservice.service.SoldierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/soldier")
@Slf4j
public class SoldierController {

    private SoldierService soldierService;

    @Autowired
    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    @PostMapping
    public ResponseEntity<String> addSoldier(@RequestBody SoldierDto dto) {
        String soldierId = null;
        try {
            soldierId = soldierService.addSoldier(dto);
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage(),e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(soldierId);
    }
}
