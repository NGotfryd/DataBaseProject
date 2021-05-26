package sample.Entity;

public class RodzajNarzedzia {

    private int id;
    private String rodzaj;

    public RodzajNarzedzia(int id, String rodzaj) {
        this.id = id;
        this.rodzaj = rodzaj;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public int getId() {
        return id;
    }

    public String getRodzaj() {
        return rodzaj;
    }
}
