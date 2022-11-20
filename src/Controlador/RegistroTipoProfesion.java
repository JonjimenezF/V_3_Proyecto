package Controlador;

import BD.Conexion;
import Modelo.Tipo_Profesion;
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
public class RegistroTipoProfesion {

    public boolean agregarTipoProfesion(Tipo_Profesion tipoProfesion) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO tipo_profesion(nombreProfesion) VALUES (?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, tipoProfesion.getNombreProfesion());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL agregar, " + e.getMessage());
            return false;
        }

    }
//Eliminar tipo profesion

    public boolean eliminarTipoProfesion(String nombre) {
        boolean flag = false;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM tipo_profesion WHERE nombreProfesion = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombre);

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "eliminar tipo profesion", 1);
            if (resp == 0) {
                stmt.executeUpdate();
                stmt.close();
                cnx.close();
                flag = true;

            }

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL eliminar, " + e.getMessage());
            flag = false;
        }
        return flag;

    }

    //Actualizar la tabla
    public boolean actualizarTipoProfesion(String nombre, String nombreNew) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE tipo_profesion SET nombreProfesion = ? WHERE nombreProfesion = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombreNew);
            stmt.setString(2, nombre);

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            System.out.println(nombreNew);
            System.out.println(nombre);
            return true;

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL actualizar, " + e.getMessage());
            return false;
        }
    }


    //Buscar por nombre
    
    public Tipo_Profesion buscarTipoProfesion(String nombre) {
        Tipo_Profesion tp = new Tipo_Profesion();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM tipo_profesion WHERE nombreProfesion = ? ";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, nombre);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tp.setIdTipoProfesion(rs.getInt("idTipoProfesion"));
                tp.setNombreProfesion(rs.getString("nombreProfesion"));

            }

            
            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL por buscar nombre, " + e.getMessage());

        }

        return tp;
    }


    //Buscar TODO
    public List<Tipo_Profesion> buscarTodo() {

        List<Tipo_Profesion> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM tipo_profesion ";
            PreparedStatement stmt = cnx.prepareCall(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tipo_Profesion tp = new Tipo_Profesion();
                tp.setIdTipoProfesion(rs.getInt("idTipoProfesion"));
                tp.setNombreProfesion(rs.getString("nombreProfesion"));

                lista.add(tp);

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
