package ehu.isad.Controller.ui;

import ehu.isad.App;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TOP3Kud implements Initializable {

    private App mainApp;

    @FXML
    private ImageView eurobisioImage;

    @FXML
    private Label top3;

    @FXML
    private TableView<Herrialde> topTaula;

    @FXML
    private TableColumn<Herrialde, Image> banderakZut;

    @FXML
    private TableColumn<?, ?> HerrialdeZut;

    @FXML
    private TableColumn<?, ?> puntuakZut;

    @FXML
    private Button OKbutton;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.itxi();
    }
    public void refresh(){

        List<Herrialde> HerrialdeList=HerrialdeKud.getInstance().top3lortu();
        ObservableList<Herrialde> herrialdea = FXCollections.observableArrayList(HerrialdeList);

        for(int i=0;i<HerrialdeList.size();i++) {

            HerrialdeZut.setCellValueFactory(new PropertyValueFactory<>("izena"));
            puntuakZut.setCellValueFactory(new PropertyValueFactory<>("puntuak"));

            banderakZut.setCellValueFactory(new PropertyValueFactory<>("bandera"));
            banderakZut.setCellFactory(p -> new TableCell<>() {
                public void updateItem(Image image, boolean empty) {
                    if (image != null && !empty){
                        final ImageView imageview = new ImageView();
                        imageview.setFitHeight(14);
                        imageview.setFitWidth(20);
                        imageview.setImage(image);
                        setGraphic(imageview);
                        setAlignment(Pos.CENTER);


                    }else{
                        setGraphic(null);
                        setText(null);
                    }
                }
            });

        }
        topTaula.setItems(herrialdea);
        topTaula.refresh();


    }
    public void setMainApp(App main) {
        this.mainApp = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image image = new Image(getClass().getResourceAsStream("/Eurovision_Song_Contest.png"));
        eurobisioImage.setImage(image);

        top3.setText("TOP 3:");
    }
    }

