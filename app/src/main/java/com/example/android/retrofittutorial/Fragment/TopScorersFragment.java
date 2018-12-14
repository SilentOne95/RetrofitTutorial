package com.example.android.retrofittutorial.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.retrofittutorial.Adapter.TopScorersAdapter;
import com.example.android.retrofittutorial.App.Api;
import com.example.android.retrofittutorial.App.App;
import com.example.android.retrofittutorial.R;
import com.example.android.retrofittutorial.TopScorers.GoalscorerDatum;
import com.example.android.retrofittutorial.TopScorers.TopscorersResult;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopScorersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopScorersFragment extends Fragment {

    final int SEASON_ID = 7953;
    final String INCLUDE = "goalscorers.player";

    Api api;
    RecyclerView recycler;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public TopScorersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopscorersFragment.
     */
    public static TopScorersFragment newInstance(String param1, String param2) {
        TopScorersFragment fragment = new TopScorersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_scorers, container, false);

        recycler = view.findViewById(R.id.recycler);
        api = App.getApi();

        getTopScorers();

        return view;
    }

    private void getTopScorers() {

        api.getTopScorers(SEASON_ID, INCLUDE).enqueue(new Callback<TopscorersResult>() {
            @Override
            public void onResponse(@NonNull Call<TopscorersResult> call, @NonNull Response<TopscorersResult> response) {
                TopscorersResult topscorersResult = response.body();
                List<GoalscorerDatum> goalscorers = topscorersResult.getData().getGoalscorers().getData();
                Collections.sort(goalscorers, new Comparator<GoalscorerDatum>() {
                    @Override
                    public int compare(GoalscorerDatum g1, GoalscorerDatum g2) {
                        return g1.getPosition() - g2.getPosition();
                    }
                });
                showTopScorers(goalscorers);
            }

            @Override
            public void onFailure(@NonNull Call<TopscorersResult> call, @NonNull Throwable t) {

            }
        });
    }

    private void showTopScorers(List<GoalscorerDatum> goalscorers) {

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(new TopScorersAdapter(goalscorers));

    }
}