/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectobanco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jaine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Inicialización de variables
        int numTicket = 1;
        Random generador = new Random();
        List<String> ticketsGenerados = new ArrayList<>();

        // Tipos de clientes y sus códigos
        String[] tipos = {
            "Adulto mayor (A)",
            "Mujer embarazada o con niño en brazos (B)",
            "Persona con discapacidad (C)",
            "Varios asuntos (D)",
            "Plataforma de servicios (E)",
            "Mujer (F)",
            "Hombre (G)"
        };
        char[] codigos = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        // Generación de tickets
        boolean continuar = true;
        while (continuar) {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "¿Desea tomar un ticket?", "Sistema de Tickets",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta != JOptionPane.YES_OPTION) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "Sistema cerrado. ¡Gracias!");
                continue;
            }
            int indiceAleatorio = generador.nextInt(tipos.length);
            String ticket = codigos[indiceAleatorio] + "" + numTicket;
            ticketsGenerados.add(ticket);

            JOptionPane.showMessageDialog(null,
                    "Ticket: " + ticket + "\nTipo: " + tipos[indiceAleatorio]);
            numTicket++;
        }

        // Distribución a cajas
        List<String> plataformaServicios = new ArrayList<>();
        List<List<String>> cajasNormales = new ArrayList<>();

        // Creamos las 5 cajas normales
        for (int i = 0; i < 5; i++) {
            cajasNormales.add(new ArrayList<>());
        }

        // Asignamos tickets a las cajas
        for (String ticket : ticketsGenerados) {
            if (ticket.charAt(0) == 'E') {
                plataformaServicios.add(ticket);
            } else {
                int cajaAsignada = generador.nextInt(5);
                cajasNormales.get(cajaAsignada).add(ticket);
            }
        }
        // Proceso de atención por caja
        int[] atendidosPorCaja = new int[5];
        int[] tiempoPorCaja = new int[5];

        // Atendidos en cajas normales
        for (int i = 0; i < 5; i++) {
            for (String ticket : cajasNormales.get(i)) {
                int minutos = 10 + generador.nextInt(111); // 10-120 minutos
                atendidosPorCaja[i]++;
                tiempoPorCaja[i] += minutos;
            }
        }
        // Atendidos en plataforma
        int atendidosPlataforma = 0;
        int tiempoPlataforma = 0;
        for (String ticket : plataformaServicios) {
            int minutos = 10 + generador.nextInt(111);
            atendidosPlataforma++;
            tiempoPlataforma += minutos;
        }

        // Generación del reporte
        String reporte = "REPORTE DE ATENCIÓN\n\n";
        reporte += "Total tickets emitidos: " + ticketsGenerados.size() + "\n\n";

        // Detalle por caja normal
        int totalAtendidos = 0;
        for (int i = 0; i < 5; i++) {
            reporte += "Caja " + (i + 1) + " atendió: " + atendidosPorCaja[i] + " tickets\n";

            if (atendidosPorCaja[i] > 0) {
                double promedio = tiempoPorCaja[i] / (double) atendidosPorCaja[i];
                reporte += "Tiempo promedio: " + String.format("%.1f", promedio) + " minutos\n\n";
            } else {
                reporte += "Tiempo promedio: 0 minutos\n\n";
            }

            totalAtendidos += atendidosPorCaja[i];
        }

        // Detalle por caja de plataforma de servicios
        reporte += "Plataforma de servicios atendió: " + atendidosPlataforma + " tickets\n";
        if (atendidosPlataforma > 0) {
            double promedioPlataforma = tiempoPlataforma / (double) atendidosPlataforma;
            reporte += "Tiempo promedio: " + String.format("%.1f", promedioPlataforma) + " minutos\n\n";
        } else {
            reporte += "Tiempo promedio: 0 minutos\n\n";
        }
        totalAtendidos += atendidosPlataforma;

       // Reporte del banco
        reporte += "Reporte \n";
        reporte += "Total atendidos: " + totalAtendidos + "\n";
        reporte += "No atendidos: " + (ticketsGenerados.size() - totalAtendidos) + "\n";
        reporte += "--- FIN DEL REPORTE ---";

        JOptionPane.showMessageDialog(null, reporte);

    }
}
