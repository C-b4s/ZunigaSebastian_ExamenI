package pKZSANTDRONSK25.ZSUtility;

//Refactorización: Creación del paquete ZSUtility y la clase ZSTool
public class ZSTool {
    public static void zsSimularLoading(){
        int maxIteraciones = 40;
        String[] animacion = {"oOo", "ooO", "oOo", "Ooo"};
        if (maxIteraciones < 1) return;
        for(int i=0;i<=maxIteraciones;i++){
            String frame = animacion[i % animacion.length];
            System.out.print("\r " + frame + " " + (i * 100 / maxIteraciones) + "%");
            try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        }
    }
}
