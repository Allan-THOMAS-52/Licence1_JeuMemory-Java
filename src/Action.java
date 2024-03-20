

public abstract class Action {

    private Joueur j;
    private String descriptif;
    private String historique;

    public Action(){
        this.j = null;
        this.descriptif = "";
        this.historique = "";
    }

    public abstract int execute();//methode abstraite car les classes filles l'utiliseront differement

    public Action(Joueur j, String desc){
        this.j = j;
        this.descriptif = desc;
        this.historique = "";
    }

    public Joueur getJoueurCourant() {
        return j;
    }
    public void setJoueurCourant(Joueur j) {
        this.j = j;
    }
    public String getDescriptif() {
        return descriptif;
    }
    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
    public String getHistorique() {
        return historique;
    }
    public void setHistorique(String pHistorique) {
        this.historique = pHistorique;
    }

    public String toString(){
        String n = "";
        n = "Joueur : "+j.toString()+"\n"+this.descriptif+"\n"+this.historique;
        return n;
    } 

    
    
    
}
