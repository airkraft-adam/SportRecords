package adam.biegi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Runner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String czas;
    private String imie;
    private String nazwisko;


    public Runner() {
    }

    public Runner(Integer id, String imie, String nazwisko, String czas) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.czas = czas;
    }

    public Runner(String imie, String nazwisko, String czas) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.czas = czas;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getCzas() {
        return czas;
    }

    public void setCzas(String czas) {
        this.czas = czas;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "id=" + id +
                ", czas='" + czas + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}


