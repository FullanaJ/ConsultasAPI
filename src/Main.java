import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import kong.unirest.Unirest;
public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
           List<Data> data = Data.createDataList(objectMapper.readTree(Unirest.get("https://www.arbeitnow.com/api/job-board-api").asString().getBody()).get("data"));
           data.forEach((d) -> d.filtra("home"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void guardarDatos(String datos) {
        Path path = Path.of("datos.json");
        try {
            Files.writeString(path, datos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
