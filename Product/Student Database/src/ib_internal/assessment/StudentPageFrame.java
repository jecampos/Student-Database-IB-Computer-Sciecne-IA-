
package ib_internal.assessment;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StudentPageFrame extends javax.swing.JFrame {

    public StudentPageFrame() {
        initComponents();
        centerTables();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        mainSplitPane = new javax.swing.JSplitPane();
        classSelectionPanel = new javax.swing.JPanel();
        selectClassLabel = new java.awt.Label();
        classSelectionComboBox = new javax.swing.JComboBox<>();
        assignClassesButton = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        JTableAndGradesSplitPane = new javax.swing.JSplitPane();
        JTablePanel = new javax.swing.JPanel();
        JTableSplitPane = new javax.swing.JSplitPane();
        assignmentJTableScrollPane = new javax.swing.JScrollPane();
        assignmentJTable = new javax.swing.JTable();
        JTableButtonsPanel = new javax.swing.JPanel();
        addAssignmentButton = new javax.swing.JButton();
        editAssignmentButton = new javax.swing.JButton();
        deleteAssignmentButton = new javax.swing.JButton();
        gradesPanel = new javax.swing.JPanel();
        classPercentageLabel = new java.awt.Label();
        classPercentageTextField = new javax.swing.JTextField();
        classGradeLabel = new java.awt.Label();
        classGradeTextField = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Page");
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);

        mainSplitPane.setDividerLocation(60);
        mainSplitPane.setDividerSize(0);
        mainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        mainSplitPane.setResizeWeight(0.25);

        selectClassLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectClassLabel.setText("Select a Class:");

        classSelectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classSelectionComboBoxActionPerformed(evt);
            }
        });

        assignClassesButton.setText("<html><center>Assign Class(es)<br>to Student</center></html>");
        assignClassesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignClassesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout classSelectionPanelLayout = new javax.swing.GroupLayout(classSelectionPanel);
        classSelectionPanel.setLayout(classSelectionPanelLayout);
        classSelectionPanelLayout.setHorizontalGroup(
            classSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classSelectionPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(selectClassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(assignClassesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        classSelectionPanelLayout.setVerticalGroup(
            classSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classSelectionPanelLayout.createSequentialGroup()
                .addGroup(classSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(classSelectionPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(classSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classSelectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectClassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(classSelectionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(assignClassesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainSplitPane.setTopComponent(classSelectionPanel);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        JTableAndGradesSplitPane.setDividerLocation(225);
        JTableAndGradesSplitPane.setDividerSize(0);
        JTableAndGradesSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        JTableAndGradesSplitPane.setResizeWeight(0.25);

        JTablePanel.setLayout(new java.awt.BorderLayout());

        JTableSplitPane.setDividerLocation(350);
        JTableSplitPane.setDividerSize(0);

        assignmentJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Assignment Name", "Grade (Between 0 and 1)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
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
        assignmentJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        assignmentJTable.getTableHeader().setReorderingAllowed(false);
        assignmentJTableScrollPane.setViewportView(assignmentJTable);

        JTableSplitPane.setLeftComponent(assignmentJTableScrollPane);

        JTableButtonsPanel.setLayout(new java.awt.GridLayout(0, 1));

        addAssignmentButton.setText("<html><center>Add<br>Assignment</center></html>");
        addAssignmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAssignmentButtonActionPerformed(evt);
            }
        });
        JTableButtonsPanel.add(addAssignmentButton);

        editAssignmentButton.setText("<html><center>Edit<br>Assignment</center></html>");
        editAssignmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAssignmentButtonActionPerformed(evt);
            }
        });
        JTableButtonsPanel.add(editAssignmentButton);

        deleteAssignmentButton.setText("<html><center>Delete<br>Assignment</center></html>");
        deleteAssignmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAssignmentButtonActionPerformed(evt);
            }
        });
        JTableButtonsPanel.add(deleteAssignmentButton);

        JTableSplitPane.setRightComponent(JTableButtonsPanel);

        JTablePanel.add(JTableSplitPane, java.awt.BorderLayout.CENTER);

        JTableAndGradesSplitPane.setLeftComponent(JTablePanel);

        classPercentageLabel.setAlignment(java.awt.Label.CENTER);
        classPercentageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        classPercentageLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        classPercentageLabel.setPreferredSize(new java.awt.Dimension(100, 20));
        classPercentageLabel.setText("Class Percentage:");

        classPercentageTextField.setEditable(false);
        classPercentageTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        classGradeLabel.setAlignment(java.awt.Label.CENTER);
        classGradeLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        classGradeLabel.setPreferredSize(new java.awt.Dimension(80, 20));
        classGradeLabel.setText("Class Grade:");

        classGradeTextField.setEditable(false);
        classGradeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout gradesPanelLayout = new javax.swing.GroupLayout(gradesPanel);
        gradesPanel.setLayout(gradesPanelLayout);
        gradesPanelLayout.setHorizontalGroup(
            gradesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradesPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(gradesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classPercentageTextField)
                    .addComponent(classPercentageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addGroup(gradesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(classGradeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classGradeTextField))
                .addGap(75, 75, 75))
        );
        gradesPanelLayout.setVerticalGroup(
            gradesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(classPercentageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classGradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classPercentageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classGradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        JTableAndGradesSplitPane.setBottomComponent(gradesPanel);

        bottomPanel.add(JTableAndGradesSplitPane, java.awt.BorderLayout.CENTER);

        mainSplitPane.setRightComponent(bottomPanel);

        getContentPane().add(mainSplitPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void classSelectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classSelectionComboBoxActionPerformed
        if (classSelectionComboBox.getItemCount() == 0) {
            return;
        }
        String classSelected = classSelectionComboBox.getSelectedItem().toString();
        
        DefaultTableModel model = (DefaultTableModel) assignmentJTable.getModel();
        model.setRowCount(0);
        
        try {
            SQLite.assignmentDatabasetoJTable(assignmentJTable, classSelected);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentPageFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        displayPercentageAndGrade();
    }//GEN-LAST:event_classSelectionComboBoxActionPerformed

    public static void initializeComboBox(ArrayList<String> classList) {
        classSelectionComboBox.removeAllItems();
        for (int i = 0; i < classList.size(); i++)
        {
            classSelectionComboBox.addItem(classList.get(i));
        }
    }
    
    private void assignClassesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignClassesButtonActionPerformed
        try {
            AssigningClassesFrame frame = new AssigningClassesFrame();
            JTable table = frame.getAssignClassesJTable();
            SQLite.getAndAddClassNamesFromDatabase(table);
            frame.setAssignClassesJTable(table);
            ArrayList<String> classList = SQLite.getAssignedClasses(DataPanel.getOriginalID());
            
            
            for (int i = 0; i < table.getRowCount(); i++)
            {
                for (int j = 0; j < classList.size(); j++)
                {
                    String classFromTable = (String)table.getValueAt(i, 0);
                    if (classFromTable.equals(classList.get(j)))
                    {
                        table.setValueAt(true, i, 1);
                    }
                }
            }           
            frame.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(StudentPageFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_assignClassesButtonActionPerformed

    private void addAssignmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAssignmentButtonActionPerformed
        if (classSelectionComboBox.getItemCount() == 0) {
            return;
        }
        String classSelected = classSelectionComboBox.getSelectedItem().toString();        
        AddingAssignmentFrame frame = new AddingAssignmentFrame(classSelected);
        frame.setVisible(true);
    }//GEN-LAST:event_addAssignmentButtonActionPerformed

    public static JTable getAssignmentJTable() {
        return assignmentJTable;
    }

    public static void addAssignmentRowToJTable (Object[] row) {
        DefaultTableModel model = (DefaultTableModel) assignmentJTable.getModel();
        model.addRow(row);
    }
    
    private void editAssignmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAssignmentButtonActionPerformed
        if (classSelectionComboBox.getItemCount() == 0) {
            return;
        }
        
        if (assignmentJTable.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Select an Assignment from the table");
            return;
        }
        
        int rowIndex = assignmentJTable.getSelectedRow();
        String classSelected = classSelectionComboBox.getSelectedItem().toString();
        EditingAssignmentFrame frame = new EditingAssignmentFrame(classSelected, (String)assignmentJTable.getValueAt(rowIndex, 0));
        
        JTextField nameField = frame.getNameTextField();
        JTextField gradeField = frame.getGradeTextField();
        
        nameField.setText((String)assignmentJTable.getValueAt(rowIndex, 0));
        gradeField.setText(Double.toString((double)assignmentJTable.getValueAt(rowIndex, 1)));
        
        frame.setNameTextField(nameField);
        frame.setGradeTextField(gradeField);  
        
        frame.setVisible(true);
    }//GEN-LAST:event_editAssignmentButtonActionPerformed

    public static void editAssignmentRowOnJTable (Object[] row)
    {
        int rowIndex = assignmentJTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) assignmentJTable.getModel();
        model.setValueAt(row[0], rowIndex, 0);
        model.setValueAt(row[1], rowIndex, 1);
    }
    
    private void deleteAssignmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAssignmentButtonActionPerformed
        if (classSelectionComboBox.getItemCount() == 0) {
            return;
        }
        
        if (assignmentJTable.getSelectionModel().isSelectionEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please Select an Assignment from the table");
            return;
        }
        String classSelected = classSelectionComboBox.getSelectedItem().toString();  
        
        int rowIndex = assignmentJTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) assignmentJTable.getModel();
        String name = (String)assignmentJTable.getValueAt(rowIndex, 0);
        double grade = Double.parseDouble(assignmentJTable.getValueAt(rowIndex, 1).toString());
        
        try {
            SQLite.deleteAssignmentFromDatbase(classSelected, name, grade);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentPageFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model.removeRow(rowIndex);
        displayPercentageAndGrade();
    }//GEN-LAST:event_deleteAssignmentButtonActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane JTableAndGradesSplitPane;
    private javax.swing.JPanel JTableButtonsPanel;
    private javax.swing.JPanel JTablePanel;
    private javax.swing.JSplitPane JTableSplitPane;
    private javax.swing.JButton addAssignmentButton;
    private javax.swing.JButton assignClassesButton;
    private static javax.swing.JTable assignmentJTable;
    private javax.swing.JScrollPane assignmentJTableScrollPane;
    private javax.swing.JPanel bottomPanel;
    private java.awt.Label classGradeLabel;
    private static javax.swing.JTextField classGradeTextField;
    private java.awt.Label classPercentageLabel;
    private static javax.swing.JTextField classPercentageTextField;
    private static javax.swing.JComboBox<String> classSelectionComboBox;
    private javax.swing.JPanel classSelectionPanel;
    private javax.swing.JButton deleteAssignmentButton;
    private javax.swing.JButton editAssignmentButton;
    private javax.swing.JPanel gradesPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JSplitPane mainSplitPane;
    private java.awt.Label selectClassLabel;
    // End of variables declaration//GEN-END:variables
    private void centerTables() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for(int i = 0; i < assignmentJTable.getColumnCount(); i++){
         assignmentJTable.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
        }
    }  
    
    public static double calculateClassPercentage(JTable table)
    {
        double sum = 0;
        if (table.getRowCount() == 0)
        {
            return sum;
        }
        
        for (int i = 0; i < table.getRowCount(); i++)
        {
            sum += (double)table.getValueAt(i, 1);
        }
        
        double percentage = sum/table.getRowCount();
        return percentage * 100;
    }
    
    public static void displayPercentageAndGrade()
    {
        double percentage = calculateClassPercentage(assignmentJTable);
        DecimalFormat f = new DecimalFormat("##.00");
        
        if (percentage == 0)
        {
            classPercentageTextField.setText("0.00%");
            classGradeTextField.setText("F");
        }
        
        else {
        classPercentageTextField.setText(f.format(percentage) + "%");
        }
        
        if (percentage >= 90)
        {
            classGradeTextField.setText("A");
        }
        
        else if (percentage >= 80)
        {
            classGradeTextField.setText("B");
        }
        
        else if (percentage >= 70)
        {
            classGradeTextField.setText("C");
        }
        
        else if (percentage >= 60)
        {
            classGradeTextField.setText("D");
        }
        
        else
        {
            classGradeTextField.setText("F");
        }
    }
}

