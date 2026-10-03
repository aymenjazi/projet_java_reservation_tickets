package reservation_tickets.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import reservation_tickets.controller.ClassController;
import reservation_tickets.controller.HoraireController;
import reservation_tickets.controller.TripController;
import reservation_tickets.controller.VilleController;
import reservation_tickets.model.Classe;
import reservation_tickets.model.Horaire;
import reservation_tickets.model.Trip;
import reservation_tickets.model.Ville;

import javax.swing.JOptionPane;


public class reservation {
	public static void main(String[] args) {
		JFrame frame=new JFrame("Reservation tickets");
		frame.setBounds(0,0 ,300 ,200);
		JLabel titre=new JLabel("Reservation tickets");
		titre.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		frame.add(titre,BorderLayout.NORTH);
		JPanel panel_trajet=new JPanel();
		panel_trajet.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Traget"));
		JLabel label_aller=new JLabel("Aller");
		panel_trajet.add(label_aller);
		JComboBox<Ville> liste_deroulante_aller=new JComboBox<Ville>();
		VilleController villecontroller=new VilleController();
		List<Ville>villes_aller=villecontroller.getVilles();
		for(int i=0;i<villes_aller.size();i++) {
			liste_deroulante_aller.addItem(villes_aller.get(i));
		}
		panel_trajet.add(liste_deroulante_aller);
		JLabel label_retour=new JLabel("Retour");
		panel_trajet.add(label_retour);
		JComboBox<Ville> liste_deroulante_retour=new JComboBox<Ville>();
		List<Ville>villes_retour=villecontroller.getVilles();
		for(int i=0;i<villes_retour.size();i++) {
			liste_deroulante_retour.addItem(villes_retour.get(i));
		}
		panel_trajet.add(liste_deroulante_retour);
		frame.add(panel_trajet,BorderLayout.EAST);
		JPanel panel_classe=new JPanel();
		panel_classe.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Classe"));
		JComboBox<Classe> liste_deroulante_classe=new JComboBox<Classe>();
		ClassController classecontroller=new ClassController();
		List<Classe>classes=classecontroller.getClasses();
		for(int i=0;i<classes.size();i++) {
			liste_deroulante_classe.addItem(classes.get(i));
		}
		panel_classe.add(liste_deroulante_classe);
		frame.add(panel_classe,BorderLayout.WEST);
		JButton bouton=new JButton();
		bouton.setText("Continuer");
		bouton.addActionListener(action->{
			TripController tripcontroller=new TripController();
			Trip t=tripcontroller.getTrip(((Ville)liste_deroulante_aller.getSelectedItem()).getId(),((Ville)liste_deroulante_retour.getSelectedItem()).getId());
			tripsclass tc=new tripsclass(t);
			tc.show();
		});
		frame.add(bouton,BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
