package services;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class PhotoService {
    private String path;

    public PhotoService(String path) {
        this.path = path;
    }

    public Optional<String> savePhoto(Part part,String directory){
        if (part.getSize() != 0){
            String resultFileAddress = path + directory;
            File file = new File(resultFileAddress);
            if (!file.exists()) {
                file.mkdir();
            }
            String[] splittedFileName = part.getSubmittedFileName().split("\\.");
            String fileName = Math.random() + "." + splittedFileName[splittedFileName.length - 1];
            String fullFileName = resultFileAddress + File.separator + fileName;
            try {
                part.write(fullFileName);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
            return Optional.of(File.separator + directory + File.separator + fileName);
        }
        return Optional.empty();
    }
}
