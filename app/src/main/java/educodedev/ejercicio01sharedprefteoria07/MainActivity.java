package educodedev.ejercicio01sharedprefteoria07;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario, txtPassword;
    private Button btnLogin;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();

        sp = getSharedPreferences(Constantes.LOGIN, MODE_PRIVATE);

        String usuario = sp.getString(Constantes.USUARIO, "");
        String password = sp.getString(Constantes.PASSWORD, "");

        if (!usuario.isEmpty() && !password.isEmpty()) {
            txtUsuario.setText(usuario);
            txtPassword.setText(password);


                Intent intent = new Intent(MainActivity.this, Second.class);
                startActivity(intent);
                finish();


        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = txtUsuario.getText().toString();
                String password = txtPassword.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString(Constantes.USUARIO, usuario);
                editor.putString(Constantes.PASSWORD, password);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, Second.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void inicializarVistas() {

        txtUsuario = findViewById(R.id.txtUsuarioMain);
        txtPassword = findViewById(R.id.txtPasswordMain);
        btnLogin = findViewById(R.id.btnLoginMain);

    }
}