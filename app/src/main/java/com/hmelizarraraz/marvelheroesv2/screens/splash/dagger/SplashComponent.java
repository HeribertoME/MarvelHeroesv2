package com.hmelizarraraz.marvelheroesv2.screens.splash.dagger;

import com.hmelizarraraz.marvelheroesv2.application.builder.AppComponent;
import com.hmelizarraraz.marvelheroesv2.screens.splash.SplashScreenActivity;

import dagger.Component;

@SplashScope
@Component(modules = {SplashContextModule.class, SplashModule.class}, dependencies = {AppComponent.class})
public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}
