package by.prokopovich.ms.weaponmicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "weapon")
@Getter
@Setter
public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String weaponType;
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "^[A-Z]{2}\\d{6}$", message = "SERIAL NUMBER FORMAT MUST HAVE THE FORMAT: XX123456")
    @Size(min = 8, max = 8, message = "SERIAL NUMBER MUST HAVE 8 SYMBOLS")
    private String serialNumber;
    private String owner;
}
