package conexionBBDD;

import java.sql.*;


public class conexionBBDD {
	Connection conexion = null;

    public conexionBBDD() {
    }
    
    public Connection conectorSQLite() {
        Connection conector = null;
        try {
            //Cargamos el driver
            Class.forName("org.sqlite.JDBC");
            //Establecemos la conexión con la base de datos
            conector = DriverManager.getConnection("jdbc:sqlite:BBDDProyecto.db");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conector;
    }

    public Connection conectorBBDD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

}
