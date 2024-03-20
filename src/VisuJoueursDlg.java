import java.awt.*;
import javax.swing.*;

public class VisuJoueursDlg extends javax.swing.JDialog {

    private LesJoueurs lj;

    public VisuJoueursDlg(java.awt.Frame parent, boolean modal, LesJoueurs lstj) {
        super(parent, modal);
        initComponents();       
        this.lj = lstj;
        initTrombi();       
    }
    
    private void initTrombi(){    
        int nb = this.lj.getNbJoueurs();//met dans nb le nombre de joueurs contenus dans lj
        Panneau.setLayout(new GridLayout(1, nb));//on definit le layout du panneau
        for (int i=0; i< nb; i++){      
            JButton jb= new JButton();//cree un bouton
            Joueur j= lj.getJoueur(i);//met dans j la reference du joueur d'index i
            jb.setName(""+i);
            //cree un actionLIstener pour le bouton cree qui lance la fonction AfficheInfosJoueur() 
            jb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AfficheInfosJoueur(evt);
                }
            });
            Panneau.add(jb);//enfin on ajoute le bouton au panneau
        }
        this.pack(); // pour ajuster correctement la taille des composants après les ajouts si besoin
    }

    private void AfficheTrombi(){
        for(int i=0;i<this.lj.getNbJoueurs();i++){
            JButton jb = (JButton)Panneau.getComponent(i);//un bouton jb referencie le bouton d'index i contenu dans le panneau
            Joueur j = this.lj.getJoueur(i);//met dans j la reference du joueur d'index i
            //definit l'icone de jb en prenant la photo du joueur
            Image img = j.getPhoto().getScaledInstance(jb.getWidth(),jb.getHeight(),Image.SCALE_DEFAULT);
            jb.setIcon(new ImageIcon(img));
        }
    }

    private void AfficheInfosJoueur(java.awt.event.ActionEvent evt){
        
        String name = ((JButton) evt.getSource()).getName();// on recupere le nom du composant qui emet des donnees
        int id = Integer.valueOf(name);//on convertit le nom en int (le nom est un String mais de forme "1", ou "20" par exemple
        //on affiche les infos du joueur dans Edition
        Edition.setText("Joueur :"+this.lj.getJoueur(id).getPseudo()+"\n");
        Edition.append("Famille préférée:"+this.lj.getJoueur(id).getFamPref()+"\n");
        Edition.append("En possession des personnages:"+"\n");
        Edition.append("Score:"+this.lj.getJoueur(id).getScore()+"\n"); 
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Afficher = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        Panneau = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 516));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choisissez un joueur pour voir ses caractéristiques");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        Afficher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        getContentPane().add(Afficher, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane2.setViewportView(Edition);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        jPanel1.add(Panneau, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
        AfficheTrombi();
    }//GEN-LAST:event_AfficherActionPerformed

    /**
     * @param args the command line arguments
     */
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
                VisuJoueursDlg dialog = new VisuJoueursDlg(new javax.swing.JFrame(), true, new LesJoueurs() );
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
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
