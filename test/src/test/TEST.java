/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author SR
 */
public class TEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int i = 162;
        String t = "test";
        
        ajouteInt(i);
        changeString(t);
        
        System.out.println(i);
        System.out.println(t);
        System.out.println(t.toUpperCase());
        System.out.println(Integer.toBinaryString(i));
    }

    static public void ajouteInt(Integer nombre) {
        nombre++;
    }

    static public void changeString(String texte) {
        texte.toUpperCase();
    }
}
