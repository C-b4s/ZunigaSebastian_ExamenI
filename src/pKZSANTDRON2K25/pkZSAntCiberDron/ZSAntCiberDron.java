package pKZSANTDRON2K25.pkZSAntCiberDron;

import java.util.Scanner;

import pKZSANTDRON2K25.pkZSAutomataBBA.ZSAutomataBBA;

public class ZSAntCiberDron {

    public Boolean zsCrearBombaBBA(Scanner sc){
        ZSAutomataBBA automata = new ZSAutomataBBA();
         System.out.println("\n[*] AUTÓMATA para DESTRUIR ARSENAL BELICO ================");
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
}
