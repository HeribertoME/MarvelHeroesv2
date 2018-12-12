package com.hmelizarraraz.marvelheroesv2.screens.heroes.core;

import com.hmelizarraraz.marvelheroesv2.api.HeroApi;
import com.hmelizarraraz.marvelheroesv2.models.Hero;
import com.hmelizarraraz.marvelheroesv2.models.Heroes;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.HeroesListActivity;
import com.hmelizarraraz.marvelheroesv2.utils.NetworkUtils;

import io.reactivex.Observable;

public class HeroesModel {

    HeroesListActivity context;
    HeroApi api;

    public HeroesModel(HeroesListActivity context, HeroApi api) {
        this.api = api;
        this.context = context;
    }

    Observable<Heroes> provideListHeroes() {
        return api.getHeroes();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    public void gotoHeroDetailsActivity(Hero hero) {
        context.goToHeroDetailsActivity(hero);
    }
}
