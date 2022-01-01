
package ib_internal.assessment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class AssigningClassesFrame extends javax.swing.JFrame {

    public AssigningClassesFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AssigningClassesPanel = new javax.swing.JPanel();
        assignClassesSplitPlane = new javax.swing.JSplitPane();
        JTableScrollPlane = new javax.swing.JScrollPane();
        assignClassesJTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Assign Classes");
        setResizable(false);

        AssigningClassesPanel.setPreferredSize(new java.awt.Dimension(250, 350));
        AssigningClassesPanel.setLayout(new java.awt.BorderLayout());

        assignClassesSplitPlane.setDividerLocation(280);
        assignClassesSplitPlane.setDividerSize(0);
        assignClassesSplitPlane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        assignClassesSplitPlane.setResizeWeight(0.75);

        assignClassesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Classes", "Assigned"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableScrollPlane.setViewportView(assignClassesJTable);

        assignClassesSplitPlane.setTopComponent(JTableScrollPlane);

        saveButton.setText("Save and Exit");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        assignClassesSplitPlane.setRightComponent(saveButton);

        AssigningClassesPanel.add(assignClassesSplitPlane, java.awt.BorderLayout.CENTER);

        getContentPane().add(AssigningClassesPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            ArrayList<String> classList = SQLite.saveClassSelectionToDatabase(assignClassesJTable);
            StudentPageFrame.initializeComboBox(classList);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AssigningClassesFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    public JTable getAssignClassesJTable() {
        return assignClassesJTable;
    }

    public void setAssignClassesJTable(JTable assignClassesJTable) {
        this.assignClassesJTable = assignClassesJTable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AssigningClassesPanel;
    private javax.swing.JScrollPane JTableScrollPlane;
    private javax.swing.JTable assignClassesJTable;
    private javax.swing.JSplitPane assignClassesSplitPlane;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
