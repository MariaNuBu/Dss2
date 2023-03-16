/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbPackage;

import static dss.Main.conector;
import java.io.File;
import java.sql.*;
import pojos.Patient;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DBCreation
{
    public static Conector c;

    public DBCreation() 
    {
        this.c = new Conector();
        File url = new File ("./Database/Credentials.db");
        if(!url.exists())
        {
            this.c.connect();
            this.createDB(this.c);
            System.out.println("Crear base");
        }
        else
        {
            this.c.connect();
        }
    }
    
    public Conector getConector()
    {
        return c;
    }
    
    public static void createDB(DBManager c)
    {
        if(c.getClass().equals(Conector.class)) 
        {
            Conector con = (Conector) c;
            tableUsers(con);
        }
    
    }
    
    private static void tableUsers(Conector con)
    {
        Conector conn = con;
        Statement st = null;
        String query = null;   
        try 
        {
            st = conn.getConnect().createStatement();
            query =  "CREATE TABLE IF NOT EXISTS users "
                + "(ID          integer PRIMARY KEY AUTOINCREMENT NOT NULL,"
                + "USERNAME     varchar(50) NOT NULL UNIQUE, "
                + "PASSWORD     BLOB NOT NULL)";
            st.execute(query);
            st.close();
            System.out.println("Tabla users hecha");
        }
        catch(Exception ex) {
            System.out.println("Error tabla users");
        }
    }
    
    
   
}
