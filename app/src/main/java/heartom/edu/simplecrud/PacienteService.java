package heartom.edu.simplecrud;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PacienteService {

    @GET("api/Pacientes")
    Call<List<Paciente>> getPacientes();

    @POST("api/Pacientes")
    Call<Paciente> registrarPaciente(@Body Paciente paciente);
}
