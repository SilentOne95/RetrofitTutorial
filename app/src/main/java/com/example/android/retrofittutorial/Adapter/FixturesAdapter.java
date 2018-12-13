package com.example.android.retrofittutorial.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.retrofittutorial.Fixtures.FixtureDatum;
import com.example.android.retrofittutorial.R;

import java.util.List;

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.ViewHolder>{

    private List<FixtureDatum> fixtures;

    public FixturesAdapter(List<FixtureDatum> fixtures) {
        this.fixtures = fixtures;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_fixtures, parent, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView localTeam;
        TextView localTeamScore;
        TextView visitorTeam;
        TextView visitorTeamScore;
        ViewHolder(View view) {
            super(view);
            localTeam = view.findViewById(R.id.local_team);
            localTeamScore = view.findViewById(R.id.local_team_score);
            visitorTeam = view.findViewById(R.id.visitor_team);
            visitorTeamScore = view.findViewById(R.id.visitor_team_score);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FixtureDatum fixturesDatum = fixtures.get(position);

        holder.localTeam.setText(fixturesDatum.getLocalTeam().getData().getName());
        holder.localTeamScore.setText(String.valueOf(fixturesDatum.getScores().getLocalteamScore()));
        holder.visitorTeam.setText(fixturesDatum.getVisitorTeam().getData().getName());
        holder.visitorTeamScore.setText(String.valueOf(fixturesDatum.getScores().getVisitorteamScore()));

    }

    @Override
    public int getItemCount() {
        return fixtures.size();
    }
}
