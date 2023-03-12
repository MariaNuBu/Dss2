/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.sqlite;

import java.sql.*;
import db.interfaces.DBManager;
import pojos.Patient;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SQLiteManager implements DBManager
{
    private Connection c;
    public SQLiteManager()
    {
            super();
    }

    public Connection getConnection()
    {
            return c;
    }
    
    @Override
    public void connect()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            this.c=DriverManager.getConnection("jdbc:sqlite:./db/Credentials.db");
            c.createStatement().execute("PRAGMA foreign_keys=ON");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
	
    @Override
    public void disconnect()
    {
        try
        {
                c.close();
        }
        catch (Exception e)
        {
                e.printStackTrace();
        }

    }
    
    @Override
    public void createTables()
    {
        try
        {
            Statement s = c.createStatement();
            String sq = "CREATE TABLE IF NOT EXISTS users"
                    + "(ID   INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Username TEXT NOT NULL,"
                    + "Password BYTES NOT NULL)";
            s.executeUpdate(sq);
            s.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void createUser(String username, byte[] password)
    {
        try
        {
            String sq = "INSERT INTO users (Username,Password) VALUES (?,?)";
            PreparedStatement ps = c.prepareStatement(sq);
            ps.setString(1, username);
            ps.setBytes(2, password);
            ps.executeUpdate(sq);
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public Patient checkPassword(String username, String password)
    {
        Patient pat=null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte [] hash=md.digest();
            String sql = ("SELECT * FROM users WHERE username LIKE ? AND password LIKE ?");
            PreparedStatement prep=c.prepareStatement(sql);
            prep.setString(1,username);
            prep.setBytes(2, hash);
            ResultSet rs=prep.executeQuery();
            pat = new Patient(rs.getString("username"),rs.getBytes("password"));
        }
        catch (NoSuchAlgorithmException e) 
        {
                e.printStackTrace();
        }
        catch (SQLException e)
        {
                e.printStackTrace();
        }
        return pat;
    }    
}
