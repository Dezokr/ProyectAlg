
package ejercicio.pkg4;
import java.sql.*;
import javax.swing.JOptionPane;
public class conexion {
    Connection con=null;
    public conexion(){
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Brayan\\Desktop\\paciente.accdb");
            Statement st=con.createStatement();

            
            JOptionPane.showMessageDialog(null,"Conexion exitosa");   
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Conexion erronea"+e);
        }
        
    }
    public Connection getConnection() 
    {
        return con;
    }
        
        
    }

