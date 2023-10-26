import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Data implements Serializable {
    public Data() {
    }

    private String slug;
    @JsonProperty("company_name")
    private String companyName;
    private String title;
    private String description;
    private boolean remote;
    private String url;
    private String[] tags;
    @JsonProperty("job_types")
    private String[] jobTypes;
    private String location;
    @JsonProperty("created_at")
    private String createdAt;

    public Data(String slug, String companyName, String title, String description, boolean remote, String url, String[] tags, String[] jobTypes, String location, String createdAt) {
        this.slug = slug;
        this.companyName = companyName;
        this.title = title;
        this.description = description;
        this.remote = remote;
        this.url = url;
        this.tags = tags;
        this.jobTypes = jobTypes;
        this.location = location;
        this.createdAt = createdAt;
    }

    public static List<Data> createDataList(JsonNode data) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(data.toString(), new TypeReference<>() {
        });
    }
    public void filtra(String palabra){
        if (this.title.contains(palabra) || this.createdAt.contains(palabra) || this.slug.contains(palabra)){
            System.out.println(this);
        }
    }

    @Override
    public String toString() {
        return "Data{" +
                "slug='" + slug + '\'' +
                ", companyName='" + companyName + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", remote=" + remote +
                ", url='" + url + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", jobTypes=" + Arrays.toString(jobTypes) +
                ", location='" + location + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
