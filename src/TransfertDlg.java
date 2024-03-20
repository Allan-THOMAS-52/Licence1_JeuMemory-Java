
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TransfertDlg extends javax.swing.JDialog {

    private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs
    private int indj; //indice joueur courant
    private Transfert tc; 
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné

    public void setOk(boolean pOk){this.ok = pOk;}            
    public boolean getOk(){return this.ok;}            
    public void setTc(Transfert pTc){ this.tc = pTc;}   
    public Transfert getTc(){ return this.tc;}
       
    

    public TransfertDlg(java.awt.Frame parent, boolean modal, LesJoueurs pLj, int pIndj) {
        super(parent, modal);
        initComponents();
        this.lj = pLj;
        this.indj = pIndj ;
        this.tc=null;
        this.ok=false;
        this.fs=null;
        initCombo(); // méthode pour remplir la liste déroulante
        indjs = 0;

        //indique que le joueur a obtenu une famille complete
        Message.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");
        
        //affiche a quel joueur les persos appartiennent, et le paquet du joueur
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());
    }

    public void initCombo(){
        for(int i=0;i<lj.getNbJoueurs();i++)
            ComboJoueurs.addItem(lj.getJoueur(i).getPseudo());
    }

    public void initPanneau(){
        PanneauG.removeAll();
        this.repaint();
        LesPersonnages lcs = new LesPersonnages();
        lcs = lj.getJoueur(this.indjs).getPaquet();
        int t = lcs.getTaille();
        int n = 1+(t-1)/4;
        PanneauG.setLayout(new java.awt.GridLayout(4,n));//definition du gridLayout
        for(int i=0;i<t;i++){//pour chaque emplacement, on cree un bouton,lui donne comme nom le nom d'une famille et lui assigne
                             //un ActionListener
            JButton bouton= new JButton();
            bouton.setName(lcs.getPerso(i).getFam());
            bouton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boutonActionPerformed(evt);
                }
            });
            PanneauG.add(bouton);
        }
        this.pack();
    }
   
    private void affichePanneau(){
        LesPersonnages lcs = lj.getJoueur(indjs).getPaquet();
        int t = lcs.getTaille();
        for (int i=0; i<t; i++){//affiche les images sur les boutons
            JButton bt = (JButton)PanneauG.getComponent(i);
            Personnage p = lcs.getPerso(i);
            p.setImgBouton(bt);
        }
    }

    public void creePanneau(JPanel jp, LesPersonnages lc){
        jp.removeAll();
        this.repaint();
        int t = lc.getTaille();
        int n = 1+(t-1)/4;
        jp.setLayout(new java.awt.GridLayout(t,n));//definition du gridLayout
        for(int i=0;i<t;i++){//pour chaque emplacement, on cree un bouton,lui donne comme nom le nom d'une famille
            JButton bouton= new JButton();//cree un bouton
            bouton.setName(lc.getPerso(i).getFam());
            jp.add(bouton);
        }
        this.pack();
    }

    private void dessinePanneau(JPanel jp, LesPersonnages lc){
        int t = lc.getTaille();
        for (int i=0; i<t; i++){//affiche les images sur les boutons
            JButton bt = (JButton) jp.getComponent(i);
            Personnage p = lc.getPerso(i);
            p.setImgBouton(bt);
        }
    }

    private void boutonActionPerformed(ActionEvent evt)
    {
        LesPersonnages lp = lj.getJoueur(indjs).getPaquet();//recupere le paquet du joueur selectionne
        int t = lp.getTaille(); //taille du paquet
        JButton bt=(JButton) evt.getSource();//recupere la source de l'evenement
        fs = bt.getName(); // la proprité Name, contient ici le nom du personnage affiché sur le bouton
        for(int i = 0; i < t; i++) {
            JButton b = (JButton)(PanneauG.getComponent(i));//recupere le composant i du panneau
            if (b.getName().equals(fs))
                //dessin d'une bordure rouge autour des persos de meme famille
                b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));
            else
                //sinon pas de bordure
                b.setBorder(null);
            }
        //affiche le nb de persos que le joueur peut recuperer et leur nom
        LesPersonnages lps = lp.getPersosFamille(fs);
        Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps.getPersos().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauG = new javax.swing.JPanel();
        JPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        JCourant = new javax.swing.JLabel();
        JCible = new javax.swing.JLabel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Transfert = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        PanneauG.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauG);

        JPanel.setLayout(new java.awt.GridLayout(2, 1));

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        Message.setText("jLabel1");
        jPanel1.add(Message);
        jPanel1.add(JCourant);
        jPanel1.add(JCible);

        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJoueursActionPerformed(evt);
            }
        });
        jPanel1.add(ComboJoueurs);

        JPanel.add(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        Transfert.setText("Transfert");
        Transfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertActionPerformed(evt);
            }
        });
        jPanel3.add(Transfert);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel3.add(Fermer);

        jPanel2.add(jPanel3, java.awt.BorderLayout.SOUTH);

        JPanel.add(jPanel2);

        getContentPane().add(JPanel);

        PanneauD.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJoueursActionPerformed
       this.indjs = ComboJoueurs.getSelectedIndex();//met l'indice du joueur selectionne dans indjs
        if (indjs != -1){
            if (this.indjs == this.indj) { //si indice joueur selectionne = joueur courant
                Infos.setText("Sélectionnez un joueur différent du joueur courant !");
                PanneauG.removeAll();//vide le panneau de gauche
                PanneauG.repaint();//rafraichit le panneau 
            }
            else {
                Infos.setText("\nJoueur sélectionné: "+lj.getJoueur(indjs).toString());//affiche le joueur selectionne
                initPanneau();
                affichePanneau();
            }
        }
    }//GEN-LAST:event_ComboJoueursActionPerformed

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        this.ok=false;
        this.dispose();
    }//GEN-LAST:event_FermerActionPerformed

    private void TransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertActionPerformed
        if(indjs!=-1 && fs != null){
            tc = new Transfert(lj.getJoueur(indjs),lj.getJoueur(indj),fs);
            if(tc.execute() > 0){//qd on transfert des cartes selectionnes, on raffraichit les panneaux
                                 //on renvoie true et on disable le bouton transfert
                LesPersonnages lP = tc.getCartesTransferees();

                creePanneau(PanneauD,lP);
                dessinePanneau(PanneauD,lP); 
            
                LesPersonnages lPS = this.lj.getJoueur(this.indjs).getPaquet();
                 
                creePanneau(PanneauG,lPS);
                dessinePanneau(PanneauG,lPS); 
             
                this.ok = true;
                Transfert.setEnabled(false);
            }
        }
        else
            Infos.setText("Il est nécessaire de sélectionner un joueur qui a au moins une carte");
    }//GEN-LAST:event_TransfertActionPerformed

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
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisuJoueursDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TransfertDlg dialog = new TransfertDlg(new javax.swing.JFrame(), true,  new LesJoueurs(), 0 );
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setSize(1000,600);
                dialog.setVisible(true);
            }
        });
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JButton Fermer;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel JCible;
    private javax.swing.JLabel JCourant;
    private javax.swing.JPanel JPanel;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JButton Transfert;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
