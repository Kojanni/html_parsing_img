import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {
    private static String SITE_URL = "http://lenta.ru/";
    private static String SEPARATOR = File.separator;
    private static String IMAGE_FOLDER = "C:" + SEPARATOR + "Users" + SEPARATOR + "ASUS" + SEPARATOR + "Pictures";


    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect(SITE_URL).get();

        Elements element = doc.select("img");
        for (Element e : element) {
            String imgURL = e.attr("abs:src");
            downloadImg(imgURL);
        }
    }

    private static void downloadImg(String imgURL) throws IOException {
        String imgName = imgURL.substring(imgURL.lastIndexOf("/") + 1);
        if ((imgName.contains(".jpg")) || (imgName.contains(".bmp")) || (imgName.contains(".tif"))
                || (imgName.contains(".png")) || (imgName.contains(".jpeg")) || (imgName.contains(".gif")) || (imgName.contains(".tiff"))) {
            System.out.println("Save image\nURL: " + imgURL + "\nImage name: " + imgName);
            try {
                URL urlImg = new URL(imgURL);
                InputStream in = urlImg.openStream();
                byte[] buffer = new byte[5000];
                int n = -1;
                OutputStream out = new FileOutputStream(IMAGE_FOLDER + SEPARATOR + imgName);
                while ((n = in.read(buffer)) != -1) {
                    out.write(buffer, 0, n);
                }
                out.close();
                System.out.println("IMAGE SAVED");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
