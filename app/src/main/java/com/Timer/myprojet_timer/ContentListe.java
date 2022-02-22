package com.Timer.myprojet_timer;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContentListe extends RecyclerView.Adapter<ContentListe.ViewHolder> {

    private Context context;
    private List<Event> events;
    private Listener listener;

    public ContentListe(Context context, List<Event> events, Listener listener){
        this.context = context;
        this.events = events;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater= LayoutInflater.from(context);
        view = inflater.inflate(R.layout.activity_content_liste, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eventTitle.setText(events.get(position).getTitle());
        holder.eventDescription.setText(events.get(position).getDescription());


                   }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public interface Listener{
        void onClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView eventTitle,eventDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTitle = itemView.findViewById(R.id.eventTitle);
            eventDescription = itemView.findViewById(R.id.eventDescription);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }
}