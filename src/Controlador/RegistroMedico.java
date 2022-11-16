
package Controlador;

import BD.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jimen
 */
public class RegistroMedico {
    
    public boolean agregarMedico(Medico medico){
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "INSERT INTO Medico(runMedico,idTipoProfesion,pNombre,sNombre,aPaterno,aMaterno) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, medico.getRunMedico());
            stmt.setInt(2, medico.getIdTipoProfesion());
            stmt.setString(3,medico.getpNombre());
            stmt.setString(4,medico.getsNombre());
            stmt.setString(5,medico.getaPaterno());
            stmt.setString(6,medico.getaMaterno());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL agregar, " + e.getMessage());
            return false;
        }
        
    }
    
    
}
