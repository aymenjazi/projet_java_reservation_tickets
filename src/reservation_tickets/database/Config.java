package reservation_tickets.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class Config {
	private Connection cnx;
	public void setCnx() {
		try {
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation_tickets","root","");
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Couldn't connect please try later");
		}
	}
	public Connection getCnx() {
		setCnx();
		return cnx;
	}
	public void clCnx(){
		try {
			cnx.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
