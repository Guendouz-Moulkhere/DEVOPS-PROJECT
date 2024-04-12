package devops.app.imcapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ImcAppApplicationTests {

    @Mock
    private ImcService imcService;

    @Autowired
    private ImcController imcController;

    @Test
    void calculateImc() {
        ImcDTO imcDTO = new ImcDTO();
        imcDTO.setPoids(70.0);
        imcDTO.setTaille(1.75);

        // Mocking the service response
        when(imcService.calculate(imcDTO))
                .thenReturn(Map.of("imc", "22.86", "avis", "Normale"));

        // Invoking the controller method
        Map<String, String> result = imcController.calcule(imcDTO);

        // Checking the response
        assertEquals("22.86", result.get("imc")); // Expected value rounded to 2 decimal places
        assertEquals("Normale", result.get("avis"));
    }
}
