package ehu.isad;

import java.awt.*;
import javafx.scene.image.Image;
public class Herrialde {
    String izena;
    Image bandera;
    int puntuak=0;
    String tv;
    String banderaPath;
    String izenArtistikoa;
    String abestia;


    public String getIzenArtistikoa() {
        return izenArtistikoa;
    }

    public void setIzenArtistikoa(String izenArtistikoa) {
        this.izenArtistikoa = izenArtistikoa;
    }



    public void setAbestia(String pabestia) {
        this.abestia = pabestia;
    }



    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public void setPuntuak(int p) {
        this.puntuak=p;
    }
    public int getPuntuak() {
        return puntuak;
    }
    public Image getBandera(){
        return bandera;
    }

    public String getBanderaPath() {
        return banderaPath;
    }

    public void setBandera(String bandera) {
        this.bandera = new Image("/Banderak/"+bandera+".png") {
        };
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    @Override
    public String toString() {
        return "Herrialde{" +
                "izena='" + izena + '\'' +
                ", bandera='" + bandera + '\'' +
                ", tv='" + tv + '\'' +
                '}';
    }

    public Herrialde(String izena, String bandera) {
        this.izena = izena;
        this.bandera = new Image("/Banderak/"+bandera+".png");
        this.banderaPath=bandera;
    }

    public void setArtista(String pizenArtistikoa) {
        izenArtistikoa=pizenArtistikoa;
    }
}
