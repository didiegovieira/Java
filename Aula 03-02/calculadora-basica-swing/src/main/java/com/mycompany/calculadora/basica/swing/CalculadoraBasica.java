/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.calculadora.basica.swing;

/**
 *
 * @author Diego
 */
public class CalculadoraBasica extends javax.swing.JFrame {

   
    /**
     * Creates new form CalculadoraBasica
     */
    public CalculadoraBasica() {
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

        lblCalculadora = new javax.swing.JLabel();
        txtNumero01 = new javax.swing.JTextField();
        btnSoma = new javax.swing.JButton();
        txtNumero02 = new javax.swing.JTextField();
        lblResultado = new javax.swing.JLabel();
        btnSubtracao = new javax.swing.JButton();
        btnMultiplicacao = new javax.swing.JButton();
        btnDivisao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCalculadora.setText("Calculadora Basica");

        txtNumero01.setText("--");

        btnSoma.setText("+");
        btnSoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSomaActionPerformed(evt);
            }
        });

        txtNumero02.setText("---");

        lblResultado.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        lblResultado.setText("Resultado: ---");

        btnSubtracao.setText("-");
        btnSubtracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubtracaoActionPerformed(evt);
            }
        });

        btnMultiplicacao.setText("*");
        btnMultiplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicacaoActionPerformed(evt);
            }
        });

        btnDivisao.setText("/");
        btnDivisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDivisaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(lblCalculadora)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblResultado)
                        .addComponent(txtNumero01)
                        .addComponent(txtNumero02))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSoma)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubtracao)
                        .addGap(18, 18, 18)
                        .addComponent(btnMultiplicacao)
                        .addGap(18, 18, 18)
                        .addComponent(btnDivisao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblCalculadora)
                .addGap(18, 18, 18)
                .addComponent(txtNumero01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNumero02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSoma)
                    .addComponent(btnSubtracao)
                    .addComponent(btnMultiplicacao)
                    .addComponent(btnDivisao))
                .addGap(44, 44, 44)
                .addComponent(lblResultado)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSomaActionPerformed
        // TODO add your handling code here:
        Double numeroConvertido = Double.valueOf(txtNumero01.getText());
        Double numeroConvertido2 = Double.valueOf(txtNumero02.getText());
        
        Double resultado = 
                numeroConvertido + 
                numeroConvertido2;
        
        lblResultado.setText("Resultado: " + resultado.toString());

    }//GEN-LAST:event_btnSomaActionPerformed

    private void btnSubtracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubtracaoActionPerformed
        // TODO add your handling code here:
        
        Double numeroConvertido = Double.valueOf(txtNumero01.getText());
        Double numeroConvertido2 = Double.valueOf(txtNumero02.getText());
        
        Double resultado = 
                numeroConvertido -
                numeroConvertido2;
        
        lblResultado.setText("Resultado: " + resultado.toString());

    }//GEN-LAST:event_btnSubtracaoActionPerformed

    private void btnMultiplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicacaoActionPerformed
        // TODO add your handling code here:
        
        Double numeroConvertido = Double.valueOf(txtNumero01.getText());
        Double numeroConvertido2 = Double.valueOf(txtNumero02.getText());
        
        Double resultado = 
                numeroConvertido *
                numeroConvertido2;
        
        lblResultado.setText("Resultado: " + resultado.toString());

    }//GEN-LAST:event_btnMultiplicacaoActionPerformed

    private void btnDivisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDivisaoActionPerformed
        // TODO add your handling code here:
        
        Double numeroConvertido = Double.valueOf(txtNumero01.getText());
        Double numeroConvertido2 = Double.valueOf(txtNumero02.getText());
        
        Double resultado = 
                numeroConvertido /
                numeroConvertido2;
        
        lblResultado.setText("Resultado: " + resultado.toString());

    }//GEN-LAST:event_btnDivisaoActionPerformed

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
            java.util.logging.Logger.getLogger(CalculadoraBasica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculadoraBasica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculadoraBasica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculadoraBasica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraBasica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDivisao;
    private javax.swing.JButton btnMultiplicacao;
    private javax.swing.JButton btnSoma;
    private javax.swing.JButton btnSubtracao;
    private javax.swing.JLabel lblCalculadora;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JTextField txtNumero01;
    private javax.swing.JTextField txtNumero02;
    // End of variables declaration//GEN-END:variables
}
