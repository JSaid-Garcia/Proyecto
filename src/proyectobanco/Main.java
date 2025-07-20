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
    }
    
}
