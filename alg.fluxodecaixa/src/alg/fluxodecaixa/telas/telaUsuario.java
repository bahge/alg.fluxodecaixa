/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg.fluxodecaixa.telas;

/**
 *
 * @author bahge
 */
public class telaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form telaUsuario
     */
    public telaUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblQuestion = new javax.swing.JLabel();
        bttInsertReceitas = new javax.swing.JButton();
        bttInserirDespesas = new javax.swing.JButton();
        bttMostrarRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Painel do usuário");

        lblQuestion.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("O que você deseja fazer?");

        bttInsertReceitas.setText("Inserir Receitas");
        bttInsertReceitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttInsertReceitasActionPerformed(evt);
            }
        });

        bttInserirDespesas.setText("Inserir Despesas");
        bttInserirDespesas.setToolTipText("");
        bttInserirDespesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttInserirDespesasActionPerformed(evt);
            }
        });

        bttMostrarRelatorio.setText("Mostrar Relatório");
        bttMostrarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttMostrarRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bttInsertReceitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttInserirDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttMostrarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblQuestion)
                .addGap(30, 30, 30)
                .addComponent(bttInsertReceitas)
                .addGap(18, 18, 18)
                .addComponent(bttInserirDespesas)
                .addGap(18, 18, 18)
                .addComponent(bttMostrarRelatorio)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttInsertReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttInsertReceitasActionPerformed
        telaReceita tela = new telaReceita();
        tela.setVisible(true);
    }//GEN-LAST:event_bttInsertReceitasActionPerformed

    private void bttInserirDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttInserirDespesasActionPerformed
        telaDespesa tela = new telaDespesa();
        tela.setVisible(true);
    }//GEN-LAST:event_bttInserirDespesasActionPerformed

    private void bttMostrarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttMostrarRelatorioActionPerformed
        telaRelatorio tela = new telaRelatorio();
        tela.setVisible(true);
    }//GEN-LAST:event_bttMostrarRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttInserirDespesas;
    private javax.swing.JButton bttInsertReceitas;
    private javax.swing.JButton bttMostrarRelatorio;
    private javax.swing.JLabel lblQuestion;
    // End of variables declaration//GEN-END:variables
}
