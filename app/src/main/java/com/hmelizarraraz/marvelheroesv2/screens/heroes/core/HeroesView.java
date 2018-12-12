package com.hmelizarraraz.marvelheroesv2.screens.heroes.core;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.hmelizarraraz.marvelheroesv2.R;
import com.hmelizarraraz.marvelheroesv2.models.Hero;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.HeroesListActivity;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.list.HeroesAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;

public class HeroesView {

    @BindView(R.id.activity_heroes_list_recycleview)
    RecyclerView list;

    View view;

    HeroesAdapter adapter;

    public HeroesView(HeroesListActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_heroes_list, parent, true);
        ButterKnife.bind(this, view);

        adapter = new HeroesAdapter();

        list.setAdapter(adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        list.setLayoutManager(layoutManager);
    }

    public Observable<Integer> itemClicks() {
        return adapter.observeClicks();
    }

    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<Hero> heroes) {
        adapter.swapAdapter(heroes);
    }
}
