package com.idepro.appbackendnetbank.util;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 29/10/2019.
 */
public final class ConstantsUtil {

    public static final String PARAM_ESTADO_OK = "OK";
    public static final String PARAM_ESTADO_NOK = "NOK";
    public static final String PARAM_ESTADO_ACTIVO = "1";
    public static final String PARAM_ESTADO_NO_ACTIVO = "0";
    public static final String PARAM_MARCA_BAJA_HABILITADO = "0";
    public static final String PARAM_MARCA_BAJA_NO_HABILITADO = "9";

    public static final String PARAM_MENSAJE_SIN_REGISTROS = "NO SE ENCONTRARON REGISTROS";
    public static final String PARAM_MENSAJE_YA_EXISTE_EL_REGISTRO = "YA EXISTE EL REGISTRO";
    public static final String PARAM_MENSAJE_ERROR = "UPS, OCURRIO UN ERROR";
    public static final String PARAM_MENSAJE_VACIO = "";

    public static final String PARAM_MENSAJE_RECURSO_NO_AUTORIZADO = "ACCESO NO AUTORIZADO PARA ESTE RECURSO";

    public static final String PARAM_MENSAJE_SAVE_RESET = "SE CREO EL TOKEN PARA EL RESETEO DE CONTRASEÑA, FAVOR DE VER SUS CORREOS";

    public static final String PARAM_MODEL_TOKEN = "TOKEN";
    public static final String PARAM_MODEL_USUARIO_NB = "USUARIO NETBANK";
    public static final String PARAM_MODEL_ROL = "ROL";
    public static final String PARAM_MODEL_PRESTAMO = "PRESTAMO";
    public static final String PARAM_MODEL_CLIENTE = "CLIENTE";

    public static final String PARAM_RECURSO_BUSCA_USUARIO_POR_ESTADO = "BUSCA USUARIO POR ESTADO";

    public static final String PARAM_MODEL_CLASIFICADOR = "CLASIFICADOR";
    public static final Integer PARAM_MODEL_CLASIFICADOR_TIPO_BLOQUEO = 1;
    public static final Integer PARAM_MODEL_CLASIFICADOR_ESTADO_BLOQUEO = 2;
    public static final Integer PARAM_MODEL_CLASIFICADOR_SUB_TIPO_CREDITO = 3;
    public static final Integer PARAM_MODEL_CLASIFICADOR_ESTADO = 4;
    public static final Integer PARAM_MODEL_CLASIFICADOR_ROL_WS = 5;
    public static final Integer PARAM_MODEL_CLASIFICADOR_RECURSO_WS = 6;
//    public static final Integer PARAM_MODEL_CLASIFICADOR_RECURSO_WS = 5;
    public static final String PARAM_MODEL_CLASIFICADOR_TABLA_IDPCON = "IDPCON";
    public static final String PARAM_MODEL_CLASIFICADOR_TABLA_GBCON = "GBCON";
    public static final String PARAM_MODEL_CLASIFICADOR_TABLA_PRCON = "PRCON";
    public static final String PARAM_MODEL_CLASIFICADOR_TABLA_RECON = "RECON";

    public static final String PARAM_PERSONA_NATURAL = "NATURAL";

    public static final String PARAM_MODEL_ROL_ADMIN = "1";

    public static String MENSAJE_ERROR(String mensajeError){
        return "UPS, OCURRIO UN ERROR (" +mensajeError+")";
    }

    public static String MENSAJE_ERROR_REQUEST(String mensajeError){
        return "PARAMETRO(S) DE ENTRADA INCORRECTO(S) (" +mensajeError+")";
    }

    public static final String PARAM_INGRESO = "ING";
    public static final String PARAM_INGRESOS_VENTA = "INGRESOS_VENTA";
    public static final String PARAM_INGRESOS_COSTO_UNITARIO = "COSTO_UNITARIO";
    public static final String PARAM_INGRESO_VENTA_DIARIA = "VENTA_DIARIA";
    public static final String PARAM_INGRESO_VENTA_RESPALDO = "VENTAS_RESPALDOS";
    public static final String PARAM_INGRESO_VENTA_HISTORICA_DIARIA = "VENTA_HISTORICA_DIARIA";
    public static final String PARAM_INGRESO_VENTA_HISTORICA_SEMANAL = "VENTA_HISTORICA_SEMANAL";
    public static final String PARAM_INGRESO_VENTA_HISTORICA_MENSUAL = "VENTA_HISTORICA_MENSUAL";
    public static final String PARAM_INGRESO_VENTA_SEMANAL = "VENTA_SEMANAL";
    public static final String PARAM_INGRESO_ESTACIONALIDAD = "ESTACIONALIDAD_INGRESOS";
    public static final String PARAM_INGRESO_OTROS_INGRESOS_ITEMS = "OTROS_INGRESOS_ITEMS";

    public static final String PARAM_COMPRA = "CST";
    public static final String PARAM_COMPRA_COSTOS_VENTAS = "COSTOS_VENTAS";

    public static final String PARAM_GASTO = "GST";
    public static final String PARAM_GASTOS_OPERATIVOS = "GASTOS_OPERATIVOS";
    public static final String PARAM_GASTOS_FAMILIARES = "GASTOS_FAMILIARES";

    public static final String PARAM_INVENTARIO = "INV";
    public static final String PARAM_INVENTARIO_MERCADERIA_DETALLADO = "INVENTARIO_MERCADERIA_DETALLADO";
    public static final String PARAM_INVENTARIO_MERCADERIA_GLOBAL = "INVENTARIO_MERCADERIA_GLOBAL";

    public static final String PARAM_ACTIVO = "ACT";
    public static final String PARAM_ACTIVO_CORRIENTE_EFECTIVO_CAJA = "ACTIVO_CORRIENTE_EFECTIVO_CAJA";
    public static final String PARAM_ACTIVO_CORRIENTE_DEPOSITO = "ACTIVO_CORRIENTE_DEPOSITO";
    public static final String PARAM_ACTIVO_CORRIENTE_CUENTA_POR_COBRAR = "ACTIVO_CORRIENTE_CUENTA_POR_COBRAR";
    public static final String PARAM_ACTIVO_CORRIENTE_ADELANTO_PROVEEDOR = "ACTIVO_CORRIENTE_ADELANTO_PROVEEDOR";
    public static final String PARAM_MATERIA_PRIMA = "MATERIA_PRIMA";
    public static final String PARAM_PRODUCTOS_EN_PROCESO = "PRODUCTOS_EN_PROCESO";
    public static final String PARAM_PRODUCTOS_TERMINADOS = "PRODUCTOS_TERMINADOS";

    public static final String PARAM_ACTIVO_FIJO_INMUEBLE = "ACTIVO_FIJO_INMUEBLE";
    public static final String PARAM_ACTIVO_FIJO_VEHICULO = "ACTIVO_FIJO_VEHICULO";
    public static final String PARAM_ACTIVO_FIJO_MAQUINARIA = "ACTIVO_FIJO_MAQUINARIA";
    public static final String PARAM_ACTIVO_FIJO_ENSERES_NEGOCIO = "ACTIVO_FIJO_ENSERES_NEGOCIO";
    public static final String PARAM_ACTIVO_FIJO_BIENES_HOGAR = "ACTIVO_FIJO_BIENES_HOGAR";
    public static final String PARAM_ACTIVO_FIJO_SEGUNDA_ACTIVIDAD = "ACTIVO_FIJO_SEGUNDA_ACTIVIDAD";

    public static final String PARAM_PASIVO = "PAS";
    public static final String PARAM_PASIVO_INSTITUCION_FINANCIERA = "PASIVO_INSTITUCION_FINANCIERA";

    public static final int PARAM_PRO_GRUPO_ID_ASALARIADO = 132;
    public static final int PARAM_PRO_GRUPO_ID_AGROPECUARIO = 134;
    public static final int PARAM_PRO_GRUPO_ID_COMERCIO = 129;
    public static final int PARAM_PRO_GRUPO_ID_SERVICIO = 130;
    public static final int PARAM_PRO_GRUPO_ID_PRODUCCION = 131;
    public static final String PARAM_PRO_GRUPO_NAME_ASALARIADO = "ASALARIADO";
    public static final String PARAM_PRO_GRUPO_NAME_AGROPECUARIO = "AGROPECUARIO";
    public static final String PARAM_PRO_GRUPO_NAME_COMERCIO = "COMERCIO";
    public static final String PARAM_PRO_GRUPO_NAME_SERVICIO = "SERVICIO";
    public static final String PARAM_PRO_GRUPO_NAME_PRODUCCION = "PRODUCCION";
    public static final String PARAM_PASIVO_ADELANTO_CLIENTE = "PASIVO_ADELANTO_CLIENTE";

    public static final String PARAM_P_PATRIMONIO = "PATRIMONIO";
    public static final String PARAM_INGRESOS_ASALARIADO = "INGRESOS_ASALARIADO";
    public static final String PARAM_P_INGRESOS = "Ingresos";
    public static final String PARAM_COSTOS_VENTAS = "COSTOS_VENTAS";
    public static final String PARAM_INGRESOS_OTRO = "INGRESOS_OTRO";

    public static final String PARAM_ETF = "ETF";
    public static final String PARAM_PASIVOS = "Pasivos";

    public static final String PARAM_PORCENTAJE = "PORCENTAJE";
    public static final String PARAM_MONEDA = "MONEDA";
    public static final String PARAM_UNDEFINED = "UNDEFINED";

    public static final String PARAM_MONEDA_NACIONAL = "MONEDA NACIONAL";
    public static final String PARAM_MONEDA_EXTRANJERA = "MONEDA EXTRANJERA";
    public static final String PARAM_MANTENIMIENTO_DE_VALOR = "MANTENIMIENTO DE VALOR";

    public static final String PARAM_P_INVENTARIO = "INVENTARIO";
    public static final String PARAM_P_SUBTOTAL = "SUBTOTAL";
    public static final String PARAM_P_CRUCE = "CRUCE";
    public static final String PARAM_P_MERMA = "MERMA";
    public static final String PARAM_P_PRECIO = "PRECIO";
    public static final String PARAM_P_NO_CUMPLE = "NO CUMPLE";
    public static final String PARAM_P_CUMPLE = "CUMPLE";

    public static final String PARAM_IP_WS_AXON = "http://services-labo-netbank.idepro.org/WSClientAxon/";
    public static final String PARAM_WS_AXON_PROXIMA_CUOTA = "proximaCuotaCredito/";
    public static final String PARAM_WS_PAGO_CREDITO = "PagoCredito/";
    public static final String PARAM_WS_REVERSION_PAGO_CREDITO = "RevertirPagoCredito/";

    // BCP - SINTESIS
    public static final String COD_ERROR_1 = "000";
    public static final String COD_ERROR_2 = "301";
    public static final String COD_ERROR_3 = "302";
    public static final String COD_ERROR_4 = "303";
    public static final String COD_ERROR_5 = "304";
    public static final String DESCRIPCION_1 = "PROCESO CONFORME";
    public static final String DESCRIPCION_2 = "FECHA PAGO INVALIDO";
    public static final String DESCRIPCION_3 = "CÓDIGO DE DEPOSITANTE NO EXISTE";
    public static final String DESCRIPCION_4 = "PROCESO PAGO REVERSION CONFORME";
    public static final String DESCRIPCION_5 = "TRANSACCION DE EMPRESA NO EXITE";
    public static final String DESCRIPCION_6 = "MONTO TOTAL INVALIDO";
    public static final Integer PARAM_CONSULTA_CANAL = 0;
    public static final String PARAM_DETALLE_CUOTA = "PROXIMA CUOTA DE PAGO";
    public static final Integer PARAM_PAGO_CANAL = 0;
    public static final String PARAM_NUMERO_CC = "";
    public static final String PARAM_ESTADO_MONEDA = "Bs.";
    public static final String PARAM_SIGLO_1 = "+";
    public static final Integer PARAM_REVERSION_CANAL = 0;
    public static final String PARAM_MESSAGE_REVERSION = "EXITO";

}
