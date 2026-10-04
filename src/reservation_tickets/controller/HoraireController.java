package reservation_tickets.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import reservation_tickets.database.Config;
import reservation_tickets.model.Horaire;
import reservation_tickets.model.Trip;

public class HoraireController extends Config{
	public List<Horaire> getTimes(Trip t){
		String requete="SELECT * FROM horaire WHERE trip=?";
		List<Horaire> liste=new ArrayList<Horaire>();
		try {
			PreparedStatement s=super.getCnx().prepareStatement(requete);
			s.setInt(1, t.getId());
			ResultSet result=s.executeQuery();
			boolean ok=result.next();
			while(ok) {
				Horaire h=new Horaire();
				h.setId(result.getInt("id"));
				h.setTemps(result.getString("temps"));
				h.setTrip(t.getId());
				liste.add(h);
				ok=result.next();
			}
			super.clCnx();
			return liste;
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			super.clCnx();
			return liste;
		}
	}

}
