package devops.app.imcapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ImcServiceTest {

    @Autowired
    private ImcService imcService;

    @Test
    public void testCalculateImc() {
        ImcDTO imcDTO = new ImcDTO();
        imcDTO.setTaille(1.75); 
        imcDTO.setPoids(70); 

       
        Map<String, String> result = imcService.calculate(imcDTO);

       
        assertEquals("24.49", result.get("imc")); 
        assertEquals("Normale", result.get("avis")); 
    }
}

