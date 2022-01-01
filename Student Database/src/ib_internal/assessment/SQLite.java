
package ib_internal.assessment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SQLite {
    
    public static void buildDatabase () throws ClassNotFoundException, SQLException  {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement1 = "CREATE TABLE \"Students\" (\n"
                + "	\"ID\"	INTEGER NOT NULL,\n"
                + "	\"First\"	TEXT NOT NULL,\n"
                + "	\"Middle\"	TEXT,\n"
                + "	\"Last\"	TEXT NOT NULL,\n"
                + "	PRIMARY KEY(\"ID\")\n"
                + ");";

        String sqlStatement2 = "CREATE TABLE \"Classes\" (\n"
                + "	\"ID\"	INTEGER NOT NULL,\n"
                + "	\"Name\"	TEXT NOT NULL UNIQUE,\n"
                + "	PRIMARY KEY(\"ID\")\n"
                + ");";
        
        String sqlStatement3 = "CREATE TABLE \"Assigned_Classes\" (\n"
                + "	\"Student_ID\"	INTEGER NOT NULL,\n"
                + "	\"Class_ID\"	INTEGER NOT NULL,\n"
                + "	FOREIGN KEY(\"Student_ID\") REFERENCES \"Students\"(\"ID\"),\n"
                + "	FOREIGN KEY(\"Class_ID\") REFERENCES \"Classes\"(\"ID\")\n"
                + ");";
        
        String sqlStatement4 = "CREATE TABLE \"Assignments\" (\n"
                + "	\"Student_ID\"	INTEGER NOT NULL,\n"
                + "	\"Class_ID\"	INTEGER NOT NULL,\n"
                + "	\"Name\"	TEXT NOT NULL UNIQUE,\n"
                + "	\"Grade\"	REAL NOT NULL,\n"
                + "	FOREIGN KEY(\"Class_ID\") REFERENCES \"Classes\"(\"ID\"),\n"
                + "	FOREIGN KEY(\"Student_ID\") REFERENCES \"Students\"(\"ID\")\n"
                + ");";
        
        Statement state = conn.createStatement();
        state.executeUpdate(sqlStatement1);
        state.executeUpdate(sqlStatement2);
        state.executeUpdate(sqlStatement3);
        state.executeUpdate(sqlStatement4);
        
        state.close();
        conn.close();
    }
    
    public static void DatabaseToJTables (JTable table1, JTable table2) throws ClassNotFoundException, SQLException 
    {

        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement1 = "SELECT * FROM Students";
        String sqlStatement2 = "SELECT * FROM Classes";
        
        Statement state1 = conn.createStatement();
        Statement state2 = conn.createStatement();
        
        ResultSet rs1 = state1.executeQuery(sqlStatement1);
        ResultSet rs2 = state2.executeQuery(sqlStatement2);

        DefaultTableModel modelOne = (DefaultTableModel)table1.getModel();
        DefaultTableModel modelTwo = (DefaultTableModel)table2.getModel();
        
        while(rs1.next())
            {         
                int id = rs1.getInt("ID");
		String first = rs1.getString("First");
		String middle = rs1.getString("Middle");
		String last = rs1.getString("Last");
                
                Object[] databaseRow1 = {id, first, middle, last};
                modelOne.addRow(databaseRow1);
            }
        
        while(rs2.next())
            {         
                int id = rs2.getInt("ID");
		String name = rs2.getString("Name");
                
                Object[] databaseRow2 = {id, name};
                modelTwo.addRow(databaseRow2);
            }
    }
    
    public static void addStudentToDatabse (int id, String first, String middle, String last) throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "INSERT INTO Students (ID,First,Middle,Last) " + 
        "VALUES (" + id + "," + "'" + first + "'" + "," +"'" + middle + "'" + "," + "'" + last + "'" + ");";
        
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement);
        
        state.close();
        conn.close();
    }
    
    public static void deleteStudentFromDatabase (String id) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "DELETE FROM Students WHERE ID = " + id + ";";
        
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement);
        
        state.close();
        conn.close();
        
    }
    
    public static void editStudentFromDatabase (int originalID, int newID, String first, String middle, String last) throws ClassNotFoundException, SQLException 
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "UPDATE Students "
                            + "SET ID = " + newID 
                            + ", First = " + "'" + first + "'" 
                            + ", Middle = " + "'" + middle + "'"
                            + ", Last = " + "'" + last + "'"
                            + " WHERE ID = " + originalID + ";";
        
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement);
        
        state.close();
        conn.close();
    }
    
    public static void addClassToDatabase (int id, String name) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "INSERT INTO Classes (ID,Name) " + 
        "VALUES (" + id + "," + "'" + name + "')";
        
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement);
    }
    
    public static void deleteClassFromDatabse(String id) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "DELETE FROM Classes WHERE ID = " + id + ";";
        
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement);
    }
    
    public static void editClassFromDatabase(int originalID, int newID, String name) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "UPDATE Classes "
                            + "SET ID = " + newID 
                            + ", Name = " + "'" + name + "'" 
                            + " WHERE ID = " + originalID + ";";
        
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement); 
    }
    
    public static void getAndAddClassNamesFromDatabase(JTable table) throws SQLException, ClassNotFoundException
    {    
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "SELECT Name FROM Classes";
        
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery(sqlStatement);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        while (rs.next())
        {
            String name = rs.getString(1);
            Object[] rowData = {name};
            model.addRow(rowData);
        }
    }
    
    public static ArrayList<String> saveClassSelectionToDatabase(JTable table) throws SQLException, ClassNotFoundException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        Statement state = conn.createStatement();
        ArrayList<String> classList = new ArrayList<>();
        
        for (int i = 0; i < table.getRowCount(); i++)
        {
            Object assigned = table.getValueAt(i, 1);
            
            if (assigned == null) {
                
            }
            
            else if ((boolean)assigned == true)
            {
                String classSelected = (String)table.getValueAt(i, 0);
                classList.add(classSelected);
                String sqlStatement = "SELECT ID FROM Classes WHERE Name = " + "'" + classSelected + "'";
                ResultSet rs = state.executeQuery(sqlStatement);
                int classID = rs.getInt(1);
                sqlStatement = "INSERT INTO Assigned_Classes (Student_ID, Class_ID)" +
                              " VALUES (" + DataPanel.getOriginalID() + ", " + classID + ")";
                state.executeUpdate(sqlStatement);
            }
            
            else if ((boolean)assigned == false)
            {
                String classSelected = (String)table.getValueAt(i, 0);
                String sqlStatement = "DELETE FROM Assigned_Classes WHERE Student_ID = " + DataPanel.getOriginalID() + 
                               " AND Class_ID = (SELECT ID FROM Classes WHERE Name = '" + classSelected + "')";
                state.executeUpdate(sqlStatement);
            }
        }
        //from https://stackoverflow.com/questions/8190541/deleting-duplicate-rows-from-sqlite-database
        String sqlStatement = "DELETE   FROM Assigned_Classes " +
                              "WHERE    ROWID NOT IN" +
                              "         (" +
                              "         SELECT  min(ROWID)" +
                              "         FROM    Assigned_Classes" +
                              "         GROUP BY" +
                              "                 Student_ID" +
                              "         ,       Class_ID" +
                              "         )";
        state.executeUpdate(sqlStatement);
        return classList;
    }
    public static ArrayList<String> getAssignedClasses (int id) throws ClassNotFoundException, SQLException
    {
        ArrayList<String> classList = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        Statement state = conn.createStatement();
        
        String sqlStatement = "SELECT Name FROM Classes WHERE ID IN" +
        "(SELECT Class_ID FROM Assigned_Classes WHERE Student_ID = (" + id + "))";
        ResultSet rs = state.executeQuery(sqlStatement);
        
        while(rs.next())
        {
            String classResult = rs.getString(1);
            classList.add(classResult);
        }
        
        return classList;
    }
    
    public static void addAssignmentToDatabase (String classSelected, String name, double grade) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        Statement state = conn.createStatement();
        
        String sqlStatement = "SELECT ID FROM Classes WHERE Name = '" + classSelected + "'"; 
        ResultSet rs = state.executeQuery(sqlStatement);
        
        
        sqlStatement = "INSERT INTO Assignments (Student_ID, Class_ID, Name, Grade) " + 
        "VALUES (" + DataPanel.getOriginalID() + "," + "'" + rs.getInt(1) + "'" + "," +"'" + name + "'" + "," + "'" + grade + "'" + ");";
        state.executeUpdate(sqlStatement);
        
    }
    public static void deleteAssignmentFromDatbase (String classSelected, String name, double grade) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "DELETE FROM Assignments WHERE Student_ID = " + DataPanel.getOriginalID() + " AND Class_ID = " +
                              "(SELECT ID FROM CLASSES WHERE Name = '" + classSelected + "')" +
                              "AND NAME = '" + name + "' AND Grade = " + grade;
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement);
    }
    public static void editAssignmentFromDatabase(String classSelected, String name, double grade, String assignmentName) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        
        String sqlStatement = "UPDATE Assignments "
                            + "SET Name = '" + name 
                            + "' , Grade = " + grade
                            + " WHERE Name = '" + assignmentName + "'";
        
        Statement state = conn.createStatement();	
        state.executeUpdate(sqlStatement); 
    }
    
    public static void assignmentDatabasetoJTable(JTable table, String classSelected) throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
	Connection conn = DriverManager.getConnection("jdbc:sqlite:Database.db");
        Statement state = conn.createStatement();
        
        String sqlStatement = "SELECT * FROM Assignments WHERE Student_ID = " + DataPanel.getOriginalID() +
                              " AND Class_ID = (SELECT ID FROM CLASSES WHERE Name = '" + classSelected + "')";
        ResultSet rs = state.executeQuery(sqlStatement);
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        while(rs.next())
        {
		String name = rs.getString(3);
		double grade = rs.getDouble(4);
                
                Object[] row = {name, grade};
                model.addRow(row);
        }
    }
}
