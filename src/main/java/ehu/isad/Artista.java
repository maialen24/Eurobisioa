package ehu.isad;

public class Artista {

    private String izenArtistikoa;
    private int partaideKop;
    private String abestia;

    public String getIzenArtistikoa() {

        return izenArtistikoa;
    }

    public String getAbestia() {

        return abestia;
    }

    public void setIzenArtistikoa(String izenArtistikoa) {

        this.izenArtistikoa = izenArtistikoa;
    }

    public int getPartaideKop() {

        return partaideKop;
    }

    public void setPartaideKop(int partaideKop) {

        this.partaideKop = partaideKop;
    }

    public Artista(String izenArtistikoa) {

        this.izenArtistikoa = izenArtistikoa;
    }

    public void setAbestia(String pabestia) {
        abestia=pabestia;
    }
}
