package reservation_tickets.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import reservation_tickets.controller.HoraireController;
import reservation_tickets.controller.TripController;
import reservation_tickets.controller.VilleController;
import reservation_tickets.controller.reservationController;
import reservation_tickets.model.Horaire;
import reservation_tickets.model.Reservation;
import reservation_tickets.model.Trip;
import reservation_tickets.model.Ville;

public class tripsclass {
	Trip t;
	public tripsclass(Trip t) {
		this.t=t;
	}
	public void show() {
		JFrame frame=new JFrame("Reservation Tickets");
		frame.setBounds(0, 0, 300, 200);
		JLabel label=new JLabel("Trip's choice");
		frame.add(label,BorderLayout.NORTH);
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Trip"));
		VilleController vc=new VilleController();
		JLabel label_allee=new JLabel(vc.getVille(t.getAllee()).getNom());
		panel.add(label_allee);
		JLabel label_arrive=new JLabel(vc.getVille(t.getArrivee()).getNom());
		panel.add(label_arrive);
		JComboBox<Horaire> liste_deroulante_horaire=new JComboBox<Horaire>();
		HoraireController horairecontroller=new HoraireController();
		List<Horaire>horaire=horairecontroller.getTimes(t);
		for(int i=0;i<horaire.size();i++) {
			liste_deroulante_horaire.addItem(horaire.get(i));
		}
		panel.add(liste_deroulante_horaire);
		frame.add(panel,BorderLayout.CENTER);
		JPanel panel_utilisateur=new JPanel();
		panel_utilisateur.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE),"Prix & Confirmation"));
		JLabel label_prix=new JLabel("prix= ");
		panel_utilisateur.add(label_prix,BorderLayout.EAST);
		JButton calculer=new JButton();
		calculer.setText("Calculer");
		calculer.addActionListener(action->{
			TripController tc=new TripController();
			int calcul=tc.calculerprix(t.getArrivee());
			label_prix.setText(label_prix.getText()+String.valueOf(calcul));
			});
		panel_utilisateur.add(calculer);
		JButton confirmer=new JButton();
		confirmer.setText("Confirmer reservation");
		confirmer.addActionListener(action->{reservationController reservationcontroller=new reservationController();
			Reservation r=new Reservation();
			r.setTemps(((Horaire)liste_deroulante_horaire.getSelectedItem()).getId());
			r.setTrip(t.getId());
			boolean confirm=reservationcontroller.insert(r);
			if(confirm) {
				JOptionPane.showMessageDialog(null, "Reservation confirmée");
			}
			else {
				JOptionPane.showMessageDialog(null, "Réservation rejetée");
			}
		});
		panel_utilisateur.add(confirmer);
		frame.add(panel_utilisateur,BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}
