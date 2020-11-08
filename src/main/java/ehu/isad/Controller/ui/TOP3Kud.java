package ehu.isad.Controller.ui;

import ehu.isad.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TOP3Kud implements Initializable {

    private App mainApp;

    @FXML
    private ImageView eurobisioImage;

    @FXML
    private Label top3;

    @FXML
    private TableView<?> topTaula;

    @FXML
    private TableColumn<?, ?> banderakZut;

    @FXML
    private TableColumn<?, ?> puntuakZut;

    @FXML
    private Button OKbutton;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.itxi();
    }
    public void setMainApp(App main) {
        this.mainApp = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image image = new Image(getClass().getResourceAsStream("/Eurovision_Song_Contest.png"));
        eurobisioImage.setImage(image);
    }

}