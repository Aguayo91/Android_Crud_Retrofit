package heartom.edu.simplecrud;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PacienteActivity extends AppCompatActivity {

    private final String baseUrl = "http://192.168.1.35:7010/";
    RecyclerView rvClientes;
    FloatingActionButton fabAdd;
    List<Paciente> listaPacientes = new ArrayList<>();
    PacienteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        iniciarControles();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvClientes.setLayoutManager(llm);

        adapter = new PacienteAdapter(listaPacientes);
        rvClientes.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvClientes.getContext(),llm.getOrientation());
        rvClientes.addItemDecoration(itemDecoration);

        PacienteService pacienteService = retrofit.create(PacienteService.class);

        Call<List<Paciente>> lista = pacienteService.getPacientes();
        lista.enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {
                if(response.isSuccessful()){
                    listaPacientes = response.body();
                    adapter = new PacienteAdapter(listaPacientes);
                    rvClientes.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Paciente>> call, Throwable t) {

            }
        });


    }

    private void iniciarControles(){
        rvClientes = (RecyclerView) findViewById(R.id.rvClientes);
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
    }
}
