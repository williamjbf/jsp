package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionDB {

    private static final String db = "jdbc:postgresql://172.18.0.2:5432/jsp?autoReconnect=true";
    private static final String userDB = "postgres";
    private static final String passwordDB = "postgres";
    private static Connection connection = null;

    static {
        toConnect();
    }

    public SingleConnectionDB() {
        toConnect();
    }

    public static Connection getConnection() {
        return connection;
    }

    private static void toConnect(){
        try{

            if(connection == null){
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(db,userDB,passwordDB);
                connection.setAutoCommit(false);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
