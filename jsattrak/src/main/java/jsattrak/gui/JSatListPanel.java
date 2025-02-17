/*
 * JSatListPanel.java
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
 * Created on August 2, 2007, 12:11 PM
 *
 *   OLD -- NOW USE JObjectListPanel instead (uses a tree for different object types)
 */

package jsattrak.gui;

import jsattrak.objects.SatelliteTleSGP4;
import java.util.Hashtable;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import jsattrak.utilities.ListTransferHandler;

/**
 *
 * @author  ganos
 */
public class JSatListPanel extends javax.swing.JPanel
{

     // satellite list model
    DefaultListModel<String> satListModel;

    // hash table passed in
    Hashtable<String,SatelliteTleSGP4> satHash;

    // calling JSatTrak program (used to send actions back)
    JSatTrak parentApp;

    /** Creates new form JSatListPanel */
    public JSatListPanel( Hashtable<String,SatelliteTleSGP4> satHashIn, JSatTrak app )
    {
        satHash = satHashIn; // save sat Hash table reference
        parentApp = app;

        initComponents();

        // allow dragging into the list
        satList.setTransferHandler(new ListTransferHandler(satHash,parentApp));

        // setup listmodel
        satListModel = new DefaultListModel<>();
        satList.setModel(satListModel); // list is empty to start with

        // DEBUG ADD a dummy tle for the ISS
//        satListModel.addElement("ISS (ZARYA)             ");
//        satHash.put( "ISS (ZARYA)             ", new SatelliteProps("ISS (ZARYA)             ", "1 25544U 98067A   07218.09848179  .00007221  00000-0  49323-4 0  7258", "2 25544  51.6308 206.0753 0008447 207.5193 269.3454 15.76085951498650") );

    }

    public void updateListSelectionData()
    {
        // selection changed
        if(satList.getSelectedValue() != null)
        {

            String nameSelected = satList.getSelectedValue().toString();

            if(satHash.containsKey(nameSelected))
            {
                // SatelliteTleSGP4 prop = satHash.get(nameSelected);
                // double[] pos = prop.getJ2000Position();
                //tleEpochText.setText( "" + prop.getSatTleEpochJulDate() + ", Pos= " + pos[0] +"," + pos[1] +"," + pos[2]);
            }
            else
            {
                //tleEpochText.setText("");
            }
        } // if anything selected
    } // updateListSelectionData

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        satList = new javax.swing.JList<>();
        removeSatButton = new javax.swing.JButton();
        optionsSatButton = new javax.swing.JButton();
        infoSatButton = new javax.swing.JButton();

        satList.setModel(new javax.swing.AbstractListModel<>()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        satList.setDragEnabled(true);
        satList.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                satListValueChanged(evt);
            }
        });

        removeSatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Delete16.gif")));
        removeSatButton.setToolTipText("Delete Satellite");
        removeSatButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeSatButtonActionPerformed(evt);
            }
        });

        optionsSatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Help16.gif")));
        optionsSatButton.setToolTipText("Satellite Settings");
        optionsSatButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                optionsSatButtonActionPerformed(evt);
            }
        });

        infoSatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Information16.gif")));
        infoSatButton.setToolTipText("Satellite Information");
        infoSatButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                infoSatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(removeSatButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoSatButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsSatButton)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(satList, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(satList, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removeSatButton)
                    .addComponent(infoSatButton)
                    .addComponent(optionsSatButton)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void infoSatButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_infoSatButtonActionPerformed
    {//GEN-HEADEREND:event_infoSatButtonActionPerformed


        // first make sure at least one sat is selected
        if(satList.getSelectedValue() == null)
        {
            return; // quit if nothing selected
        }

        // get name of selected satellite
        String nameSelected = satList.getSelectedValue().toString();

        if(satHash.containsKey(nameSelected))
        {
            SatelliteTleSGP4 prop = satHash.get(nameSelected);

            // create property Panel:
            SatPropertyPanel newPanel = new SatPropertyPanel(prop);

            String windowName = prop.getName().trim(); // set name - trim excess spaces

            // create new internal frame window
            JInternalFrame iframe = new JInternalFrame(windowName,true,true,true,true);

            iframe.setContentPane( newPanel ); // set contents pane
            iframe.setSize(365,355); // set size

            iframe.setVisible(true);
            parentApp.addInternalFrame(iframe);

        } // if sat in hashTable

    }//GEN-LAST:event_infoSatButtonActionPerformed

    private void optionsSatButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_optionsSatButtonActionPerformed
    {//GEN-HEADEREND:event_optionsSatButtonActionPerformed
       // first make sure at least one sat is selected
        if(satList.getSelectedValue() == null)
        {
            return; // quit if nothing selected
        }

        // get name of selected satellite
        String nameSelected = satList.getSelectedValue().toString();

        if(satHash.containsKey(nameSelected))
        {
            SatelliteTleSGP4 prop = satHash.get(nameSelected);

            // create create Sat Settings panel
            SatSettingsPanel newPanel = new SatSettingsPanel(prop,parentApp);

            String windowName = prop.getName().trim() + " - Settings"; // set name - trim excess spaces

            // create new internal frame window
            JInternalFrame iframe = new JInternalFrame(windowName,true,true,true,true);

            // save iframe
            newPanel.setInternalFrame(iframe);

            iframe.setContentPane( newPanel ); // set contents pane
            iframe.setSize(340,380); // set size w,h

            iframe.setVisible(true);
            parentApp.addInternalFrame(iframe);

        } // if sat in hashTable
    }//GEN-LAST:event_optionsSatButtonActionPerformed

    private void removeSatButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removeSatButtonActionPerformed
    {//GEN-HEADEREND:event_removeSatButtonActionPerformed
// remove satellite selected
        if(satList.getSelectedValue() != null)
        {
            String nameSelected = satList.getSelectedValue().toString();
            satHash.remove( nameSelected ); // remove it from hashTable
            int removeIndex = satList.getSelectedIndex();
            satListModel.remove(removeIndex); // remove sat from list

            // force repaint
            //twoDEarthPanel.repaint(); // GOT TO FIGURE THIS ONE OUT YET
            parentApp.forceRepainting();
        }
    }//GEN-LAST:event_removeSatButtonActionPerformed

    private void satListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_satListValueChanged
    {//GEN-HEADEREND:event_satListValueChanged
        updateListSelectionData();
    }//GEN-LAST:event_satListValueChanged



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton infoSatButton;
    private javax.swing.JButton optionsSatButton;
    private javax.swing.JButton removeSatButton;
    private javax.swing.JList<String> satList;
    // End of variables declaration//GEN-END:variables

    // requires sat Prop
    public void addSat2List(SatelliteTleSGP4 prop )
    {
        // add sat to hash
        satHash.put( prop.getName() ,  prop);

        // propogate satellite to current date
        prop.propogate2JulDate( parentApp.getCurrentJulTime() );

        // add name to list
        satListModel.addElement(prop.getName());

    } // addSat2List

    // clear list and refresh  - (used in closing and opening scenario)
    public void refreshSatList()
    {
        satListModel.clear(); // clear list
        for( SatelliteTleSGP4 sat : satHash.values() )
        {
            satListModel.addElement(sat.getName());
        }

    } // refresh sat List from satHash

}
