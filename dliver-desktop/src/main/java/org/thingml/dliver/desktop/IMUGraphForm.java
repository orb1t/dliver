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
 * IMUGraphForm.java
 *
 * Created on 1 juil. 2012, 15:40:14
 */
package org.thingml.dliver.desktop;

import org.thingml.dliver.driver.Dliver;
import org.thingml.dliver.driver.DliverListener;
import java.awt.Color;
import org.thingml.rtcharts.swing.*;

/**
 *
 * @author franck
 */
public class IMUGraphForm extends javax.swing.JFrame implements DliverListener {

    protected static final int BUFFER_SIZE = 250;
    protected static final int AMAX = 500;
    protected static final int AMINOR = 200;
    protected static final int GMAX = 1800;
    protected static final int GMINOR = 500;
    protected static final Color ACOLOR = new java.awt.Color(255, 204, 0);
    protected static final Color GCOLOR = new java.awt.Color(255, 153, 0);
    
    
    protected GraphBuffer bax = new GraphBuffer(BUFFER_SIZE);
    protected GraphBuffer bay = new GraphBuffer(BUFFER_SIZE);
    protected GraphBuffer baz = new GraphBuffer(BUFFER_SIZE);
    protected GraphBuffer bgx = new GraphBuffer(BUFFER_SIZE);
    protected GraphBuffer bgy = new GraphBuffer(BUFFER_SIZE);
    protected GraphBuffer bgz = new GraphBuffer(BUFFER_SIZE);
    
    protected Dliver belt;
    
    /** Creates new form IMUGraphForm */
    public IMUGraphForm(Dliver b) {
        this.belt = b;
        if (b != null) b.addDliverListener(this);
        initComponents();

        ((GraphPanel)jPanel1).start();
        ((GraphPanel)jPanel2).start();
        ((GraphPanel)jPanel3).start();
        ((GraphPanel)jPanel4).start();
        ((GraphPanel)jPanel5).start();
        ((GraphPanel)jPanel6).start();
        //((GraphPanel)jPanel1).setAutoScale(true);
        //((GraphPanel)jPanel2).setAutoScale(true);
        //((GraphPanel)jPanel3).setAutoScale(true);
        //((GraphPanel)jPanel4).setAutoScale(true);
        //((GraphPanel)jPanel5).setAutoScale(true);
        //((GraphPanel)jPanel6).setAutoScale(true);
       

        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new BarGraphPanel(bax, "Accelerometer X", -AMAX, AMAX, AMINOR, ACOLOR);
        jPanel2 = new BarGraphPanel(bay, "Accelerometer Y", -AMAX, AMAX, AMINOR, ACOLOR);
        jPanel3 = new BarGraphPanel(baz, "Accelerometer Z", -AMAX, AMAX, AMINOR, ACOLOR);
        jPanel4 = new BarGraphPanel(bgx, "Gyroscope X", -GMAX, GMAX, GMINOR, GCOLOR);
        jPanel5 = new BarGraphPanel(bgy, "Gyroscope Y", -GMAX, GMAX, GMINOR, GCOLOR);
        jPanel6 = new BarGraphPanel(bgz, "Gyroscope Z", -GMAX, GMAX, GMINOR, GCOLOR);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("d-LIVER IMU Graphs");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                IMUGraphForm.this.windowClosed(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));
        getContentPane().add(jPanel1);
        getContentPane().add(jPanel2);
        getContentPane().add(jPanel3);
        getContentPane().add(jPanel4);
        getContentPane().add(jPanel5);
        getContentPane().add(jPanel6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void windowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosed
    if (belt != null) belt.removeDliverListener(this);
    ((GraphPanel)jPanel1).stop();
    ((GraphPanel)jPanel2).stop();
    ((GraphPanel)jPanel3).stop();
    ((GraphPanel)jPanel4).stop();
    ((GraphPanel)jPanel5).stop();
    ((GraphPanel)jPanel6).stop();
}//GEN-LAST:event_windowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cUSerialNumber(long value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cUFWRevision(String value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void batteryStatus(int value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void indicationDev(int value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void measurementPatient(int value, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void messageOverrun(int value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void referenceClockTime(long value, boolean seconds) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fullClockTimeSync(long value, boolean seconds) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void heartRate(int valueHr, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void heartRateInterval(int value, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eCGData(int value) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eCGSignalQuality(int value, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eCGRaw(int value, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
	public void gyroPitch(int value, int timestamp) {
            //jTextFieldGy.setText(""+value);
            bgy.insertData(value);
	}

	@Override
	public void gyroRoll(int value, int timestamp) {
           //jTextFieldGx.setText(""+value);
            bgx.insertData(value);
	}

	@Override
	public void gyroYaw(int value, int timestamp) {
            //jTextFieldGz.setText(""+value);
            bgz.insertData(value);

	}

	@Override
	public void accLateral(int value, int timestamp) {
           // jTextFieldAy.setText(""+value);
            bay.insertData(value);
	}

	@Override
	public void accLongitudinal(int value, int timestamp) {
            //jTextFieldAz.setText(""+value);
            baz.insertData(value);

	}

	@Override
	public void accVertical(int value, int timestamp) {
            //jTextFieldAx.setText(""+value);
            bax.insertData(value);

	}

    @Override
    public void rawActivityLevel(int value, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void combinedIMU(int ax, int ay, int az, int gx, int gy, int gz, int timestamp) {
        bax.insertData(ax);
        bay.insertData(ay);
        baz.insertData(az);
        bgx.insertData(gx);
        bgy.insertData(gy);
        bgz.insertData(gz);
    }

    @Override
    public void skinTemperature(int value, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void connectionLost() {
        
    }

    @Override
    public void referenceClockTimeSync(int timeSyncSeqNum, long value) {
        
    }
    @Override
    public void quaternion(int w, int x, int y, int z, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void magnetometer(int x, int y, int z, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ptt(int value, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iCGAbs(int icgAbs, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iCGAbsAc(int icgAbsAc, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void iCGDer(int icgAbsDer, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ppgRaw(int ppgDer, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ppgDer(int ppgDer, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void btPutChar(int value) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eventEpoch(int eventNum, int val, long epoch) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void playStart(long epoch) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void playStop() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stepCount(long step, int timestamp) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
