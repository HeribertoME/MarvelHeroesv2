package com.hmelizarraraz.marvelheroesv2.screens.heroes.dagger;

import com.hmelizarraraz.marvelheroesv2.api.HeroApi;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.HeroesListActivity;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.core.HeroesModel;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.core.HeroesPresenter;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.core.HeroesView;
import com.hmelizarraraz.marvelheroesv2.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class HeroesModule {

    HeroesListActivity heroesListContext;

    public HeroesModule(HeroesListActivity context) {
        this.heroesListContext = context;
    }

    @HeroesScope
    @Provides
    HeroesView provideView() {
        return new HeroesView(heroesListContext);
    }

    @HeroesScope
    @Provides
    HeroesPresenter providePresenter(RxSchedulers schedulers, HeroesView view, HeroesModel model) {
        CompositeDisposable disposable = new CompositeDisposable();
        return new HeroesPresenter(schedulers, model, view, disposable);
    }

    @HeroesScope
    @Provides
    HeroesListActivity provideContext() {
        return heroesListContext;
    }

    @HeroesScope
    @Provides
    HeroesModel provideModel(HeroApi api) {
        return new HeroesModel(heroesListContext, api);
    }
}
