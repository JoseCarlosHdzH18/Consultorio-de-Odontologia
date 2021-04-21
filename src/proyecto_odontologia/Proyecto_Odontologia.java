package proyecto_odontologia;

import ConexionMySQL.Conectar;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proyecto_Odontologia { 
    //https://fernando-gaitan.com.ar/conectar-java-con-mysql-en-netbeans/
    public static Connection conexion = null;
    
    public static void main(String[] args) {
        try {
            conexion = Conectar.obtener();
            LogIn.LogIn Iniciar = new LogIn.LogIn();
            Iniciar.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Proyecto_Odontologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean Consultar(String usuario, String pass){
        try {
            String inst = "SELECT * FROM usuario";
            PreparedStatement consulta = conexion.prepareStatement(inst );
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                String nombreMysql = resultado.getString("Nombre");
                String passMysql = resultado.getString("Pass");
                System.out.println(nombreMysql + "   Contra: " + passMysql);
                if(nombreMysql.equals(usuario) && passMysql.equals(pass)){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Proyecto_Odontologia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
