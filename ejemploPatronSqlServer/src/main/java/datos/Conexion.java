package datos;

import java.sql.*;

public class Conexion {
    
            
  //  private static final String JDBC_URL = "jdbc:sqlserver://LT-RULDIN-LENOV\\SQLEXPRESS2019:55847;databaseName=pdb;Integrated Security=True;";
    //private static final String JDBC_URL = "jdbc:sqlserver://LT-RULDIN-LENOV\\SQLEXPRESS2019:55847;database=pdb;user=ruldin;password=andrea";
          
            
    //private static final String JDBC_URL = "jdbc:sqlserver://LT-RULDIN-LENOV\\SQLEXPRESS2019:55847;databaseName=pdb;Integrated Security=True;";
    private static final String JDBC_URL = "jdbc:sqlite:C:\\DBSQLite\\final.db";
//    private static final String JDBC_USER = "root";
//    private static final String JDBC_PASS = "";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }
    
    
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
