package com.example.android.retrofittutorial.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.retrofittutorial.R;
import com.example.android.retrofittutorial.Standings.StandingDatum;

import java.util.List;

public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.ViewHolder> {

    private List<StandingDatum> standings;

    public StandingsAdapter(List<StandingDatum> standings) {
        this.standings = standings;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_standings, parent, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView position;
        TextView name;
        TextView matchesPlayed;
        TextView goalsFor;
        TextView goalsAgainst;
        TextView points;
        ViewHolder(View view) {
            super(view);
            position = view.findViewById(R.id.position);
            name = view.findViewById(R.id.name);
            matchesPlayed = view.findViewById(R.id.matches_played);
            goalsFor = view.findViewById(R.id.goals_for);
            goalsAgainst = view.findViewById(R.id.goals_against);
            points = view.findViewById(R.id.points);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StandingDatum standingsDatum = standings.get(position);
        holder.position.setText(String.valueOf(standingsDatum.getPosition()));
        holder.name.setText(standingsDatum.getTeamName());
        holder.matchesPlayed.setText(String.valueOf(standingsDatum.getOverall().getGamesPlayed()));
        holder.goalsFor.setText(String.valueOf(standingsDatum.getOverall().getGoalsScored()));
        holder.goalsAgainst.setText(String.valueOf(standingsDatum.getOverall().getGoalsAgainst()));
        holder.points.setText(String.valueOf(standingsDatum.getPoints()));
    }

    @Override
    public int getItemCount() {
        return standings.size();
    }
}
