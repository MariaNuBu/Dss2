/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbPackage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Patient;

/**
 *
 * @author msmar
 */
public class dbCheck {
    
    private Conector c;

    public dbCheck(Conector c) {
        this.c = c;
    }   
     
    public void createUser(String username, byte[] password)
    {
        try
        {
            String sq = "INSERT INTO users (Username,Password) VALUES (?,?)";
            PreparedStatement ps = this.c.getConnect().prepareStatement(sq);
            System.out.println(ps);
            ps.setString(1, username);
            ps.setBytes(2, password);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public Patient checkPassword(String username, String password)
    {
        Conector c = this.c;
        Patient pat=null;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte [] hash=md.digest();
            String sql = ("SELECT * FROM users WHERE username LIKE ? AND password LIKE ?");
            PreparedStatement prep=c.getConnect().prepareStatement(sql);
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
