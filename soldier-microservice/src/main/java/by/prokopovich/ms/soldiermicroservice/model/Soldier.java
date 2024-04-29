package by.prokopovich.ms.soldiermicroservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "soldier")
@Getter
@Setter
@NoArgsConstructor
public class Soldier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    @Column(name = "weapon_number")
    private String weaponNumber = "not assigned";

    public Soldier(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.weaponNumber = weaponNumber;
    }
}
