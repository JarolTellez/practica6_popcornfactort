package mx.edu.itson.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button=findViewById(R.id.botonP)

        button.setOnClickListener {
            var intento=Intent(this, Catalogo::class.java)
            this.startActivity(intento)
        }
    }
}