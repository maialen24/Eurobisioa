package ehu.isad.Controller.ui;

import ehu.isad.App;
import ehu.isad.Controller.db.HerrialdeKud;
import ehu.isad.Herrialde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HerrialdeaHautatuKud implements Initializable {
    private App mainApp;

    @FXML
    private ImageView eurobisioImage;

    @FXML
    private Label label;

    @FXML
    private ComboBox<Herrialde> aukerak;

    @FXML
    private Button okButton;

    @FXML
    void onClick(ActionEvent event) {
    //Begiratu ia bozkatu duen

        //Bozkatu badu
        Herrialde h= new Herrialde(aukerak.getValue().getIzena(),aukerak.getValue().getBanderaPath());
        mainApp.herrialdeaEzarri(h);
        if (HerrialdeKud.getInstance().bozkatuDu(aukerak.getValue().getIzena())){
            mainApp.erroreaErakutsi();
        }else{
            mainApp.BozkatuTaulaErakutsi();
        }
    }


    public void setMainApp(App main) {
        this.mainApp = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(getClass().getResourceAsStream("/Eurovision_Song_Contest.png"));
        eurobisioImage.setImage(image);

        List<Herrialde> HerrialdeList = HerrialdeKud.getInstance().lortuHerrialdeak();
        ObservableList<Herrialde> herrialdeak = FXCollections.observableArrayList(HerrialdeList);

        aukerak.setConverter(new StringConverter<Herrialde>() {
            @Override
            public String toString(Herrialde herrialde) {
                if (herrialde==null)
                    return "";
                return herrialde.getIzena();
            }

            @Override
            public Herrialde fromString(String string) {
                return null;
            }
        });
        aukerak.setItems(herrialdeak);
        aukerak.setEditable(false);

    }

}
