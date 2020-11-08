package ehu.isad.Controller.ui;

import ehu.isad.App;
import ehu.isad.Artista;
import ehu.isad.Controller.db.HerrialdeKud;
import ehu.isad.Herrialde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BozkaketaTaulaKud implements Initializable {

    private App mainApp;

    @FXML
    private ImageView BanderaImage;

    @FXML
    private ImageView EurovisionImage;

    @FXML
    private Label info;

    @FXML
    private TableView<Herrialde> bozkatuTaula;

    @FXML
    private TableColumn<Herrialde,Image> banderakZut;

    @FXML
    private TableColumn<Herrialde,String> herrialdeaZut;

    @FXML
    private TableColumn<Herrialde,String> artistaZut;

    @FXML
    private TableColumn<Herrialde,String > abestiaZut;

    @FXML
    private TableColumn<Herrialde, Integer> puntuakZut;

    int p=0;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.TOP3Erakutsi();
    }

    public void setMainApp(App main) {
        this.mainApp = main;
    }


    public void hasieratu(){
     //   Image image1 = new Image(getClass().getResourceAsStream("/Banderak/"+mainApp.hIzena()+".png"));
        BanderaImage.setImage(mainApp.lortuH().getBandera());
        info.setText(mainApp.hIzena()+" horrela nahi ditu bere puntuak banatu:");

        List<Herrialde> HerrialdeList = HerrialdeKud.getInstance().lortuHerrialdeak();
        ObservableList<Herrialde> herrialdeak = FXCollections.observableArrayList(HerrialdeList);

        for(int i=0;i<HerrialdeList.size();i++){

            herrialdeaZut.setCellValueFactory(new PropertyValueFactory<>("izena"));
            puntuakZut.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
            String iz=HerrialdeList.get(i).getIzena();
            Artista a=HerrialdeKud.getInstance().lortuArtista(HerrialdeList.get(i).getIzena());
            if(a!=null) {
                HerrialdeList.get(i).setArtista(a.getIzenArtistikoa());
                HerrialdeList.get(i).setAbestia(a.getAbestia());

                artistaZut.setCellValueFactory(new PropertyValueFactory<>("izenArtistikoa"));
               // abestiaZut.setCellValueFactory(new PropertyValueFactory<>("abestia"));
            }


            Callback<TableColumn<Herrialde, Integer>, TableCell<Herrialde,Integer>> defaultTextFieldCellFactory
                    = TextFieldTableCell.<Herrialde,Integer>forTableColumn(new IntegerStringConverter());

            puntuakZut.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
            puntuakZut.setCellFactory(col -> {
                TableCell<Herrialde, Integer> cell = defaultTextFieldCellFactory.call(col);

                cell.setOnMouseClicked(event -> {
                    if (! cell.isEmpty()) {
                        if (cell.getTableView().getSelectionModel().getSelectedItem().getIzena().equals(mainApp.hIzena())) {
                            cell.setEditable(false);
                        }else if(p<5){
                            cell.setEditable(true);
                        }
                    }
                });

                return cell ;
            });
         //   puntuakZut.setCellFactory(
                 //   TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

            puntuakZut.setCellFactory(TextFieldTableCell.<Herrialde,Integer>forTableColumn(new IntegerStringConverter()));

            // Nola gorde balio berria modeloan
            // On Cell edit commit (for puntuakZut column)
            if(p<5) {
                puntuakZut.setOnEditCommit((TableColumn.CellEditEvent<Herrialde, Integer> event) -> {

                    TablePosition<Herrialde, Integer> pos = event.getTablePosition();
                    int row = pos.getRow();
                    Herrialde h = event.getTableView().getItems().get(row);

                    Integer puntuak = event.getNewValue();
                    h.setPuntuak(puntuak);
                    p = p + puntuak;

                });
            }

            bozkatuTaula.refresh();
            banderakZut.setCellValueFactory(new PropertyValueFactory<Herrialde, Image>("bandera"));

            banderakZut.setCellFactory(p -> new TableCell<>() {
                public void updateItem(Image image, boolean empty) {
                    if (image != null && !empty){
                        final ImageView imageview = new ImageView();
                        imageview.setFitHeight(14);
                        imageview.setFitWidth(20);
                        imageview.setImage(image);
                        setGraphic(imageview);
                        setAlignment(Pos.CENTER);
                        // tbData.refresh();
                    }else{
                        setGraphic(null);
                        setText(null);
                    }
                }
            });

        }
        bozkatuTaula.setItems(herrialdeak);
        int guztira=0;
        ArrayList<Integer> puntuakJaso=new ArrayList<>();
        for(int i=0;i<HerrialdeList.size();i++){
            guztira=guztira+HerrialdeList.get(i).getPuntuak();
            if(HerrialdeList.get(i).getPuntuak()!=0){
                puntuakJaso.add(i);
            }
        }
        if(guztira<=5){
            for(int a=0;a<puntuakJaso.size();a++) {
                HerrialdeKud.getInstance().puntuakEguneratu(mainApp.hIzena(),HerrialdeList.get(a).getIzena(),HerrialdeList.get(a).getPuntuak());
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image image = new Image(getClass().getResourceAsStream("/Eurovision_Song_Contest.png"));
        EurovisionImage.setImage(image);
        bozkatuTaula.setEditable(true);

        /*

        List<Herrialde> HerrialdeList = HerrialdeKud.getInstance().lortuHerrialdeak();
        ObservableList<Herrialde> herrialdeak = FXCollections.observableArrayList(HerrialdeList);

        for(int i=0;i<HerrialdeList.size();i++){

            herrialdeaZut.setCellValueFactory(new PropertyValueFactory<>("izena"));
            String iz=HerrialdeList.get(i).getIzena();
            Artista a=HerrialdeKud.getInstance().lortuArtista(HerrialdeList.get(i).getIzena());
            if(a!=null) {
                HerrialdeList.get(i).setArtista(a.getIzenArtistikoa());
                HerrialdeList.get(i).setAbestia(a.getAbestia());

                artistaZut.setCellValueFactory(new PropertyValueFactory<>("izenArtistikoa"));
                abestiaZut.setCellValueFactory(new PropertyValueFactory<>("abestia"));
            }

            puntuakZut.setCellFactory(
                    TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

            Callback<TableColumn<Herrialde, String>, TableCell<Herrialde, String>> defaultTextFieldCellFactory
                    = TextFieldTableCell.<Herrialde>forTableColumn();

            puntuakZut.setCellValueFactory(new PropertyValueFactory<>("puntuak"));
            puntuakZut.setCellFactory(col -> {
                TableCell<Herrialde, String> cell = defaultTextFieldCellFactory.call(col);

                cell.setOnMouseClicked(event -> {
                    if (! cell.isEmpty()) {
                        if (cell.getTableView().getSelectionModel().getSelectedItem().getIzena().equals(mainApp.hIzena())) {
                            cell.setEditable(false);
                        }else {
                            cell.setEditable(true);
                        }
                    }
                });

                return cell ;
            });
            banderakZut.setCellValueFactory(new PropertyValueFactory<Herrialde, Image>("bandera"));

            banderakZut.setCellFactory(p -> new TableCell<>() {
                public void updateItem(Image image, boolean empty) {
                    if (image != null && !empty){
                        final ImageView imageview = new ImageView();
                        imageview.setFitHeight(14);
                        imageview.setFitWidth(20);
                        imageview.setImage(image);
                        setGraphic(imageview);
                        setAlignment(Pos.CENTER);
                        // tbData.refresh();
                    }else{
                        setGraphic(null);
                        setText(null);
                    }
                };
            });

        }
        bozkatuTaula.setItems(herrialdeak);*/
    }
}
