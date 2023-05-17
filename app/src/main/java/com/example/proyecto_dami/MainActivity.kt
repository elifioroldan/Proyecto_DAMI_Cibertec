package com.example.proyecto_dami

import android.R
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.proyecto_dami.databinding.ActivityMainBinding
import com.example.proyecto_dami.interfaces.ApiInteface
import com.example.proyecto_dami.models.CategoriaCLS
import com.example.proyecto_dami.models.UsuarioCLS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception
import java.lang.StringBuilder

const val BASE_URL="http://onlinezero-001-site1.itempurl.com/api/"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIngresar.setOnClickListener {
            try {
                // some code
                var nombre= binding.txtusuario.editText?.text.toString();
                var contra= binding.txtcontra.editText?.text.toString();

                var retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL).build().create(ApiInteface::class.java)
                val ousu = UsuarioCLS(nom_usu = nombre, contra_usu = contra, id_usu = 0, activo_usu = "", id_per = 0,
                    id_tipousu = 0, nom_per = "", nom_tipousu = "")
                var retrofitdata= retrofitBuilder.getDataUsuario(ousu)

                retrofitdata.enqueue(object : Callback<UsuarioCLS?>{

                    override fun onResponse(
                        call: Call<UsuarioCLS?>,
                        response: Response<UsuarioCLS?>
                    ) {
                        var responseBody = response.body()!!
                        var idusu= responseBody.id_usu
                        if (idusu!=0){
                            alertView("Se inicio sessión");
                        }else{
                            alertView("Usuario o contraseña incorrecta");
                        }
                    }

                    override fun onFailure(call: Call<UsuarioCLS?>, t: Throwable) {
                        alertView("Ocurrio un error");
                    }


                })
            } catch (e: Exception) {
                // handler
                alertView(e.message.toString());

            }







        }
    }


    private fun alertView(message: String) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Hello")
            .setMessage(message) //     .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            //      public void onClick(DialogInterface dialoginterface, int i) {
            //          dialoginterface.cancel();
            //          }})
            .setPositiveButton("Ok",
                DialogInterface.OnClickListener { dialoginterface, i -> }).show()
    }



}