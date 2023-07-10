package model.DBUnitil;

//import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;

public interface DatabaseInfo {
//    public static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=A01_RT03";
//    public static String userDB="sa";
//    public static String passDB="123456";
//    public static Connection getConnect(){
//        try {
//            Context initContext = new InitialContext();
//            Context envContext  = (Context)initContext.lookup("java:/comp/env");
//            DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
//            return ds.getConnection();
//        } catch (Exception ex) {
//            Logger.getLogger(DatabaseInfo.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    
    
        public static Connection getConnect() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=A01_RT03";
        conn = DriverManager.getConnection(url, "sa", "123456");
        return conn;
    }
    
}
