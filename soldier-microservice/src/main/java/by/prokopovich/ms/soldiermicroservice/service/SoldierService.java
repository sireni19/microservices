package by.prokopovich.ms.soldiermicroservice.service;

import by.prokopovich.ms.soldiermicroservice.dto.SoldierDto;

import java.util.concurrent.ExecutionException;

public interface SoldierService {

    String addSoldier(SoldierDto dto) throws ExecutionException, InterruptedException;
}
