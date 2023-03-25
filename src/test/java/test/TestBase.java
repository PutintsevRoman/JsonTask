package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import jsonParser.Detective;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

public class TestBase {
    static Detective detective;

    @BeforeAll
    static void beforeAll() throws IOException {
        File file = new File("src/test/resources/json/detectives.json");
        ObjectMapper objectMapper = new ObjectMapper();
        detective = objectMapper.readValue(file, Detective.class);
    }

}
