package DataAccess;

import java.sql.Connection;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:database//ExaBot2k24.sqlite";
    private static Connection conn = null;
    protected SQLiteDataHelper(){}

    
}
