package com.matchslide.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matchslide.R;
import com.matchslide.adapter.MatchListAdapter;
import com.matchslide.model.Match;

import java.util.ArrayList;

public class MatchListFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchListAdapter matchListAdapter;
    private ArrayList<Match> matches;

    public MatchListFragment() {

        matches = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            matches.add(new Match("Tijuana aaaaaaaa", "Atlante", "6:30", "ESPN"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_match_list, container, false);

        matchListAdapter = new MatchListAdapter(getContext(), matches);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_match_list_recyclerview_matches);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(matchListAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        Log.d("size", "" + matches.size());

//        TextView textView = (TextView) rootView.findViewById(R.id.text);
//        textView.setText(getArguments().getString("date") + "");

        return rootView;
    }
}