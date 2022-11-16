
package Modelo;

/**
 *
 * @author jimen
 */
public class Tipo_Profesion {
    
    int idTipoProfesion;
    String nombreProfesion;

    public Tipo_Profesion() {
    }

    public Tipo_Profesion(int idTipoProfesion, String nombreProfesion) {
        this.idTipoProfesion = idTipoProfesion;
        this.nombreProfesion = nombreProfesion;
    }

    public int getIdTipoProfesion() {
        return idTipoProfesion;
    }

    public void setIdTipoProfesion(int idTipoProfesion) {
        this.idTipoProfesion = idTipoProfesion;
    }

    public String getNombreProfesion() {
        return nombreProfesion;
    }

    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }

    @Override
    public String toString() {
        return "Tipo_Profesion{" + "idTipoProfesion=" + idTipoProfesion + ", nombreProfesion=" + nombreProfesion + '}';
    }
    
    
    
}
