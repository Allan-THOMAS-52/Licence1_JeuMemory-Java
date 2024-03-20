import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class SaisieJoueurDlg extends javax.swing.JDialog {
    
    private boolean ok;//indicateur de fermeture
    private Joueur joueur;//le joueur qui va etre cree
    private Image photo;//photo du joueur
    private LesPersonnages lp;//liste familles existantes ( famille preferee du joueur )

    public SaisieJoueurDlg(java.awt.Frame parent, boolean modal, LesPersonnages lstj) {
        super(parent, modal);
        initComponents();       
        this.lp = lstj;       
        initListeFamille();
        this.ok=false;
        this.joueur = new Joueur();
    }

    public boolean getOk(){ return this.ok; }
    public Joueur getJoueur(){ return this.joueur;}
        
    private void initListeFamille(){
        ArrayList<String> lst;
        DefaultListModel mod = new DefaultListModel();//creation d'un modele pour la JList
        ListeFamilles.setModel(mod);//application du model
        lst = lp.getFamilles();//lst contient les familles des personnages contenus dans lp
        for(int i = 0;i<lst.size();i++)
            mod.addElement(lst.get(i));//ajout de chaque famille dans le modele et donc dans la JList 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPseudo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListeFamilles = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Parcourir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Photo = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Créez votre joueur !");
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.GridLayout(3, 1));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Donnez votre pseudo :");
        jPanel4.add(jLabel2, java.awt.BorderLayout.NORTH);

        txtPseudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPseudoActionPerformed(evt);
            }
        });
        jPanel4.add(txtPseudo, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Quelle est votre famille préférée de personnages ?");
        jPanel5.add(jLabel3, java.awt.BorderLayout.NORTH);

        jScrollPane2.setViewportView(ListeFamilles);

        jPanel5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Choisissez une photo :");
        jPanel6.add(jLabel4, java.awt.BorderLayout.NORTH);

        Parcourir.setText("Parcourir");
        Parcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParcourirActionPerformed(evt);
            }
        });
        jPanel6.add(Parcourir, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(Photo, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel7.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel7.add(Valider);

        jPanel3.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPseudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPseudoActionPerformed
        //ne fais rien, je n'ai pas reussi a supprimer la methode :/
    }//GEN-LAST:event_txtPseudoActionPerformed

    private void ParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParcourirActionPerformed
        //creation fenetre de choix de fichier qui commence au repertoire principal
        JFileChooser choose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	
        choose.setDialogTitle("Choisissez une photo: ");     //titre de la fenetre
        choose.setFileSelectionMode(JFileChooser.FILES_ONLY);//on autorise uniquement les fichiers et non les dossiers
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images JPG et GIF", "jpg", "gif");//creation d'un filtre
        choose.setAcceptAllFileFilterUsed(false);   // refus de tous les types de fichier     
        choose.addChoosableFileFilter(filter);      //acceptation de seulement les fichiers du filtre "filtre"

        int res = choose.showOpenDialog(this);          // Ouvre le fichier

        if (res == JFileChooser.APPROVE_OPTION) {       //si un fichier est choisi
                File file = choose.getSelectedFile();   //variable contenant le fichier choisi
                String path = file.getAbsolutePath();   //variable contenant le chemin du fichier
                ImageIcon pathI = new ImageIcon(path);  //creation d'une imageIcon du fichier
                Photo.setIcon(pathI);                   //application de l'imageIcon au bouton
                photo = pathI.getImage();               //application de l'image choisie a l'attribut photo
        }			
        choose.setVisible(true);                        //rend la fenetre visible
    }//GEN-LAST:event_ParcourirActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        if(txtPseudo.getText().equals("") || txtPseudo.getText().equals("Pseudo vide !"))
            txtPseudo.setText("Pseudo vide !");
        else{
            if(!ListeFamilles.isSelectionEmpty()){               
                //construction joueur
                this.joueur.setPseudo(txtPseudo.getText());//ajout du pseudo
                this.joueur.setFamPref(ListeFamilles.getSelectedValue()); //ajout de la famille preferee
                this.joueur.setScore(0);//ajout du score
                if(Photo.getIcon()!=null)//si une photo est selectionnee, on l'assigne au joueur
                    joueur.setPhoto(photo);
                this.ok = true;
                dispose(); //ferme la fenetre active 
            }
        }       
    }//GEN-LAST:event_ValiderActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        this.ok = false;
        dispose(); //ferme la fenetre active
    }//GEN-LAST:event_AnnulerActionPerformed

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
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaisieJoueurDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaisieJoueurDlg dialog = new SaisieJoueurDlg(new javax.swing.JFrame(), true, new LesPersonnages());
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
    private javax.swing.JList<String> ListeFamilles;
    private javax.swing.JButton Parcourir;
    private javax.swing.JButton Photo;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtPseudo;
    // End of variables declaration//GEN-END:variables
}
