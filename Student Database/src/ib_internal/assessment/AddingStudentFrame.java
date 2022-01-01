
package ib_internal.assessment;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddingStudentFrame extends javax.swing.JFrame {

    public AddingStudentFrame() {
        initComponents();
        idTextField.setDocument(new JTextFieldLimit(9));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPanel = new javax.swing.JPanel();
        id = new java.awt.Label();
        idTextField = new javax.swing.JTextField();
        first = new java.awt.Label();
        firstTextField = new javax.swing.JTextField();
        middle = new java.awt.Label();
        middleTextField = new javax.swing.JTextField();
        last = new java.awt.Label();
        lastTextField = new javax.swing.JTextField();
        addNewStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Student");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(340, 225));
        setResizable(false);

        addPanel.setVerifyInputWhenFocusTarget(false);
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        id.setName(""); // NOI18N
        id.setText("ID Number:");
        addPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        id.getAccessibleContext().setAccessibleName("ID Number");

        addPanel.add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 210, -1));

        first.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        first.setText("First Name:");
        addPanel.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        addPanel.add(firstTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, -1));

        middle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        middle.setText("Middle Name (Optional) :");
        addPanel.add(middle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, -1));
        addPanel.add(middleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        last.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        last.setText("Last Name:");
        addPanel.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, -1));
        addPanel.add(lastTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        addNewStudentButton.setText("Add New Student");
        addNewStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewStudentButtonActionPerformed(evt);
            }
        });
        addPanel.add(addNewStudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 290, -1));

        getContentPane().add(addPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewStudentButtonActionPerformed
        
        if (idTextField.getText().equals("") | firstTextField.getText().equals("") | lastTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a Value for Each Required Section");
            return;
        }
       
       try {
        
        int savedID = Integer.parseInt(idTextField.getText());
        
        if (savedID <= 0)
        {
            JOptionPane.showMessageDialog(null, "Please enter an ID number between 1 and 999999999");
            return;
        } 
         
        String savedFirst = firstTextField.getText();
        String savedMiddle = middleTextField.getText();
        String savedLast = lastTextField.getText();
        
        SQLite.addStudentToDatabse(savedID, savedFirst, savedMiddle, savedLast);
        
        Object[] row = {savedID, savedFirst, savedMiddle, savedLast};
        
        DataPanel.addStudentRowToJTable(row);
        dispose();
        }
       
        catch(NumberFormatException e) {    
            JOptionPane.showMessageDialog(null, "Please Enter Digits Only For The ID");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddingStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addNewStudentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewStudentButton;
    private javax.swing.JPanel addPanel;
    private java.awt.Label first;
    private javax.swing.JTextField firstTextField;
    private java.awt.Label id;
    private javax.swing.JTextField idTextField;
    private java.awt.Label last;
    private javax.swing.JTextField lastTextField;
    private java.awt.Label middle;
    private javax.swing.JTextField middleTextField;
    // End of variables declaration//GEN-END:variables
}
