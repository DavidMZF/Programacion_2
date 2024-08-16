package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MFSQLiteDataHelper {
    private static String mfDBPathConnection = "jdbc:sqlite:DataBase//FMEcuFauna.sqlite"; 
    private static Connection mfConn = null;
    // protected SQLiteDataHelper(){}
    
    protected static synchronized Connection openConnection() throws Exception{
        try {
            if(mfConn == null)
                mfConn = DriverManager.getConnection(mfDBPathConnection);
        } catch (SQLException e) {
             throw e;   //new Exception(e,"SQLiteDataHelper","Fallo la coneccion a la base de datos");
        } 
        return mfConn;
    }

    protected static void closeConnection() throws Exception{
        try {
            if (mfConn != null)
                mfConn.close();
        } catch (Exception e) {
            throw e;    //new Exception(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }

    //public static Connection getConnection() throws SQLException {
    //    return DriverManager.getConnection(mfDBPathConnection);
    //}
}
