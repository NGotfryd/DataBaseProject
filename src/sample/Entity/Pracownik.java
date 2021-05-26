package sample.Entity;

public class Pracownik {

    private Integer id;
    private String imie;
    private String nazwisko;
    private String PESEL;
    private String stanowisko;
    private Integer zarobki;
    private Integer kierownik;
    private String miasto;
    private String ulica;
    private Integer nrDomu;
    private Integer nrMieszkania;
    private String kodPocztowy;

    public Pracownik(Integer id, String imie, String nazwisko, String PESEL, String stanowisko, Integer zarobki, Integer kierownik, String miasto, String ulica, Integer nrDomu, Integer nrMieszkania, String kodPocztowy) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.stanowisko = stanowisko;
        this.zarobki = zarobki;
        this.kierownik = kierownik;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.kodPocztowy = kodPocztowy;
    }

    public Pracownik(Integer id, String imie, String nazwisko, String PESEL, String stanowisko, Integer zarobki, String miasto, String ulica, Integer nrDomu, Integer nrMieszkania, String kodPocztowy) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.stanowisko = stanowisko;
        this.zarobki = zarobki;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.kodPocztowy = kodPocztowy;
    }

    public Pracownik(Integer id, String imie, String nazwisko, String PESEL, String stanowisko, Integer zarobki, String miasto, String ulica, Integer nrDomu, String kodPocztowy) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.stanowisko = stanowisko;
        this.zarobki = zarobki;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.kodPocztowy = kodPocztowy;
    }

    public Pracownik(Integer id, String imie, String nazwisko, String PESEL, String stanowisko, Integer zarobki, Integer kierownik, String miasto, String ulica, Integer nrDomu, String kodPocztowy) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.stanowisko = stanowisko;
        this.zarobki = zarobki;
        this.kierownik = kierownik;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.kodPocztowy = kodPocztowy;
    }

    public Integer getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public Integer getZarobki() {
        return zarobki;
    }

    public Integer getKierownik() {
        return kierownik;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public Integer getNrDomu() {
        return nrDomu;
    }

    public Integer getNrMieszkania() {
        return nrMieszkania;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public void setZarobki(Integer zarobki) {
        this.zarobki = zarobki;
    }

    public void setKierownik(Integer kierownik) {
        this.kierownik = kierownik;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setNrDomu(Integer nrDomu) {
        this.nrDomu = nrDomu;
    }

    public void setNrMieszkania(Integer nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
