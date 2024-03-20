

public class Bataille extends Action {

    private Joueur adversaire;

    public Joueur getAdversaire() {
        return adversaire;
    }

    public Bataille(Joueur a, Joueur b){
        super(a,"Bataille");
        this.adversaire = b;
    }

    public int execute(){
        int res=-2;
        if(getJoueurCourant().getPaquet().getTaille()>0 && this.adversaire.getPaquet().getTaille()>0){
            res = -1;
            Personnage c1 = (Personnage)getJoueurCourant().getPaquet().getPerso(0);
            Personnage c2 = (Personnage)adversaire.getPaquet().getPerso(0);
            getJoueurCourant().getPaquet().retirePerso(c1);
            adversaire.getPaquet().retirePerso(c2);
            if(c1.getValeur() == c2.getValeur()){
                res = 0;
                getJoueurCourant().getPaquet().ajoutPerso(c1);
                adversaire.getPaquet().ajoutPerso(c2);
            }
            else{
                if(c1.getValeur() > c2.getValeur()){
                    res = 1;
                    getJoueurCourant().getPaquet().ajoutPerso(c1);
                    adversaire.getPaquet().ajoutPerso(c2);
                }
                else{
                   res = 2;
                   adversaire.getPaquet().ajoutPerso(c1);
                   adversaire.getPaquet().ajoutPerso(c2);
                }
            }
            if(getJoueurCourant().getPaquet().getTaille() == 0 || adversaire.getPaquet().getTaille() == 0){
                String s = "Bataille "+getJoueurCourant().getPseudo()+" contre "+this.adversaire.getPseudo();
                if(res == 1)
                    s+= "\ngagné";
                else
                    s+= "\nPerdu";
                setHistorique(s);       
            }       
        }
    return res;      
    }


}
