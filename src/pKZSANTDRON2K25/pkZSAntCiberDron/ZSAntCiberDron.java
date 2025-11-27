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
    StringBuilder zsAcumulador = new StringBuilder();
    boolean zsEncabezadoMostrado = false;


    Boolean explotarBomba = true;
    if (!explotarBomba) {
        System.out.println("ERROR. La bomba no puede explotar en este momento.");
        return false;
    }

    String archivo = "ZunigaSebastian_procesado.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

        String linea;

        // MOSTRAR ENCABEZADO SOLO UNA VEZ
        if (!zsEncabezadoMostrado) {
            System.out.println("COORDENADAS UCRANIANAS A DESTRUIR:");
            System.out.printf("%-20s %-20s %-20s\n",
                    "Geoposicion", "Tipo Arsenal", "Accion(TRUE)");
            System.out.println("--------------------------------------------------------------");
            zsEncabezadoMostrado = true;
        }

        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue;

            String[] columnas = linea.split("\\|");

            if (columnas.length < 7) continue;

            String geopos = columnas[0].trim().replace("Coord-", "").trim();
            String arsenal = columnas[6].trim();

            // VALIDAR si coincide con el tipo enviado como parámetro
            if (!arsenal.equals(zsTipoArsenal)) continue;

            // SOLO queremos 04 y 02 (y mostrar primero los 04)
            if (geopos.equals("04") || geopos.equals("02")) {
                zsAcumulador.append(
                    String.format("%-20s %-20s %-20s\n",
                            geopos, arsenal, "true")
                );
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    // MOSTRAR ACUMULADO hasta ahora
    System.out.print(zsAcumulador.toString());

    System.out.println("\n[*] Extracción completada.\n");

    return true;
}


}
