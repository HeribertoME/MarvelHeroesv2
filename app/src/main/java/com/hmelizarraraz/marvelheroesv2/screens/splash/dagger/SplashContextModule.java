package com.hmelizarraraz.marvelheroesv2.screens.splash.dagger;

import com.hmelizarraraz.marvelheroesv2.screens.splash.SplashScreenActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashContextModule {
    SplashScreenActivity splashContext;

    public SplashContextModule(SplashScreenActivity context) {
        this.splashContext = context;
    }

    @SplashScope
    @Provides
    SplashScreenActivity provideSplashContext() {
        return splashContext;
    }
}
