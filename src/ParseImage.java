import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseImage {

    public List<String> parse(String siteUrl) throws IOException {
        List<String> imageUrls = new ArrayList<>();
        Document doc = Jsoup.connect(siteUrl).get();
        Elements element = doc.select("img");
        for (Element e : element) {
            String imgURL = e.attr("abs:src");
            String imgName = imgName(imgURL);
            if ((imgName.contains(".jpg")) || (imgName.contains(".bmp")) || (imgName.contains(".tif"))
                    || (imgName.contains(".png")) || (imgName.contains(".jpeg")) || (imgName.contains(".gif")) || (imgName.contains(".tiff"))) {
                imageUrls.add(imgURL);
            }
        }
        return imageUrls;
    }

    private static String imgName(String imgUrl) {
        return imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
    }

}
