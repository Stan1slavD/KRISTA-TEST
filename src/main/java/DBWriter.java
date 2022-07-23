import java.sql.*;

public class DBWriter {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "1403";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/krista-test";

    public static void write(Catalog catalog) throws Exception {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement statement = connection.createStatement();
        int cid = catalog.getId();
        String cdate = catalog.getDate();
        String cuuid = catalog.getUuid();
        String cname = catalog.getCompany();
        String SQL_INSERT_CATALOG = "INSERT INTO public.d_cat_catalog(id, delivery_date, company, uuid) VALUES (" + cid + ",'" + cdate + "','" + cname + "','" + cuuid + "')";
        System.out.println(SQL_INSERT_CATALOG);
        statement.executeUpdate(SQL_INSERT_CATALOG);


        catalog.getPlants().forEach(p -> {
            String SQL_INSERT_PLANT = "INSERT INTO public.f_cat_plants(\n" +
                    "\tcommon, botanical, zone, light, price, availability, catalog_id)\n" +
                    "\tVALUES ('" + p.getCommon() + "','" + p.getBotanical() + "'," + p.getZone() + ",'" + p.getLight() + "','" + p.getPrice().substring(1) + "'," + p.getAvailability() + "," + catalog.getId() + ")";

            System.out.println(SQL_INSERT_PLANT);
            try {
                statement.executeUpdate(SQL_INSERT_PLANT);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public static int getMaxPlantID()throws Exception{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = connection.createStatement();
        String SQL_MAX_ID = "SELECT COUNT(common) AS res FROM f_cat_plants";
        ResultSet res= statement.executeQuery(SQL_MAX_ID);
        int max=0;
        if (res.next())
            max = res.getInt("res");
        return max;
    }
    public static int getMaxCatalogID()throws Exception{
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = connection.createStatement();
        String SQL_MAX_ID = "SELECT MAX(id) AS res FROM d_cat_catalog";
        ResultSet res= statement.executeQuery(SQL_MAX_ID);
        int max=0;
        if (res.next())
            max = res.getInt("res");
        return max;
    }
}
