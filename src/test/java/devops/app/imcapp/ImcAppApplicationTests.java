import org.junit.Test;
import static org.junit.Assert.assertEquals;
import devops.app.imcapp.ImcDTO;
import devops.app.imcapp.ImcService;

public class ImcAppApplicationTests {

    @Test
    public void calculateImc() {
        double height = 1.75;
        double weight = 70;
        double expectedImc = 22.86; // Valeur attendue avec deux chiffres après la virgule
        double delta = 0.01; // Tolérance de 0.01 pour la comparaison des valeurs décimales

        ImcDTO data = new ImcDTO();
        data.setTaille(height);
        data.setPoids(weight);

        ImcService imcService = new ImcService();
        double actualImc = Double.parseDouble(imcService.calculate(data).get("imc"));

        assertEquals(expectedImc, actualImc, delta);
    }
}
