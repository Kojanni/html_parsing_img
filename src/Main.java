import java.io.*;
import java.util.List;

public class Main {
    private static String SITE_URL = "http://lenta.ru/";
    private static String SEPARATOR = File.separator;
    private static String IMAGE_FOLDER = "C:" + SEPARATOR + "Users" + SEPARATOR + "ASUS" + SEPARATOR + "Pictures";

    public static void main(String[] args) throws IOException {
        ParseImage parseImage = new ParseImage();
        List<String> imageUrls = parseImage.parse(SITE_URL);
        ImageStorage imageStorage = new ImageStorage(imageUrls);
        imageStorage.download(IMAGE_FOLDER);
    }
}
