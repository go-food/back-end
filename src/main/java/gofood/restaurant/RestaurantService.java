package gofood.restaurant;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;

@Service
@Transactional
public class RestaurantService extends BaseService<Restaurant> {
    @Autowired
    protected RestaurantService(RestaurantRepository repo) {
        super(repo);
    }

    @Autowired
    private AmazonS3 amazonS3Client;

    protected String uploadImage(String bucketName, String filename, MultipartFile file) {
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucketName, filename, file.getInputStream(), metadata);
            return "File uploaded";
        } catch (IOException ioe) {
            return "File does not exist";
        }
    }
}
