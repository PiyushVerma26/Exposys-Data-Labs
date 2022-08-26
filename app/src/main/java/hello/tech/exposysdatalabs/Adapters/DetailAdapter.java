package hello.tech.exposysdatalabs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hello.tech.exposysdatalabs.Modals.FormModal;
import hello.tech.exposysdatalabs.R;
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.viewHolder> {

    ArrayList<FormModal> list;
    Context context;

    public DetailAdapter(ArrayList<FormModal> list ,Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.formdetailrv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        FormModal models= list.get(position);
        holder.name.setText(models.getName());
        holder.phone.setText(models.getPhone());
        holder.email.setText(models.getEmail());
        holder.college.setText(models.getCollege());
        holder.ten.setText(models.getTen());
        holder.twelve.setText(models.getTwelve());
        holder.stream.setText(models.getStreamCourse());
        holder.duration.setText(models.getDuration());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView name,ten,twelve,college,stream,duration,phone,email;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tvName);
            ten=itemView.findViewById(R.id.tvTen);
            twelve=itemView.findViewById(R.id.twelve);
            college=itemView.findViewById(R.id.tvCollege);
            stream=itemView.findViewById(R.id.streams);
            duration=itemView.findViewById(R.id.tvMonths);
            email=itemView.findViewById(R.id.tvEmail);
            phone=itemView.findViewById(R.id.tvPhone);


        }
    }
}
