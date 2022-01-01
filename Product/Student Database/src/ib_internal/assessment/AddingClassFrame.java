
package ib_internal.assessment;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddingClassFrame extends javax.swing.JFrame {

    public AddingClassFrame() {
        initComponents();
        idTextField.setDocument(new JTextFieldLimit(9));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPanel = new javax.swing.JPanel();
        id = new java.awt.Label();
        idTextField = new javax.swing.JTextField();
        name = new java.awt.Label();
        nameTextField = new javax.swing.JTextField();
        addNewClassButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Class");
        setAlwaysOnTop(true);
        setResizable(false);

        addPanel.setPreferredSize(new java.awt.Dimension(325, 140));
        addPanel.setVerifyInputWhenFocusTarget(false);
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        id.setName(""); // NOI18N
        id.setText("ID Number:");
        addPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        id.getAccessibleContext().setAccessibleName("ID Number");

        addPanel.add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 210, -1));

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setText("Name:");
        addPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        addPanel.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, -1));

        addNewClassButton.setText("Add New Class");
        addNewClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewClassButtonActionPerformed(evt);
            }
        });
        addPanel.add(addNewClassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, -1));

        getContentPane().add(addPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewClassButtonActionPerformed
        
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
        
        SQLite.addClassToDatabase(savedID, savedName);
        
        Object[] row = {savedID, savedName};
        DataPanel.addClassRowToJTable(row);
        dispose();
        }
       
        catch(NumberFormatException e) {    
            JOptionPane.showMessageDialog(null, "Please Enter Digits Only For The ID");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddingClassFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addNewClassButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewClassButton;
    private javax.swing.JPanel addPanel;
    private java.awt.Label id;
    private javax.swing.JTextField idTextField;
    private java.awt.Label name;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
}
