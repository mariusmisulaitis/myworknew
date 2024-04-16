package lt.mariusworks.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Knyga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String autorius;
    private String pavadinimas;
    private Integer metai;
    private String zanras;
    private String vieta;

}
