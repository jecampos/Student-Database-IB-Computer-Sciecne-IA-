
package ib_internal.assessment;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddingAssignmentFrame extends javax.swing.JFrame {

    private String currentClass;
    
    public AddingAssignmentFrame(String currentClass) {
        this.currentClass = currentClass;
        initComponents();
        gradeTextField.setDocument(new JTextFieldLimit(9));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addPanel = new javax.swing.JPanel();
        name = new java.awt.Label();
        nameTextField = new javax.swing.JTextField();
        grade = new java.awt.Label();
        gradeTextField = new javax.swing.JTextField();
        addNewAssignmentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Assignment");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(325, 155));
        setResizable(false);

        addPanel.setPreferredSize(new java.awt.Dimension(325, 164));
        addPanel.setVerifyInputWhenFocusTarget(false);
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setText("Name:");
        addPanel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        addPanel.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 220, -1));

        grade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        grade.setText("Grade (Between 0 and 1):");
        addPanel.add(grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, -1));
        addPanel.add(gradeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 130, -1));

        addNewAssignmentButton.setText("Add New Assignment");
        addNewAssignmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewAssignmentButtonActionPerformed(evt);
            }
        });
        addPanel.add(addNewAssignmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 290, -1));

        getContentPane().add(addPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewAssignmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewAssignmentButtonActionPerformed
        
        if (nameTextField.getText().equals("") | grade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a Value for Each Required Section");
            return;
        }
       
       try {
        
        double gradeNum = Double.parseDouble(gradeTextField.getText());
        System.out.println(gradeNum);
        
        if (gradeNum < 0 || gradeNum > 1)
        {
            JOptionPane.showMessageDialog(null, "Please enter an grade between 0 and 1");
            return;
        } 
         
        String savedName = nameTextField.getText();        
        
        SQLite.addAssignmentToDatabase(currentClass, savedName, gradeNum); 
        
        Object[] row = {savedName, gradeNum};
        StudentPageFrame.addAssignmentRowToJTable(row);
        StudentPageFrame.displayPercentageAndGrade();
        dispose();
        }
       
        catch(NumberFormatException e) {    
            JOptionPane.showMessageDialog(null, "Please Enter Digits/Decimals Only For The Grade");
            Logger.getLogger(AddingAssignmentFrame.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddingAssignmentFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addNewAssignmentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewAssignmentButton;
    private javax.swing.JPanel addPanel;
    private java.awt.Label grade;
    private javax.swing.JTextField gradeTextField;
    private java.awt.Label name;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
}
