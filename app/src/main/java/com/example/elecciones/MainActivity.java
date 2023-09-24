package com.example.elecciones;

public class MainActivity {
    import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {

        private EditText edadEditText;
        private Button votarButton;
        private Button finalizarButton;
        private TextView ganadorTextView;
        private int votosCandidato1 = 0;
        private int votosCandidato2 = 0;
        private int votosCandidato3 = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            edadEditText = findViewById(R.id.edadEditText);
            votarButton = findViewById(R.id.votarButton);
            finalizarButton = findViewById(R.id.finalizarButton);
            ganadorTextView = findViewById(R.id.ganadorTextView);

            votarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String edadStr = edadEditText.getText().toString();
                    if (!edadStr.isEmpty()) {
                        int edad = Integer.parseInt(edadStr);
                        if (edad >= 18) {
                            realizarVoto();
                        } else {
                            Toast.makeText(MainActivity.this, "Debe ser mayor de edad para votar", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Ingrese su edad", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            finalizarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calcularGanador();
                }
            });
        }

        private void realizarVoto() {
            // Aquí puedes implementar la lógica para registrar el voto
            // Por ejemplo, puedes mostrar una lista de candidatos y permitir al usuario elegir uno.
            // Luego, incrementa el contador de votos del candidato elegido.
            // En este ejemplo, se simula el voto de manera simple.
            votosCandidato1++;
            Toast.makeText(MainActivity.this, "¡Voto registrado!", Toast.LENGTH_SHORT).show();
        }

        private void calcularGanador() {
            // Aquí debes implementar la lógica para determinar el candidato ganador y mostrarlo en ganadorTextView.
            // Por ejemplo, puedes comparar los votos de los candidatos y mostrar al ganador.
            String ganador;
            if (votosCandidato1 > votosCandidato2 && votosCandidato1 > votosCandidato3) {
                ganador = "Candidato 1";
            } else if (votosCandidato2 > votosCandidato1 && votosCandidato2 > votosCandidato3) {
                ganador = "Candidato 2";
            } else if (votosCandidato3 > votosCandidato1 && votosCandidato3 > votosCandidato2) {
                ganador = "Candidato 3";
            } else {
                ganador = "Empate";
            }
            ganadorTextView.setText("El candidato ganador es: " + ganador);
        }
    }

}
