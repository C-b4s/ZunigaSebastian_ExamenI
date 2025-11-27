package pKZSANTDRON2K25;

import java.io.*;
import java.util.Scanner;

import pKZSANTDRON2K25.pkZSAntCiberDron.ZSAntCiberDron;
import pKZSANTDRON2K25.pkZSUtility.ZSTool;

public class ZSAppAntCiberDron {
    Scanner sc = new Scanner (System.in);


    public void inicializar(){
        System.out.println("[*] INFORMACION: ");
        System.out.println("   -    Nombre: Zuniga Sebastian");
        System.out.println("   -    Cédula: 1727915942");
        zsLeerArchivo();

        ZSAntCiberDron antCiberDron = new ZSAntCiberDron();
        boolean bombaBBA = antCiberDron.zsCrearBombaBBA(sc);

        if (bombaBBA){
            System.out.println("\nLa bomba BBA ha sido desarrollada satisfactoriamente");
        }else{
            System.out.println("\nLa bomba BBA no ha podido ser creada");
        }

        boolean bomba = antCiberDron.zsBuscar("abbbbbbbb");
        bomba = antCiberDron.zsBuscar("abbbb");

        if (bomba){
            System.out.println("\nOPERACION EXITOSA");
        }else{
            System.out.println("\nOPERACION FALLIDA");
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
