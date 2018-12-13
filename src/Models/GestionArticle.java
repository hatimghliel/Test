/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DAO.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hatim
 */

public class GestionArticle {
    private Connection Con;
    private Statement St;
    private Dao dao;
    
    public GestionArticle(){
        Dao dao=new Dao();
        dao.setPilote("com.mysql.jdbc.Driver");
        dao.setUrl("jdbc:mysql://localhost:3306/jdbc");
        dao.setLogin("root");
        dao.setPassword("");
        dao.SeConnecter();
        Con= dao.getConnexion();
    }
    public void Create(int code,String Des,float Prix){
        String req;
        req= "insert into Article values('"+code+"','"+Des+"','"+Prix+"');";
        try
        {
          if(Con!=null)
          {
              St = Con.createStatement();
              St.executeUpdate(req);
              System.out.println("Requete executée avec succes ! ");

          }
        }
        catch(SQLException ex){
            System.err.println("Requete create erronnée !! "+ex.getMessage());
        }
    }
    
    public void add(int code,String Nom,float Prix)
    {
        try{
            PreparedStatement pst = Con.prepareStatement("insert into Article values(?,?,?)");
            pst.setInt(1, code);
            pst.setString(2, Nom);
            pst.setFloat(3, Prix);
            pst.executeUpdate();
            System.out.println("Requete executée avec succes ! ");
        }
        catch(SQLException ex){
            System.err.println("Requete add erronnée !! "+ ex.getMessage());
        }
    }
    public  void all_Articles(){
        ResultSet Res;
        try
        {
            St = Con.createStatement();
            Res=St.executeQuery("Select * from Article;");
            System.out.println("Affichage des articles :  ");
            while(Res.next())
            {
                System.out.println(Res.getInt(1)+" "+Res.getString(2)+" "+Res.getFloat(3));
            }
        }
        catch (SQLException ex) 
        {
            System.err.println("Requete add erronnée !! "+ ex.getMessage());
        }
    }
      public  ResultSet LesArticles(){
        ResultSet Res=null;
        try
        {
            St = Con.createStatement();
            Res=St.executeQuery("Select * from Article;");       
        }
        catch (SQLException ex) 
        {
            System.err.println("Requete add erronnée !! "+ ex.getMessage());
        }
        return Res;
    }
    
    public void delete(int code)
    {
        try
        {
        PreparedStatement pst = Con.prepareStatement("delete from Article where id=?");
        pst.setInt(1, code);
        pst.executeUpdate();
        System.out.println("Suppression effectuée avec succes!  ");
        }
        catch(SQLException ex)
        {
             System.err.println("delete a generé des erreurs !! "+ ex.getMessage());
        }
    }
    public void UpdatePrix(int i,float p )
    {
        try
        {
        PreparedStatement pst = Con.prepareStatement("update Article set prix=? where id=?");
        pst.setFloat(1, p);
        pst.setInt(2,i);
        
        pst.executeUpdate();
        System.out.println("Mise a jour effectuée avec succes!  ");
        }
        catch(SQLException ex)
        {
             System.err.println("MAJ a generé des erreurs !! "+ ex.getMessage());
        }
    }
    public void read(int i){
        ResultSet res;
        try{
            PreparedStatement Pst = Con.prepareStatement("select * from Article where id=?");
            Pst.setInt(1,i);
            res = Pst.executeQuery();
            System.out.println("Affichage Article numero : "+i);
            if(res.next())
            {
                System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getFloat(3));
            }    
        }
        catch(SQLException ex){
            System.err.println("la requete read a generé des erreurs !! "+ ex.getMessage());
        }
    }
    
}
