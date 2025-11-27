package pKZSANTDRON2K25.pkZSHormiga;

import pKZSANTDRON2K25.pkZSAlimento.ZSOmnivoro;

public class ZSHZangano extends ZSHormiga implements IZSHormiga{

    @Override
    public Boolean zsComer(ZSOmnivoro alimento) {
        if (alimento instanceof ZSOmnivoro){
            System.out.println("El zangano está comiendo");
            return true;
        }else{
            System.out.println("El zangano no puede comer alimento que no sea de omnivoro");
            return false;
        }
    }

    public Boolean zsVivir(){
        ZSOmnivoro comida = new ZSOmnivoro();
        if (zsComer(comida)){
            System.out.println("El zangano puede vivir en condiciones adecuadas");
            return true;
        }else{
            System.out.println("El zangano no puede vivir porque no come");
            return false;
        }
    }
    
}
