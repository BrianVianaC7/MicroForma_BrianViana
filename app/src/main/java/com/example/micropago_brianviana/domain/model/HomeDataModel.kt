package com.example.micropago_brianviana.domain.model

import com.example.micropago_brianviana.data.network.response.HomeDataResponse
import com.google.gson.annotations.SerializedName

data class HomeDataModel(
    var idAr: Int? = null,
    var noAr: String? = null,
    var segmento: Int? = null,
    var isKeyAccount: Int? = null,
    var horasGarantia: Int? = null,
    var horasAtencion: Int? = null,
    var idCliente: Int? = null,
    var descCliente: String? = null,
    var isWincor: Int? = null,
    var noAfiliacion: String? = null,
    var fecalta: String? = null,
    var fecGarantia: String? = null,
    var idServicio: Int? = null,
    var descServicio: String? = null,
    var sintoma: String? = null,
    var concepto: String? = null,
    var descCorta: String? = null,
    var bitacora: String? = null,
    var notasRemedy: String? = null,
    var descEquipo: String? = null,
    var equipo: String? = null,
    var noSerie: String? = null,
    var direccion: String? = null,
    var colonia: String? = null,
    var poblacion: String? = null,
    var estado: String? = null,
    var cp: String? = null,
    var descNegocio: String? = null,
    var idNegocio: Int? = null,
    var telefono: String? = null,
    var idStatusAr: Int? = null,
    var idProducto: Int? = null,
    var idRegion: Int? = null,
    var idUnidadAtendida: Int? = null,
    var fecAtencion: String? = null,
    var caja: String? = null,
    var fecCierre: String? = null,
    var idStatusValidacionPrefacturacion: Int? = null,
    var fecAltaPref: String? = null,
    var comentario: String? = null,
    var noSim: String? = null,
    var claveRechazo: String? = null,
    var idFalla: Int? = null,
    var descSoftware: String? = null,
    var descConectividad: String? = null,
    var totalImagenes: Int? = null,
    var idMovInventario: Int? = null,
    var km: Int? = null,
    var isLocal: Int? = null,
    var notViaticos: Int? = null
)

fun HomeDataResponse.toDomain() = HomeDataModel(
    idAr = idAr,
    noAr = noAr,
    segmento = segmento,
    isKeyAccount = isKeyAccount,
    horasGarantia = horasGarantia,
    horasAtencion = horasAtencion,
    idCliente = idCliente,
    descCliente = descCliente,
    isWincor = isWincor,
    noAfiliacion = noAfiliacion,
    fecalta = fecalta,
    fecGarantia = fecGarantia,
    idServicio = idServicio,
    descServicio = descServicio,
    sintoma = sintoma,
    concepto = concepto,
    descCorta = descCorta,
    bitacora = bitacora,
    notasRemedy = notasRemedy,
    descEquipo = descEquipo,
    equipo = equipo,
    noSerie = noSerie,
    direccion = direccion,
    colonia = colonia,
    poblacion = poblacion,
    estado = estado,
    cp = cp,
    descNegocio = descNegocio,
    idNegocio = idNegocio,
    telefono = telefono,
    idStatusAr = idStatusAr,
    idProducto = idProducto,
    idRegion = idRegion,
    idUnidadAtendida = idUnidadAtendida,
    fecAtencion = fecAtencion,
    caja = caja,
    fecCierre = fecCierre,
    idStatusValidacionPrefacturacion = idStatusValidacionPrefacturacion,
    fecAltaPref = fecAltaPref,
    comentario = comentario,
    noSim = noSim,
    claveRechazo = claveRechazo,
    idFalla = idFalla,
    descSoftware = descSoftware,
    descConectividad = descConectividad,
    totalImagenes = totalImagenes,
    idMovInventario = idMovInventario,
    km = km,
    isLocal = isLocal,
    notViaticos = notViaticos
)