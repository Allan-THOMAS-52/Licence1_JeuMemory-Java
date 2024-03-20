
public class Transfert extends Action{
    
    private Joueur cible;
    private String fp; //famille de la carte sélectionnée
    private LesPersonnages cartesTransferees; // cartes transférées

    public LesPersonnages getCartesTransferees() {
        return cartesTransferees;
    }

    public Joueur getJoueurCible(){ return this.cible; }

    public Transfert(Joueur c, Joueur sc, String f) {
        super(sc, "Transfert de cartes");
        this.cible = c;
        this.fp=f;
        this.cartesTransferees= new LesPersonnages();
    }

    public int execute(){
        if(fp!=null){
            this.cartesTransferees.ajoutGpePerso(this.cible.getPaquet().getPersosFamille(fp));//ajoute les cartes selectionnes aux 
                                                                                              //cartes transferees
            this.cible.setPaquet(this.cible.getPaquet().retireGpePersos(cartesTransferees)); //on retire les cartes a la cible
            getJoueurCourant().ajoutGpePersoPaquet(cartesTransferees);//ajoute au paquet du j courant les cartes transferees
            setHistorique("Le joueur "+getJoueurCourant().getPseudo()+" a pris les cartes de la famille "+
                                            fp+" au joueur "+this.cible.getPseudo());               
        }
        return (this.cartesTransferees.getTaille() == 0) ? 0  : this.cartesTransferees.getTaille() ;
                    //si aucune carte transferee : renvoie 0
                    //sinon renvoie le nb de cartes transferees
    }
 

}
