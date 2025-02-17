/*
 * InitialConditionsPanel.java
 * =====================================================================
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
 * =====================================================================
 *
 * Created on January 11, 2008, 3:04 PM
 */

package jsattrak.customsat.gui;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import jsattrak.customsat.InitialConditionsNode;
import name.gano.astro.AstroConst;
import name.gano.astro.Kepler;
import name.gano.astro.time.Time;

/**
 *
 * @author  sgano
 */
public class InitialConditionsPanel extends javax.swing.JPanel
{

    InitialConditionsNode icNode;

    boolean componentsIni = false; // flag for when the components have been inialized

   // used for diaplying settings panel
    private JInternalFrame iframe; // used to know what its parent frame is - to close window

    final Time scenarioEpochDate; // used for date string functions

    /** Creates new form InitialConditionsPanel
     * @param icNode inital conditions node
     * @param scenarioEpochDate  scenario epoch date
     */
    public InitialConditionsPanel(InitialConditionsNode icNode, final Time scenarioEpochDate)
    {
        this.icNode = icNode;
        this.scenarioEpochDate = scenarioEpochDate;

        initComponents();

        // fill out components with current settings
        if(icNode.isUsingKepElements())
        {
            // fill out kep
            double[] kep = icNode.getKeplarianElements();

            setKepElementsInGUI(kep);

        }
        else
        {
            // fill out cartesian j2k
            double[] state = icNode.getJ2kIniState();

            setJ2kInGUI(state);
        }

        // fill in epoch
        epochTextField.setText( scenarioEpochDate.convertJD2String( icNode.getIniJulDate() )  );


        // select kep or cartesian
       if(icNode.isUsingKepElements())
       {
           inputComboBox.setSelectedIndex(0);
       }
       else
       {
            inputComboBox.setSelectedIndex(1);
       }


        componentsIni = true;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        applyButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputComboBox = new javax.swing.JComboBox<String>();
        iniTabbedPane = new javax.swing.JTabbedPane();
        kepPanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        saTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        eTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        iTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        longTextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        argTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        mTextField = new javax.swing.JTextField();
        j2kPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        xTextField = new javax.swing.JTextField();
        yTextField = new javax.swing.JTextField();
        zTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dzTextField = new javax.swing.JTextField();
        dyTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dxTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        epochTextField = new javax.swing.JTextField();

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                applyButtonActionPerformed(evt);
            }
        });

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Input Type:");

        inputComboBox.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Keplarian Elements", "J2000.0 State" }));
        inputComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                inputComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setText("Semimajor axis [m]:");

        saTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saTextFieldActionPerformed(evt);
            }
        });

        jLabel11.setText("Eccentricity:");

        eTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                eTextFieldActionPerformed(evt);
            }
        });

        jLabel12.setText("Inclination [deg]:");

        iTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                iTextFieldActionPerformed(evt);
            }
        });

        jLabel13.setText("Long. of asc. node:");

        longTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                longTextFieldActionPerformed(evt);
            }
        });

        jLabel14.setText("Arg. of perigee:");

        argTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                argTextFieldActionPerformed(evt);
            }
        });

        jLabel15.setText("Mean anomaly (epoch):");

        mTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                mTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kepPanelLayout = new javax.swing.GroupLayout(kepPanel);
        kepPanel.setLayout(kepPanelLayout);
        kepPanelLayout.setHorizontalGroup(
            kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kepPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(iTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(longTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(argTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(mTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(saTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        kepPanelLayout.setVerticalGroup(
            kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kepPanelLayout.createSequentialGroup()
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(saTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(eTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(iTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(longTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(argTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(kepPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(mTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        iniTabbedPane.addTab("Keplarian Elements", kepPanel);

        jLabel3.setText("X:");

        jLabel4.setText("Y:");

        jLabel5.setText("Z:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("* Note: Units are in meters");

        xTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                xTextFieldActionPerformed(evt);
            }
        });

        yTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                yTextFieldActionPerformed(evt);
            }
        });

        zTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                zTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("dZ:");

        dzTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dzTextFieldActionPerformed(evt);
            }
        });

        dyTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dyTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setText("dY:");

        jLabel9.setText("dX:");

        dxTextField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dxTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout j2kPanelLayout = new javax.swing.GroupLayout(j2kPanel);
        j2kPanel.setLayout(j2kPanelLayout);
        j2kPanelLayout.setHorizontalGroup(
            j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j2kPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j2kPanelLayout.createSequentialGroup()
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(j2kPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(j2kPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(j2kPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(j2kPanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(j2kPanelLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(j2kPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dzTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel6))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        j2kPanelLayout.setVerticalGroup(
            j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(j2kPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(j2kPanelLayout.createSequentialGroup()
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(zTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(j2kPanelLayout.createSequentialGroup()
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(dxTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(dyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(j2kPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(dzTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        iniTabbedPane.addTab("J2000.0 State", j2kPanel);

        jLabel2.setText("Epoch:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iniTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(111, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epochTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iniTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(epochTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(applyButton))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(cancelButton)
                    .addComponent(okButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void xTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_xTextFieldActionPerformed
    {//GEN-HEADEREND:event_xTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_xTextFieldActionPerformed

    private void yTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_yTextFieldActionPerformed
    {//GEN-HEADEREND:event_yTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_yTextFieldActionPerformed

    private void zTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_zTextFieldActionPerformed
    {//GEN-HEADEREND:event_zTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_zTextFieldActionPerformed

    private void dzTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dzTextFieldActionPerformed
    {//GEN-HEADEREND:event_dzTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dzTextFieldActionPerformed

    private void dyTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dyTextFieldActionPerformed
    {//GEN-HEADEREND:event_dyTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dyTextFieldActionPerformed

    private void dxTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dxTextFieldActionPerformed
    {//GEN-HEADEREND:event_dxTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dxTextFieldActionPerformed

    private void saTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saTextFieldActionPerformed
    {//GEN-HEADEREND:event_saTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_saTextFieldActionPerformed

    private void eTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_eTextFieldActionPerformed
    {//GEN-HEADEREND:event_eTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_eTextFieldActionPerformed

    private void iTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_iTextFieldActionPerformed
    {//GEN-HEADEREND:event_iTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_iTextFieldActionPerformed

    private void longTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_longTextFieldActionPerformed
    {//GEN-HEADEREND:event_longTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_longTextFieldActionPerformed

    private void argTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_argTextFieldActionPerformed
    {//GEN-HEADEREND:event_argTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_argTextFieldActionPerformed

    private void mTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mTextFieldActionPerformed
    {//GEN-HEADEREND:event_mTextFieldActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_mTextFieldActionPerformed

    private void inputComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_inputComboBoxActionPerformed
    {//GEN-HEADEREND:event_inputComboBoxActionPerformed

        if(inputComboBox.getSelectedItem().toString().equalsIgnoreCase("Keplarian Elements"))
        {
            iniTabbedPane.setEnabledAt(0, true); // kep
            iniTabbedPane.setEnabledAt(1, false); // j2k
            iniTabbedPane.setSelectedIndex(0);

            // convert data from one panel to the other (this only runs when change has occured
            if(componentsIni)
            {
                double[] j2k = getJ2kInGUI();

                double[] kep = Kepler.SingularOsculatingElements(AstroConst.GM_Earth, j2k);

                setKepElementsInGUI(kep);
            }
        }
        else if(inputComboBox.getSelectedItem().toString().equalsIgnoreCase("J2000.0 State"))
        {
            iniTabbedPane.setEnabledAt(0, false); // kep
            iniTabbedPane.setEnabledAt(1, true); // j2k
            iniTabbedPane.setSelectedIndex(1);

            // convert data from one panel to the other
            if(componentsIni)
            {
                double[] kep = getKepElementsFromGUI();

                double [] j2k = Kepler.state(AstroConst.GM_Earth, kep, 0.0);

                setJ2kInGUI(j2k); // set values to GUI

            }
        }

    }//GEN-LAST:event_inputComboBoxActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_okButtonActionPerformed
    {//GEN-HEADEREND:event_okButtonActionPerformed
        boolean success = saveSettings();

         // close internal frame
        if (success)
        {
            try
            {
                iframe.dispose(); // could setClosed(true)
            }
            catch (Exception e)
            {
            }
        }
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButtonActionPerformed
    {//GEN-HEADEREND:event_cancelButtonActionPerformed
        // close internal frame
        try
        {
            iframe.dispose(); // could setClosed(true)
        }
        catch(Exception e){}
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_applyButtonActionPerformed
    {//GEN-HEADEREND:event_applyButtonActionPerformed
        saveSettings();
    }//GEN-LAST:event_applyButtonActionPerformed

    private boolean saveSettings()
    {
        // save settings back to Node
        boolean saveSuccess = true;

         // save epoch
        saveSuccess = saveEpoch();

        try
        {
            // get correct kep/j2k elements save them
            if (inputComboBox.getSelectedIndex() == 0)
            {
                // kepler input
                icNode.setUsingKepElements(true);

                double[] kep = this.getKepElementsFromGUI();

                icNode.setKeplarianElements(kep);

            }
            else
            {
                // j2k input
                icNode.setUsingKepElements(false);

                double[] j2k = this.getJ2kInGUI();

                icNode.setJ2kIniState(j2k);
            }

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Date format error, check input.", "Data ERROR", JOptionPane.ERROR_MESSAGE);
            saveSuccess = false;
        }

        return saveSuccess;

    }

     // date formats for displaying and reading in
    private SimpleDateFormat dateformat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS z");
    private SimpleDateFormat dateformatShort1 = new SimpleDateFormat("dd MMM y H:m:s.S z");
    private SimpleDateFormat dateformatShort2 = new SimpleDateFormat("dd MMM y H:m:s z"); // no Milliseconds


    private boolean saveEpoch()
    {


            // enter hit in date/time box...
            //System.out.println("Date Time Changed");

            GregorianCalendar currentTimeDate = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
            //or
            //GregorianCalendar currentTimeDate = new GregorianCalendar();

            boolean dateAccepted = true; // assume date valid at first
            try
            {
                currentTimeDate.setTime(dateformatShort1.parse(epochTextField.getText()));
                epochTextField.setText(dateformat.format(currentTimeDate.getTime()));
            }
            catch (Exception e2)
            {
                try
                {
                    // try reading without the milliseconds
                    currentTimeDate.setTime(dateformatShort2.parse(epochTextField.getText()));
                    epochTextField.setText(dateformat.format(currentTimeDate.getTime()));
                }
                catch (Exception e3)
                {
                    // bad date input put back the old date string
                    epochTextField.setText( scenarioEpochDate.convertJD2String( icNode.getIniJulDate() )  );
                    dateAccepted = false;
                //System.out.println(" -- Rejected");
                } // catch 2

            } // catch 1

            if (dateAccepted)
            {
                // date entered was good...
                // System.out.println(" -- Accepted");

                // save

                Time newTime = new Time();
                newTime.set( currentTimeDate.getTimeInMillis() );

                icNode.setIniJulDate( newTime.getJulianDate() );


            } // if date accepted
            else
            {
                JOptionPane.showMessageDialog(this, "Epoch Date format incorrect", "Epoch ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JTextField argTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dxTextField;
    private javax.swing.JTextField dyTextField;
    private javax.swing.JTextField dzTextField;
    private javax.swing.JTextField eTextField;
    private javax.swing.JTextField epochTextField;
    private javax.swing.JTextField iTextField;
    private javax.swing.JTabbedPane iniTabbedPane;
    private javax.swing.JComboBox<String> inputComboBox;
    private javax.swing.JPanel j2kPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel kepPanel;
    private javax.swing.JTextField longTextField;
    private javax.swing.JTextField mTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JTextField saTextField;
    private javax.swing.JTextField xTextField;
    private javax.swing.JTextField yTextField;
    private javax.swing.JTextField zTextField;
    // End of variables declaration//GEN-END:variables


    private double[] getKepElementsFromGUI()
    {
        double[] kepElements = new double[6];

        kepElements[0] = Double.parseDouble(saTextField.getText());
        kepElements[1] = Double.parseDouble(eTextField.getText());
        kepElements[2] = Double.parseDouble(iTextField.getText())* Math.PI/180.0;
        kepElements[3] = Double.parseDouble(longTextField.getText())* Math.PI/180.0;
        kepElements[4] = Double.parseDouble(argTextField.getText())* Math.PI/180.0;
        kepElements[5] = Double.parseDouble(mTextField.getText())* Math.PI/180.0;

        return kepElements;
    }

    private void setKepElementsInGUI(double[] kep)
    {
        saTextField.setText(kep[0] + "");
        eTextField.setText(kep[1] + "");
        iTextField.setText((kep[2] * 180.0 / Math.PI) + "");
        longTextField.setText((kep[3] * 180.0 / Math.PI) + "");
        argTextField.setText((kep[4] * 180.0 / Math.PI) + "");
        mTextField.setText((kep[5]*180.0/Math.PI) + "");
    }

    private double[] getJ2kInGUI()
    {
        double[] state = new double[6];

        state[0] = Double.parseDouble(xTextField.getText());
        state[1] = Double.parseDouble(yTextField.getText());
        state[2] = Double.parseDouble(zTextField.getText());
        state[3] = Double.parseDouble(dxTextField.getText());
        state[4] = Double.parseDouble(dyTextField.getText());
        state[5] = Double.parseDouble(dzTextField.getText());

        return state;
    }

    private void setJ2kInGUI(double[] state)
    {
        xTextField.setText(state[0] + "");
        yTextField.setText(state[1] + "");
        zTextField.setText(state[2] + "");
        dxTextField.setText(state[3] + "");
        dyTextField.setText(state[4] + "");
        dzTextField.setText(state[5] + "");
    }

    public JInternalFrame getIframe()
    {
        return iframe;
    }

    public void setIframe(JInternalFrame iframe)
    {
        this.iframe = iframe;
    }


}
