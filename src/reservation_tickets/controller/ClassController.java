package reservation_tickets.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import reservation_tickets.database.Config;
import reservation_tickets.model.Classe;

public class ClassController extends Config{
	public List<Classe> getClasses() {
		String requete="SELECT * FROM classe;";
		List<Classe> liste=new ArrayList<Classe>();
		try {
			Statement s=super.getCnx().createStatement();
			ResultSet result=s.executeQuery(requete);
			boolean ok=result.next();
			while(ok) {
				Classe c=new Classe();
				c.setId(result.getInt("id"));
				c.setNom(result.getString("nom"));
				liste.add(c);
				ok=result.next();
			}
			System.out.println(liste);
			return liste;
			}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return liste;
		}
	}
	
}



