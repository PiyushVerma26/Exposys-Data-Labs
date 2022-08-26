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

import hello.tech.exposysdatalabs.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
ActivityLoginBinding binding;
FirebaseAuth mAuth;
DatabaseReference reference;
ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();
        pd=new ProgressDialog(this);
        pd.setTitle("Logging You In");
        pd.setMessage("Loading Please Wait.....");

        binding.tvRegister.setOnClickListener(v -> {
            startActivity(new Intent(Login.this,SignUp.class));
            finish();
        });


        binding.btnLog.setOnClickListener(v -> {
            String email=binding.logEmail.getText().toString().trim();
            String password=binding.logPassword.getText().toString().trim();
            if (TextUtils.isEmpty(email)||TextUtils.isEmpty(password))
            {
                Toast.makeText(Login.this, "Fields Are Empty", Toast.LENGTH_SHORT).show();
            }
            else
            {
                LoginUser(email,password);
            }
        });

    }

    public void LoginUser(String email, String password) {
        pd.show();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            pd.dismiss();
            if (task.isSuccessful()) {
                Toast.makeText(Login.this, "Welcome To Let's Chat", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Login.this, MainActivity.class));
                finish();
            }
        }).addOnFailureListener(e -> {
            pd.dismiss();
            Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }
}