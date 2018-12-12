package com.hmelizarraraz.marvelheroesv2.screens.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hmelizarraraz.marvelheroesv2.models.Hero;
import com.hmelizarraraz.marvelheroesv2.screens.details.core.HeroDetailsView;
import com.hmelizarraraz.marvelheroesv2.screens.details.dagger.DaggerHeroDetailsComponent;
import com.hmelizarraraz.marvelheroesv2.screens.details.dagger.HeroDetailsModule;

import javax.inject.Inject;

public class HeroDetailsActivity extends AppCompatActivity {

    @Inject
    HeroDetailsView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Hero hero = (Hero) getIntent().getExtras().get("hero");

        DaggerHeroDetailsComponent.builder()
                .heroDetailsModule(new HeroDetailsModule(this, hero))
                .build()
                .inject(this);

        setContentView(view.view());
    }
}
