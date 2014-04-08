/**
 * Copyright (C) 2014 SINTEF <steffen.dalgard@sintef.no>
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
 * ConsoleFrame.java
 *
 * Created on 16 Jan. 2014,
 */
package org.thingml.dliver.driver;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Steffen
 */
public class TraceConsole extends javax.swing.JFrame  {
    int maxBuffer = 1000;
    int reduceSize = 10;
    int bytesInBuffer = 0;
    DefaultCaret caret; 

    
    public TraceConsole(int maxBuffer, int reduceSize) {
        this.maxBuffer = maxBuffer;
        this.reduceSize = reduceSize;
        this.bytesInBuffer = 0;
        
        initComponents();
        
        caret = (DefaultCaret)jTextArea1.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        jTextArea1.addKeyListener(new KeyListener()
        {
              //When any key is pressed and released then the 
              //keyPressed and keyReleased methods are called respectively.
              //The keyTyped method is called when a valid character is typed.
              //The getKeyChar returns the character for the key used. If the key
              //is a modifier key (e.g., SHIFT, CTRL) or action key (e.g., DELETE, ENTER)
              //then the character will be a undefined symbol.
              @Override 
              public void keyPressed(KeyEvent e)
              {
                  e.consume();
              }
              @Override
              public void keyReleased(KeyEvent e)
              {
                  e.consume();
              }
              
              @Override
              public void keyTyped(KeyEvent e)
              {
                  //The getKeyModifiers method is a handy
                  //way to get a String representing the
                  //modifier key.
                  int ascii = e.getKeyChar();
                  System.out.println("Got keyTyped("+ ascii );
                  if (ascii == 0x0a) {
                      jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
                      System.out.println("Got CR ... reset caret to end of doc");
                  }
                  e.consume();
              }
        });

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("d-LIVER BT trace console");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                TraceConsole.this.windowClosed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void windowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosed
}//GEN-LAST:event_windowClosed

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void checkMaxBuffer() {
        if (bytesInBuffer > maxBuffer) {
            jTextArea1.replaceRange("", 0, reduceSize -1);
            bytesInBuffer = jTextArea1.getDocument().getLength();
        }
    }
    
    synchronized public void putChar(int value) {
        String txt = "" + ((char)value);
        jTextArea1.append(txt);
        bytesInBuffer += 1;
        checkMaxBuffer();

    }

    synchronized public void putInt(int value) {

        String txt = " " + (value);
        jTextArea1.append(txt);
        bytesInBuffer += txt.length();
        checkMaxBuffer();
    }

    synchronized public void putString(String value) {
        jTextArea1.append(value);
        bytesInBuffer += value.length();
        checkMaxBuffer();
    }
}