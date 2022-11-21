
package Controlador;

import BD.Conexion;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    
    
    public boolean eliminarMedico(int run) {
        boolean flag = false;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM medico WHERE runMedico = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, run);

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "eliminar Medico", 1);
            if (resp == 0) {
                stmt.executeUpdate();
                stmt.close();
                cnx.close();
                flag = true;
            }

        }catch (SQLException e) {
            System.out.println("Error en la consulta SQL eliminar, " + e.getMessage());
            flag = false;
        }
        return flag;

    }
    
    
    //public boolean actualizarMedicop(String pnombre, String pnombreNew , String snombre, String snombreNew , String aPaterno,String aPaternoNew , String aMaterno , String aMaternoNew)
    public boolean actualizarMedicop(String id, String pnombreNew ,String snombreNew , String aPaternoNew , String aMaternoNew) {
 
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE medico SET pNombre = ? , sNombre = ?, aPaterno = ?, aMaterno = ? WHERE runMedico = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, pnombreNew);
            stmt.setString(2, snombreNew);
            stmt.setString(3, aPaternoNew);
            stmt.setString(4, aMaternoNew);
            stmt.setString(5, id);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            System.out.println(id);
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL actualizar, " + e.getMessage());
            return false;
        }
    }
    
    public Medico buscarMedicoN(int id) {
        Medico m = new Medico();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM medico WHERE runMedico = ? ";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                m.setRunMedico(rs.getInt("runMedico"));
                m.setpNombre(rs.getString("pNombre"));
                m.setsNombre(rs.getString("sNombre"));
                m.setaPaterno(rs.getString("aPaterno"));
                m.setaMaterno(rs.getString("aMaterno"));
                m.setIdTipoProfesion(rs.getInt("idTipoProfesion"));
                

            }

            
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL por buscar M, " + e.getMessage());

        }

        return m;
    }
    
    
    public List<Medico> buscarTodo() {

        List<Medico> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM medico ";
            PreparedStatement stmt = cnx.prepareCall(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Medico m = new Medico();
                m.setRunMedico(rs.getInt("runMedico"));
                m.setpNombre(rs.getString("pNombre"));
                m.setsNombre(rs.getString("sNombre"));
                m.setaPaterno(rs.getString("aPaterno"));
                m.setaMaterno(rs.getString("aMaterno"));
                m.setIdTipoProfesion(rs.getInt("idTipoProfesion"));

                lista.add(m);

            }

            stmt.executeUpdate();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL Buscar todo, " + e.getMessage());

        }

        return lista;
    }

}

