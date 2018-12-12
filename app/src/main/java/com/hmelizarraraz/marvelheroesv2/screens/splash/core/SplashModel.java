package com.hmelizarraraz.marvelheroesv2.screens.splash.core;

import com.hmelizarraraz.marvelheroesv2.api.HeroApi;
import com.hmelizarraraz.marvelheroesv2.models.Heroes;
import com.hmelizarraraz.marvelheroesv2.screens.splash.SplashScreenActivity;
import com.hmelizarraraz.marvelheroesv2.utils.NetworkUtils;

import io.reactivex.Observable;

public class SplashModel {

    private HeroApi api;
    private SplashScreenActivity splashContext;

    public SplashModel(HeroApi api, SplashScreenActivity splashContext) {
        this.api = api;
        this.splashContext = splashContext;
    }

    Observable<Heroes> provideListHeroes() {
        return api.getHeroes();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(splashContext);
    }

    public void gotoHeroesListActivity() {
        splashContext.showHeroesListActivity();
    }
}
