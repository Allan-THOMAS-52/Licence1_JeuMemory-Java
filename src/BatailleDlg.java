
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;


public class BatailleDlg extends javax.swing.JDialog {

    private LesJoueurs lj;
    private int indj;
    private Joueur adversaire;
    private boolean ok;
    private Bataille b; 

    public BatailleDlg(java.awt.Frame parent, boolean modal, LesJoueurs pLj, int jc) {
        super(parent, modal);
        initComponents();
        this.lj = pLj;
        this.indj = jc;
        this.adversaire = null;
        this.ok = false;
        this.b = null;
        Annuler.setText("Annuler");
        Annuler.setVisible(true);
        Message.setText(this.lj.getJoueur(this.indj).getPseudo()+" va effectuer une bataille contre : ");
        initListeJ();
    }

    public LesJoueurs getLj() {
        return lj;
    }
    public void setLj(LesJoueurs lj) {
        this.lj = lj;
    }
    public int getIndj() {
        return indj;
    }
    public void setIndj(int indj) {
        this.indj = indj;
    }
    public Joueur getAdversaire() {
        return adversaire;
    }
    public void setAdversaire(Joueur adversaire) {
        this.adversaire = adversaire;
    }
    public boolean isOk() {
        return ok;
    }
    public void setOk(boolean ok) {
        this.ok = ok;
    }
    public Bataille getB() {
        return b;
    }
    public void setB(Bataille b) {
        this.b = b;
    }
 
    private void initListeJ(){//initialise la liste des joueurs
        DefaultListModel mod = new DefaultListModel();
        mod.removeAllElements();
        ListeJ.setModel(mod);
        for(int i=0;i<lj.getNbJoueurs();i++)
            mod.addElement(lj.getJoueur(i).getPseudo());//on ajoute tous les joueurs contenus dans lj
        ListeJ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Vainqueur = new javax.swing.JLabel();
        Annuler = new javax.swing.JButton();
        Demarrer = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InfoCarte1 = new javax.swing.JTextArea();
        Carte1 = new javax.swing.JButton();
        Carte2 = new javax.swing.JButton();
        Ic2 = new javax.swing.JScrollPane();
        InfoCarte2 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        Joueur = new javax.swing.JLabel();
        Adversaire = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeJ = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));
        jPanel1.add(Vainqueur);

        Annuler.setText("Annuler/Fermer");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel1.add(Annuler);

        Demarrer.setText("Demarrer");
        Demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemarrerActionPerformed(evt);
            }
        });
        jPanel1.add(Demarrer);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 4));

        InfoCarte1.setColumns(20);
        InfoCarte1.setRows(5);
        jScrollPane2.setViewportView(InfoCarte1);

        jPanel5.add(jScrollPane2);

        Carte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arctice-assassin.jpg"))); // NOI18N
        jPanel5.add(Carte1);

        Carte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/assault-trooper.jpg"))); // NOI18N
        jPanel5.add(Carte2);

        InfoCarte2.setColumns(20);
        InfoCarte2.setRows(5);
        Ic2.setViewportView(InfoCarte2);

        jPanel5.add(Ic2);

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));
        jPanel2.add(Joueur);
        jPanel2.add(Adversaire);

        jPanel4.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));
        jPanel3.add(Message);

        ListeJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeJMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListeJ);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListeJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeJMouseClicked
        Joueur jo = new Joueur();
        int ind = ListeJ.getSelectedIndex();//on recupere l'index de l'objet selectionne
        if(ind!=-1)
            jo = this.lj.getJoueur(indj);
        if(this.lj.getJoueur(ind).getPseudo().equals(jo.getPseudo()))//si le joueur selectionne est = joueur courant
            Joueur.setText("Selectionne un joueur différent !");
        else{
            this.adversaire = this.lj.getJoueur(ind);
            b = new Bataille(jo, this.adversaire);//on lance une bataille avec les deux joueurs
            Annuler.setVisible(true);
            Joueur.setText(jo.getPseudo());
            Adversaire.setText(this.adversaire.getPseudo());
            InfoCarte1.setText(jo.getPaquet().toString());
            InfoCarte2.setText(this.adversaire.getPaquet().toString());
        }
    }//GEN-LAST:event_ListeJMouseClicked

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.ok=false;
        if (Annuler.getText().equals("Annuler"))
            this.b.setHistorique("Bataille interrompue en cours de partie");
         this.setVisible(false);
        this.dispose();   
    }//GEN-LAST:event_AnnulerActionPerformed

    private void DemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemarrerActionPerformed
        Joueur jc = lj.getJoueur(indj); //joueur courant
        if(jc!=null && this.adversaire!=null){
            //afficher les infos des 2 joueurs
            InfoCarte1.append("\n"+jc.getPseudo()+" joue "+jc.getPaquet().getPerso(0)+"\n");
            InfoCarte2.append("\n"+this.adversaire.getPseudo()+" joue "+this.adversaire.getPaquet().getPerso(0)+"\n");
            //execution de la bataille
            int res = b.execute();
            switch(res){
                case 0:
                        InfoCarte1.append("exaequo : aucun gagnant \n");
                        InfoCarte2.append("exaequo : aucun gagnant \n");
                        break;
                case 1:
                        InfoCarte1.append(jc.getPseudo()+" gagne \n");
                        InfoCarte2.append(this.adversaire.getPseudo()+" perd \n");
                        Vainqueur.setText(jc.getPseudo());
                        break;
                case 2:
                        InfoCarte1.append(jc.getPseudo()+" perd \n");
                        InfoCarte2.append(this.adversaire.getPseudo()+" gagne \n");
                        Vainqueur.setText(this.adversaire.getPseudo());
                        break; 
            }
            //affichage nouveaux contenus de paquets
            InfoCarte1.append(jc.getPaquet().toString());
            InfoCarte2.append(this.adversaire.getPaquet().toString());
            //boolean maj
            this.ok = true;
            //plus de cartes
            LesPersonnages pjc = jc.getPaquet();
            LesPersonnages pad = this.adversaire.getPaquet();
            //si un des joueurs n'a plus de cartes
            if(pjc.getTaille()==0||pad.getTaille()==0){
                Demarrer.setEnabled(false);
                Annuler.setText("fermer");
            }
            //si ils ont encore des cartes
            else{
                //affiche la 1ere carte des joueurs
                pjc.getPerso(0).setImgBouton(Carte1);
                pad.getPerso(0).setImgBouton(Carte2);
            }

        }

    }//GEN-LAST:event_DemarrerActionPerformed

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
                BatailleDlg dialog = new BatailleDlg(new javax.swing.JFrame(), true, new LesJoueurs(), 0);
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
    private javax.swing.JLabel Adversaire;
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Carte1;
    private javax.swing.JButton Carte2;
    private javax.swing.JButton Demarrer;
    private javax.swing.JScrollPane Ic2;
    private javax.swing.JTextArea InfoCarte1;
    private javax.swing.JTextArea InfoCarte2;
    private javax.swing.JLabel Joueur;
    private javax.swing.JList<String> ListeJ;
    private javax.swing.JLabel Message;
    private javax.swing.JLabel Vainqueur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
