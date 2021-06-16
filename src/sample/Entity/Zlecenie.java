package sample.Entity;

import java.util.Date;

public class Zlecenie {

    private Integer id;
    private String nazwaZlecenia;
    private String telZlecenia;
    private Date poczatekZlecenia;
    private Date koniecZlecenia;
    private Integer kierownik;
    private String miasto;
    private String ulica;
    private Integer nrDomu;
    private String kodPocztowy;


    public Zlecenie(Integer id, String nazwaZlecenia, String telZlecenia, Date poczatekZlecenia, Date koniecZlecenia, Integer kierownik, String miasto, String ulica, Integer nrDomu, String kodPocztowy) {
        this.id = id;
        this.nazwaZlecenia = nazwaZlecenia;
        this.telZlecenia = telZlecenia;
        this.poczatekZlecenia = poczatekZlecenia;
        this.koniecZlecenia = koniecZlecenia;
        this.kierownik = kierownik;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.kodPocztowy = kodPocztowy;
    }

    public Integer getId() {
        return id;
    }

    public String getNazwaZlecenia() {
        return nazwaZlecenia;
    }

    public String getTelZlecenia() {
        return telZlecenia;
    }

    public Date getPoczatekZlecenia() {
        return poczatekZlecenia;
    }

    public Date getKoniecZlecenia() {
        return koniecZlecenia;
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

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNazwaZlecenia(String nazwaZlecenia) {
        this.nazwaZlecenia = nazwaZlecenia;
    }

    public void setTelZlecenia(String telZlecenia) {
        this.telZlecenia = telZlecenia;
    }

    public void setPoczatekZlecenia(Date poczatekZlecenia) {
        this.poczatekZlecenia = poczatekZlecenia;
    }

    public void setKoniecZlecenia(Date koniecZlecenia) {
        this.koniecZlecenia = koniecZlecenia;
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

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
