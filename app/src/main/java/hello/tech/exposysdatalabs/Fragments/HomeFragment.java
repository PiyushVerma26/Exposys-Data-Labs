package hello.tech.exposysdatalabs.Fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

import hello.tech.exposysdatalabs.Adapters.ArticlesAdapter;
import hello.tech.exposysdatalabs.Interfaces.ApiInterface;
import hello.tech.exposysdatalabs.Modals.ArticlesModal;
import hello.tech.exposysdatalabs.Modals.NewsModal;
import hello.tech.exposysdatalabs.databinding.FragmentHomeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    FragmentHomeBinding binding;
    ArrayList<ArticlesModal> list;
    ArticlesAdapter adapter;
    ProgressDialog pd;
     String BASE_URL="https://newsapi.org/";
     String Url="https://newsapi.org/v2/everything?q=apple&from=2022-08-25&to=2022-08-25&sortBy=popularity&apiKey=8ea6e34badc54e7490609e62032cb235";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        list=new ArrayList<>();
        adapter=new ArticlesAdapter(list,getContext());
        pd=new ProgressDialog(getContext());
        binding.recycleHome.setLayoutManager(new LinearLayoutManager(this.getContext()));
        binding.recycleHome.setAdapter(adapter);
        binding.recycleHome.setHasFixedSize(true);
        pd.setTitle("Fetching Data");
        pd.setMessage("Loading Please Wait.....");
        pd.show();

        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiInterface =retrofit.create(ApiInterface.class);
        Call<NewsModal> call;
        call=apiInterface.getNews(Url);
        call.enqueue(new Callback<NewsModal>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<NewsModal> call, @NonNull Response<NewsModal> response) {
                pd.dismiss();

                NewsModal newsModal=response.body();
                assert newsModal != null;
                if(newsModal.getArticles() != null)
                {
                    ArrayList<ArticlesModal> articles = newsModal.getArticles();
                    for (int i = 0; i < articles.size(); i++) {
                        list.add(new ArticlesModal(articles.get(i).getTitle(), articles.get(i).getContent(), articles.get(i).getUrlToImage()));
                    }
                }
                else
                {
                    Toast.makeText(getContext(),"Api Problem",Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(@NonNull Call<NewsModal> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Failed To Get News", Toast.LENGTH_SHORT).show();
            }
        });


        return binding.getRoot();
    }
}
