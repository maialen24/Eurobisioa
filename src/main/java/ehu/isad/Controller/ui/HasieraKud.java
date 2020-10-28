package ehu.isad.Controller.ui;

import ehu.isad.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class HasieraKud implements Initializable {
    private App mainApp;

    @FXML
    private Button bozkatuButton;

    @FXML
    private ImageView eurobidioImage;

    @FXML
    void onClick(ActionEvent event) {
        mainApp.HerrialdeaHautatuErakutsi();
    }


    public void setMainApp(App main) {
        this.mainApp = main;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image image = new Image(getClass().getResourceAsStream("/Eurovision_Song_Contest.png"));
        eurobidioImage.setImage(image);
    }
}
