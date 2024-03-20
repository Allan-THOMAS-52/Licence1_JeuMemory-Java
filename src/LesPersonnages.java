import java.util.ArrayList;

public class LesPersonnages {

 private ArrayList<Personnage> persos;

    public ArrayList<Personnage> getPersos(){  return persos;  }
    public int getTaille() { return this.persos.size();  }   
    public void ajoutPerso(Personnage ajPerso){ persos.add(ajPerso); }
    public void retireCartes(){  persos.clear();  }

    public LesPersonnages() {
        this.persos = new ArrayList<Personnage>();
    }
                   
    public int getScore(){   //retourne le score final en parcourant tout les personnages
        int sc = 0;
        for(int i=0; i<getTaille(); i++)
           sc+=getPerso(i).getValeur();
        return sc;
    }
          
    public Personnage getPerso(int i){ // retourne le perso a l'index i
        if (i>=0 && i<this.persos.size())
             return this.persos.get(i);
        else return null;
    }
    
    public LesPersonnages getPersosFamille(String f) //retourne les persos de la famille passee en parametre
    {   LesPersonnages lp = new LesPersonnages();
        for(int i=0; i<getTaille(); i++)
            if(getPerso(i).getFam().equals(f))
                lp.ajoutPerso(getPerso(i));
        return lp;
    }

    public ArrayList<String> getFamilles(){ //retourne une ArrayList<> contenant les familles, sans doublon
        ArrayList<String> lst = new ArrayList<String>();
        for (int j=0; j<this.persos.size(); j++){
            Personnage p = this.persos.get(j);
            boolean trouve = false;
            for (int i=0; i< lst.size(); i++)
                if (lst.get(i).equals(p.getFam()))
                    trouve = true;
            if (!trouve) lst.add(p.getFam());
        }
    return lst;
    }
      
    public void ajoutGpePerso(LesPersonnages ajPerso){//permet d'ajouter un groupe de personnages
       for(int i=0;i<ajPerso.getTaille();i++)
           this.persos.add(ajPerso.getPerso(i));
    }
   
    public void retirePerso(Personnage p){    //permet de retirer un personnage
        int i=0; 
        boolean trouve = false;
        while(i<getTaille() && !trouve){
            if (getPerso(i).getNom().equals(p.getNom())){
                this.persos.remove(i);  
                trouve = true;
            }
            else i++;
        }      
    }
    
   public LesPersonnages retirePersos(int n){//retourne une nouvelle liste de personnages sans celui dont l'index est passe en parametre
        LesPersonnages lcr = new LesPersonnages();
        for (int i=0; i<=n; i++){        
            lcr.ajoutPerso(getPerso(0));
            this.persos.remove(0);  
        }
        return lcr;
    } 
    
    public LesPersonnages retirePersosFamille(String f) {   //retire tout les persos d'une meme famille
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getTaille()){
            if (getPerso(i).getFam().equals(f)) {
                lcr.ajoutPerso(getPerso(i));
                this.persos.remove(i);  
            }
            else i++;
        }
        return lcr;
    }

    public LesPersonnages retireGpePersos(LesPersonnages lc) {   //retire tout les persos d'une meme famille
        for(int i=0;i<lc.getTaille();i++){
                this.retirePerso(lc.getPerso(i));  
            }
        return this;
    }
           	
    public LesPersonnages(int nc) { //permet de creer la liste des personnages en fontion du nombre voulu
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutPerso(new Personnage("communs", "assault-trooper", 10));
            ajoutPerso(new Personnage("communs", "commando", 20));
            ajoutPerso(new Personnage("rares", "absolute-zero", 10));
            ajoutPerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles
            ajoutPerso(new Personnage("communs", "devestrator", 30));
            ajoutPerso(new Personnage("rares", "brawler", 30));
            ajoutPerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutPerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutPerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutPerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles

            ajoutPerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutPerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutPerso(new Personnage("legendaires", "power-chord", 10));
            ajoutPerso(new Personnage("legendaires", "raptor", 20));
            ajoutPerso(new Personnage("legendaires", "raven", 30));
            ajoutPerso(new Personnage("epiques", "burnout", 10));
            ajoutPerso(new Personnage("epiques", "funk-ops", 20));
            ajoutPerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles
            ajoutPerso(new Personnage("communs", "dominator", 40));
            ajoutPerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutPerso(new Personnage("communs", "jungle-scout", 60));
            ajoutPerso(new Personnage("communs", "pathfinder", 70));
            ajoutPerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutPerso(new Personnage("rares", "brite-bomber", 50));
            ajoutPerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutPerso(new Personnage("rares", "dazzle", 70));
            ajoutPerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutPerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutPerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutPerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutPerso(new Personnage("legendaires", "red-knight", 40));
            ajoutPerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }

    public String tostring(){
        String res="";
        for(int i=0;i<this.getTaille();i++)
            res+="\n"+this.getPerso(i);
        return res;
    }  
}
