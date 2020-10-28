package ehu.isad.Controller.db;

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
}
