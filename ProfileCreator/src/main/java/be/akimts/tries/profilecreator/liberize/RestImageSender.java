package be.akimts.tries.profilecreator.liberize;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class RestImageSender {

    private final RestTemplate template;
    private final String IMG_SERVER_URL = "http://localhost:8080"; // TODO to property

    public RestImageSender(RestTemplateBuilder templateBuilder) {
        this.template = templateBuilder.build();
    }

    public ResourceDetails save(MultipartFile file) throws IOException {

        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
        bodyBuilder.part("file", file.getBytes(), MediaType.valueOf(file.getContentType()));

        return template.postForEntity(IMG_SERVER_URL + "/img/save", file, ResourceDetails.class).getBody();
    }



}
