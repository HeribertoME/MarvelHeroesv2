package com.hmelizarraraz.marvelheroesv2.screens.heroes.core;

import android.util.Log;

import com.hmelizarraraz.marvelheroesv2.models.Hero;
import com.hmelizarraraz.marvelheroesv2.utils.UiUtils;
import com.hmelizarraraz.marvelheroesv2.utils.rx.RxSchedulers;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class HeroesPresenter {
    HeroesView view;
    HeroesModel model;
    RxSchedulers rxSchedulers;
    CompositeDisposable subscriptions;
    ArrayList<Hero> heros = new ArrayList<>();

    public HeroesPresenter(
            RxSchedulers rxSchedulers,
            HeroesModel model,
            HeroesView view,
            CompositeDisposable subscriptions) {
        this.rxSchedulers = rxSchedulers;
        this.view = view;
        this.model = model;
        this.subscriptions = subscriptions;
    }

    public void onCreate() {
        Log.d("enter to presenter", "oki");
        subscriptions.add(getHeroesList());
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }

    private Disposable respondToClick() {
        return view
                .itemClicks()
                .subscribe(integer ->
                        model
                                .gotoHeroDetailsActivity(heros.get(integer))
                );
    }

    private Disposable getHeroesList() {
        return model
                .isNetworkAvailable()
                .doOnNext(networkAvailable -> {
                    if (!networkAvailable) {
                        Log.d("no conn", "no connexion");
                    }
                })
                .filter(isNetworkAvailable -> true)
                .flatMap(isAvailable -> model.provideListHeroes())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(heroes -> {
                    Log.d("ok loaded", "cccc");
                    view.swapAdapter((ArrayList<Hero>) heroes.getElements());
                    heros = (ArrayList<Hero>) heroes.getElements();
                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                });
    }
}
