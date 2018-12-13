/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.sun.istack.internal.logging.Logger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author hatim
 */
public class MonModele extends AbstractTableModel {
  private int NbLignes=0;
  private int NbCol=0;
  private String[] Titres;
  private ArrayList<Vector<String>> MesLignes = new ArrayList<Vector<String>>();
  
  public MonModele(ResultSet Rs)
  {
   try{
       ResultSetMetaData rsmd = Rs.getMetaData();
       NbCol = rsmd.getColumnCount();
       Titres = new String[NbCol];
       for (int i=0;i<NbCol;i++)
       {
           Titres[i]=rsmd.getColumnName(i+1);
           Vector<String> Lignes;
           while(Rs.next())
           {
               Lignes = new Vector<String>();
               for (int j=0;j<NbCol;j++)
               {
                   Lignes.add(Rs.getObject(j+1).toString());
               }
               MesLignes.add(Lignes);
               NbLignes++;
           }
           
       }
   }   
   catch(SQLException Ex){
    System.err.println("Erreure classe MonModele");   
   }
  }

    @Override
    public int getRowCount() {
        return NbLignes;
    }

    @Override
    public int getColumnCount() {
        return NbCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return MesLignes.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
         return Titres[column];
    }
  
}
