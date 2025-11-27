package pKZSANTDRONSK25;

import java.io.*;

public class ZSAppAntCiberDron {
    
    public void inicializar(){
        leerArchivo();
    }
    
    
    public void leerArchivo(){
   String entrada = "ZunigaSebastian.csv";
        String salida  = "ZunigaSebastian_procesado.csv";

        try (
            BufferedReader br = new BufferedReader(new FileReader(entrada));
            BufferedWriter bw = new BufferedWriter(new FileWriter(salida))
        ) {
            String coord;

            while ((coord = br.readLine()) != null) {
                String coordProcesada = coord.replace(";", "|");
                bw.write(coordProcesada);
                bw.newLine();
                System.out.println(coordProcesada);
            }

            System.out.println("\nArchivo convertido correctamente.\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

