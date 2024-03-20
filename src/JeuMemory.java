import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JeuMemory extends javax.swing.JFrame {

    private LesPersonnages persos;
    private LesJoueurs joueurs;
    private Jeu monJeu;
    private int l1,l2,c1,c2;

    private JButton but1;//permet certaines actions sur les cases que l'on clique
    private JButton but2;

    private PlateauJeu getPlateau(){return this.monJeu.getPlateau();}
        
    public JeuMemory() {
        initComponents();
        this.l1=l2=c1=c2=-1;
        this.persos = new LesPersonnages();
        this.joueurs = new LesJoueurs();
        this.monJeu = new Jeu(persos, joueurs,4);       
    }

    private void boutonActionPerformed(ActionEvent evt){
        JButton bout = (JButton) evt.getSource();//prend la source de l'evenement
        String name = bout.getName();
        int lig=0,col=0,nb=0;

        //permet de trouver la ligne du bouton clické
        for(int i=0;i<this.monJeu.getPlateau().getNblig();i++){
            for(int j=0;j<this.monJeu.getPlateau().getNbcol();j++){
                if(nb == Integer.parseInt(name)){
                    lig=i;
                    break;
                }
                else
                    nb++;
            }
            if(nb == Integer.parseInt(name))
                break;          
        }

        //permet de trouver la colonne du bouton clické
        col=Integer.parseInt(name)%this.monJeu.getPlateau().getNbcol();

        Personnage p = this.persos.getPerso(this.monJeu.getPlateau().getCase(lig, col));
        p.setImgBouton(bout);

        if(l1 == -1 && c1 == -1){
            l1 = lig;
            c1 = col;
            this.but1=bout;
        }else if(l2 == -1 && c2 == -1){
                l2 = lig;
                c2 = col;
                this.but2=bout;
                startTimer();
            }
    }

    public void startTimer(){
        // définit un timer qui lance la vérification des deux personnages au bout d'une demi-seconde
        Timer t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                verifPersos();
            }
        });
        t.setRepeats(false);
        t.start();
    }

    public void verifPersos(){
        if(this.monJeu.getPlateau().getCase(l1,c1) == this.monJeu.getPlateau().getCase(l2,c2)){
            String fam = this.persos.getPerso(this.monJeu.getPlateau().getCase(l1,c1)).getFam();
            int bonus = this.monJeu.traiterTour(this.monJeu.getJoueurCourant(),this.monJeu.getPlateau().getCase(l1,c1));
            if(bonus >=0){
                Edition.append("Le joueur "+this.monJeu.getJoueurCourant().getPseudo()+" a gagné tous les personnages de la famille "
                                    +fam);
                if(bonus == 0){
                    this.monJeu.getPlateau().termineJeu();
                    Edition.append("Le joueur "+this.monJeu.getJoueurCourant().getPseudo()+" a gagné");
                    for (int j=0; j<this.monJeu.getPlateau().getNblig()*this.monJeu.getPlateau().getNbcol() ; j++)
                        Panneau.getComponent(j).setEnabled(false);
                    Demarrer.setEnabled(false);
                }
                if(bonus == 1){
                    TransfertDlg trans = new TransfertDlg(this,true,this.joueurs,
                                            this.joueurs.getIndiceJoueur(this.monJeu.getJoueurCourant()));
                    trans.setSize(1000,600);
                    trans.setVisible(true);
                    
                    System.out.println("Le joueur "+trans.getTc().getJoueurCible().getPseudo()+" a recu les personnages : "+
                                                   trans.getTc().getCartesTransferees().tostring());
                } 
                if(bonus == 2){
                    
                    BatailleDlg bat = new BatailleDlg(this, true, this.joueurs, 
                                            this.joueurs.getIndiceJoueur(this.monJeu.getJoueurCourant()));
                    bat.setSize(1000,600);
                    bat.setVisible(true);
                    System.out.println(bat.getB().getHistorique());
                }
                bonus = -1;
                this.monJeu.setJoueurCourant(this.monJeu.getIndSuivant(this.joueurs.getIndiceJoueur(this.monJeu.getJoueurCourant())));
            }
            this.monJeu.getPlateau().invalide(l1, c1, l2, c2);

            if(this.monJeu.getPlateau().jeuVide())
                Edition.setText(this.joueurs.getGagnants().tostring());
            else
                Edition.setText("C'est à "+this.monJeu.getJoueurCourant().getPseudo()+" de jouer");

            this.monJeu.getJoueurCourant().setScore(this.monJeu.getJoueurCourant().getScore()+
                                    this.persos.getPerso(this.monJeu.getPlateau().getCase(l1, l2)).getValeur());

            NbPersosT.setText("Nb de personnages trouvés : "+(this.monJeu.getPlateau().getNbc()-this.monJeu.getPlateau().getNbp()));
            NbPersosR.setText("Nb de personnages restants : "+this.monJeu.getPlateau().getNbp());
        }
        else{
            this.but1.setIcon(null);
            this.but2.setIcon(null);
            this.monJeu.setJoueurCourant(this.monJeu.getIndSuivant(this.joueurs.getIndiceJoueur(this.monJeu.getJoueurCourant())));
            Jc.setText("C'est à "+this.monJeu.getJoueurCourant().getPseudo()+" de jouer");
            Edition.setText("C'est à "+this.monJeu.getJoueurCourant().getPseudo()+" de jouer");
        }
        l1=l2=c1=c2=-1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        NbPersosT = new javax.swing.JLabel();
        NbPersosR = new javax.swing.JLabel();
        Jc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Demarrer = new javax.swing.JButton();
        Recommencer = new javax.swing.JButton();
        Panneau = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Options = new javax.swing.JMenuItem();
        AjoutJoueur = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Joueurs = new javax.swing.JMenuItem();
        VisuPerso = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Transfert_Test = new javax.swing.JMenuItem();
        Bataille = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memory");

        jPanel1.setPreferredSize(new java.awt.Dimension(360, 470));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(3, 1));
        jPanel2.add(NbPersosT);
        jPanel2.add(NbPersosR);

        Jc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel2.add(Jc);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 122));

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        Demarrer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Demarrer.setText("Demarrer");
        Demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemarrerActionPerformed(evt);
            }
        });
        jPanel3.add(Demarrer);

        Recommencer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Recommencer.setText("Recommencer");
        Recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommencerActionPerformed(evt);
            }
        });
        jPanel3.add(Recommencer);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        Panneau.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Paramètres");

        Options.setText("Options");
        Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsActionPerformed(evt);
            }
        });
        jMenu1.add(Options);

        AjoutJoueur.setText("Ajout Joueur");
        AjoutJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutJoueurActionPerformed(evt);
            }
        });
        jMenu1.add(AjoutJoueur);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Visualiser");

        Joueurs.setText("Joueur");
        Joueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoueursActionPerformed(evt);
            }
        });
        jMenu2.add(Joueurs);

        VisuPerso.setText("Carte");
        VisuPerso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisuPersoActionPerformed(evt);
            }
        });
        jMenu2.add(VisuPerso);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Actions");

        Transfert_Test.setText("Transfert");
        Transfert_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Transfert_TestActionPerformed(evt);
            }
        });
        jMenu3.add(Transfert_Test);

        Bataille.setText("Bataille");
        Bataille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatailleActionPerformed(evt);
            }
        });
        jMenu3.add(Bataille);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsActionPerformed
        InitDlg diag = new InitDlg(this,true);//creation d'une boite de dialog de type InitDlg
        diag.setSize(1000,600);
        diag.setVisible(true);
        if(diag.getOk()){ //accesseur pour recuperer l'indicateur
            LesJoueurs lj = diag.getJoueurs();
            for(int i=0;i<diag.getJoueurs().getNbJoueurs();i++)               
                this.joueurs.ajouteJoueur(lj.getJoueur(i)); //accesseur pour recuperer les joueurs choisis
            this.persos = new LesPersonnages(diag.getNiveau());
            this.monJeu = new Jeu(this.persos,this.joueurs,diag.getNiveau()); 
        }
    }//GEN-LAST:event_OptionsActionPerformed

    private void JoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoueursActionPerformed
        VisuJoueursDlg diag = new VisuJoueursDlg(this, true, this.joueurs); //creation d'une boite de dialog de type VisuJoueursDlg
        diag.setSize(1000,600);
        diag.setVisible(true);
    }//GEN-LAST:event_JoueursActionPerformed

    private void AjoutJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutJoueurActionPerformed
        SaisieJoueurDlg diag = new SaisieJoueurDlg(this, true, this.persos);//creation d'une boite de dialog de type SaisieJoueurDlg
        diag.setSize(1000,600);
        diag.setVisible(true);
        if(diag.getOk()==true)
            this.joueurs.ajouteJoueur(diag.getJoueur());
    }//GEN-LAST:event_AjoutJoueurActionPerformed

    private void VisuPersoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisuPersoActionPerformed
        //creation d'une boite de dialog de type VisuPersonnagesDlg
        VisuPersonnagesDlg diag = new VisuPersonnagesDlg(this, true, this.monJeu.getJoueurCourant()); 
        diag.setSize(1000,600);
        diag.setVisible(true);
    }//GEN-LAST:event_VisuPersoActionPerformed

    private void Transfert_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Transfert_TestActionPerformed
        TransfertDlg diag = new TransfertDlg(this,true,this.joueurs,this.joueurs.getIndiceJoueur(this.monJeu.getJoueurCourant()));
        diag.setSize(1000,600);
        diag.setVisible(true);
    }//GEN-LAST:event_Transfert_TestActionPerformed

    private void BatailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatailleActionPerformed
        BatailleDlg diag = new BatailleDlg(this, true, this.joueurs, this.joueurs.getIndiceJoueur(this.monJeu.getJoueurCourant()));
        diag.setSize(1000,600);
        diag.setVisible(true);
    }//GEN-LAST:event_BatailleActionPerformed

    private void DemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemarrerActionPerformed
        if(this.joueurs.getNbJoueurs()>=2){

            //disable ou enable des boutons
            Demarrer.setEnabled(false);
            Recommencer.setEnabled(false);
            Options.setEnabled(false);
            AjoutJoueur.setEnabled(false);
            AjoutJoueur.setEnabled(true);
            Joueurs.setEnabled(true);
            VisuPerso.setEnabled(true);

            int nc = this.monJeu.getPlateau().getNbc();
            NbPersosT.setText("Nb de personnages trouvés : "+(nc-this.monJeu.getPlateau().getNbp()));
            NbPersosR.setText("Nb de personnages restants : "+this.monJeu.getPlateau().getNbp());
            Jc.setText("C'est à "+this.monJeu.getJoueurCourant().getPseudo()+" de jouer");

            //construction dynamique du JPanel Panneau
            int l = this.monJeu.getPlateau().getNblig();
            int c = this.monJeu.getPlateau().getNbcol();
            Panneau.setLayout(new GridLayout(l,c));
            
            for(int i=0;i<2*nc;i++){
                JButton bt = new JButton();
                bt.setName(""+i);
                bt.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        boutonActionPerformed(evt);
                    }
                });
                Panneau.add(bt);
            }      
        }
        else
            Edition.setText("Selectionnez au moins 2 joueurs");
    }//GEN-LAST:event_DemarrerActionPerformed

    private void RecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommencerActionPerformed
        this.joueurs = new LesJoueurs();
        this.monJeu = new Jeu(this.persos,this.joueurs,4);
    }//GEN-LAST:event_RecommencerActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuMemory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                JeuMemory jm = new JeuMemory();
                jm.setVisible(true);
                jm.setSize(1250,850);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AjoutJoueur;
    private javax.swing.JMenuItem Bataille;
    private javax.swing.JButton Demarrer;
    private javax.swing.JTextArea Edition;
    private javax.swing.JLabel Jc;
    private javax.swing.JMenuItem Joueurs;
    private javax.swing.JLabel NbPersosR;
    private javax.swing.JLabel NbPersosT;
    private javax.swing.JMenuItem Options;
    private javax.swing.JPanel Panneau;
    private javax.swing.JButton Recommencer;
    private javax.swing.JMenuItem Transfert_Test;
    private javax.swing.JMenuItem VisuPerso;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
