package tn.esprit.stationski.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private     long numInscri;
    private     int numSemaine;
    @ManyToOne
    @JsonIgnore
    private  Skieur skieur;
    @ManyToOne
    private    Cours cours;
}
