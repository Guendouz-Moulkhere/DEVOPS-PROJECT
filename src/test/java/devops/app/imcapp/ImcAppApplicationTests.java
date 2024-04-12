package devops.app.imcapp;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ImcAppApplicationTests {

	@Test
	void shouldBeEqualToDenutrie() {
		ImcService imcService = new ImcService();
		Map<String, String> map = imcService.calculate(new ImcDTO(1.75, 50));
		assertEquals("Dénutrie", map.get("avis"));
		assertEquals("16.0", map.get("imc"));
	}
	
	@Test
	void shouldBeEqualToAccru() {
		ImcService imcService = new ImcService();
		Map<String, String> map = imcService.calculate(new ImcDTO(1.75, 55));
		assertEquals("Accru", map.get("avis"));
		assertEquals("17.0", map.get("imc"));
	}
	
	@Test
	void shouldBeEqualToNormale() {
		ImcService imcService = new ImcService();
		Map<String, String> map = imcService.calculate(new ImcDTO(1.75, 60));
		assertEquals("Normale", map.get("avis"));
		assertEquals("19.0", map.get("imc"));
	}
	
	@Test
	void shouldBeEqualToSurpoids() {
		ImcService imcService = new ImcService();
		Map<String, String> map = imcService.calculate(new ImcDTO(1.75, 78));
		assertEquals("Surpoids", map.get("avis"));
		assertEquals("25.0", map.get("imc"));
	}
	
	@Test
	void shouldBeEqualToEleve() {
		ImcService imcService = new ImcService();
		Map<String, String> map = imcService.calculate(new ImcDTO(1.75, 92));
		assertEquals("Elevé", map.get("avis"));
		assertEquals("30.0", map.get("imc"));
	}
	
	@Test
	void shouldBeEqualToTresEleve() {
		ImcService imcService = new ImcService();
		Map<String, String> map = imcService.calculate(new ImcDTO(1.75, 108));
		assertEquals("Très elevé", map.get("avis"));
		assertEquals("35.0", map.get("imc"));
	}
	
	@Test
	void shouldBeEqualToObese() {
		ImcService imcService = new ImcService();
		Map<String, String> map = imcService.calculate(new ImcDTO(1.75, 123));
		assertEquals("Obèse", map.get("avis"));
		assertEquals("40.0", map.get("imc"));
	}

}
