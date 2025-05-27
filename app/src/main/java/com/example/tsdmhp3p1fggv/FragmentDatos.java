package com.example.tsdmhp3p1fggv;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentDatos extends Fragment {
    public FragmentDatos() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_datos, container, false);
    }

    // Método para obtener los datos ingresados
    public Datos obtenerDatos() {
        View view = getView();
        if (view != null) {
            String nombre = ((EditText) view.findViewById(R.id.etNombre)).getText().toString();
            String edad = ((EditText) view.findViewById(R.id.etEdad)).getText().toString();
            String correo = ((EditText) view.findViewById(R.id.etCorreo)).getText().toString();
            String sexo = ((EditText) view.findViewById(R.id.etSexo)).getText().toString();
            String telefono = ((EditText) view.findViewById(R.id.etTelefono)).getText().toString();

            return new Datos(nombre, edad, correo, sexo, telefono);
        }
        return null;
    }
}