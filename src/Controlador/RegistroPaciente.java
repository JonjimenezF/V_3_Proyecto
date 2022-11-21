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
public class RegistroPaciente {

    public boolean agregarPaciente(Paciente paciente) {
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "INSERT INTO paciente(RunPaciente,pNombrePaciente,sNombrePaciente,aPaternoPaciente,aMaternoPaciente,edad,celular) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, paciente.getRunPaciente());
            stmt.setString(2, paciente.getpNombrePaciente());
            stmt.setString(3, paciente.getsNombrePaciente());
            stmt.setString(4, paciente.getaPaternoPaciente());
            stmt.setString(5, paciente.getaMaternoPaciente());
            stmt.setInt(6, paciente.getEdad());
            stmt.setInt(7, paciente.getCelular());

            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL agregar, " + e.getMessage());
            return false;
        }

    }

    public boolean eliminarPaciente(int run) {
        boolean flag = false;

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "DELETE FROM paciente WHERE runPaciente = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, run);

            int resp = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "eliminar Paciente", 1);
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

    public boolean actualizarPaciente(int id, String pnombreNew, String snombreNew, String aPaternoNew, String aMaternoNew, int edadNew, int celularNew) {

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "UPDATE paciente SET pNombrePaciente = ? , sNombrePaciente = ?, aPaternoPaciente = ?, aMaternoPaciente = ?, edad = ?, celular = ? WHERE runPaciente = ?";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setString(1, pnombreNew);
            stmt.setString(2, snombreNew);
            stmt.setString(3, aPaternoNew);
            stmt.setString(4, aMaternoNew);
            stmt.setInt(5, edadNew);
            stmt.setInt(6, celularNew);
            stmt.setInt(7, id);

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

    public Paciente buscarPacienteN(int id) {
        Paciente p = new Paciente();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM paciente WHERE runPaciente = ? ";
            PreparedStatement stmt = cnx.prepareCall(query);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p.setRunPaciente(rs.getInt("runPaciente"));
                p.setpNombrePaciente(rs.getString("pNombrePaciente"));
                p.setsNombrePaciente(rs.getString("sNombrePaciente"));
                p.setaPaternoPaciente(rs.getString("aPaternoPaciente"));
                p.setaMaternoPaciente(rs.getString("aMaternoPaciente"));
                p.setEdad(rs.getInt("edad"));
                p.setCelular(rs.getInt("celular"));

            }

            rs.close();
            stmt.close();
            cnx.close();

        } catch (SQLException e) {
            System.out.println("Error en la consulta SQL por buscar M, " + e.getMessage());

        }

        return p;
    }

    public List<Paciente> buscarTodo() {

        List<Paciente> lista = new ArrayList<>();

        try {

            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();

            String query = "SELECT * FROM paciente ";
            PreparedStatement stmt = cnx.prepareCall(query);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setRunPaciente(rs.getInt("runPaciente"));
                p.setpNombrePaciente(rs.getString("pNombrePaciente"));
                p.setsNombrePaciente(rs.getString("sNombrePaciente"));
                p.setaPaternoPaciente(rs.getString("aPaternoPaciente"));
                p.setaMaternoPaciente(rs.getString("aMaternoPaciente"));
                p.setEdad(rs.getInt("edad"));
                p.setCelular(rs.getInt("celular"));

                lista.add(p);

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
