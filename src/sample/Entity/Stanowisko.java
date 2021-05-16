package sample.Entity;

public class Stanowisko {

    private int id;
    private String nazwa;

    public Stanowisko(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
