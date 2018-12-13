/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hatim
 */
public class Dao {
    private static String Pilote;
    private static String Url;
    private static String Login;
    private static String Password;
    private static Connection connexion;
    public static final String ANSI_GREEN = "\u001B[32m";
    
    
    public void SeConnecter(){
        try {
            System.out.println("Chargement de Pilote...");
            Class.forName(Pilote);
            System.out.println(ANSI_GREEN+"Chargement Reussi ");
            connexion = DriverManager.getConnection(Url,Login, Password);
             System.out.println(ANSI_GREEN+"connexion Etablie ");
                
        } 
        catch (ClassNotFoundException ex) 
        {
            System.err.println("Probleme de Pilote !!");
        }
        catch (SQLException ex) 
        {
                 System.err.println("Probleme de connexion!!");
        }
    }

    public static void setPilote(String Pilote) {
        Dao.Pilote = Pilote;
    }

    public static void setUrl(String Url) {
        Dao.Url = Url;
    }

    public static void setLogin(String Login) {
        Dao.Login = Login;
    }

    public static void setPassword(String Password) {
        Dao.Password = Password;
    }

    public static void setConnexion(Connection connexion) {
        Dao.connexion = connexion;
    }

    public static Connection getConnexion() {
        return connexion;
    }
    
}
