package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Entity.Narzedzie;
import sample.Entity.Wypozyczenie;

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
    private Button refreshNarzedzieButton;

    @FXML
    private Tab PracownicyTab;

    @FXML
    private TableView<?> tabelaPracownik;

    @FXML
    private TableColumn<?, ?> idPracownikCol;

    @FXML
    private TableColumn<?, ?> imiePracownikCol;

    @FXML
    private TableColumn<?, ?> nazwiskoPracowikCol;

    @FXML
    private TableColumn<?, ?> PESELPracownikCol;

    @FXML
    private TableColumn<?, ?> stanowiskoPracownikCol;

    @FXML
    private TableColumn<?, ?> zarobkiPracownikCol;

    @FXML
    private TableColumn<?, ?> kierownikPracownikCol;

    @FXML
    private TableColumn<?, ?> miastoPracownikCol;

    @FXML
    private TableColumn<?, ?> UlicaPracownikCol;

    @FXML
    private TableColumn<?, ?> domPracownikCol;

    @FXML
    private TableColumn<?, ?> mieszkaniePracownikCol;

    @FXML
    private TableColumn<?, ?> kodpocztowyPracownikCol;

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
    private Button refreshZlecenieButton;


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





}