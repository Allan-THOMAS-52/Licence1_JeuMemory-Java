import java.awt.*;
import javax.swing.*;

public class VisuPersonnagesDlg extends javax.swing.JDialog {

    private Joueur j; //joueur dont on affiche les cartes   

    public VisuPersonnagesDlg(java.awt.Frame parent, boolean modal , Joueur jo) {
        super(parent, modal);
        initComponents();  
        this.j = jo;
        initPanneau();        
        txtScore.setText("Score:"+j.getPaquet().getScore());//affichage du score
        txtNomJoueur.setText("Cartes du joueur : "+j.getPseudo());
    }

    private void initPanneau(){     
        int nb = j.getPaquet().getTaille();//taille du gridL en fonction du nb de cartes
        Panneau.setLayout(new GridLayout(0, 2));//definition du gridLayout
        for (int i=0; i< nb; i++){   //creation des boutons    
            JButton jb= new JButton(); 
            jb.setName(""+i);
            Panneau.add(jb);
        }
        this.pack(); // pour ajuster correctement la taille des composants après les ajouts si besoin
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNomJoueur = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtScore = new javax.swing.JLabel();
        Afficher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNomJoueur.setText("Cartes du joueur :");
        getContentPane().add(txtNomJoueur, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.BorderLayout());

        txtScore.setText("Score :");
        jPanel1.add(txtScore, java.awt.BorderLayout.NORTH);

        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        jPanel1.add(Afficher, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
        for(int i=0;i<j.getPaquet().getTaille();i++){
            JButton jb = (JButton)Panneau.getComponent(i);//on recupere le composant en position i           
            //on definit l'icone du bouton par l'icone du perso 
            Image img = j.getPaquet().getPerso(i).getPhoto().getScaledInstance(jb.getWidth(),jb.getHeight(),Image.SCALE_DEFAULT);
            jb.setIcon(new ImageIcon(img));
        }
        this.pack(); // pour ajuster correctement la taille des composants après les ajouts si besoin
    }//GEN-LAST:event_AfficherActionPerformed
  
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
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisuPersonnagesDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VisuPersonnagesDlg dialog = new VisuPersonnagesDlg(new javax.swing.JFrame(), true, new Joueur());
                dialog.setSize(800,450);//taille de creation, pour eviter que la fenetre soit trop petite
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
    private javax.swing.JButton Afficher;
    private javax.swing.JPanel Panneau;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtNomJoueur;
    private javax.swing.JLabel txtScore;
    // End of variables declaration//GEN-END:variables
}
