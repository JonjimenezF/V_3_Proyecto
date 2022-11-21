
package Modelo;

import java.util.Date;

/**
 *
 * @author jimen
 */
public class Atencion {
    
    private int id_Atencion;
    private String hora;
    private Date fecha;
    private int runMedico;
    private int runPaciente;

    public Atencion() {
    }

    public Atencion(int id_Atencion, String hora, Date fecha, int runMedico, int runPaciente) {
        this.id_Atencion = id_Atencion;
        this.hora = hora;
        this.fecha = fecha;
        this.runMedico = runMedico;
        this.runPaciente = runPaciente;
    }

    public int getId_Atencion() {
        return id_Atencion;
    }

    public void setId_Atencion(int id_Atencion) {
        this.id_Atencion = id_Atencion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getRunMedico() {
        return runMedico;
    }

    public void setRunMedico(int runMedico) {
        this.runMedico = runMedico;
    }

    public int getRunPaciente() {
        return runPaciente;
    }

    public void setRunPaciente(int runPaciente) {
        this.runPaciente = runPaciente;
    }

    @Override
    public String toString() {
        return "Atencion{" + "id_Atencion=" + id_Atencion + ", hora=" + hora + ", fecha=" + fecha + ", runMedico=" + runMedico + ", runPaciente=" + runPaciente + '}';
    }
    
    
    
}
