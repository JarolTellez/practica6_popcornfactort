package mx.edu.itson.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView



class detalle_pelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_image: ImageView=findViewById(R.id.iv_pelicula_imagen)
        val tv_nombre_pelicula: TextView=findViewById(R.id.tv_nombre_pelicula)
        val tv_pelicula_desc: TextView=findViewById(R.id.tv_pelicula_desc)
        val seatsLeft:TextView=findViewById(R.id.seatLeft)
        val buyTickets:Button=findViewById(R.id.buyTickets)

      val bundle=intent.extras
        var ns=0
        var id=-1
        var title=""
      if(bundle!=null){
          ns=bundle.getInt("seats")
          title=bundle.getString("titulo")!!
          iv_pelicula_image.setImageResource(bundle.getInt("header"))
          tv_nombre_pelicula.setText(bundle.getString("titulo"))
          tv_pelicula_desc.setText(bundle.getString("sinopsis"))
          seatsLeft.setText("$ns seats available")
          id=bundle.getInt("pos")

      }

        if(ns==0){
            buyTickets.isEnabled=false;
        }else{
            buyTickets.isEnabled=true
            buyTickets.setOnClickListener{
                val intent: Intent=Intent(this, SeatSelection::class.java)
                intent.putExtra("id",id)
                intent.putExtra("name",title)

                this.startActivity(intent)
            }
        }


    }
}