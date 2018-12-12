package com.hmelizarraraz.marvelheroesv2.screens.details.dagger;

import com.hmelizarraraz.marvelheroesv2.models.Hero;
import com.hmelizarraraz.marvelheroesv2.screens.details.HeroDetailsActivity;
import com.hmelizarraraz.marvelheroesv2.screens.details.core.HeroDetailsView;

import dagger.Module;
import dagger.Provides;

@Module
public class HeroDetailsModule {

    HeroDetailsActivity detailsContext;
    Hero hero;

    public HeroDetailsModule(HeroDetailsActivity context, Hero hero) {
        this.detailsContext = context;
        this.hero = hero;
    }

    @Provides
    HeroDetailsView provideView() {
        return new HeroDetailsView(detailsContext, hero);
    }
}
