package com.example.tsdmhp3p1fggv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentMostrar extends Fragment {
    private Datos datos;

    public FragmentMostrar() {
        // Constructor vacío requerido
    }

    public static FragmentMostrar newInstance(Datos datos) {
        FragmentMostrar fragment = new FragmentMostrar();
        Bundle args = new Bundle();
        args.putParcelable("datos", datos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            datos = getArguments().getParcelable("datos");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mostrar, container, false);

        // Mostrar los datos recibidos en los TextView
        if (datos != null) {
            ((TextView) view.findViewById(R.id.tvNombre)).setText("Nombre: " + datos.getNombre());
            ((TextView) view.findViewById(R.id.tvEdad)).setText("Edad: " + datos.getEdad());
            ((TextView) view.findViewById(R.id.tvCorreo)).setText("Correo: " + datos.getCorreo());
            ((TextView) view.findViewById(R.id.tvSexo)).setText("Sexo: " + datos.getSexo());
            ((TextView) view.findViewById(R.id.tvTelefono)).setText("Teléfono: " + datos.getTelefono());
        }

        // Manejo del botón "Regresar" para volver a FragmentDatos
        Button btnRegresar = view.findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDatos fragmentDatos = new FragmentDatos();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedorFragment, fragmentDatos);
                transaction.addToBackStack(null);
                transaction.commit();

                // Notificar a PrincipalActivity para habilitar el botón "Enviar Datos"
                if (getActivity() instanceof PrincipalActivity) {
                    ((PrincipalActivity) getActivity()).habilitarBotonEnviar();
                }
            }
        });

        return view;
    }
}