package com.example.fastjoke.screens.showjokes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fastjoke.R;
import com.example.fastjoke.model.Joke;
import com.example.fastjoke.repository.FastJokeDao;

import java.util.List;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    private final LayoutInflater inflater;
    private final List<Joke> jokes;
    private final FastJokeDao dao;

    JokeAdapter(Context context, List<Joke> jokes, FastJokeDao dao) {
        this.inflater = LayoutInflater.from(context);
        this.jokes = jokes;
        this.dao = dao;
    }

    @NonNull
    @Override
    public JokeAdapter.JokeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.jokelist_item, parent, false);
        return new JokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JokeAdapter.JokeViewHolder holder, int position) {

        Joke joke = jokes.get(position);
        holder.contextView.setText(joke.context);
        holder.authorView.setText(joke.username);
        holder.dateView.setText(joke.date);
        holder.deleteButton.setOnClickListener(l -> {
            dao.deleteJoke(joke);

            jokes.remove(joke);

            this.notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return jokes.size();
    }

    public static class JokeViewHolder extends RecyclerView.ViewHolder {
        final TextView contextView, authorView, dateView;
        final Button deleteButton;

        JokeViewHolder(View view) {
            super(view);
            contextView = view.findViewById(R.id.tvContext);
            authorView = view.findViewById(R.id.tvAuthor);
            dateView = view.findViewById(R.id.tvDate);
            deleteButton = view.findViewById(R.id.btnDelete);

        }
    }

}
