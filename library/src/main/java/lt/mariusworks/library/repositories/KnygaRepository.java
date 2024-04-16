package lt.mariusworks.library.repositories;

import lt.mariusworks.library.entities.Knyga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnygaRepository extends JpaRepository<Knyga, Long> {


//    Knyga[] findAllByZanras(String zanras);

    List<Knyga> findAllByZanras(String zanras);

    List<Knyga> getAllByMetaiAndZanras(Integer metai, String zanras);

    Integer countByMetaiAndZanras(Integer metai, String zanras);
}
