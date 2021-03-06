/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thingml.dliver.desktop;

import org.thingml.dliver.driver.Dliver;

/**
 *
 * @author steffend
 */
public class MathLabLoggerForm extends javax.swing.JFrame {
    protected String unitName;
    protected DliverMathLabLogger logger;
    protected Dliver belt;
    protected String ipHost;
    protected int    ipPort;

    /**
     * Creates new form UDPLoggerForm
     */
    public MathLabLoggerForm(Dliver b) {
        this.belt = b;
        initComponents();
        ipHost = jTextFieldIpHost.getText();
        ipPort = Integer.parseInt(jTextFieldIpPort.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonStop = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jTextFieldIpHost = new javax.swing.JTextField();
        jTextFieldIpPort = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MathLab UDP logging");

        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jTextFieldIpHost.setText("localhost");
        jTextFieldIpHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIpHostActionPerformed(evt);
            }
        });

        jTextFieldIpPort.setText("40000");
        jTextFieldIpPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIpPortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldIpHost)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStop)
                        .addGap(59, 59, 59)
                        .addComponent(jButtonStart))
                    .addComponent(jTextFieldIpPort))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jTextFieldIpHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTextFieldIpPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStop)
                    .addComponent(jButtonStart))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        if (logger != null) {
            belt.removeDliverListener(logger);
            logger.stopLogging();
            logger = null;
        }
        jButtonStart.setEnabled(true);
        jButtonStop.setEnabled(false);
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        unitName = jTextFieldIpHost.getText();
        logger = new DliverMathLabLogger(ipHost, ipPort, belt);
        belt.addDliverListener(logger);
        logger.startLogging();
        jButtonStart.setEnabled(false);
        jButtonStop.setEnabled(true);
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jTextFieldIpHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIpHostActionPerformed
        ipHost = jTextFieldIpHost.getText();
        System.out.println("Host changed to - " + ipHost);
    }//GEN-LAST:event_jTextFieldIpHostActionPerformed

    private void jTextFieldIpPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIpPortActionPerformed
        ipPort = Integer.parseInt(jTextFieldIpPort.getText());
        System.out.println("Port changed to - " + ipPort);
    }//GEN-LAST:event_jTextFieldIpPortActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JTextField jTextFieldIpHost;
    private javax.swing.JTextField jTextFieldIpPort;
    // End of variables declaration//GEN-END:variables
}
