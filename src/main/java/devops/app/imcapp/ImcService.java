package devops.app.imcapp;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ImcService {

	public Map<String, String> calculate(ImcDTO data) {
		if(data == null || (data.getPoids() == 0.0 && data.getTaille() == 0.0)) {
			return Map.of("imc", "Empty data",
					"avis", "Empty data");
		}
		double imc = data.getPoids() / Math.pow(data.getTaille(), 2);
		imc = Math.round(imc * 100) / 100;
		String advise = this.analyse(imc);
		return Map.of("imc", String.valueOf(imc),
				"avis", advise);
	}

	private String analyse(double imc) {
		if(imc < 16.5) return "Dénutrie";
		if(imc >= 16.5 && imc < 18.5) return "Accru";
		if(imc >= 18.5 && imc < 25) return "Normale";
		if(imc >= 25 && imc < 30) return "Surpoids";
		if(imc >= 30 && imc < 35) return "Elevé";
		if(imc >= 35 && imc < 40) return "Très elevé";
		if(imc >= 40) return "Obèse";
		return "RAS";
	}
}
