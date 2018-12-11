/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.grafica;

import javax.swing.JOptionPane;

/**
 *
 * @author sebastiancaicedo
 */
public class Calculadora extends javax.swing.JFrame {
    String num1;
    String num2;

   
    public Calculadora() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text2 = new javax.swing.JTextField();
        operaciones = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        res = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero 1:");

        jLabel2.setText("Numero 2:");

        operaciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Suma.", "Resta.", "Multiplicacion.", "Division." }));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(text1))))
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(operaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        num1= text1.getText();
        num2= text2.getText();
        int op= operaciones.getSelectedIndex();
        switch(op){
            case 0:
                if(validInt(num1,num2)==true){
                    res.setText(""+(Integer.parseInt(num1)+Integer.parseInt(num2)));
                }
                else
                {
                    if(validDouble(num1,num2)==true){
                        res.setText(""+ (Double.parseDouble(num1)+Double.parseDouble(num2)));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Numeros no validos");
                    }
                }
                break;
            case 1:
                if(validInt(num1,num2)==true){
                    res.setText(""+ (Integer.parseInt(num1)-Integer.parseInt(num2)));
                }
                else
                {
                    if(validDouble(num1,num2)==true){
                        res.setText(""+ (Double.parseDouble(num1)- Double.parseDouble(num2)));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Numeros no validos");
                    }
                }
                break;
            case 2:
                if(validInt(num1,num2)==true){
                    res.setText(""+ (Integer.parseInt(num1)* Integer.parseInt(num2)));
                }
                else
                {
                    if(validDouble(num1,num2)==true){
                        res.setText(""+ (Double.parseDouble(num1)* Double.parseDouble(num2)));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Numeros no validos");
                    }
                }
                break;
            case 3:
                if(validInt(num1,num2)==true){
                    res.setText(""+ (Integer.parseInt(num1)/ Integer.parseInt(num2)));
                }
                else
                {
                    if(validDouble(num1,num2)==true){
                        res.setText(""+ (Double.parseDouble(num1)/ Double.parseDouble(num2)));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Numeros no validos");
                    }
                }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }
  //------------------------------------------------------------------------------
    public boolean validInt(String n1, String n2){
        boolean sw=true;
        if(sw==true){
            try{
                Integer.parseInt(n1);
                Integer.parseInt(n2);
            }catch(Exception ex){sw=false;};
        }
        return sw;
    }
    
    public boolean validDouble(String n1, String n2){
        boolean sw=true;
        if(sw==true){
            try{
                Double.parseDouble(n1);
                Double.parseDouble(n2);
            }catch(Exception ex){sw=false;};
        }
        return sw;
    }
    
    
  //------------------------------------------------------------------------------
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox operaciones;
    private javax.swing.JTextField res;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    // End of variables declaration//GEN-END:variables
}
