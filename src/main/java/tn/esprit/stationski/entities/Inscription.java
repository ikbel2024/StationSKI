package tn.esprit.stationski.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@NoArgsConstructor
@ToString
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInscription ;
    private Integer numSemaine ;

    @ManyToOne
    Skieur skieur;

    @ManyToOne
    Cours cours;
}
