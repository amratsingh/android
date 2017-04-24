package com.matchslide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.matchslide.R;
import com.matchslide.model.Match;

import java.util.ArrayList;

public class MatchListAdapter extends RecyclerView.Adapter<MatchListAdapter.MatchListViewHolder> {

    private Context context;
    private ArrayList<Match> matches;

    public MatchListAdapter(Context context, ArrayList<Match> matches) {
        this.context = context;
        this.matches = matches;
    }

    class MatchListViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTeamOne, tvTeamTwo, tvTime, tvChannel;

        public MatchListViewHolder(View itemView) {
            super(itemView);

            tvTeamOne = (TextView) itemView.findViewById(R.id.row_match_tv_team_one);
            tvTeamTwo = (TextView) itemView.findViewById(R.id.row_match_tv_team_two);

            tvTime = (TextView) itemView.findViewById(R.id.row_match_tv_time);
            tvChannel = (TextView) itemView.findViewById(R.id.row_match_tv_channel);
        }
    }

    @Override
    public MatchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_match, parent, false);

        return new MatchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MatchListViewHolder holder, int position) {

        Match match = matches.get(position);

        holder.tvTeamOne.setText(match.getTeamOne());
        holder.tvTeamTwo.setText(match.getTeamTwo());

        holder.tvTime.setText(match.getTime());
        holder.tvChannel.setText(match.getChannel());
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }
}
