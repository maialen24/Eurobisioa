package ehu.isad;

public class Herrialde {
    String izena;
    String bandera;
    String tv;

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
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
        this.bandera = bandera;
    }
}
