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
public class Skieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;
    private String nomS;
    private String prenomS ;
    private LocalDate dateNaissance;
    private String ville ;

    @ManyToMany(mappedBy="skieurs", cascade = CascadeType.ALL)
    private Set<Piste> pistes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="skieur")
    private Set<Inscription> Inscriptions;

    @OneToOne
    private Abonnement abonnement;
}
