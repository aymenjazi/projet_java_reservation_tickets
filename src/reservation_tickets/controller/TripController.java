package reservation_tickets.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import reservation_tickets.database.Config;
import reservation_tickets.model.Reservation;
import reservation_tickets.model.Trip;

public class TripController extends Config {
	/*public boolean inserer(Trip t) {
		String requete="INSERT INTO TRIP (aller,arrivee) VALUES (?,?,?);";
		try{
			PreparedStatement s=super.getCnx().prepareStatement(requete);
			s.setInt(1,t.getAllee());
			s.setInt(2, t.getArrivee());
			return s.execute();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
		
	}*/
	public Trip getTrip(int allee,int arrive){
		String requete="SELECT * FROM trip WHERE ville_allee=? AND ville_retour=?";
		Trip t=new Trip();
		try {
			PreparedStatement s=super.getCnx().prepareStatement(requete);
			s.setInt(1,allee);
			s.setInt(2, arrive);
			ResultSet result=s.executeQuery();
			boolean ok=result.next();
			if(ok) {
				t.setAllee(result.getInt("ville_allee"));
				t.setArrivee(result.getInt("ville_retour"));
				t.setId(result.getInt("id"));
			}
			super.clCnx();
			return t;	
		}
		catch(SQLException e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
			super.clCnx();
			return t;
		}
	}
	public int calculerprix(int id) {
		String requete ="SELECT ville.prix+classe.prix AS prix FROM ville JOIN trip ON (ville.id=trip.ville_retour) JOIN classe ON (trip.classe=classe.id)WHERE trip.ville_retour=?;";
		try {
			PreparedStatement s=super.getCnx().prepareStatement(requete);
			s.setInt(1, id);
			ResultSet result=s.executeQuery();
			boolean move=result.next();
			if(move) {
				int x=result.getInt("prix");
				super.clCnx();
				return x;
			}
			else {
				super.clCnx();
				return 0;
			}
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			super.clCnx();
			return 0;
		}
	}
	/*public boolean update(Trip t) {
		String requete="UPDATE INTO TRIP (aller,retour,temps) VALUES (?,?,?);";
		try {
			PreparedStatement s=super.getCnx().prepareStatement(requete);
			return s.execute();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}*/
	/*public boolean delete(int id) {
		String requete="DELETE FROM TABLE trip WHERE id=?;";
		try {
			PreparedStatement s=super.getCnx().prepareStatement(requete,id);
			return s.execute();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}*/
	
}
