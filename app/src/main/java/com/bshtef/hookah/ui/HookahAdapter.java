package com.bshtef.hookah.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bshtef.hookah.R;
import com.bshtef.hookah.data.model.Hookah;
import com.bumptech.glide.Glide;

import java.util.List;

public class HookahAdapter extends RecyclerView.Adapter<HookahAdapter.HookahViewHolder> {

    private List<Hookah> hookahs;
    private ClickListener listener;

    public void setArticles(List<Hookah> hookahs) {
        this.hookahs = hookahs;
        notifyDataSetChanged();
    }

    public HookahAdapter(List<Hookah> hookahs, ClickListener listener) {
        this.hookahs = hookahs;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HookahAdapter.HookahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hookah, parent, false);
        return new HookahViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HookahViewHolder holder, int position) {
        holder.bind(hookahs.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return hookahs.size();
    }

    public interface ClickListener{
        void click(Hookah hookah);
    }

    static class HookahViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;
        private TextView description;
        private TextView price;

        HookahViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.desc);
            price = itemView.findViewById(R.id.price);
        }

        void bind(final Hookah hookah, final ClickListener listener){
            title.setText(hookah.getName());
            description.setText(hookah.getDescription());
            price.setText(itemView.getContext().getString(R.string.price, String.valueOf(hookah.getPrice())));

            Glide.with(itemView).load(hookah.getImageUrl()).into(image);

            itemView.setOnClickListener(v -> listener.click(hookah));
        }
    }
}
