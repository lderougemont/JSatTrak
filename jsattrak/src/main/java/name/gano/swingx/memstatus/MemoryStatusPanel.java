/*
 * MemoryStatusPanel.java
 * =================================================================
 *   This file is part of JSatTrak.
 *
 *   Copyright 2007-2013 Shawn E. Gano
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * ====================================================================
 *
 * Created on August 2, 2008, 10:18 PM
 */

package name.gano.swingx.memstatus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import javax.swing.Timer;

/**
 *
 * @author  Shawn
 */
public class MemoryStatusPanel extends javax.swing.JPanel implements MouseListener
{
    private Timer playTimer;
    private boolean stopTimer = false;
    private int updateRateMs = 2500;

    DecimalFormat df = new DecimalFormat("#,##0.00");

    /** Creates new form MemoryStatusPanel */
    public MemoryStatusPanel()
    {
        initComponents();

        this.addMouseListener(this);

        memProgressBar.setMaximum(100);
        memProgressBar.addMouseListener(this);

        playTimer = new Timer(updateRateMs, new ActionListener()
        {
            public void actionPerformed(ActionEvent evt)
            {
                updateStatus();
                //System.out.println("Mem update");

                if (stopTimer)
                {
                    playTimer.stop();
                    //System.out.println("Mem stopped!");
                }
            }
        });
        playTimer.setRepeats(true);
        playTimer.start();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memProgressBar = new javax.swing.JProgressBar();

        memProgressBar.setString("0 MB / 0 MB");
        memProgressBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(memProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(memProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void updateStatus()
    {
        double totMem1 = java.lang.Runtime.getRuntime().totalMemory() / 1048576.0; // Megabytes
        double freeMem1 = java.lang.Runtime.getRuntime().freeMemory() / 1048576.0;
        double usedMem1 = totMem1 - freeMem1;

        // take one time step in the aimation
        int usedMemPercent = (int) Math.round(100.0 * (usedMem1) / totMem1);
        memProgressBar.setValue(usedMemPercent);

        memProgressBar.setString(df.format(usedMem1) + " MB / " + df.format(totMem1) + " MB");

        memProgressBar.setToolTipText("Free Memory: " + df.format(freeMem1) + " MB");

        if(!memProgressBar.isShowing())
        {
            stopTimer = true; // stop updates
            memProgressBar.setString("STOPPED - click to restart");
        }
    } // updateStatus


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar memProgressBar;
    // End of variables declaration//GEN-END:variables


    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
        System.gc();
        updateStatus();
        //System.out.println("GC");
        // if stopped - restart
        if(stopTimer == true)
        {
            stopTimer = false;
            playTimer.start();
        }
    }


}
