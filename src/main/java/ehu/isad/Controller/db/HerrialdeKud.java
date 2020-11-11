package ehu.isad.Controller.db;

import ehu.isad.Artista;
import ehu.isad.Herrialde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeKud {
    private static final HerrialdeKud instance = new HerrialdeKud();

    public static HerrialdeKud getInstance() {
        return instance;
    }

    private HerrialdeKud() {
    }

    public List<Herrialde> lortuHerrialdeak() {

        String query = "select izena, bandera from Herrialde";
        DBkudeatzaile dbKudeatzaile = DBkudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Herrialde> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {

                String izena = rs.getString("izena");
                String bandera = rs.getString("bandera");
                Herrialde h=new Herrialde(izena,bandera);
                emaitza.add(h);

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

    public boolean bozkatuDu(String herrialdea){
        String query = "select puntuak from Bozkaketa where bozkatuDu like '%"+herrialdea+"%' and urtea=year(now())";
        DBkudeatzaile dbKudeatzaile = DBkudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        try {
            return rs.next();
        } catch(SQLException throwables){
            throwables.printStackTrace();
            return false;
        }

    }

    public Artista lortuArtista(String Herrialde){
        String query = "select artista,abestia from Ordezkaritza where urtea=year(now()) and herrialdea like '%"+Herrialde+"%'";
        DBkudeatzaile dbKudeatzaile = DBkudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        Artista a=null;
        List<Herrialde> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {

                String izena = rs.getString("artista");
                String abestia = rs.getString("abestia");
                a=new Artista(izena,abestia);

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return a;
    }

    public int lortuPuntuak(String herrialdea){
        String query = "select puntuak from Bozkaketa where year(urtea)=year(now()) and bozkatuaIzanDa like '%"+herrialdea+"%'";
        DBkudeatzaile dbKudeatzaile = DBkudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        int puntuak=0;

        try {
            while (rs.next()) {
                puntuak = puntuak+rs.getInt("puntuak");

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return puntuak;
    }

    public List<Herrialde> top3lortu(){
        String query = "select herrialdea, bandera, puntuak from Ordezkaritza, Herrialde where izena=herrialdea and urtea=year(now()) ORDER BY puntuak desc";
        DBkudeatzaile dbKudeatzaile = DBkudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Herrialde> emaitza = new ArrayList<>();
        try {
            int i=0;
            while (rs.next() && i<3) {
                String izena = rs.getString("herrialdea");
                String bandera = rs.getString("bandera");
                int puntuak= rs.getInt("puntuak");
                Herrialde h=new Herrialde(izena,bandera);
                h.setPuntuak(puntuak);
                emaitza.add(h);
                i++;

            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return emaitza;
    }

    public void puntuakEguneratu(String nork,String nori, int puntuak,String artista){
        String query = "insert into Bozkaketa(bozkatuaIzanDa,bozkatuDu,urtea,puntuak) values('"+nori+"', '"+nork+"' ,year(now()), '"+puntuak+"')";
        DBkudeatzaile dbKudeatzaile = DBkudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        String query2="update Ordezkaritza set puntuak="+puntuak+" where herrialdea like '%"+nori+"%' and urtea=year(now()) and artista='"+artista+"'";
        ResultSet rs2 = dbKudeatzaile.execSQL(query2);
    }
}
