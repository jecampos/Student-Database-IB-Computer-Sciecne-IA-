
package ib_internal.assessment;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditingStudentFrame extends javax.swing.JFrame {

    public EditingStudentFrame() {
        initComponents();
        idTextField.setDocument(new JTextFieldLimit(9));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPanel = new javax.swing.JPanel();
        id = new java.awt.Label();
        idTextField = new javax.swing.JTextField();
        first = new java.awt.Label();
        firstTextField = new javax.swing.JTextField();
        middle = new java.awt.Label();
        middleTextField = new javax.swing.JTextField();
        last = new java.awt.Label();
        lastTextField = new javax.swing.JTextField();
        saveChangesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Student");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(340, 225));
        setResizable(false);

        editPanel.setVerifyInputWhenFocusTarget(false);
        editPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        id.setName(""); // NOI18N
        id.setText("ID Number:");
        editPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        id.getAccessibleContext().setAccessibleName("ID Number");

        editPanel.add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 210, -1));

        first.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        first.setText("First Name:");
        editPanel.add(first, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        editPanel.add(firstTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 210, -1));

        middle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        middle.setText("Middle Name (Optional) :");
        editPanel.add(middle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, -1));
        editPanel.add(middleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, -1));

        last.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        last.setText("Last Name:");
        editPanel.add(last, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, -1));
        editPanel.add(lastTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        saveChangesButton.setText("Save Changes");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });
        editPanel.add(saveChangesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 290, -1));

        getContentPane().add(editPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed
        
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
        
        SQLite.editStudentFromDatabase(DataPanel.getOriginalID(), savedID, savedFirst, savedMiddle, savedLast);
        DataPanel.editStudentRowOnJTable(savedID, savedFirst, savedMiddle, savedLast);
        
        dispose();
        }
       
        catch(NumberFormatException e) {    
            JOptionPane.showMessageDialog(null, "Please Enter Digits Only For The ID");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddingStudentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveChangesButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editPanel;
    private java.awt.Label first;
    private javax.swing.JTextField firstTextField;
    private java.awt.Label id;
    private javax.swing.JTextField idTextField;
    private java.awt.Label last;
    private javax.swing.JTextField lastTextField;
    private java.awt.Label middle;
    private javax.swing.JTextField middleTextField;
    private javax.swing.JButton saveChangesButton;
    // End of variables declaration//GEN-END:variables

    public JTextField getFirstTextField() {
        return firstTextField;
    }

    public void setFirstTextField(JTextField firstTextField) {
        this.firstTextField = firstTextField;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JTextField getLastTextField() {
        return lastTextField;
    }

    public void setLastTextField(JTextField lastTextField) {
        this.lastTextField = lastTextField;
    }

    public JTextField getMiddleTextField() {
        return middleTextField;
    }

    public void setMiddleTextField(JTextField middleTextField) {
        this.middleTextField = middleTextField;
    }
}
