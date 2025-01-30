package tn.esprit.stationski.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@ToString
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur ;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance ;
    private String ville ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="cours")
    private Set<Inscription> Inscriptions;


}
