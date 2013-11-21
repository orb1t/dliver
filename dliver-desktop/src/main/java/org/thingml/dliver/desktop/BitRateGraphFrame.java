/**
 * Copyright (C) 2012 SINTEF <franck.fleurey@sintef.no>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SkinTempGraphFrame.java
 *
 * Created on 1 juil. 2012, 17:21:18
 */
package org.thingml.dliver.desktop;

import java.awt.Color;
import org.thingml.rtcharts.swing.*;

/**
 *
 * @author franck
 */
public class BitRateGraphFrame extends javax.swing.JFrame implements BitRateListemer {

    protected GraphBuffer brate = new GraphBuffer(100);
    
    protected BitRateCounter counter;
    
    /** Creates new form SkinTempGraphFrame */
    public BitRateGraphFrame(BitRateCounter counter) {
        this.counter = counter;
        if (counter != null) counter.addDliverListener(this);
        initComponents();
        ((GraphPanel)jPanel1).start();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new BarGraphPanel(brate, "Bandwidth Usage (bytes/sec)", 0, 12000, 2000, Color.red);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ChestBelt Bluetooth Bandwidth Usage");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                BitRateGraphFrame.this.windowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void windowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosed
     if (counter != null) counter.removeDliverListener(this);
    ((GraphPanel)jPanel1).stop();
}//GEN-LAST:event_windowClosed

 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void bitRate(int value) {
        brate.insertData(value);
    }
}
