package reservation_tickets.model;

public class Trip {
	private int id;
	private int allee;
	private int arrivee;
	private String classe;
	private String temps;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAllee() {
		return allee;
	}
	public void setAllee(int allee) {
		this.allee = allee;
	}
	public int getArrivee() {
		return arrivee;
	}
	public void setArrivee(int arrivee) {
		this.arrivee = arrivee;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getTemps() {
		return temps;
	}
	public void setTemps(String temps) {
		this.temps = temps;
	}
	
}
