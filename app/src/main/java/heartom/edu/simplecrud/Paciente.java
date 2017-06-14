package heartom.edu.simplecrud;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paciente {

    @SerializedName("IdPaciente")
    @Expose
    private Integer idPaciente;
    @SerializedName("ApPaterno")
    @Expose
    private String apPaterno;
    @SerializedName("ApMaterno")
    @Expose
    private String apMaterno;
    @SerializedName("Nombres")
    @Expose
    private String nombres;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}