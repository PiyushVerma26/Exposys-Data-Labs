package hello.tech.exposysdatalabs.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import hello.tech.exposysdatalabs.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment {
    FragmentAboutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAboutBinding.inflate(getLayoutInflater());

        binding.linkCard.setOnClickListener(v -> {
            String linkLin = "https://www.linkedin.com/in/piyushverma26/";
            String pack = "com.linkedin.android";
            Callopen(linkLin, pack, linkLin);

        });
        binding.gitCard.setOnClickListener(v -> {
            String gitLink = "https://github.com/PiyushVerma26";
            String pack = "com.github.android";
            Callopen(gitLink, pack, gitLink);
        });

        return binding.getRoot();
    }

    private void Callopen(String link, String pack, String web) {

        try {
            Uri uri = Uri.parse(link);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(pack);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException) {
            Uri uri = Uri.parse(web);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(pack);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }
}