/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;

/**
 *
 * @author Hector Burgos
 */
public class AddEmployedView extends javax.swing.JFrame {

    /**
     * Creates new form RegistroEmpleados
     */
    public AddEmployedView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLTitle = new javax.swing.JLabel();
        JBAcept = new javax.swing.JButton();
        JBCancel = new javax.swing.JButton();
        JPEmployedData = new javax.swing.JPanel();
        JLName = new javax.swing.JLabel();
        JTFName = new javax.swing.JTextField();
        JLAmmount = new javax.swing.JLabel();
        JTFAmmount = new javax.swing.JTextField();
        JBAccount = new javax.swing.JLabel();
        JTFAccount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLTitle.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JLTitle.setText("Llenar datos de nuevo empleado");

        JBAcept.setText("Aceptar");

        JBCancel.setText("Cancelar");

        JLName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JLName.setText("Nombre");

        JTFName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTFName.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JLAmmount.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JLAmmount.setText("Monto");

        JTFAmmount.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTFAmmount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JBAccount.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JBAccount.setText("Cuenta de destino");

        JTFAccount.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        JTFAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout JPEmployedDataLayout = new javax.swing.GroupLayout(JPEmployedData);
        JPEmployedData.setLayout(JPEmployedDataLayout);
        JPEmployedDataLayout.setHorizontalGroup(
            JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPEmployedDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPEmployedDataLayout.createSequentialGroup()
                        .addComponent(JBAccount)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(JTFAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPEmployedDataLayout.createSequentialGroup()
                        .addGroup(JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLName)
                            .addComponent(JLAmmount))
                        .addGap(72, 72, 72)
                        .addGroup(JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFAmmount)
                            .addComponent(JTFName))))
                .addContainerGap())
        );
        JPEmployedDataLayout.setVerticalGroup(
            JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPEmployedDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLName)
                    .addComponent(JTFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLAmmount)
                    .addComponent(JTFAmmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(JPEmployedDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAccount)
                    .addComponent(JTFAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPEmployedData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(JBCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBAcept)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLTitle)
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLTitle)
                .addGap(18, 18, 18)
                .addComponent(JPEmployedData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBAcept)
                    .addComponent(JBCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Listener de los botones
    public JButton listenJBSave() {
        return JBAcept;
    }

    public JButton listenJBExit() {
        return JBCancel;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JBAccount;
    public javax.swing.JButton JBAcept;
    public javax.swing.JButton JBCancel;
    private javax.swing.JLabel JLAmmount;
    private javax.swing.JLabel JLName;
    private javax.swing.JLabel JLTitle;
    private javax.swing.JPanel JPEmployedData;
    public javax.swing.JTextField JTFAccount;
    public javax.swing.JTextField JTFAmmount;
    public javax.swing.JTextField JTFName;
    // End of variables declaration//GEN-END:variables
}
