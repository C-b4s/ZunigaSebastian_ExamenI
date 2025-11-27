package pKZSANTDRONSK25;

import java.io.*;
import java.util.Scanner;

import pKZSANTDRONSK25.ZSAutomataBBA.ZSAutomataBBA;
import pKZSANTDRONSK25.ZSUtility.ZSTool;

public class ZSAppAntCiberDron {
    Scanner sc = new Scanner (System.in);


    public void inicializar(){
        System.out.println("[*] INFORMACION: ");
        System.out.println("   -    Nombre: Zuniga Sebastian");
        System.out.println("   -    Cédula: 1727915942");
        zsLeerArchivo();


        ZSAutomataBBA automata = new ZSAutomataBBA();
         System.out.println("\n[*] AUTÓMATA para DESTRUIR ARSENAL BELICO ================");
         System.out.println("Coordenadas a destruir: 4 y 2\n");
        System.out.println("Ingrese el tipo de arsenal para validar (escriba 'salir' para terminar):\n");

        while (true) {
            System.out.print("Arsenal belico: ");
            String cadena = sc.nextLine().trim();

            if (cadena.equalsIgnoreCase("salir")) {
                System.out.println("\n[*] Finalizando validación...");
                break;
            }

            boolean resultado = automata.zsEvaluar(cadena);

            if (resultado) {
                System.out.println("    Confirmado. Arsenal belico identificado exitosamentet\n");
            } else {
                System.out.println("     ERROR. El arsenal belico no ha sido identificado\n");
            }
        }
    }
    
    //Refactorización: Cambio en el nombre del método leerArchivo a zsLeerArchivo 
    public void zsLeerArchivo(){
   String entrada = "ZunigaSebastian.csv";
        String salida  = "ZunigaSebastian_procesado.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(entrada));
            BufferedWriter bw = new BufferedWriter(new FileWriter(salida))
        ) {
            String coord;

            System.out.println("\n[*] COORDENADAS UCRANIANAS:");
            
            int i = 0;  
            while ((coord = br.readLine()) != null) {
                String coordProcesada = coord.replace(";", "|");
                bw.write(coordProcesada);
                bw.newLine();

                if(i == 0){
                    System.out.printf("%-20s %-80s\n","Loading:", coordProcesada);
                }else{
                    ZSTool.zsSimularLoading();
                    System.out.println("                  " + coordProcesada);
                }

                i++;
                
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    

}
}
