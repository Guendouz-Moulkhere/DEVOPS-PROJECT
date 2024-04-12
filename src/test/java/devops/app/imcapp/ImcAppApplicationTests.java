import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ImcAppApplicationTests {

    @Test
    public void calculateImc() {
        double height = 1.75;
        double weight = 70;
        double expectedImc = 22.86; // Valeur attendue avec deux chiffres après la virgule
        double delta = 0.01; // Tolérance de 0.01 pour la comparaison des valeurs décimales

        ImcCalculator calculator = new ImcCalculator();
        double actualImc = calculator.calculateImc(weight, height);

        assertEquals(expectedImc, actualImc, delta);
    }
}
