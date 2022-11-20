package Modelo;

/**
 *
 * @author jimen
 */
public class Paciente {
    
    private int runPaciente,edad,celular;
    private String pNombrePaciente, sNombrePaciente,aPaternoPaciente,aMaternoPaciente;

    public Paciente() {
    }

    public Paciente(int runPaciente, int edad, int celular, String pNombrePaciente, String sNombrePaciente, String aPaternoPaciente, String aMaternoPaciente) {
        this.runPaciente = runPaciente;
        this.edad = edad;
        this.celular = celular;
        this.pNombrePaciente = pNombrePaciente;
        this.sNombrePaciente = sNombrePaciente;
        this.aPaternoPaciente = aPaternoPaciente;
        this.aMaternoPaciente = aMaternoPaciente;
    }

    public int getRunPaciente() {
        return runPaciente;
    }

    public void setRunPaciente(int runPaciente) {
        this.runPaciente = runPaciente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getpNombrePaciente() {
        return pNombrePaciente;
    }

    public void setpNombrePaciente(String pNombrePaciente) {
        this.pNombrePaciente = pNombrePaciente;
    }

    public String getsNombrePaciente() {
        return sNombrePaciente;
    }

    public void setsNombrePaciente(String sNombrePaciente) {
        this.sNombrePaciente = sNombrePaciente;
    }

    public String getaPaternoPaciente() {
        return aPaternoPaciente;
    }

    public void setaPaternoPaciente(String aPaternoPaciente) {
        this.aPaternoPaciente = aPaternoPaciente;
    }

    public String getaMaternoPaciente() {
        return aMaternoPaciente;
    }

    public void setaMaternoPaciente(String aMaternoPaciente) {
        this.aMaternoPaciente = aMaternoPaciente;
    }

    @Override
    public String toString() {
        return "Paciente{" + "runPaciente=" + runPaciente + ", edad=" + edad + ", celular=" + celular + ", pNombrePaciente=" + pNombrePaciente + ", sNombrePaciente=" + sNombrePaciente + ", aPaternoPaciente=" + aPaternoPaciente + ", aMaternoPaciente=" + aMaternoPaciente + '}';
    }
    
    
    
   
    
}
