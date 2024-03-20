
public class Jeu {

    private LesPersonnages lesPers; //les personnages du jeu
    private LesJoueurs lesJ;        //les joueurs du jeu
    private PlateauJeu monPlateau;  //donne l'etat courant du jeu
    private Action act;             //action a realiser
    private int indice;             //indice du joueur courant

    public LesPersonnages getLesPers() {
        return lesPers;
    }
    public void setLesPers(LesPersonnages lesPers) {
        this.lesPers = lesPers;
    }
    public LesJoueurs getLesJ() {
        return lesJ;
    }
    public void setLesJ(LesJoueurs lesJ) {
        this.lesJ = lesJ;
    }
    public PlateauJeu getPlateau() {
        return monPlateau;
    }
    public void setPlateau(PlateauJeu monPlateau) {
        this.monPlateau = monPlateau;
    }
    public Action getAct() {
        return act;
    }
    public void setAct(Action act) {
        this.act = act;
    }
    public int getIndice() {
        return indice;
    }
    public void setIndice(int indice) {
        this.indice = indice;
    }

    public Jeu(LesPersonnages lp,LesJoueurs lj,int nBc){
        this.lesPers = lp;
        this.lesJ = lj;
        this.indice = 0;
        this.monPlateau = new PlateauJeu(nBc);
        this.act = null; 
    }

    public Joueur getJoueurCourant(){
        return this.lesJ.getJoueur(indice);
    }

    public int getIndSuivant(int ic){
        return (ic+1)%this.lesJ.getNbJoueurs();  //qd on est au dernier joueur, on repart au 1er
    }    

    public void setJoueurCourant(int n){
        this.indice = n;
    }

    public boolean finJeu(){
        return this.monPlateau.jeuVide();
    }

    public int traiterTour(Joueur jo, int s){//permet de donner un bonus au joueur lors du jeu
        int bonus = -1;
        Personnage pers = lesPers.getPerso(s);
        this.lesJ.getJoueur(this.indice).ajoutPersoPaquet(pers);
        String f = pers.getFam();
        int nbf = this.lesPers.getPersosFamille(f).getTaille();
        int nbj = this.lesJ.getJoueur(this.indice).getPaquet().getPersosFamille(f).getTaille();
        if(nbf == nbj){
            if(f.equals(this.lesJ.getJoueur(this.indice).getFamPref())){
                bonus = 0;
                monPlateau.termineJeu();
            }else{
                if(f.equals("rares") || f.equals("communs"))
                    bonus = 1;
                else 
                    if(f.equals("legendaire") || f.equals("epiques"))
                        bonus = 2;
                    else
                        bonus = 3;
            }
        }
        return bonus;
    }
}
