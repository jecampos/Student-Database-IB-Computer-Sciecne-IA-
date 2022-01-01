package ib_internal.assessment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataPanel extends JPanel {

    public DataPanel() throws ClassNotFoundException, SQLException{
        initComponents();
        centerTables();
        SQLite.DatabaseToJTables(StudentTable, classTable);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanes = new javax.swing.JTabbedPane();
        studentSplitPane = new javax.swing.JSplitPane();
        studentScrollPane = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        studentButtonsPanel = new javax.swing.JPanel();
        addingStudentButton = new javax.swing.JButton();
        editStudentButton = new javax.swing.JButton();
        deleteStudentButton = new javax.swing.JButton();
        goToStudentPageButton = new javax.swing.JButton();
        classSplitPlane = new javax.swing.JSplitPane();
        classScrollPanel = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        classButtonPanel = new javax.swing.JPanel();
        addClassButton = new javax.swing.JButton();
        editClassButton = new javax.swing.JButton();
        deleteClassButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(500, 400));
        setLayout(new java.awt.BorderLayout());

        studentSplitPane.setDividerSize(0);
        studentSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        studentSplitPane.setResizeWeight(0.75);

        StudentTable.setAutoCreateRowSorter(true);
        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Middle Name", "Last Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        StudentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        StudentTable.getTableHeader().setReorderingAllowed(false);
        studentScrollPane.setViewportView(StudentTable);

        studentSplitPane.setLeftComponent(studentScrollPane);

        studentButtonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        addingStudentButton.setText("Add Student");
        addingStudentButton.setToolTipText("");
        addingStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addingStudentButtonActionPerformed(evt);
            }
        });
        studentButtonsPanel.add(addingStudentButton);

        editStudentButton.setText("Edit Student");
        editStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentButtonActionPerformed(evt);
            }
        });
        studentButtonsPanel.add(editStudentButton);

        deleteStudentButton.setText("Delete Student");
        deleteStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentButtonActionPerformed(evt);
            }
        });
        studentButtonsPanel.add(deleteStudentButton);

        goToStudentPageButton.setText("<html><center>Go To<br>Student's Page</center></html>");
        goToStudentPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToStudentPageButtonActionPerformed(evt);
            }
        });
        studentButtonsPanel.add(goToStudentPageButton);

        studentSplitPane.setRightComponent(studentButtonsPanel);

        tabbedPanes.addTab("Students", studentSplitPane);

        classSplitPlane.setDividerSize(0);
        classSplitPlane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        classSplitPlane.setResizeWeight(0.75);

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        classTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        classTable.getTableHeader().setReorderingAllowed(false);
        classScrollPanel.setViewportView(classTable);

        classSplitPlane.setLeftComponent(classScrollPanel);

        classButtonPanel.setLayout(new java.awt.GridLayout(1, 0));

        addClassButton.setText("Add Class");
        addClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassButtonActionPerformed(evt);
            }
        });
        classButtonPanel.add(addClassButton);

        editClassButton.setText("Edit Class");
        editClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClassButtonActionPerformed(evt);
            }
        });
        classButtonPanel.add(editClassButton);

        deleteClassButton.setText("Delete Class");
        deleteClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClassButtonActionPerformed(evt);
            }
        });
        classButtonPanel.add(deleteClassButton);

        classSplitPlane.setRightComponent(classButtonPanel);

        tabbedPanes.addTab("Classes", classSplitPlane);

        add(tabbedPanes, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void addingStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addingStudentButtonActionPerformed
        AddingStudentFrame addFrame = new AddingStudentFrame();
        addFrame.setVisible(true);
    }//GEN-LAST:event_addingStudentButtonActionPerformed
    
    // from https://www.youtube.com/watch?v=XWpxl1aCOyU&t=166s&ab_channel=1BestCsharpblog
    public static void addStudentRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        model.addRow(dataRow);
    }
    
    private void editStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentButtonActionPerformed
        if (StudentTable.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Select a student from the table");
            return;
        }
        
        int rowIndex = StudentTable.getSelectedRow();
        
        Object id = StudentTable.getModel().getValueAt(rowIndex, 0);
        
        DataPanel.setOriginalID((Integer)id);
        
        Object first = StudentTable.getModel().getValueAt(rowIndex, 1);
        Object middle = StudentTable.getModel().getValueAt(rowIndex, 2);
        Object last = StudentTable.getModel().getValueAt(rowIndex, 3);
        
        EditingStudentFrame editFrame = new EditingStudentFrame();
        
        JTextField idField = editFrame.getIdTextField();
        JTextField firstField = editFrame.getFirstTextField();
        JTextField middleField = editFrame.getMiddleTextField();
        JTextField lastField = editFrame.getLastTextField();
        
        idField.setText(Integer.toString((int)id));
        firstField.setText((String)first);
        middleField.setText((String)middle);
        lastField.setText((String)last);
        
        editFrame.setIdTextField(idField);
        editFrame.setFirstTextField(firstField);
        editFrame.setMiddleTextField(middleField);
        editFrame.setLastTextField(lastField);
        
        editFrame.setVisible(true);
    }//GEN-LAST:event_editStudentButtonActionPerformed

    public static void editStudentRowOnJTable(int id, String first, String middle, String last) 
    {
        int rowIndex = StudentTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        model.setValueAt(id, rowIndex, 0);
        model.setValueAt(first, rowIndex, 1);
        model.setValueAt(middle, rowIndex, 2);
        model.setValueAt(last, rowIndex, 3);
    }
        
    private void deleteStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentButtonActionPerformed
        if (StudentTable.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Select a student from the table");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();
        int rowIndex = StudentTable.getSelectedRow();
        Object idObject = StudentTable.getValueAt(rowIndex, 0);
        String idString = idObject.toString();
        
        try {
            SQLite.deleteStudentFromDatabase(idString);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.removeRow(rowIndex);
    }//GEN-LAST:event_deleteStudentButtonActionPerformed

    private void addClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassButtonActionPerformed
        AddingClassFrame addFrame = new AddingClassFrame();
        addFrame.setVisible(true);
    }//GEN-LAST:event_addClassButtonActionPerformed

    public static void addClassRowToJTable (Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel) classTable.getModel();
        model.addRow(dataRow);
    }
        
    private void deleteClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteClassButtonActionPerformed
        if (classTable.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Select a class from the table");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) classTable.getModel();
        int rowIndex = classTable.getSelectedRow();
        Object idObject = classTable.getValueAt(rowIndex, 0);
        String idString = idObject.toString();
        
        try {
            SQLite.deleteClassFromDatabse(idString);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.removeRow(rowIndex);        
    }//GEN-LAST:event_deleteClassButtonActionPerformed

    private void editClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClassButtonActionPerformed
        if (classTable.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Select a class from the table");
            return;
        }
        
        int rowIndex = classTable.getSelectedRow(); 
        Object id = classTable.getModel().getValueAt(rowIndex, 0);
        setOriginalID((Integer)id);
        
        Object name = classTable.getModel().getValueAt(rowIndex, 1);
        
        EditingClassFrame editFrame = new EditingClassFrame();
        
        JTextField idField = editFrame.getIdTextField();
        JTextField nameField = editFrame.getNameTextField();
        
        idField.setText(Integer.toString((int)id));
        nameField.setText((String)name);
        
        editFrame.setIdTextField(idField);
        editFrame.setNameTextField(nameField);
        
        editFrame.setVisible(true);       
    }//GEN-LAST:event_editClassButtonActionPerformed

    public static void editClassRowOnJTable(int id, String name)
    {
        int rowIndex = classTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) classTable.getModel();
        model.setValueAt(id, rowIndex, 0);
        model.setValueAt(name, rowIndex, 1);
    }

    private void goToStudentPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToStudentPageButtonActionPerformed
        try {
            if (StudentTable.getSelectionModel().isSelectionEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please Select a student from the table");
                return;
            }
            
            int rowIndex = StudentTable.getSelectedRow();
            Object id = StudentTable.getModel().getValueAt(rowIndex, 0);
            setOriginalID((Integer)id);
            
            ArrayList<String> classList = SQLite.getAssignedClasses(originalID);
            StudentPageFrame pageFrame = new StudentPageFrame();
            StudentPageFrame.initializeComboBox(classList);
            
            pageFrame.setVisible(true);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_goToStudentPageButtonActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable StudentTable;
    private javax.swing.JButton addClassButton;
    private javax.swing.JButton addingStudentButton;
    private javax.swing.JPanel classButtonPanel;
    private javax.swing.JScrollPane classScrollPanel;
    private javax.swing.JSplitPane classSplitPlane;
    private static javax.swing.JTable classTable;
    private javax.swing.JButton deleteClassButton;
    private javax.swing.JButton deleteStudentButton;
    private javax.swing.JButton editClassButton;
    private javax.swing.JButton editStudentButton;
    private javax.swing.JButton goToStudentPageButton;
    private javax.swing.JPanel studentButtonsPanel;
    private javax.swing.JScrollPane studentScrollPane;
    private javax.swing.JSplitPane studentSplitPane;
    private static javax.swing.JTabbedPane tabbedPanes;
    // End of variables declaration//GEN-END:variables
    private static int originalID;

    public static int getOriginalID() {
        return originalID;
    }

    public static void setOriginalID(int originalID) {
        DataPanel.originalID = originalID;
    }
    
     
    private void centerTables() {
        
        //center cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for(int i = 0; i < StudentTable.getColumnCount(); i++){
         StudentTable.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
        
        for(int i = 0; i < classTable.getColumnCount(); i++){
        classTable.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
    }
}