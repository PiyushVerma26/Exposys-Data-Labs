package hello.tech.exposysdatalabs.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import hello.tech.exposysdatalabs.WebView.WebControl;
import hello.tech.exposysdatalabs.databinding.FragmentWebsiteBinding;

public class PaymentFragment extends Fragment {
    FragmentWebsiteBinding binding;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentWebsiteBinding.inflate(getLayoutInflater());
        binding.web.loadUrl("https://www.instamojo.com/@Exposysdatalabs");
        binding.web.getSettings().setJavaScriptEnabled(true);
        binding.web.setWebViewClient(new WebControl());
        return binding.getRoot();
    }
}