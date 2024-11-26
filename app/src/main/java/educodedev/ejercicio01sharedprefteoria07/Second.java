package educodedev.ejercicio01sharedprefteoria07;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Second extends AppCompatActivity {
    Button btnEliminar;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        inicializarVistas();
        sp = getSharedPreferences(Constantes.LOGIN, MODE_PRIVATE);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            SharedPreferences.Editor editor = sp.edit();
            editor.clear();
            editor.apply();


        }
    });

    }

    private void inicializarVistas() {
            btnEliminar = findViewById(R.id.btnEliminarSecond);

    }
}