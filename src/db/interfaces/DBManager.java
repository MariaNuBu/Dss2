/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db.interfaces;

import pojos.Patient;

/**
 *
 * @author msmar
 */
public interface DBManager 
{
    public void connect();
    public void disconnect();
    public void createTables();
    public void createUser(String username, byte[] password);
    public Patient checkPassword(String username, String password);
    
}
