package com.hmelizarraraz.marvelheroesv2.screens.heroes.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hmelizarraraz.marvelheroesv2.R;
import com.hmelizarraraz.marvelheroesv2.models.Hero;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class HeroesAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Hero> listHeroes = new ArrayList<>();

    public void swapAdapter(ArrayList<Hero> heroes) {
        this.listHeroes.clear();
        this.listHeroes.addAll(heroes);
        notifyDataSetChanged();
    }

    public Observable<Integer> observeClicks() {
        return itemClicks;
    }


    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hero, viewGroup, false);
        return new HeroViewHolder(view, itemClicks);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder heroViewHolder, int i) {
        Hero hero = listHeroes.get(i);
        heroViewHolder.bind(hero);
    }

    @Override
    public int getItemCount() {
        if (listHeroes != null && listHeroes.size() > 0) {
            return listHeroes.size();
        } else {
            return 0;
        }
    }
}
