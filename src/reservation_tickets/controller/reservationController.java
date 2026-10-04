package reservation_tickets.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import reservation_tickets.database.Config;
import reservation_tickets.model.Reservation;

public class reservationController extends Config{
	public boolean insert(Reservation R) {
		String requete="INSERT INTO reservation (trip,temps) VALUES (?,?);";
		try {
			PreparedStatement s=super.getCnx().prepareStatement(requete);
			s.setInt(1,R.getTrip());
			s.setInt(2,R.getTemps());
			boolean ok=s.executeUpdate()==1;
			super.clCnx();
			return ok;
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			super.clCnx();
			return false;
		}
	}
}
