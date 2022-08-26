package hello.tech.exposysdatalabs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import hello.tech.exposysdatalabs.Modals.ArticlesModal;
import hello.tech.exposysdatalabs.R;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.viewHolder> {
    ArrayList<ArticlesModal> articlesModals;
    Context context;

    public ArticlesAdapter(ArrayList<ArticlesModal> articlesModals, Context context) {
        this.articlesModals = articlesModals;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.vision,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ArticlesModal modal=articlesModals.get(position);
        holder.title.setText(modal.getTitle());
        holder.content.setText(modal.getContent());
        Picasso.get().load(modal.getUrlToImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return articlesModals.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,content;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.logoSkill);
            title=itemView.findViewById(R.id.title);
            content=itemView.findViewById(R.id.content);
        }
    }
}
