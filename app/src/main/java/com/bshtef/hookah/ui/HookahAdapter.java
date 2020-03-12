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

        private ImageView imageView;
        private TextView title;
        private TextView description;

        HookahViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hookah_picture);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.hookah_description);
        }

        void bind(final Hookah hookah, final ClickListener listener){
            title.setText(hookah.getName());
            description.setText(hookah.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.click(hookah);
                }
            });
        }
    }
}
