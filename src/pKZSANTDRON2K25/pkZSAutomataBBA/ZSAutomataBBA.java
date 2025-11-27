package pKZSANTDRONSK25.ZSAutomataBBA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZSAutomataBBA {

    private List<Character> alfabeto;
    private List<String> estados;
    private HashMap<String, String> transiciones;
    private String estadoInicial;
    private List<String> estadosDeAceptacion;

    public ZSAutomataBBA() {


        alfabeto = new ArrayList<>();
        estados = new ArrayList<>();
        transiciones = new HashMap<>();
        estadosDeAceptacion = new ArrayList<>();

        // Alfabeto
        alfabeto.add('a');
        alfabeto.add('b');
        alfabeto.add('c');
        alfabeto.add('d');

        
        estados.add("q0"); 
        estados.add("q1"); 
        estados.add("q2"); 
        estados.add("q3"); 
        estados.add("q4"); 

        
        estadoInicial = "q0";

        
        estadosDeAceptacion.add("q3");
        estadosDeAceptacion.add("q4");

        transiciones.put("q0,a", "q1");
        transiciones.put("q1,b", "q2");

        transiciones.put("q2,c", "q3");
        transiciones.put("q3,d", "q4");

        transiciones.put("q4,d", "q4");
    }

    public boolean evaluar(String texto) {
        String estadoActual = estadoInicial;

        for (int i = 0; i < texto.length(); i++) {
            char simbolo = texto.charAt(i);

            String clave = estadoActual + "," + simbolo;

            if (!transiciones.containsKey(clave)) {
                return false; 
            }

            estadoActual = transiciones.get(clave);
        }

        
        return estadosDeAceptacion.contains(estadoActual);
    }
}
