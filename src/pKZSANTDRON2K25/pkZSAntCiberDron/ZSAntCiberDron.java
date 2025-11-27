package pKZSANTDRON2K25.pkZSAntCiberDron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import pKZSANTDRON2K25.pkZSAutomataBBA.ZSAutomataBBA;

public class ZSAntCiberDron implements IZSIA{

    public Boolean zsCrearBombaBBA(Scanner sc){
        ZSAutomataBBA automata = new ZSAutomataBBA();
         System.out.println("\n[*] AUTOMATA para DESTRUIR ARSENAL BELICO ================");
         System.out.println("Coordenadas a destruir: 4 y 2\n");
        System.out.println("Ingrese el tipo de arsenal para validar (escriba 'salir' para terminar):\n");

            System.out.print("Arsenal belico: ");
            String cadena = sc.nextLine().trim();


            boolean resultado = automata.zsEvaluar(cadena);

            if (resultado) {
                System.out.println("    Confirmado. Arsenal belico identificado exitosamentet\n");
                return true;
            } else {
                System.out.println("     ERROR. El arsenal belico no ha sido identificado\n");
                return false;
            }
    }

    @Override
    public Boolean zsBuscar(String zsTipoArsenal) {
    Boolean explotarBomba = true;

    if (explotarBomba) {
        System.out.println("COORDENADAS UCRANIANAS A DESTRUIR:");
        String archivo = "ZunigaSebastian_procesado.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            System.out.printf("%-20s %-20s %-20s\n",
                    "Geoposicion", "Tipo Arsenal", "Accion(TRUE)");
            System.out.println("--------------------------------------------------------------");

            while ((linea = br.readLine()) != null) {

                String[] columnas = linea.split("\\|");

                if (columnas.length < 3) continue;

                String geopos = columnas[0].trim();
                String arsenal = columnas[1].trim();

               
                if ((geopos.equals("02") || geopos.equals("04"))
                        && arsenal.equals(zsTipoArsenal)) {

                    System.out.printf("%-20s %-20s %-20s\n",
                            geopos, arsenal, "true");
                }
            }

            System.out.println("\n[*] Extracción completada.\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    } else {
        System.out.println("ERROR. La bomba no puede explotar en este momento.");
        return false;
    }
}

}
