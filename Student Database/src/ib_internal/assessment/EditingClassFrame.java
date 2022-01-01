
package ib_internal.assessment;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditingClassFrame extends javax.swing.JFrame {

    public EditingClassFrame() {
        initComponents();
        idTextField.setDocument(new JTextFieldLimit(9));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editPanel = new javax.swing.JPanel();
        id = new java.awt.Label();
        idTextField = new javax.swing.JTextField();
        name = new java.awt.Label();
        nameTextField = new javax.swing.JTextField();
        saveChangesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Class");
        setAlwaysOnTop(true);
        setResizable(false);

        editPanel.setPreferredSize(new java.awt.Dimension(325, 140));
        editPanel.setVerifyInputWhenFocusTarget(false);
        editPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        id.setName(""); // NOI18N
        id.setText("ID Number:");
        editPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        id.getAccessibleContext().setAccessibleName("ID Number");

        editPanel.add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 210, -1));

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setText("Name:");
        editPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        editPanel.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, -1));

        saveChangesButton.setText("Save Changes");
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });
        editPanel.add(saveChangesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, -1));

        getContentPane().add(editPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed
        
        if (idTextField.getText().equals("") | nameTextField.getText().equals("")) {
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
         
        String savedName = nameTextField.getText();
        
        SQLite.editClassFromDatabase(DataPanel.getOriginalID(), savedID, savedName);
        DataPanel.editClassRowOnJTable(savedID, savedName);
        
        dispose();
        }
       
        catch(NumberFormatException e) {    
            JOptionPane.showMessageDialog(null, "Please Enter Digits Only For The ID");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditingClassFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveChangesButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel editPanel;
    private java.awt.Label id;
    private javax.swing.JTextField idTextField;
    private java.awt.Label name;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton saveChangesButton;
    // End of variables declaration//GEN-END:variables

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }
}
