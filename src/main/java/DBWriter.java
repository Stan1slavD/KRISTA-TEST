import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
}
