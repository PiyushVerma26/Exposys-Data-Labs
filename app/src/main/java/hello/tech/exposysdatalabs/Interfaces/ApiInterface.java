package hello.tech.exposysdatalabs.Interfaces;

import hello.tech.exposysdatalabs.Modals.NewsModal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {
    @GET
    Call<NewsModal> getNews(@Url String uri);
}
