package sample.Entity;

public class Narzedzie {

    private Integer id;
    private String typ;
    private String rodzaj;
    private Boolean stan;
    private Integer amortyzacja;

    public Narzedzie(Integer id, String typ, String rodzaj, Boolean stan, Integer amortyzacja) {
        this.id = id;
        this.typ = typ;
        this.rodzaj = rodzaj;
        this.stan = stan;
        this.amortyzacja = amortyzacja;
    }

    public Integer getId() {
        return id;
    }

    public String getTyp() {
        return typ;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public Boolean getStan() {
        return stan;
    }

    public Integer getAmortyzacja() {
        return amortyzacja;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public void setStan(Boolean stan) {
        this.stan = stan;
    }

    public void setAmortyzacja(Integer amortyzacja) {
        this.amortyzacja = amortyzacja;
    }
}
