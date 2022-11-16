
package Modelo;

/**
 *
 * @author jimen
 */
public class Medico {

   
    
    int runMedico,idTipoProfesion;
    String pNombre,sNombre,aPaterno,aMaterno;
    

    public Medico() {
    }

    public Medico(int runMedico, int idTipoProfesion, String pNombre, String sNombre, String aPaterno, String aMaterno) {
        this.runMedico = runMedico;
        this.idTipoProfesion = idTipoProfesion;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
    }

    public int getRunMedico() {
        return runMedico;
    }

    public void setRunMedico(int runMedico) {
        this.runMedico = runMedico;
    }

    public int getIdTipoProfesion() {
        return idTipoProfesion;
    }

    public void setIdTipoProfesion(int idTipoProfesion) {
        this.idTipoProfesion = idTipoProfesion;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    @Override
    public String toString() {
        return "Medico{" + "runMedico=" + runMedico + ", idTipoProfesion=" + idTipoProfesion + ", pNombre=" + pNombre + ", sNombre=" + sNombre + ", aPaterno=" + aPaterno + ", aMaterno=" + aMaterno + '}';
    }

    
    

    
   
    
}
