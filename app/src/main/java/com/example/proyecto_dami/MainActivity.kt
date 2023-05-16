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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

const val BASE_URL="http://onlinezero-001-site1.itempurl.com/api/"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIngresar.setOnClickListener {
            alertView("Hola");

            var nombre= binding.txtusuario.editText?.text.toString();
            var contra= binding.txtcontra.editText?.text.toString();

            var retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build().create(ApiInteface::class.java)

            var retrofitdata= retrofitBuilder.getData()

            retrofitdata.enqueue(object : Callback<List<CategoriaCLS>?>{

                override fun onResponse(
                    call: Call<List<CategoriaCLS>?>,
                    response: Response<List<CategoriaCLS>?>
                ) {
                    alertView("Data");

                    var responseBody = response.body()!!
                   //  var myStringBuilder= StringBuilder()
                   for(myData in responseBody){
                       alertView(myData.nom_cat);

                   }
                }

                override fun onFailure(call: Call<List<CategoriaCLS>?>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })





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