package sample.Entity;

public class Adres {


    private String miasto;
    private String ulica;
    private int nrDomu;
    private int nrMieszkania;
    private String kodPocztowy;

    public Adres(String miasto, String ulica, int nrDomu, int nrMieszkania, String kodPocztowy) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNrDomu() {
        return nrDomu;
    }

    public int getNrMieszkania() {
        return nrMieszkania;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }


    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public void setNrMieszkania(int nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrDomu=" + nrDomu +
                ", nrMieszkania=" + nrMieszkania +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                '}';
    }
}
