
import java.awt.Image;
import javax.swing.ImageIcon;


public class InitDlg extends javax.swing.JDialog {

    private LesJoueurs lj; //les joueurs selectionnes
    private boolean ok;//indicateur de fermeture
    private int nc;//niveau du jeu (4,10,18,32)

    public InitDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);//constructeur de la classe ancetre, ici JDialog
        initComponents();       
        this.lj = new LesJoueurs();
        this.ok = false;
        this.nc = 4;
        NbPerso4.setSelected(true);
    }

    public LesJoueurs getJoueurs(){ return this.lj; }       
    public boolean getOk(){ return this.ok; }              
    public int getNiveau(){ return this.nc; }
          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        taille = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        NbPerso4 = new javax.swing.JRadioButton();
        NbPerso10 = new javax.swing.JRadioButton();
        NbPerso18 = new javax.swing.JRadioButton();
        NbPerso32 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        caseLara = new javax.swing.JCheckBox();
        caseJack = new javax.swing.JCheckBox();
        caseJean = new javax.swing.JCheckBox();
        caseMozart = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        BPhoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel1.add(Valider);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choisissez la taille du jeu");
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.GridLayout(4, 1));

        taille.add(NbPerso4);
        NbPerso4.setText("enfant (4 personnages, 2 familles)");
        NbPerso4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbPerso4ActionPerformed(evt);
            }
        });
        jPanel6.add(NbPerso4);

        taille.add(NbPerso10);
        NbPerso10.setText("débutant (10 personnages, 4 familles)");
        NbPerso10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbPerso10ActionPerformed(evt);
            }
        });
        jPanel6.add(NbPerso10);

        taille.add(NbPerso18);
        NbPerso18.setText("avancé (18 personnages, 4 familles)");
        NbPerso18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbPerso18ActionPerformed(evt);
            }
        });
        jPanel6.add(NbPerso18);

        taille.add(NbPerso32);
        NbPerso32.setText("expert (32 personnages, 6 familles)");
        NbPerso32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbPerso32ActionPerformed(evt);
            }
        });
        jPanel6.add(NbPerso32);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choisissez les joueurs créés par défaut");
        jPanel4.add(jLabel2, java.awt.BorderLayout.NORTH);

        jPanel7.setLayout(new java.awt.GridLayout(4, 1));

        caseLara.setText("Lara");
        caseLara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseLaraActionPerformed(evt);
            }
        });
        jPanel7.add(caseLara);

        caseJack.setText("Jack");
        caseJack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseJackActionPerformed(evt);
            }
        });
        jPanel7.add(caseJack);

        caseJean.setText("Jean-Sébastien");
        caseJean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseJeanActionPerformed(evt);
            }
        });
        jPanel7.add(caseJean);

        caseMozart.setText("Amadeus");
        caseMozart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caseMozartActionPerformed(evt);
            }
        });
        jPanel7.add(caseMozart);

        jPanel4.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(2, 1));

        Edition.setColumns(20);
        Edition.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        jPanel5.add(jScrollPane1);
        jPanel5.add(BPhoto);

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.ok = false;
        dispose();//ferme la fenetre active
    }//GEN-LAST:event_AnnulerActionPerformed

    private void NbPerso4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbPerso4ActionPerformed
        this.nc = 4;
    }//GEN-LAST:event_NbPerso4ActionPerformed

    private void NbPerso10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbPerso10ActionPerformed
        this.nc = 10;
    }//GEN-LAST:event_NbPerso10ActionPerformed

    private void NbPerso18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbPerso18ActionPerformed
        this.nc = 18;
    }//GEN-LAST:event_NbPerso18ActionPerformed

    private void NbPerso32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbPerso32ActionPerformed
        this.nc = 32;
    }//GEN-LAST:event_NbPerso32ActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        //regarde si les cases sont selectionnes, et cree et ajoute les persos a lj le cas echeant
        if(caseLara.isSelected()==true){
            Joueur lara = new Joueur("Lara", "epiques");
            lara.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg")).getImage());       
            lj.ajouteJoueur(lara);
        }
        if(caseJack.isSelected()==true){
            Joueur jack = new Joueur("Jack", "rares");
            jack.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")).getImage());       
            lj.ajouteJoueur(jack);
        }
        if(caseJean.isSelected()==true){
            Joueur jean=new Joueur("Jean-Sébastien", "alpins-femmes");
            jean.setPhoto(new ImageIcon(getClass().getResource("/img/bach.jpg")).getImage());       
            lj.ajouteJoueur(jean);
        }
        if(caseMozart.isSelected()==true){
            Joueur mozart=new Joueur("Amadeus", "communs");
            mozart.setPhoto(new ImageIcon(getClass().getResource("/img/mozart.jpg")).getImage());       
            lj.ajouteJoueur(mozart);
        }

        this.ok = true;
        dispose();//ferme la fenetre active
    }//GEN-LAST:event_ValiderActionPerformed

    private void caseLaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseLaraActionPerformed
        //verifie si la checkBox est selectionnee.Cree le personnage,
        //affiche sa photo sur le bouton BPhoto et affiche ses informations dans Edition 
        if(caseLara.isSelected()){
            Joueur j=new Joueur("Lara", "epiques");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/lara.jpg")).getImage());       
            Edition.setText(j.toString());
            Image img = j.getPhoto().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_DEFAULT);
            BPhoto.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_caseLaraActionPerformed

    private void caseJackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseJackActionPerformed
        //verifie si la checkBox est selectionnee.Cree le personnage,
        //affiche sa photo sur le bouton BPhoto et affiche ses informations dans Edition         
        if(caseJack.isSelected()){
            Joueur j=new Joueur("Jack", "rares");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/jack.png")).getImage());       
            Edition.setText(j.toString());
            Image img = j.getPhoto().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_DEFAULT);
            BPhoto.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_caseJackActionPerformed

    private void caseJeanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseJeanActionPerformed
        //verifie si la checkBox est selectionnee.Cree le personnage,
        //affiche sa photo sur le bouton BPhoto et affiche ses informations dans Edition 
        if(caseJean.isSelected()){
            Joueur j=new Joueur("Jean-Sébastien", "alpins-femmes");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/bach.jpg")).getImage());       
            Edition.setText(j.toString());
            Image img = j.getPhoto().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_DEFAULT);
            BPhoto.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_caseJeanActionPerformed

    private void caseMozartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caseMozartActionPerformed
        //verifie si la checkBox est selectionnee.Cree le personnage,
        //affiche sa photo sur le bouton BPhoto et affiche ses informations dans Edition 
        if(caseMozart.isSelected()){
            Joueur j=new Joueur("Amadeus", "communs");
            j.setPhoto(new ImageIcon(getClass().getResource("/img/mozart.jpg")).getImage());       
            Edition.setText(j.toString());
            Image img = j.getPhoto().getScaledInstance(BPhoto.getWidth(),BPhoto.getHeight(),Image.SCALE_DEFAULT);
            BPhoto.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_caseMozartActionPerformed

    
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
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InitDlg dialog = new InitDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Annuler;
    private javax.swing.JButton BPhoto;
    private javax.swing.JTextArea Edition;
    private javax.swing.JRadioButton NbPerso10;
    private javax.swing.JRadioButton NbPerso18;
    private javax.swing.JRadioButton NbPerso32;
    private javax.swing.JRadioButton NbPerso4;
    private javax.swing.JButton Valider;
    private javax.swing.JCheckBox caseJack;
    private javax.swing.JCheckBox caseJean;
    private javax.swing.JCheckBox caseLara;
    private javax.swing.JCheckBox caseMozart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup taille;
    // End of variables declaration//GEN-END:variables
}
