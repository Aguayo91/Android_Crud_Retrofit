package heartom.edu.simplecrud;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class PacienteDialog extends DialogFragment {

    Button btnRegistrar,btnCancelar;
    EditText etNombre,etPaterno,etMaterno;
    Comunicator comunicator;

    public PacienteDialog() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        comunicator = (Comunicator) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_paciente_dialog, container, false);
        iniciarControles(v);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paciente paciente = new Paciente();
                paciente.setNombres(etNombre.getText().toString());
                paciente.setApPaterno(etPaterno.getText().toString());
                paciente.setApMaterno(etMaterno.getText().toString());
                comunicator.RegistrarPaciente(paciente);
                dismiss();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return v;
    }

    private void iniciarControles(View v){
        btnRegistrar = (Button) v.findViewById(R.id.btnRegistrar);
        btnCancelar = (Button) v.findViewById(R.id.btnCancelar);
        etNombre  = (EditText) v.findViewById(R.id.etNombre);
        etMaterno = (EditText) v.findViewById(R.id.etMaterno);
        etPaterno = (EditText) v.findViewById(R.id.etPaterno);
    }


    public interface Comunicator{
        void RegistrarPaciente(Paciente paciente);
    }

}
