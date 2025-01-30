package tn.esprit.stationski.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@ToString
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAbon ;
    private LocalDate dateDebut ;
    private LocalDate datefin ;
    private Float prixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon ;
}
