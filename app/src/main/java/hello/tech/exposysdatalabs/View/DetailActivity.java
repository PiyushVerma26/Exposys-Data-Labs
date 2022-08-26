package hello.tech.exposysdatalabs.View;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hello.tech.exposysdatalabs.Adapters.DetailAdapter;
import hello.tech.exposysdatalabs.Modals.FormModal;
import hello.tech.exposysdatalabs.databinding.ActivityDetailActivtyBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailActivtyBinding binding;
  DatabaseReference reference;
    FirebaseAuth mAuth;
    ArrayList<FormModal> list;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailActivtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference("Application Form");
        list=new ArrayList<>();
        pd=new ProgressDialog(this);
        DetailAdapter adapter=new DetailAdapter(list,this);

        binding.recycleDetail.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleDetail.setHasFixedSize(true);
        binding.recycleDetail.setAdapter(adapter);
        pd.setTitle("Fetching data");
        pd.setMessage("Loading Please Wait");
        pd.show();


        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();
                pd.dismiss();
                for (DataSnapshot dataSnapShot : snapshot.getChildren()) {
                    FormModal modal = dataSnapShot.getValue(FormModal.class);
                    assert modal != null;
                    modal.setUserId(dataSnapShot.getKey());
                    list.add(modal);
                }
                adapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                pd.dismiss();
                Toast.makeText(DetailActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}