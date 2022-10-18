package com.idepro.appbackendnetbank.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by vTorrez/sidepro-pc3 on 30-12-14.
 * MC4.SRL
 */
public class MethodUtil {

//    public static final DateTimeFormatter DD_MM_YYYY_HHMMSS_J8 = DateTimeFormatter .ofPattern("dd-MM-yyyy HH:mm:ss");
//    public static final DateTimeFormatter DD_MM_YYYY_J8 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //LocalDateTime datetime = LocalDateTime.parse(auxRequest.getFecha(), DateUtil.DD_MM_YYYY_HHMMSS_J8);

    public static BigDecimal roundingTwoDecimal(BigDecimal n) {
        if (n != null) {
            return n.setScale(2, RoundingMode.HALF_UP);
        } else {
            return null;
        }
    }

    public static String bigDecimal(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "null";
        }
        DecimalFormat formatter = formatterDecimalFormat();
        //
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        return formatter.format(bigDecimal);
    }

    public static String bigDecimalWithoutThousandSeparator(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "null";
        }
        DecimalFormat formatter = formatterDecimalFormat();
        //
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        //
        String dato = formatter.format(bigDecimal);
        dato = dato.replace(",", "");
        return dato;
    }

    public static DecimalFormat bigDecimalNoCommaSeparator() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
        return decimalFormat;
    }

    public static String bigDecimal(BigDecimal bigDecimal, String sufijo) {
        if (bigDecimal == null) {
            return "null";
        }
        return bigDecimal(bigDecimal) + " " + sufijo;
    }

    public static String bigDecimalIntegerValueSufix(BigDecimal bigDecimal, String sufijo) {
        if (bigDecimal == null) {
            return "null";
        }
        return bigDecimal.intValue() + " " + sufijo;
    }

    public static String tamEmp(String tipo, BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return "null";
        }
        bigDecimal.setScale(3, RoundingMode.HALF_UP);

        return String.valueOf(bigDecimal) + " - " + tipo;
    }

    /**
     * Formato de fecha dd-MM-yyyy
     *
     * @param date
     * @return
     */
    public static String dateStandard(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }

    /**
     * Formato de fecha dd-MM-yyyy HH:mm:ss para pruebas y logs
     *
     * @param date
     * @return
     */
    public static String dateDefault(Date date) {
        if (date == null) {
            return "null";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * Formato de fecha yyyy-MM-dd para que los archivos se encuentren ordenados
     *
     * @param date
     * @return
     */
    public static String dateFile(Date date) {
        if (date == null) {
            return "null";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String dateFileYYYYMMDD(Date date) {
        if (date == null) {
            return "null";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String dateHours(Date date) {
        if (date == null) {
            return "null";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }

    public static String dateHour(Date date) {
        if (date == null) {
            return "null";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return sdf.format(date);
    }

    public static String dateMonth(Integer month) {
        if (month > 11) {
            return "null";
        }
        String[] months = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return months[month];
    }

    public static String dateDay(Integer day) {
        if (day > 7) {
            return "null";
        }
        String[] days = {"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
        return days[day - 1];
    }

    public static String dateDayBolivia(Integer day) {
        if (day > 7) {
            return "null";
        }
        String[] days = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        return days[day - 1];
    }

    public static String dateMonthShort(Integer month) {
        if (month > 11) {
            return "null";
        }
        String[] months = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        return months[month];
    }

    public static BigDecimal plazoConversion(int plz, String unidadPlazo) {

        BigDecimal result = new BigDecimal(0);
        BigDecimal plazo = new BigDecimal(plz);
        unidadPlazo = unidadPlazo.trim();
        if ("ANIOS".equals(unidadPlazo))
            result = plazo.divide(new BigDecimal(360), 2, RoundingMode.HALF_UP);
        if ("MES(ES)".equals(unidadPlazo))
            result = plazo.divide(new BigDecimal(30), 2, RoundingMode.HALF_UP);
        if ("DIAS".equals(unidadPlazo))
            result = plazo;
        if ("SEMANAS".equals(unidadPlazo))
            result = plazo.divide(new BigDecimal(7), 2, RoundingMode.HALF_UP);

        return result;
    }

    public static String dateGetMonth(Date fecha) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(fecha.getTime());
        return dateMonth(calendar.get(Calendar.MONTH));
    }

    public static String dateGetMonthAndYear(Date fecha) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(fecha.getTime());
        String monthAndYear = dateMonth(calendar.get(Calendar.MONTH)) + "\n" + calendar.get(Calendar.YEAR);
        return monthAndYear;
    }

    public static String dateGetMonthShort(Date fecha) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(fecha.getTime());
        return dateMonthShort(calendar.get(Calendar.MONTH));
    }

    public static DecimalFormat formatterDecimalFormat() {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        return formatter;
    }

    public static DecimalFormat formatterDecimalFormat(int scale) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.setMaximumFractionDigits(scale);
        formatter.setMinimumFractionDigits(scale);
        return formatter;
    }

    public static String labelAsTextField(String label, String value) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("<div class=\"col-sm-4\">");
        stringBuilder.append("  <label>").append(label).append("</label>");
        stringBuilder.append("</div>");
        stringBuilder.append("<div class=\"col-sm-8\">");
        stringBuilder.append("  <div class=\"form-control\" style=\"background-color: #E9E9E9;\">");
        stringBuilder.append(value);
        stringBuilder.append("  </div>");
        stringBuilder.append("</div>");
        return stringBuilder.toString();
    }

    public static String labelAsText(String label, String value) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("<div class=\"col-sm-12\">");
        stringBuilder.append("  <label>").append(label).append(":</label> ").append(value);
        stringBuilder.append("</div>");
        return stringBuilder.toString();
    }

    public static String normalizeString(String original) {
        String nfdNormalizedString = Normalizer.normalize(original, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static void createAndModifyFile(String path, String name, String text) {
        try {
//            String pathApp = context.getRealPath("");
            System.out.println("Path: " + path);
            File archivo = new File(path, name + ".txt");
//            if (archivo.exists()) {
//                System.out.println("no nuevo");
//                BufferedReader Flee = new BufferedReader(new FileReader(archivo));
//                String contenido, contenido2 = "";
//                while ((contenido = Flee.readLine()) != null) {
//                    /*Imprime la linea leida*/
//                    System.out.println("*******" + contenido);
//                    contenido2 = contenido2 + contenido +"\r\n";
//                }
//                System.out.println("Contenido2");
//                System.out.println(contenido2);
//                Flee.close();
//            }
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true), "utf-8"));
            Fescribe.write(text + "\r\n");
            Fescribe.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String a = "áéíóúÁÉÍÓÚÑñ";
        System.out.printf("Original: " + a + "\nFinal: " + normalizeString(a));
    }

}
