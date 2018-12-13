/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ensat;
import DAO.*;
import Models.*;
/**
 *
 * @author hatim
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GestionArticle G = new GestionArticle(); 
       G.all_Articles();
       G.read(1);
    }
    
}
