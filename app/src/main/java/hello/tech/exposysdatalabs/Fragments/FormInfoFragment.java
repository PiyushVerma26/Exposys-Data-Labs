package hello.tech.exposysdatalabs.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import hello.tech.exposysdatalabs.View.DetailActivity;
import hello.tech.exposysdatalabs.databinding.FragmentFormInfoBinding;

public class FormInfoFragment extends Fragment {
    FragmentFormInfoBinding binding;
    ProgressDialog pd;
    public FormInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentFormInfoBinding.inflate(getLayoutInflater());
        String passCode ="Exposys";
        pd =new ProgressDialog(getContext());
        pd.setMessage("Loading PLease Wait...");


        binding.btnCheck.setOnClickListener(v -> {
            pd.show();
            String entryCode=binding.passcode.getText().toString().trim();
            if (TextUtils.isEmpty(entryCode))
            {
                pd.dismiss();
                Toast.makeText(getContext(),"Please Enter PassCode",Toast.LENGTH_SHORT).show();
            }
            else if (passCode.equals(entryCode))
            {
                pd.dismiss();
                Toast.makeText(getContext(),"Code Matched",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getContext(), DetailActivity.class));
            }
            else
            {
                pd.dismiss();
                binding.passcode.setText("");
                Toast.makeText(getContext(),"Please Enter Valid PassCode",Toast.LENGTH_SHORT).show();
            }

        });
        return binding.getRoot();
    }
}