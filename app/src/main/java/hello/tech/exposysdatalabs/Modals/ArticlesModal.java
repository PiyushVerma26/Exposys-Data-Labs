package hello.tech.exposysdatalabs.Modals;

public class ArticlesModal {
    String title;
    String content;
    String urlToImage;

    public ArticlesModal(String title, String content, String urlToImage) {
        this.title = title;
        this.content= content;
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
