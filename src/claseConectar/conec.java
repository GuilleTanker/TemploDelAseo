/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package claseConectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zTGuilleTankerSz
 */
public class conec {
    static Connection conn=null;
    static Statement st=null;
    static ResultSet rs=null;
    
   
    static String bd="XE";
    static String login="root";
    static String password="SYSTEM";
    static String url="jdbc:mysql://localhost/aseo";
    
    public static Connection Enlace(Connection conn)throws SQLException    {
        try {
         Class.forName("com.mysql.jdbc.Driver");
         conn=DriverManager.getConnection(url, login, password);
         System.out.println("claseConectar.conec.Enlace()"+"Conected" );
        }
        catch(ClassNotFoundException e )
        {
            System.out.print("Clase no encontrada");
        }
        return conn;
    }
    
    public static Statement sta(Statement st)throws SQLException    {
        conn=Enlace(conn);
        st=conn.createStatement();
        return st;
    }
    public static ResultSet EnlEst(ResultSet rs)throws SQLException    {
       st=sta(st);
       rs=st.executeQuery("select * from vendedor");
        return rs;
    }
    
 public static void main(String[] args) {
     conectar coneec = new conectar();
     
      
    }
}
