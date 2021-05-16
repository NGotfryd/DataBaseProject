package sample.Entity;

public class Pracownik {

    private int id;
    private int stanowisko;
    private int kierownik;

    public Pracownik(int id, int stanowisko, int kierownik) {
        this.id = id;
        this.stanowisko = stanowisko;
        this.kierownik = kierownik;
    }

    public Pracownik(int id, int stanowisko) {
        this.id = id;
        this.stanowisko = stanowisko;
    }

    public int getId() {
        return id;
    }

    public int getStanowisko() {
        return stanowisko;
    }

    public int getKierownik() {
        return kierownik;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStanowisko(int stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setKierownik(int kierownik) {
        this.kierownik = kierownik;
    }
}
