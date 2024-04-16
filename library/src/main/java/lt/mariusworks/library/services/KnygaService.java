package lt.mariusworks.library.services;

import lombok.AllArgsConstructor;
import lt.mariusworks.library.entities.Knyga;
import lt.mariusworks.library.repositories.KnygaRepository;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class KnygaService {

    private KnygaRepository knygaRepository;

    public void pridetiKnyga(String autorius, String pavadinimas, Integer metai, String zanras, String vieta) {
        Knyga knyga = new Knyga();
        knyga.setPavadinimas(pavadinimas);
        knyga.setAutorius(autorius);
        knyga.setMetai(metai);
        knyga.setZanras(zanras);
        knyga.setVieta(vieta);

        this.knygaRepository.saveAndFlush(knyga);
    }

    public void istrintiKnygaPagalId(Long id) {
        for (Knyga k : this.knygaRepository.findAll()) {
            if (k.getId().equals(id)) {
                this.knygaRepository.delete(k);
            }
        }
    }

    public void atnaujintiKnygaPagalId(Long id, String vieta) {
        for (Knyga k : this.knygaRepository.findAll()) {
            if (k.getId().equals(id)) {
                k.setVieta(vieta);
                this.knygaRepository.saveAndFlush(k);
            }
        }
    }

    public void knygosPagalZanra(String zanras) {

        System.out.println("Knygos pagal pasirinkta zanra: " + zanras);
        for (Knyga k : this.knygaRepository.findAllByZanras(zanras)) {
            System.out.println(k);
        }
    }


    public void SiuMetuKnygosPagalZanra() {

        System.out.println("Siu metu knygos pagal zanra: fantastika");
        for (Knyga k : this.knygaRepository.getAllByMetaiAndZanras(2024, "fantastika")) {
            System.out.println(k);
        }
    }

    public void SiuMetuKnygosPagalZanraSkaicius() {

        System.out.println("Siu metu knygu skaicius pagal zanra: fantastika");
        System.out.println(this.knygaRepository.countByMetaiAndZanras(2024, "fantastika"));
    }
}

