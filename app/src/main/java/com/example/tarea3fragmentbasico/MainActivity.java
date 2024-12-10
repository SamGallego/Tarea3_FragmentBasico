package com.example.tarea3fragmentbasico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private EditText editTextText;
    private Button actualizarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextText = findViewById(R.id.editTextText);
        actualizarButton = findViewById(R.id.actualizar);


        actualizarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String texto = editTextText.getText().toString();

                // Crea una nueva instancia del fragmento con el texto como argumento
                MiFragmento miFragmento = MiFragmento.newInstance(texto);

                // Reemplaza el contenido del FragmentContainerView con el nuevo fragmento
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, miFragmento);
                fragmentTransaction.commit();
            }
        });

    }


}
