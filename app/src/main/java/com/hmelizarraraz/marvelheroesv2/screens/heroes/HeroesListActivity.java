package com.hmelizarraraz.marvelheroesv2.screens.heroes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hmelizarraraz.marvelheroesv2.application.AppController;
import com.hmelizarraraz.marvelheroesv2.models.Hero;
import com.hmelizarraraz.marvelheroesv2.screens.details.HeroDetailsActivity;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.core.HeroesPresenter;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.core.HeroesView;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.dagger.DaggerHeroesComponent;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.dagger.HeroesModule;

import java.io.Serializable;

import javax.inject.Inject;

public class HeroesListActivity extends AppCompatActivity {

    @Inject
    HeroesView view;
    @Inject
    HeroesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerHeroesComponent.builder()
                .appComponent(AppController.getNetComponent())
                .heroesModule(new HeroesModule(this))
                .build()
                .inject(this);

        setContentView(view.view());
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void goToHeroDetailsActivity(Hero hero) {
        Intent in = new Intent(this, HeroDetailsActivity.class);
        in.putExtra("hero", (Serializable) hero);
        startActivity(in);
    }
}
