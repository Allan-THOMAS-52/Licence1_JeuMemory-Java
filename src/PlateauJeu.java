
public class PlateauJeu {

    private int tab [ ][ ]; //tableau en deux dimension
    private int nbp; // nombre de personnages sur le plateau qui diminue au cours du jeu
    private int nblig; //nb lignes
    private int nbcol; //nb colonnes

    public PlateauJeu(int n)
    {   this.nbp=n;
        this.nblig=(int)(Math.sqrt(nbp*2)) ;// nb lignes vaut la racine de 2 x le nb de personnages sur le plateau
        this.nbcol=nbp*2/nblig;// nb colonnes vaut nb persos x 2 divise par le nb de lignes
        this.tab=new int [this.nblig][this.nbcol];
        initPlateauJeu();
    }

    public PlateauJeu() { this(4); }
    public int getNblig() { return this.nblig; }
    public int getNbcol() { return this.nbcol; }
    public int getNbp() { return this.nbp; }
    public int getCase(int l, int c) { return tab[l][c]; }
    public int getNbc() { return this.nblig*this.nbcol/2; }

    public void initPlateauJeu()
    { int k=0;
        for(int i=0; i<this.nblig; i++)
            for(int j=0; j<this.nbcol; j++)
                tab[i][j]=(k++)%this.nbp;
        melange();
    }

    public void invalide(int l1, int c1, int l2, int c2){ //permet d'invalider deux cases
        tab[l1][c1]=-1;
        tab[l2][c2]=-1;
        nbp--;
    }
     
    public void melange(){ //permet de melanger les cases de maniere aleatoire
        for(int i=1;i<1000;i++){
            int l1 = (int)Math.random()*nblig;
            int c1 = (int)Math.random()*nbcol;
            int l2 = (int)Math.random()*nblig;
            int c2 = (int)Math.random()*nbcol;
            //echange des cases via une variable tampon
            int temp = tab[l1][c1];
            tab[l1][c1] = tab[l2][c2];
            tab[l2][c2] = temp;
        }        
    }

    public boolean jeuVide(){ //verifie si le jeu est entierement vide
       boolean ok = false;
        int nb=0;
        for(int i=0;i<nblig;i++)
            for(int j=0;j<nbcol;j++)
                if(isValide(i,j)==false)
                    nb++;  
        ok = nb == nblig*nbcol;                 
        return ok;
    }

    public boolean isValide(int l, int c){ // verifie si une case est valide
        if(tab[l][c]!=1)
            return true;
        else
            return false;
    }

    public void termineJeu(){ //definit toutes les cases comme invalides
        for(int i=0;i<nblig;i++)
            for(int j=0;j<nbcol;j++)
                tab[i][j] = -1;
        this.nbp = 0;       
    } 
}
