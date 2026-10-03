package reservation_tickets.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import reservation_tickets.database.Config;
import reservation_tickets.model.Ville;

public class VilleController extends Config {
	public List<Ville> getVilles() {
		String requete="SELECT * FROM ville;";
		List<Ville> liste=new ArrayList<Ville>();
		try {
			Statement s=super.getCnx().createStatement();
			ResultSet result=s.executeQuery(requete);
			while(result.next()) {
				Ville v=new Ville();
				v.setId(result.getInt("id"));
				v.setNom(result.getString("nom"));
				liste.add(v);
			}
			System.out.println(liste);
			return liste;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return liste;
		}
	}
	public Ville getVille(int id) {
		String requete="SELECT * FROM ville WHERE id=?";
		Ville v=new Ville();
		try {
			PreparedStatement s=super.getCnx().prepareStatement(requete);
			s.setInt(1, id);
			ResultSet result=s.executeQuery();
			if(result.next()) {
				v.setId(result.getInt("id"));
				v.setNom(result.getString("nom"));
			}
			return v;
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return v;
		}
	}

}
