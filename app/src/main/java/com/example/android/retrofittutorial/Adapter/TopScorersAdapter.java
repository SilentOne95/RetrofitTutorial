package com.example.android.retrofittutorial.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.retrofittutorial.R;
import com.example.android.retrofittutorial.TopScorers.GoalscorerDatum;

import java.util.List;

public class TopScorersAdapter extends RecyclerView.Adapter<TopScorersAdapter.ViewHolder> {

    private List<GoalscorerDatum> goalscorers;

    public TopScorersAdapter(List<GoalscorerDatum> goalscorers) {
        this.goalscorers = goalscorers;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView position;
        TextView name;
        TextView goals;
        ViewHolder(View view) {
            super(view);
            position = view.findViewById(R.id.position);
            name = view.findViewById(R.id.name);
            goals = view.findViewById(R.id.goals);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_top_scorers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GoalscorerDatum goalscorerDatum = goalscorers.get(position);
        holder.position.setText(String.valueOf(goalscorerDatum.getPosition()));
        holder.name.setText(goalscorerDatum.getPlayer().getData().getCommonName());
        holder.goals.setText(String.valueOf(goalscorerDatum.getGoals()));
    }

    @Override
    public int getItemCount() {
        return goalscorers.size();
    }
}