package Trabajo_3.Ejercicios;

import java.util.Date;

public class GeneradorInformes {
    public String generarInformeOcupacion(Date fechaInicio, Date fechaFin) {
        return "Generando informe de ocupación del " + fechaInicio + " al " + fechaFin;
    }

    public String generarInformeIngresos(Date fechaInicio, Date fechaFin) {
        return "Generando informe de ingresos del " + fechaInicio + " al " + fechaFin;
    }
}
