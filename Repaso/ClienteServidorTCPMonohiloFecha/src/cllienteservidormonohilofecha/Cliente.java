
package cllienteservidormonohilofecha;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    
    public static final int PORT = 5656;
    
    public static void main(String[] args) {
        
        try(Socket cliente = new Socket("localhost", PORT); 
                var entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                var salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream())), true)){
            String linea;
            Scanner sc = new Scanner(System.in);
            while (true) {                
                linea = entrada.readLine();
                System.out.println(linea);
                linea = sc.nextLine();
                salida.println(linea);
                if(linea.equalsIgnoreCase("destroy")){
                    System.out.println("Desconectando del servidor.");
                    break;
                }
                linea = entrada.readLine();
                System.out.println(linea);
            }

        } catch(IOException ex){
            System.out.printf("ERROR: %s\n", ex.getMessage());
            System.exit(-1);
        }
        
        
    }
    
}
