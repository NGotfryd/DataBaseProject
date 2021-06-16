package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Entity.Narzedzie;
import sample.Entity.Pracownik;
import sample.Entity.Wypozyczenie;
import sample.Entity.Zlecenie;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private Tab magazynTab;

    @FXML
    private TableView<Narzedzie> TabelaNarzedzia;

    @FXML
    private TableColumn<Narzedzie, Integer> IDNarzedzieColumn;

    @FXML
    private TableColumn<Narzedzie, String> TypNarzedzieColumn;

    @FXML
    public TableColumn<Narzedzie, String> RodzajNarzezdiaColumn;

    @FXML
    private TableColumn<Narzedzie, Boolean> StanNarzedzieColumn;

    @FXML
    private TableColumn<Wypozyczenie, Date> WyporzyczenieNarzedzieColumn;

    @FXML
    public TableColumn<Narzedzie, Integer> AmortyzacjaNarzedzieColumn;

    @FXML
    private TextField txtIDNarzedzia;

    @FXML
    private TextField txtRodzajNArzedzia;

    @FXML
    private TextField txtTypNarzedzia;

    @FXML
    private TextField txtAmortyzacjaNarzedzia;

    @FXML
    private TextField txtStanNarzedzia;

    @FXML
    private Button insertNArzedzieButton;

    @FXML
    private Button updateNarzedzieButton;

    @FXML
    private Button deleteNarzedzieButton;

    @FXML
    private Button wypozyczNarzedzieButton;

    @FXML
    private Tab PracownicyTab;

    @FXML
    private TableView<Pracownik> tabelaPracownik;

    @FXML
    private TableColumn<Pracownik, Integer> idPracownikCol;

    @FXML
    private TableColumn<Pracownik, String> imiePracownikCol;

    @FXML
    private TableColumn<Pracownik, String> nazwiskoPracowikCol;

    @FXML
    private TableColumn<Pracownik, String> PESELPracownikCol;

    @FXML
    private TableColumn<Pracownik, String> stanowiskoPracownikCol;

    @FXML
    private TableColumn<Pracownik, Integer> zarobkiPracownikCol;

    @FXML
    private TableColumn<Pracownik, Integer> kierownikPracownikCol;

    @FXML
    private TableColumn<Pracownik, String> miastoPracownikCol;

    @FXML
    private TableColumn<Pracownik, String> UlicaPracownikCol;

    @FXML
    private TableColumn<Pracownik, Integer> domPracownikCol;

    @FXML
    private TableColumn<Pracownik, Integer> mieszkaniePracownikCol;

    @FXML
    private TableColumn<Pracownik, String> kodpocztowyPracownikCol;

    @FXML
    private TextField txtIDPracownik;

    @FXML
    private TextField txtImiePracownik;

    @FXML
    private TextField txtNazwiskoPracownik;

    @FXML
    private TextField txtPESELPracownik;

    @FXML
    private TextField txtStanowiskoPracownik;

    @FXML
    private TextField txtZarobkiPracownik;

    @FXML
    private TextField txtKierownikPracownika;

    @FXML
    private TextField txtMiastoPracownik;

    @FXML
    private TextField txtUlicaPracownik;

    @FXML
    private TextField txtNrDomPracownik;

    @FXML
    private TextField txtNrMieszkaniaPracownik;

    @FXML
    private TextField txtKodPocztowyPracownik;

    @FXML
    private Button insertPracownikButton;

    @FXML
    private Button updatePracownikButton;

    @FXML
    private Button deletetPracownikButton;

    @FXML
    private Button refreshPracownikButton;

    @FXML
    private Tab ZleceniaTab;

    @FXML
    private TextField txtIDZlecenia;

    @FXML
    private TextField txtNazwaZlecenia;

    @FXML
    private TextField txtTelZlecenia;

    @FXML
    private TextField txtIDataRozplecenia;

    @FXML
    private TextField txtIDKierownikaZlecenia;

    @FXML
    private TextField txtMiastoZlecenia;

    @FXML
    private TextField txtUlicaZlecenia;

    @FXML
    private TextField txtNrDomZlecenia;

    @FXML
    private Button insertZlecenieButton;

    @FXML
    private Button updateZlecenieButton;

    @FXML
    private Button deleteZlecenieButton;

    @FXML
    private TableView<Zlecenie> tablelaZlecen;

    @FXML
    private TableColumn<Zlecenie, Integer> idZleceniaCol;

    @FXML
    private TableColumn<Zlecenie, String> nazwaZleceniaCol;

    @FXML
    private TableColumn<Zlecenie, String> telZlecenieCol;

    @FXML
    private TableColumn<Zlecenie, Date> rozpoczecieZleceniaCol;

    @FXML
    private TableColumn<Zlecenie, Date> zakonczenieZleceniaCol;

    @FXML
    private TableColumn<Zlecenie, Integer> kierownikZleceniaCol;

    @FXML
    private TableColumn<Zlecenie, String> miastoZleceniaCol;

    @FXML
    private TableColumn<Zlecenie, String> ulicaZeceniaCol;

    @FXML
    private TableColumn<Zlecenie, Integer> domZleceniaCol;

    @FXML
    private TableColumn<Zlecenie, String> kodpocztowyZleceniaCol;



    public Connection getConnection() throws SQLException
    {
        Connection conn;
         try{
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd", "root", "root" );
             return conn;

         }catch(Exception ex){
            System.out.println("error: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try {
            showNarzedzie();
            showPracownik();
            showZlecenie();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void executeQuery(String query) throws SQLException {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public ObservableList<Narzedzie> getNarzedzieList() throws SQLException {

        ObservableList<Narzedzie> Narzedzielist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT `n`.`id`, `t`.`typ`, `r`.`rodzaj`, `n`.`stan`, `n`.`amortyzacja` "+
                        "FROM(( `narzedzie` n " +
                        "JOIN `typnarzedzia` t ON `t`.`id` = `n`.`typ`) " +
                        "JOIN `rodzajnarzedzia` r ON `t`.`rodzaj` = `r`.`id`);";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs =st.executeQuery(query);
            Narzedzie narzedzie;

            while(rs.next())
            {
                narzedzie = new Narzedzie(rs.getInt("id"), rs.getString("typ"), rs.getString("rodzaj"), rs.getBoolean("stan"), rs.getInt("amortyzacja"));
                Narzedzielist.add(narzedzie);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return Narzedzielist;
    }

    public void showNarzedzie() throws SQLException {
        ObservableList<Narzedzie> list = getNarzedzieList();

        IDNarzedzieColumn.setCellValueFactory(new PropertyValueFactory<Narzedzie,Integer>("id"));
        TypNarzedzieColumn.setCellValueFactory(new PropertyValueFactory<Narzedzie,String>("typ"));
        RodzajNarzezdiaColumn.setCellValueFactory(new PropertyValueFactory<Narzedzie,String>("rodzaj"));
        StanNarzedzieColumn.setCellValueFactory(new PropertyValueFactory<Narzedzie,Boolean>("stan"));
        AmortyzacjaNarzedzieColumn.setCellValueFactory(new PropertyValueFactory<Narzedzie,Integer>("amortyzacja"));

        TabelaNarzedzia.setItems(list);
    }


    @FXML
    void insertNarzedzie (ActionEvent event) throws SQLException {
       String query = "INSERT INTO `narzedzie` (`typ`, `amortyzacja`, `stan`) VALUES (" + "'"+txtTypNarzedzia.getText()+"', " + "'" + txtAmortyzacjaNarzedzia.getText() + "', " +"'"+ txtStanNarzedzia.getText() + "'" + ");";
       executeQuery(query);
       showNarzedzie();
    }

    @FXML
    void updateNarzedzie (ActionEvent event) throws SQLException {
        String query = "update narzedzie set typ ='"+txtTypNarzedzia.getText()+"',amortyzacja='"+txtAmortyzacjaNarzedzia.getText()+"', stan='"+txtStanNarzedzia.getText()+"'" +
                " where id="+txtIDNarzedzia.getText();
        executeQuery(query);
        showNarzedzie();
    }

    @FXML
    void deleteNarzedzie (ActionEvent event) throws SQLException {
        String query = "DELETE FROM narzedzie WHERE id='" + txtIDNarzedzia.getText() + "';";
        executeQuery(query);
        showNarzedzie();
    }

    @FXML
    void refreshNarzedzie(ActionEvent event) throws SQLException {
        showNarzedzie();
    }

    @FXML
    void handleMouseActionN(ActionEvent event)
    {
        Narzedzie narzedzie = TabelaNarzedzia.getSelectionModel().getSelectedItem();
        txtIDNarzedzia.setText(narzedzie.getId().toString());
        txtRodzajNArzedzia.setText(narzedzie.getRodzaj());
        txtTypNarzedzia.setText(narzedzie.getTyp());
        txtAmortyzacjaNarzedzia.setText(narzedzie.getAmortyzacja().toString());
        if(narzedzie.getStan())
            txtStanNarzedzia.setText("true");
        else
            txtStanNarzedzia.setText("false");

    }


    /********************************8
     *       PRACOWNICY             *
     *                              */


    public ObservableList<Pracownik> getPracownikList() throws SQLException {

        ObservableList<Pracownik> Pracowniklist = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT `pi`.`id`, `pi`.`imie`, `pi`.`nazwisko`, `pi`.`pesel`, `s`.`nazwa`, `pi`.`zarobki`, `p`.`kierownik`, `a`.`miasto`, `a`.`ulica`, `a`.`nr_domu`, `a`.`nr_mieszkania`, `a`.`kod_pocztowy`\n" +
                "    FROM(((( `pracownikinfo` pi \n" +
                "\tJOIN `pracownik` p ON `pi`.`id` = `p`.`id`) \n" +
                "\tJOIN `stanowisko` s ON `s`.`id` = `p`.`stanowisko`)\n" +
                "    JOIN `kierownik` k ON  `k`.id = `p`.`stanowisko`)\n" +
                "    JOIN `adres` a ON `a`.`id` = `pi`.`adres`);";
        Statement st;
        ResultSet rs;

        try{
            st = conn.createStatement();
            rs =st.executeQuery(query);
            Pracownik pracownik;

            while(rs.next())
            {
                pracownik = new Pracownik(rs.getInt("id"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("PESEL"), rs.getString("nazwa"),
                        rs.getInt("zarobki"), rs.getInt("kierownik"), rs.getString("miasto"), rs.getString("ulica"), rs.getInt("nr_domu"),
                         rs.getInt("nr_mieszkania"), rs.getString("kod_pocztowy"));
                Pracowniklist.add(pracownik);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return Pracowniklist;
    }

    public void showPracownik() throws SQLException {
        ObservableList<Pracownik> list = getPracownikList();

        idPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,Integer>("id"));
        imiePracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("imie"));
        nazwiskoPracowikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("nazwisko"));
        PESELPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("PESEL"));
        stanowiskoPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("stanowisko"));
        zarobkiPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,Integer>("zarobki"));
        kierownikPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,Integer>("kierownik"));
        miastoPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("miasto"));
        UlicaPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("ulica"));
        domPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,Integer>("nrDomu"));
        mieszkaniePracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,Integer>("nrMieszkania"));
        kodpocztowyPracownikCol.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("kodPocztowy"));
        tabelaPracownik.setItems(list);
    }

    @FXML
    void insertPracownik (ActionEvent event) throws SQLException {
        String query = "INSERT INTO `adres` (`miasto`, `ulica`, `nr_domu`,`nr_mieszkania`,`kod_pocztowy`) VALUES (" + "'"+txtMiastoPracownik.getText()+"', " + "'" + txtUlicaPracownik.getText() + "', " +"'"+ txtNrDomPracownik.getText() + "'"
                           + "`" + txtNrMieszkaniaPracownik.getText() +  "`" + "`" + txtKodPocztowyPracownik.getText() +"`" +")" + "INSERT INTO `pracownikinfo` (`imie`, `nazwisko`, `pesel`, `zarobki`, `adres`) VALUES"
                + "(`" + txtImiePracownik.getText() + "`," + "`" + txtNazwiskoPracownik.getText() + "`," + "`" + txtZarobkiPracownik.getText() + "`, select adres.id form adres order by id desc limit 1,"
                + "insert into `pracownik` (`stanowisko`, `kierownik`) values (" + "'select stanowisko.id form stanowisko where nazwa = '" + txtStanowiskoPracownik.getText() +"` , '" + txtKierownikPracownika.getText()+"'";

        executeQuery(query);
        showPracownik();
    }

    @FXML
    void updatePracownik (ActionEvent event) throws SQLException {
        String query = "update narzedzie set typ ='"+txtTypNarzedzia.getText()+"',amortyzacja='"+txtAmortyzacjaNarzedzia.getText()+"', stan='"+txtStanNarzedzia.getText()+"'" +
                " where id="+txtIDNarzedzia.getText();
        executeQuery(query);
        showPracownik();
    }

    @FXML
    void deletePracownik (ActionEvent event) throws SQLException {
        String query = "DELETE FROM pracownik WHERE id='" + txtIDPracownik.getText() + "';";
        executeQuery(query);
        showPracownik();
    }


/********************************8
 *      ZLECENIA          *
 *                              */

public ObservableList<Zlecenie> getZlecenieList() throws SQLException {

    ObservableList<Zlecenie> Zlecenielist = FXCollections.observableArrayList();
    Connection conn = getConnection();
    String query = "SELECT `z`.`id`, `zl`.`nazwa`, `zl`.`telefon`, `z`.`data_zlecenia`, `z`.`data_zakonczenia`, `z`.`kierownik`, `a`.`miasto`, `a`.`ulica`,`a`.`nr_domu`,`a`.`kod_pocztowy`\n" +
            "    FROM(( `zlecenie` z \n" +
            "\tJOIN `zleceniodawca` zl ON `zl`.`id` = `z`.`id`) \n" +
            "\tJOIN `adres` a ON `z`.`adres_budowy` = `a`.`id`);";
    Statement st;
    ResultSet rs;

    try{
        st = conn.createStatement();
        rs =st.executeQuery(query);
        Zlecenie zlecenie;

        while(rs.next())
        {
            zlecenie = new Zlecenie(rs.getInt("id"), rs.getString("nazwa"), rs.getString("telefon"), rs.getDate("data_zlecenia"), rs.getDate("data_zakonczenia"),
                    rs.getInt("kierownik"),rs.getString("miasto"),rs.getString("ulica"), rs.getInt("nr_domu"),rs.getString("kod_pocztowy"));
            Zlecenielist.add(zlecenie);
        }
    }catch(Exception ex)
    {
        ex.printStackTrace();
    }

    return Zlecenielist;
}

    public void showZlecenie() throws SQLException {
        ObservableList<Zlecenie> list = getZlecenieList();

        idZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,Integer>("id"));
        nazwaZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,String>("nazwaZlecenia"));
        telZlecenieCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,String>("telZlecenia"));
        rozpoczecieZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,Date>("poczatekZlecenia"));
        zakonczenieZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,Date>("koniecZlecenia"));
        kierownikZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,Integer>("kierownik"));
        miastoZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,String>("miasto"));
        ulicaZeceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,String>("ulica"));
        domZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,Integer>("nrDomu"));
        kodpocztowyZleceniaCol.setCellValueFactory(new PropertyValueFactory<Zlecenie,String>("kodPocztowy"));

        tablelaZlecen.setItems(list);
    }

    @FXML
    void insertZlecenie (ActionEvent event) throws SQLException {
        String query = "INSERT INTO `narzedzie` (`typ`, `amortyzacja`, `stan`) VALUES (" + "'"+txtTypNarzedzia.getText()+"', " + "'" + txtAmortyzacjaNarzedzia.getText() + "', " +"'"+ txtStanNarzedzia.getText() + "'" + ");";
        executeQuery(query);
        showNarzedzie();
    }

    @FXML
    void updateZlecenie (ActionEvent event) throws SQLException {
        String query = "update narzedzie set typ ='"+txtTypNarzedzia.getText()+"',amortyzacja='"+txtAmortyzacjaNarzedzia.getText()+"', stan='"+txtStanNarzedzia.getText()+"'" +
                " where id="+txtIDNarzedzia.getText();
        executeQuery(query);
        showNarzedzie();
    }

    @FXML
    void deleteZlecenie (ActionEvent event) throws SQLException {
        String query = "DELETE FROM narzedzie WHERE id='" + txtIDNarzedzia.getText() + "';";
        executeQuery(query);
        showNarzedzie();
    }


    public void WypozyczNarzedzie(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../sample/resources/Wypozycz.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = (Stage) wypozyczNarzedzieButton.getScene().getWindow();
        stage.setScene(new Scene(root1));
        stage.show();

    }
}