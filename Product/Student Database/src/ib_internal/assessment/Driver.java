package ib_internal.assessment;

import java.io.File;
import javax.swing.JFrame;
import java.sql.SQLException;

public class Driver extends JFrame {

	DataPanel panel;
	
	public Driver() throws ClassNotFoundException, SQLException {
		this.setTitle("Student Database");
					
		panel = new DataPanel();
		
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
            File tempFile = new File("database.db");
            boolean exists = tempFile.exists();
            
            if (!exists)
            {
                SQLite.buildDatabase();
            }
            
            new Driver();
		
    }
}

