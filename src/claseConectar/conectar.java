package claseConectar;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author zTGuilleTankerSz
 */

public class conectar {
Connection conect = null;
   public Connection conexion()
    {
      try {
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://localhost/proyecto","root","SYSTEM");
           System.out.println("Conectado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
     
}
   public static void main(String[] args) {
     conectar coneec = new conectar();
     coneec.conexion();
      
    }
}
