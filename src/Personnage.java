import java.awt.*;
import javax.swing.*;

public class Personnage {
    
    private String famille;
    private String nom;
    private int valeur;
    private Image photo;

    public Personnage(){
       this.famille = "anonyme";
       this.nom = "anonyme";
       this.valeur=0;
       this.photo=new ImageIcon(getClass().getResource("img/anonyme.png")).getImage();//on assigne une Image au personnage
    }
   
    public Personnage(String pFamille,String pNom,int pValeur){
       this.famille = pFamille;
       this.nom = pNom;
       this.valeur=pValeur;
       this.photo=new ImageIcon(getClass().getResource("img/"+this.nom+".jpg")).getImage();//on assigne une Image au personnage
    }

    public void setFam(String pFam){ this.famille=pFam;}
    public void setNom(String pNom){ this.nom=pNom;}
    public void setValeur(int pValeur){ this.valeur=pValeur;}
    public void setPhoto(Image pPhoto){ this.photo=pPhoto;}

    public String getFam(){ return this.famille; }
    public String getNom(){ return this.nom; }
    public int getValeur(){ return this.valeur; }
    public Image getPhoto(){ return this.photo; }

    public void setImgBouton(JButton jb){
       Image img = photo.getScaledInstance(jb.getWidth(),jb.getHeight(),Image.SCALE_SMOOTH);
       jb.setIcon(new ImageIcon(img));
    }

    public String toString(){
        String result = this.nom;
        result += "de la famille "+this.famille+", la valeur : "+this.valeur;
        return result;
    }
}
