package ehu.isad.Controller.ui;

import ehu.isad.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaKud implements Initializable {

    private App mainApp;
    @FXML
    private ImageView eurobisioImage;

    @FXML
    private Label erroreaLabel;

    @FXML
    private Button okButton;


    public void setMainApp(App main) {
        this.mainApp = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(getClass().getResourceAsStream("/Eurovision_Song_Contest.png"));
        eurobisioImage.setImage(image);
    }
}
