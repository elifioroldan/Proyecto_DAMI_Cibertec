package com.example.proyecto_dami.models

import java.util.Date

data class VentaCLS(
    val id_venta:Int,
val id_usu:Int,
val nombrepersonaventa:String,
val total_venta:Double,
val fec_venta:Date,
val activo_ventaval :String,
val  lista:List<DetalleCLS>

)
