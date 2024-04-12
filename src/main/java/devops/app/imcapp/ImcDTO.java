package devops.app.imcapp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImcDTO {
	
	private double taille;
	private double poids;
	
	public double getTaille() {
		return this.taille;
	}
	
	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPoids() {
		return this.poids;
	}
	
	public void setPoids(double poids) {
		this.poids = poids;
	}
}
