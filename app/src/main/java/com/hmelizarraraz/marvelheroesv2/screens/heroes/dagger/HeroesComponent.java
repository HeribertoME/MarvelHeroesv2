package com.hmelizarraraz.marvelheroesv2.screens.heroes.dagger;

import com.hmelizarraraz.marvelheroesv2.application.builder.AppComponent;
import com.hmelizarraraz.marvelheroesv2.screens.heroes.HeroesListActivity;


import dagger.Component;

@HeroesScope
@Component(dependencies = {AppComponent.class}, modules = {HeroesModule.class})
public interface HeroesComponent {
    void inject(HeroesListActivity heroesListActivity);
}
