package adam.biegi;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RunnerRepository extends JpaRepository<Runner, Integer> {
    List<Runner> findAll();

    @Query("SELECT u FROM Runner u WHERE (u.imie = :imie) AND (u.nazwisko=:nazwisko)")
    List<Runner> findByImieAndNazwisko(@Param("imie") String imie, @Param("nazwisko") String nazwisko);

}