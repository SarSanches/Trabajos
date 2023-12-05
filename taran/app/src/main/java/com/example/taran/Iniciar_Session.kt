package com.example.taran
import AdminSQLiteOpenHelper
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taran.Menu
import com.example.taran.R
import com.example.taran.inciarsession

class Iniciar_Session : AppCompatActivity() {

    // Referencia a la clase SQLiteOpenHelper para acceder a la base de datos
    private val dbHelper = AdminSQLiteOpenHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_session)

        val nombreEditText: EditText = findViewById(R.id.editTextText)
        val contrasenaEditText: EditText = findViewById(R.id.editTextTextPassword3)
        val buttonIniciarSesion: Button = findViewById(R.id.button2)

        buttonIniciarSesion.setOnClickListener {
            val nombreUsuario = nombreEditText.text.toString()
            val contrasena = contrasenaEditText.text.toString()

            if (verificarCredenciales(nombreUsuario, contrasena)) {
                // Credenciales correctas, ir a la pantalla del menú
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
            } else {
                // Credenciales incorrectas, mostrar mensaje de error
                Toast.makeText(this, "Nombre o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        // Bloque relacionado con el botón tx
        val tx: View = findViewById(R.id.tx)
        tx.setOnClickListener {
            val intent = Intent(this, inciarsession::class.java)
            startActivity(intent)
        }
    }

    private fun verificarCredenciales(nombreUsuario: String, contrasena: String): Boolean {
        // Obtener una referencia de la base de datos en modo lectura
        val db = dbHelper.readableDatabase

        // Definir las columnas que deseamos consultar
        val columnas = arrayOf(
            AdminSQLiteOpenHelper.COLUMN_NOMBRE,
            AdminSQLiteOpenHelper.COLUMN_CONTRASENA
        )

        // Definir la cláusula WHERE para la consulta
        val seleccion = "${AdminSQLiteOpenHelper.COLUMN_NOMBRE} = ? AND ${AdminSQLiteOpenHelper.COLUMN_CONTRASENA} = ?"

        // Argumentos para la cláusula WHERE
        val argumentos = arrayOf(nombreUsuario, contrasena)

        // Realizar la consulta
        val cursor = db.query(
            AdminSQLiteOpenHelper.TABLE_NAME,
            columnas,
            seleccion,
            argumentos,
            null,
            null,
            null
        )

        // Verificar si se obtuvo algún resultado
        val resultado = cursor.count > 0

        // Cerrar el cursor y la base de datos
        cursor.close()
        db.close()

        return resultado
    }
}
