import java.util.ArrayList;

public class LesJoueurs {
    private ArrayList<Joueur> lstJ;

    public LesJoueurs() {
      this.lstJ = new ArrayList<Joueur>();
    }

    public Joueur getJoueur(int i){
        if (i>=0 && i<this.lstJ.size())
             return this.lstJ.get(i);
        else 
            return null;
    }

    public int getNbJoueurs() { 
         return this.lstJ.size(); 
    }

    public void ajouteJoueur(Joueur pJoueur){
       lstJ.add(pJoueur);
    }

    public Joueur rechJoueur(String p)
    {   Joueur lp = null;
        for(int i=0; i<getNbJoueurs(); i++)
            if(getJoueur(i).getPseudo().equals(p))
                  lp=getJoueur(i);                
        return lp;
    }

    public int getIndiceJoueur(Joueur j)
    {   
        for(int i=0; i<getNbJoueurs(); i++)
            if(getJoueur(i).getPseudo().equals(j.getPseudo()))
                  return i;                
        return -1;
    }

    public void retireJoueur(Joueur j)
    { 
        int i=0; 
        boolean trouve = false;
        while(i<getNbJoueurs() && !trouve){
          if (getJoueur(i).getPseudo().equals(j.getPseudo())){
              this.lstJ.remove(i);  
              trouve = true;
          }
          else i++;
        }      
    }
    public LesJoueurs getGagnants(){   
        int max=getJoueur(0).getScore();
        for(int i=1; i<getNbJoueurs();i++)
            if (getJoueur(i).getScore()>max)
                max=this.getJoueur(i).getScore();

        LesJoueurs lst=new LesJoueurs();
            for(int i=0; i<getNbJoueurs();i++)
                if (getJoueur(i).getScore()==max)
                    lst.ajouteJoueur(getJoueur(i));
        return lst;
    }

    public String tostring(){
        String res="";
        for(int i=0;i<this.getNbJoueurs();i++)
            res+="\n"+this.getJoueur(i);
        return res;
    } 

}
