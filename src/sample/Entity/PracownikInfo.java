package sample.Entity;



public class PracownikInfo  {

    private int id;
    private String imie;
    private String nazwisko;
    private String pesel;
    private int zarobki;
    private Adres pracownikAdres;

    public PracownikInfo(String imie, String nazwisko, String pesel, int zarobki, Adres pracownikAdres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.zarobki = zarobki;
        this.pracownikAdres = pracownikAdres;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setZarobki(int zarobki) {
        this.zarobki = zarobki;
    }

    public void setPracownikAdres(Adres pracownikAdres) {
        this.pracownikAdres = pracownikAdres;
    }

    public int getId() {
        return id;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public int getZarobki() {
        return zarobki;
    }

    public Adres getPracownikAdres() {
        return pracownikAdres;
    }
}
