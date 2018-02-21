package com.iesemilidarder.projectcloud.core.base;

/* Importamos las distintas librias */

import com.iesemilidarder.projectcloud.core.dao.Opiniones;
import com.iesemilidarder.projectcloud.core.dao.Restaurants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/* Creamos una clases llamada readDB y realizamos la conexion a una base de datos */

public class ReadDB {

    public final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public final static String THIN_URL = "jdbc:oracle:thin:@35.205.41.45:1521:XE";
    public final static String USER = "usuari";
    public final static String PASSWORD = "usuari";

    private static Restaurants RestaurantsDB(ResultSet rs) {

        try {
            String codigo = rs.getString("RES_CODI");
            String nombre = rs.getString("RES_NOM");
            String direccion = rs.getString("RES_ADRECA");
            String web = rs.getString("RES_WEB");
            String telefono = rs.getString("RES_TELEFON");
            String descripcion = rs.getString("TRS_DESCRIPCIO");
            String imagen = rs.getString("RES_URL_IMG");
            String media = rs.getString("RES_MITJANA");

            Restaurants restaurant = new Restaurants();
            restaurant.setCodigo(codigo);
            restaurant.setNombre(nombre);
            restaurant.setDireccion(direccion);
            restaurant.setWeb(web);
            restaurant.setTelefono(telefono);
            restaurant.setDescripcion(descripcion);
            restaurant.setImagen(imagen);
            restaurant.setMedia(media);
            return restaurant;

        } catch (Exception e) {
            return null;
        }
    }


    public ArrayList readRestaurants(String buscar) {
        ArrayList rest = new ArrayList();
        try {
            /* Aqui nos conectamos a la base de datos le indicamos la IP, Puerto, Usuario y Contraseña */
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");
            Statement stmt = con.createStatement();
            ResultSet rs;

            if (buscar == null) {
                rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_MITJANA, T.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS T WHERE R.RES_TRS_CODI = T.TRS_CODI ORDER BY RES_MITJANA DESC");
            } else {
                rs = stmt.executeQuery("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON, R.RES_URL_IMG, R.RES_MITJANA, T.TRS_DESCRIPCIO FROM RESTAURANTS R, TRESTAURANTS T WHERE R.RES_TRS_CODI = T.TRS_CODI AND LOWER (RES_NOM) LIKE '%" + buscar.toLowerCase() + "%'");

            }
            while (rs.next()) {
                String nombre = rs.getString("RES_NOM");
                String direccion = rs.getString("RES_ADRECA");
                String web = rs.getString("RES_WEB");
                String telefono = rs.getString("RES_TELEFON");
                String descripcion = rs.getString("TRS_DESCRIPCIO");
                String imagen = rs.getString("RES_URL_IMG");
                String media = rs.getString("RES_MITJANA");
                String codigo = rs.getString("RES_CODI");

                Restaurants rstnt = new Restaurants();
                rstnt.setNombre(nombre);
                rstnt.setDireccion(direccion);
                rstnt.setWeb(web);
                rstnt.setTelefono(telefono);
                rstnt.setDescripcion(descripcion);
                rstnt.setImagen(imagen);
                rstnt.setMedia(media);
                rstnt.setCodigo(codigo);
                rest.add(rstnt);
            }
            stmt.close();
            con.close();


        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rest;
    }


    /**
     * Version funcinal proyecto Alberto
     **/

    public static Restaurants leerRestaurante(String id) {
        Restaurants restaurant = null;
        try {
            String sql = ("SELECT R.RES_CODI, R.RES_NOM, R.RES_ADRECA, R.RES_WEB, R.RES_TELEFON,\n" +
                    "  R.RES_URL_IMG, R.RES_MITJANA, R.RES_LATITUD, R.RES_LONGITUD, T.TRS_DESCRIPCIO\n" +
                    "FROM RESTAURANTS R\n" +
                    "JOIN TRESTAURANTS T ON R.RES_TRS_CODI=T.TRS_CODI\n" +
                    "WHERE R.RES_CODI = " + id + "");

            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                restaurant = RestaurantsDB(rs);
            }

            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return restaurant;
    }


/*Arraylist para leer las opiniones de los usuarios sobre los restaurantes*/

    public ArrayList readOpinions(String id) {

        ArrayList arrayOpinions = new ArrayList();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@35.205.41.45:1521:XE", "usuari", "usuari");

            Statement stmt = con.createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT O.OPI_OBSERVACIO, O.OPI_PUNTUACIO, U.USU_NOM FROM OPINIONS O\n" +
                    "JOIN USUARIS U ON U.USU_CODI = O.OPI_USU_CODI\n" +
                    "JOIN RESTAURANTS R ON O.OPI_RES_CODI = R.RES_CODI\n" +
                    "WHERE R.RES_CODI = " + id + "");

            while (rs.next()) {

                String observacion = rs.getString("OPI_OBSERVACIO");
                String puntuacion = rs.getString("OPI_PUNTUACIO");
                String nombreUsu = rs.getString("USU_NOM");

                Opiniones opiniones = new Opiniones();

                opiniones.setObservacion(observacion);
                opiniones.setPuntuacion(puntuacion);
                opiniones.setNombreUsu(nombreUsu);
                arrayOpinions.add(opiniones);

            }
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arrayOpinions;
    }


    /**
     * Version funcinal proyecto Alberto
     **/

    public static List LeerRestaurantsAPI() {
        List<Restaurants> LeerRestaurantsAPI = new ArrayList<>();

        try {
            String sql = "SELECT R.RES_CODI,R.RES_NOM,R.RES_ADRECA,R.RES_WEB,R.RES_TELEFON,R.RES_URL_IMG,R.RES_MITJANA, TR.TRS_DESCRIPCIO " + "FROM RESTAURANTS R,TRESTAURANTS TR " + "WHERE  R.RES_TRS_CODI = TR.TRS_CODI";

            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(THIN_URL, USER, PASSWORD);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMapper<Restaurants> mapper = new ResultSetMapper<>();
            LeerRestaurantsAPI = mapper.mapResultSetToObject(rs, Restaurants.class);
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return LeerRestaurantsAPI;
    }
}
/* David Rojas Julia */
/* 2º ASIX */