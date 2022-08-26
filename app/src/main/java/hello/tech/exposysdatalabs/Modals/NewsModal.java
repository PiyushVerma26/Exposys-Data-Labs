package hello.tech.exposysdatalabs.Modals;

import java.util.ArrayList;

public class NewsModal {
    String status;
    String totalResults;
    ArrayList<ArticlesModal> articles;

    public NewsModal(String status, String totalResults, ArrayList<ArticlesModal> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public ArrayList<ArticlesModal> getArticles() {
        return articles;
    }
}
