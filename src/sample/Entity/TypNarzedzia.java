package sample.Entity;

public class TypNarzedzia {

    private int id;
    private String typ;
    private int rodzaj;

    public TypNarzedzia(int id, String typ, int rodzaj) {
        this.id = id;
        this.typ = typ;
        this.rodzaj = rodzaj;
    }

    public int getId() {
        return id;
    }

    public String getTyp() {
        return typ;
    }

    public int getRodzaj() {
        return rodzaj;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setRodzaj(int rodzaj) {
        this.rodzaj = rodzaj;
    }
}
