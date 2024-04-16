package lt.mariusworks.library;

import lombok.AllArgsConstructor;
import lt.mariusworks.library.services.KnygaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
@SpringBootApplication
public class LibraryApplication {

    private KnygaService knygaService;

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        this.knygaService.pridetiKnyga("Autorius1", "Pavadinimas1", 2023, "fantastika", "Vilnius");
        this.knygaService.pridetiKnyga("Autorius2", "Pavadinimas2", 2024, "romanas", "Panevezys");
        this.knygaService.pridetiKnyga("Autorius3", "Pavadinimas3", 2024, "fantastika", "Klaipeda");
        this.knygaService.pridetiKnyga("Autorius4", "Pavadinimas4", 2019, "fantastika", "Siauliai");
        this.knygaService.istrintiKnygaPagalId(1L);
        this.knygaService.atnaujintiKnygaPagalId(3L, "Marijampole");
        this.knygaService.knygosPagalZanra("fantastika");
        this.knygaService.SiuMetuKnygosPagalZanra();
        this.knygaService.SiuMetuKnygosPagalZanraSkaicius();
    }

}
