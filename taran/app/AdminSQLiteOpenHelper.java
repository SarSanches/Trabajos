import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class inciarsession extends AppCompatActivity {

    private EditText nombreEditText, contrasenaEditText, confirmarContrasenaEditText;
    private Button registrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_session);  // Asegúrate de reemplazar con el nombre correcto de tu archivo XML

        // Inicializar vistas
        nombreEditText = findViewById(R.id.editTextText3);
        contrasenaEditText = findViewById(R.id.editTextTextPassword);
        confirmarContrasenaEditText = findViewById(R.id.editTextTextPassword2);
        registrarButton = findViewById(R.id.button6);

        // Configurar el evento de clic para el botón de registro
        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String nombre = nombreEditText.getText().toString();
        String contrasena = contrasenaEditText.getText().toString();
        String confirmarContrasena = confirmarContrasenaEditText.getText().toString();

        // Verificar que las contraseñas coincidan
        if (!contrasena.equals(confirmarContrasena)) {
            // Manejar el caso en que las contraseñas no coinciden
            // Puedes mostrar un mensaje de error o realizar otra acción
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Abrir la base de datos
        DatabaseManager databaseManager = new DatabaseManager(this);
        databaseManager.open();

        // Insertar el nuevo usuario en la base de datos
        long userId = databaseManager.insertUser(nombre, contrasena);

        // Cerrar la base de datos
        databaseManager.close();

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
    }
}
