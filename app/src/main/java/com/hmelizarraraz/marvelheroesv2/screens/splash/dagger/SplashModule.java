package com.hmelizarraraz.marvelheroesv2.screens.splash.dagger;

import com.hmelizarraraz.marvelheroesv2.api.HeroApi;
import com.hmelizarraraz.marvelheroesv2.screens.splash.SplashScreenActivity;
import com.hmelizarraraz.marvelheroesv2.screens.splash.core.SplashModel;
import com.hmelizarraraz.marvelheroesv2.screens.splash.core.SplashPresenter;
import com.hmelizarraraz.marvelheroesv2.screens.splash.core.SplashView;
import com.hmelizarraraz.marvelheroesv2.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class SplashModule {

    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        return new SplashPresenter(model, schedulers, compositeDisposable);
    }

    @SplashScope
    @Provides
    SplashView provideSplashView(SplashScreenActivity context) {
        return new SplashView(context);
    }

    @SplashScope
    @Provides
    SplashModel provideSplashModel(HeroApi api, SplashScreenActivity ctx) {
        return new SplashModel(api, ctx);
    }
}
