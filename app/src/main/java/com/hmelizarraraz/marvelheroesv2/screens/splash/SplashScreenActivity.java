package com.hmelizarraraz.marvelheroesv2.screens.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hmelizarraraz.marvelheroesv2.application.AppController;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.HeroesListActivity;
import com.hmelizarraraz.marvelheroesv2.screens.splash.core.SplashPresenter;
import com.hmelizarraraz.marvelheroesv2.screens.splash.core.SplashView;
import com.hmelizarraraz.marvelheroesv2.screens.splash.dagger.DaggerSplashComponent;
import com.hmelizarraraz.marvelheroesv2.screens.splash.dagger.SplashContextModule;

import javax.inject.Inject;

public class SplashScreenActivity extends AppCompatActivity {

    @Inject
    SplashView view;
    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSplashComponent.builder()
                .appComponent(AppController.getNetComponent())
                .splashContextModule(new SplashContextModule(this))
                .build()
                .inject(this);

        setContentView(view.constructView());
        splashPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }

    public void showHeroesListActivity() {
        Log.d("loaded", "ok showed");
        Intent i = new Intent(this, HeroesListActivity.class);
        startActivity(i);
    }
}
