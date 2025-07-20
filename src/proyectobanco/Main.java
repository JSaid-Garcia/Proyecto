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
        while(continuar) {
            int respuesta = JOptionPane.showConfirmDialog(null, 
                "¿Desea tomar un ticket?", "Sistema de Tickets", 
                JOptionPane.YES_NO_OPTION);
            
            if(respuesta != JOptionPane.YES_OPTION) {
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
        for(int i = 0; i < 5; i++) {
            cajasNormales.add(new ArrayList<>());
        }

    }
}
