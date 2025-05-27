package com.example.tsdmhp3p1fggv;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnEnviar = findViewById(R.id.btnEnviar);

        // Cargar FragmentDatos al inicio
        cargarFragment(new FragmentDatos());

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentDatos fragmentDatos = (FragmentDatos) getSupportFragmentManager().findFragmentById(R.id.contenedorFragment);

                if (fragmentDatos != null) {
                    Datos datos = fragmentDatos.obtenerDatos();
                    if (datos != null) {
                        FragmentMostrar fragmentMostrar = FragmentMostrar.newInstance(datos);
                        cargarFragment(fragmentMostrar);

                        // Deshabilitar el botón cuando el fragment de mostrar datos está activo
                        btnEnviar.setEnabled(false);
                    }
                }
            }
        });
    }

    // Método para cambiar fragmentos y gestionar habilitación del botón
    private void cargarFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        // Habilitar el botón solo cuando `FragmentDatos` esté activo
        btnEnviar.setEnabled(fragment instanceof FragmentDatos);
    }

    // Método que será llamado desde `FragmentMostrar` para volver a habilitar el botón "Enviar Datos"
    public void habilitarBotonEnviar() {
        btnEnviar.setEnabled(true);
    }
}