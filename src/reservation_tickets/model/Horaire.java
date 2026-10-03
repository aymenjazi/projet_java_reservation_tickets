package reservation_tickets.model;

public class Horaire {
	private int id;
	private String temps;
	private int trip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTemps() {
		return temps;
	}
	public void setTemps(String temps) {
		this.temps = temps;
	}
	public int getTrip() {
		return trip;
	}
	public void setTrip(int trip) {
		this.trip = trip;
	}
	@Override
	public String toString() {
		return temps;
	}
	
}
