package hello.tech.exposysdatalabs.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

import hello.tech.exposysdatalabs.Modals.UserDetail;
import hello.tech.exposysdatalabs.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    FirebaseAuth mAuth;
    DatabaseReference reference;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pd = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();

        pd.setTitle("Creating Your Account");
        pd.setMessage("Loading Please Wait......");
//        Already A Member
        binding.signLogin.setOnClickListener(v -> {
            startActivity(new Intent(SignUp.this, Login.class));
            finish();
        });

//     SignUp

        binding.btnRegister.setOnClickListener(v -> {
            String email = binding.signEmail.getText().toString().trim();
            String password = binding.signPassword.getText().toString().trim();
            String RePassword = binding.signRePassword.getText().toString().trim();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(RePassword)) {
                Toast.makeText(SignUp.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                Toast.makeText(SignUp.this, "Password Must Be OF 6 Characters", Toast.LENGTH_SHORT).show();
            } else {
                SignupUser(email, password);
            }
        });


    }


    //    Function For Sign UP
    public void SignupUser(String email, String password) {
        pd.show();
        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
            String id = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
            UserDetail user = new UserDetail(email, password, id);
            reference.child("Users").child(id).setValue(user).addOnCompleteListener(task -> {
                pd.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUp.this, Login.class));
                    finish();
                }
            });

        }).addOnFailureListener(e -> {
            pd.dismiss();
            Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }
}