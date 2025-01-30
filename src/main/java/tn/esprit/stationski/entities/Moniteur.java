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
public class Moniteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMoniteur ;
    private String nomM;
    private String prenomM;
    private LocalDate dateRecru ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cours > cours ;
}
