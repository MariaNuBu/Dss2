/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author msmar
 */
public class Patient {
    
    private Integer ID;
    private String username;
    private byte[] password;
    private boolean fever;
    private boolean diarrhea;
    private boolean fatigue;
    private boolean abdominal_pain;
    private boolean blood_in_stool;
    private boolean mouth_sores;
    private boolean reduced_appetite;
    private boolean weight_loss;
    private boolean nausea_vomiting;
    private boolean anemia;
    private boolean constipation;
    private boolean abdomen_swelling;
    private boolean flatulence;
    private boolean heartburn;
    private boolean bloating;
    private int IBSScore;
    private int CrohnScore;
    private int CeliacScore;
    private int IntObsScore;
    
    public Patient(String userName, byte[] password)
    {
        this.username = userName;
        this.password = password;
    }
    
    public Integer getId() 
    {
            return ID;
    }
    public void setId(Integer id)
    {
            this.ID = id;
    }

    public Patient(boolean fever, boolean diarrhea, boolean fatigue, boolean abdominal_pain, boolean blood_in_stool, boolean mouth_sores, boolean reduced_appetite, boolean weight_loss, boolean nausea_vomiting, boolean anemia, boolean constipation, boolean abdomen_swelling, boolean flatulence, boolean heartburn, boolean bloating) {
        this.fever = fever;
        this.diarrhea = diarrhea;
        this.fatigue = fatigue;
        this.abdominal_pain = abdominal_pain;
        this.blood_in_stool = blood_in_stool;
        this.mouth_sores = mouth_sores;
        this.reduced_appetite = reduced_appetite;
        this.weight_loss = weight_loss;
        this.nausea_vomiting = nausea_vomiting;
        this.anemia = anemia;
        this.constipation = constipation;
        this.abdomen_swelling = abdomen_swelling;
        this.flatulence = flatulence;
        this.heartburn = heartburn;
        this.bloating = bloating;
        this.CrohnScore = 0;
        this.IBSScore = 0;
        this.CeliacScore = 0;
        this.IntObsScore = 0;

    }

    public boolean getFever() {
        return fever;
    }

    public boolean getDiarrhea() {
        return diarrhea;
    }

    public boolean getFatigue() {
        return fatigue;
    }

    public boolean getAbdominal_pain() {
        return abdominal_pain;
    }

    public boolean getBlood_in_stool() {
        return blood_in_stool;
    }

    public boolean getMouth_sores() {
        return mouth_sores;
    }

    public boolean getReduced_appetite() {
        return reduced_appetite;
    }

    public boolean getWeight_loss() {
        return weight_loss;
    }

    public boolean getNausea_vomiting() {
        return nausea_vomiting;
    }

    public boolean getAnemia() {
        return anemia;
    }

    public boolean getConstipation() {
        return constipation;
    }

    public boolean getAbdomen_swelling() {
        return abdomen_swelling;
    }

    public boolean getFlatulence() {
        return flatulence;
    }

    public boolean getHeartburn() {
        return heartburn;
    }

    public boolean getBloating() {
        return bloating;
    }

    public int getCrohnScore() {
        return CrohnScore;
    }

    public int getIBSScore() {
        return IBSScore;
    }

    public int getCeliacScore() {
        return CeliacScore;
    }

    public int getIntObsScore() {
        return IntObsScore;
    }

    public void setAbdomen_swelling(boolean abdomen_swelling) {
        this.abdomen_swelling = abdomen_swelling;
    }

    public void setAbdominal_pain(boolean abdominal_pain) {
        this.abdominal_pain = abdominal_pain;
    }

    public void setAnemia(boolean anemia) {
        this.anemia = anemia;
    }

    public void setBlood_in_stool(boolean blood_in_stool) {
        this.blood_in_stool = blood_in_stool;
    }

    public void setConstipation(boolean constipation) {
        this.constipation = constipation;
    }

    public void setCrohnScore(int CrohnScore) {
        this.CrohnScore = CrohnScore;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public void setFlatulence(boolean flatulence) {
        this.flatulence = flatulence;
    }

    public void setHeartburn(boolean heartburn) {
        this.heartburn = heartburn;
    }

    public void setBloating(boolean bloating) {
        this.bloating = bloating;
    }

    public void setIBSScore(int IBSScore) {
        this.IBSScore = IBSScore;
    }

    public void setMouth_sores(boolean mouth_sores) {
        this.mouth_sores = mouth_sores;
    }

    public void setNausea_vomiting(boolean nausea_vomiting) {
        this.nausea_vomiting = nausea_vomiting;
    }

    public void setReduced_appetite(boolean reduced_appetite) {
        this.reduced_appetite = reduced_appetite;
    }

    public void setWeight_loss(boolean weight_loss) {
        this.weight_loss = weight_loss;
    }

    public void setCeliacScore(int CeliacScore) {
        this.CeliacScore = CeliacScore;
    }

    public void setIntObsScore(int IntObsScore) {
        this.IntObsScore = IntObsScore;
    }

    public void calculatePunctuationCrohn(int score) {
        this.CrohnScore = this.CrohnScore + score;
    }

    public void calculatePunctuationIBS(int score) {
        this.IBSScore = this.IBSScore + score;
    }

    public void calculatePunctuationCeliac(int score) {
        this.CeliacScore = this.CeliacScore + score;
    }

    public void calculatePunctuationIntObs(int score) {
        this.IntObsScore = this.IntObsScore + score;
    }

}
