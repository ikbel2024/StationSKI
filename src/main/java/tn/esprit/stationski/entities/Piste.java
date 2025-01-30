package tn.esprit.stationski.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor
@ToString
public class Piste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String nomPiste ;
    @Enumerated(EnumType.STRING)
    private Couleur couleur ;
    private int longeur ;
    private int pente ;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Skieur> skieurs;
}
