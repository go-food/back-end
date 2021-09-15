package gofood.file;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Service
public class FileService {
    private final AmazonS3 amazonS3Client;
    private static final String BUCKET_NAME = "gofoodbucket";

    @Autowired
    public FileService(AmazonS3 amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }

    public String uploadImage(String folder, MultipartFile file) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        String key = generateFileName(file);
        key = folder + key;

        try {
            amazonS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), metadata);
        } catch (IOException e) {
            return null;
        }
        return amazonS3Client.getUrl(BUCKET_NAME, key).toString();

    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + Objects.requireNonNull(multiPart.getOriginalFilename()).replace(" ", "_");
    }
}
