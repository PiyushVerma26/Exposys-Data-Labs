package hello.tech.exposysdatalabs.Fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import hello.tech.exposysdatalabs.WebView.WebControl;
import hello.tech.exposysdatalabs.databinding.FragmentWebsiteBinding;

public class WebsiteFragment extends Fragment {
    FragmentWebsiteBinding binding;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ProgressDialog pd;
        pd=new ProgressDialog(getContext());
        pd.setMessage("Loading Please Wait...");
        pd.show();
        binding= FragmentWebsiteBinding.inflate(getLayoutInflater());
        pd.dismiss();
        binding.web.loadUrl("https://www.youtube.com/results?search_query=exposys+data+labs+internship" );
        binding.web.getSettings().setJavaScriptEnabled(true);
        binding.web.setWebViewClient(new WebControl());
        return binding.getRoot();
    }
}