import java.io.*;
import java.net.URL;
import java.util.List;

public class ImageStorage {
    private static String SEPARATOR = File.separator;
    private List<String> imgUrls;

    public ImageStorage(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public void download(String ImageFolder) throws IOException {
        this.imgUrls.forEach(imgURL -> {
            String imgName = imgURL.substring(imgURL.lastIndexOf("/") + 1);
            System.out.println("Save image\nURL: " + imgURL + "\nImage name: " + imgName);
            try {
                URL urlImg = new URL(imgURL);
                InputStream in = urlImg.openStream();
                byte[] buffer = new byte[5000];
                int n = -1;
                OutputStream out = new FileOutputStream(ImageFolder + SEPARATOR + imgName);
                while ((n = in.read(buffer)) != -1) {
                    out.write(buffer, 0, n);
                }
                out.close();
                System.out.println("IMAGE SAVED");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void writeImageUrl() {
        this.imgUrls.forEach(System.out::println);
    }
}
