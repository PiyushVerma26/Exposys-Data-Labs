package hello.tech.exposysdatalabs.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import hello.tech.exposysdatalabs.Modals.FormModal;
import hello.tech.exposysdatalabs.databinding.FragmentApplicationBinding;

public class ApplicationFragment extends Fragment {
    FragmentApplicationBinding binding;
    ProgressDialog pd;
    FirebaseAuth mAuth;
    DatabaseReference reference;

    public ApplicationFragment() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//adding instances
        binding = FragmentApplicationBinding.inflate(getLayoutInflater());
        pd = new ProgressDialog(getContext());
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
//        Form Submission Button
        binding.btnSubmit.setOnClickListener(v -> {
            pd.setMessage("Loading Please Wait.....");
            String streamCourse = binding.streams.getText().toString().trim();
            String duration = binding.months.getText().toString().trim();
            String name = binding.name.getText().toString().trim();
            String email = binding.Email.getText().toString().trim();
            String phone = binding.phone.getText().toString().trim();
            String ten = binding.ten.getText().toString().trim();
            String twelve = binding.twelve.getText().toString().trim();
            String college = binding.college.getText().toString().trim();
            binding.streams.setText("");
            binding.months.setText("");
            binding.Email.setText("");
            binding.phone.setText("");
            binding.ten.setText("");
            binding.twelve.setText("");
            binding.name.setText("");
            binding.college.setText("");


            if (TextUtils.isEmpty(streamCourse) || TextUtils.isEmpty(duration) || TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(phone) ||
                    TextUtils.isEmpty(ten) || TextUtils.isEmpty(twelve) || TextUtils.isEmpty(college)) {
                Toast.makeText(getContext(), "Fields Are Empty", Toast.LENGTH_SHORT).show();
            } else {
                pd.show();
                StoringApplicationDetail(streamCourse, duration, name, email, phone, ten, twelve, college);
            }

        });


        return binding.getRoot();
    }

    private void StoringApplicationDetail(String streamCourse, String duration, String name, String email, String phone, String ten, String twelve, String college) {
        String id = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        FormModal form = new FormModal(streamCourse, duration, name, email, phone, ten, twelve, college,id);

        reference.child("Application Form").child(id).setValue(form).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                pd.dismiss();
                Toast.makeText(getContext(), "Application Form IS Submitted ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}