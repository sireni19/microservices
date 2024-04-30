package by.prokopovich.ms.soldiermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Представляет объект SoldierDto, который используется для преобразования входящих данных JSON.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
    public class SoldierDto {
    private String lastName;
    private String firstName;
    private String patronymic;
}
