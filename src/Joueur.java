import java.awt.*;
import javax.swing.*;

public class Joueur {

    private String pseudo;
    private String famPref;
    private Image photo;
    private LesPersonnages paquet;
    private int score;

    public Joueur(){
        this.pseudo="anonyme";
        this.famPref="anonyme";
        this.photo=new ImageIcon(getClass().getResource("/img/anonyme.png")).getImage();//on assigne une Image au joueur
        this.paquet = new LesPersonnages();
        this.score=0;
        
    }
    public Joueur(String pPseudo,String pFamPref){
        this.pseudo=pPseudo;
        this.famPref=pFamPref;
        this.photo= new ImageIcon(getClass().getResource("/img/anonyme.png")).getImage();//on assigne une Image au joueur
        this.paquet = new LesPersonnages();
        this.score=0;
    }

    public void setFamPref(String pFam){ this.famPref=pFam;}
    public void setPseudo(String pPseudo){ this.pseudo=pPseudo;}
    public void setPaquet(LesPersonnages pPaquet){ this.paquet=pPaquet;}
    public void setScore(int pScore){ this.score=pScore;}
    public void setPhoto(Image pPhoto){ this.photo=pPhoto;}

    public String getFamPref(){ return this.famPref; }
    public String getPseudo(){ return this.pseudo; }
    public LesPersonnages getPaquet(){ return this.paquet; }
    public Image getPhoto(){ return this.photo; }
    public int getScore(){ return this.score;}

    public String toString(){
        String result;
        result ="Joueur nommé : "+this.pseudo+"\n Famille préférée : "+this.famPref+
                "\n En possession des personnages:"+"\n Score:"+this.score;
        return result;
    }

    //methodes qui permettent de tester la fenetre VisuPersonnagesDlg
    public void ajoutPersoPaquet(Personnage p){
        this.paquet.ajoutPerso(p);
    }

    public void ajoutGpePersoPaquet(LesPersonnages p){
        this.paquet.ajoutGpePerso(p);
    }

    public void initPaquetTest(){
        ajoutPersoPaquet(new Personnage("communs","assault-trooper",10));
        ajoutPersoPaquet(new Personnage("communs", "commando", 20));
        ajoutPersoPaquet(new Personnage("rares", "absolute-zero", 10));
    }

   

}
