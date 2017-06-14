package heartom.edu.simplecrud;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PacienteService {

    @GET("api/Pacientes")
    Call<List<Paciente>> getPacientes();
}
