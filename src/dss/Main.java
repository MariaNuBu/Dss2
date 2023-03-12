/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dss;

import pojos.Patient;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import db.sqlite.SQLiteManager;
import db.interfaces.DBManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.NoResultException;
/**
 *
 * @author msmar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static DBManager db;
    
    public static void main(String[] args) {
        
        db= new SQLiteManager();
        db.connect();
        db.createTables();
        
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        
        KieSession ksession = kc.newKieSession("IntestinalDiseasesKS");
        
        register();
        
        Patient p = logIn();
        /*
        Patient p = askSymptoms();
        
        ksession.insert(p);
        
        
        ksession.fireAllRules();
        
        System.out.println("AFTER");
        
        System.out.println("Crohn probability: "+p.getCrohnScore());
        System.out.println("IBS probability: "+p.getIBSScore());
        System.out.println("Celiac probability: "+p.getCeliacScore());
        System.out.println("Intestinal Obstruction probability: "+p.getIntObsScore());
        */       

    }
    public static boolean getValue(String answer)
    {
        if (answer.contentEquals("yes"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static Patient logIn()
    {
        System.out.println("Introduce your username");
        String username = DataObtention.readLine();
        System.out.println("Introduce your password");
        String pass = DataObtention.readLine();
        Patient p = null;
        try
        {
            p = db.checkPassword(username, pass);
        }
        catch(NoResultException e)
        {
            System.err.println("Wrong credentials, please try again");
        }
        return p;//aqui habria que en vez de devolver patient llevar al menu de seleccion de sintomas
    }
    
    public static void register() 
    {
        System.out.println("Introduce your username");
        String username = DataObtention.readLine();
        System.out.println("Introduce your password");
        String password = DataObtention.readLine();
        MessageDigest md = null;
        try
        {
            md = MessageDigest.getInstance("SHA-512");
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte [] pass=md.digest();        
        db.createUser(username, pass);
        //y aqui ya mandarle al menu como en el otro
        System.out.println("Registered succesfully");
        
    }
    public static Patient askSymptoms()
    {
        System.out.println("Do you have fever?");
        String answer = DataObtention.readLine();
        Boolean fever = getValue(answer);
        System.out.println("Do you have diarrhea?");
        answer = DataObtention.readLine();
        Boolean diarrhea = getValue(answer);
        System.out.println("Do you have fatigue?");
        answer = DataObtention.readLine();
        Boolean fatigue = getValue(answer);
        System.out.println("Do you have abdominal_pain?");
        answer = DataObtention.readLine();
        Boolean abdominal_pain = getValue(answer);
        System.out.println("Do you have blood_in_stool?");
        answer = DataObtention.readLine();
        Boolean blood_in_stool = getValue(answer);
        System.out.println("Do you have mouth_sores?");
        answer = DataObtention.readLine();
        Boolean mouth_sores = getValue(answer);
        System.out.println("Do you have reduced_appetite?");
        answer = DataObtention.readLine();
        Boolean reduced_appetite = getValue(answer);
        System.out.println("Do you have weight_loss?");
        answer = DataObtention.readLine();
        Boolean weight_loss = getValue(answer);
        System.out.println("Do you have nausea_vomiting?");
        answer = DataObtention.readLine();
        Boolean nausea_vomiting = getValue(answer);
        System.out.println("Do you have constipation?");
        answer = DataObtention.readLine();
        Boolean constipation = getValue(answer);
        System.out.println("Do you have anemia?");
        answer = DataObtention.readLine();
        Boolean anemia = getValue(answer);
        System.out.println("Do you have abdomen_swelling?");
        answer = DataObtention.readLine();
        Boolean abdomen_swelling = getValue(answer);
        System.out.println("Do you have flatulence?");
        answer = DataObtention.readLine();
        Boolean flatulence = getValue(answer);
        System.out.println("Do you have heartburn?");
        answer = DataObtention.readLine();
        Boolean heartburn = getValue(answer);
        System.out.println("Do you have bloating?");
        answer  = DataObtention.readLine();
        Boolean bloating = getValue(answer);
        Patient p = new Patient(fever,diarrhea,fatigue,abdominal_pain,blood_in_stool,mouth_sores,reduced_appetite,weight_loss,
            nausea_vomiting,anemia,constipation,abdomen_swelling,flatulence,heartburn,bloating);
        return p;
    }
        
}
    

