/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Patient;


public class Conector implements DBManager {

    private Connection connect;
    private String url;

    public Conector() {
        this.connect = null;
        this.url = null;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            String bUrl = "jdbc:sqlite:" + ".//Database//DBproject.db";
            this.connect = DriverManager.getConnection(bUrl);
            this.url = ".//Database//DBproject.db";
        } catch (Exception ex) {
        }
    }

    public void disconnect() {
        try {
            this.connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}