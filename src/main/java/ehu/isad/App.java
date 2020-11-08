/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ehu.isad;

import ehu.isad.Controller.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private Herrialde herrialdea;

    private Parent erroreaUI;
    private Parent hasieraUI;
    private Parent herrialdeaHautatuUI;
    private Parent top3UI;
    private Parent bozkatuTaulaUI;

    private Stage stage;

    private ErroreaKud erroreakud;
    private HasieraKud hasieraKud;
    private HerrialdeaHautatuKud herrialdeaHautatuKud;
    private TOP3Kud top3Kud;
    private BozkaketaTaulaKud bozkatuTaulaKud;





    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        pantailakKargatu();

        stage.setTitle("EUROVISION");
        stage.setScene(new Scene(hasieraUI, 450, 275));
        stage.show();
    }

    private void pantailakKargatu() throws IOException {

        FXMLLoader loaderHasiera = new FXMLLoader(getClass().getResource("/Hasiera.fxml"));
        hasieraUI = (Parent) loaderHasiera.load();
        hasieraKud = loaderHasiera.getController();
        hasieraKud.setMainApp(this);


        FXMLLoader loaderMain = new FXMLLoader(getClass().getResource("/HerrialdeaHautatu.fxml"));
        herrialdeaHautatuUI = (Parent) loaderMain.load();
        herrialdeaHautatuKud = loaderMain.getController();
        herrialdeaHautatuKud.setMainApp(this);

        FXMLLoader loaderError = new FXMLLoader(getClass().getResource("/Errorea.fxml"));
        erroreaUI = (Parent) loaderError.load();
        erroreakud = loaderError.getController();
        erroreakud.setMainApp(this);

        FXMLLoader loaderTaula = new FXMLLoader(getClass().getResource("/BozkatuTaula.fxml"));
        bozkatuTaulaUI = (Parent) loaderTaula.load();
        bozkatuTaulaKud = loaderTaula.getController();
        bozkatuTaulaKud.setMainApp(this);

        FXMLLoader loaderTop3 = new FXMLLoader(getClass().getResource("/TOP3.fxml"));
        top3UI = (Parent) loaderTop3.load();
        top3Kud = loaderTop3.getController();
        top3Kud.setMainApp(this);
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void hasieraErakutsi() {
        stage.setScene(new Scene(hasieraUI));
        stage.show();
        stage.setTitle("EUROBISIOA");

    }
    public void HerrialdeaHautatuErakutsi() {
        stage.setScene(new Scene(herrialdeaHautatuUI));
        stage.show();
        stage.setTitle("Informazioaren eguneraketa");

    }

    public void erroreaErakutsi() {
        stage.setScene(new Scene(erroreaUI));
        erroreakud.hasieratu();
        stage.show();
        stage.setTitle(herrialdea.izena+" inguruko informazioa");

    }

    public void BozkatuTaulaErakutsi() {
        stage.setScene(new Scene(bozkatuTaulaUI));
        bozkatuTaulaKud.hasieratu();
        stage.show();
        stage.setTitle("Bozkaketa panela");


    }
    public void TOP3Erakutsi() {
        stage.setScene(new Scene(top3UI));
        stage.show();
        stage.setTitle("Datuak sartu");

    }

    public String hIzena(){
        return herrialdea.izena;
    }

    public void herrialdeaEzarri(Herrialde h){
        herrialdea=h;
    }

    public void itxi(){
        stage.close();
    }
    public Herrialde lortuH(){
        return herrialdea;
    }
}
